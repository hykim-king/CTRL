package com.pcwk.ctrl.naver.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pcwk.ctrl.cmn.MemberVO;
import com.pcwk.ctrl.cmn.MessageVO;
import com.pcwk.ctrl.member.dao.MemberDao;
import com.pcwk.ctrl.member.service.MemberService;
import com.pcwk.ctrl.naver.Item;

@Service("naverProfileService")
public class NaverProfileServiceImpl implements NaverProfileService {
	final Logger LOG = LogManager.getLogger(getClass());

	@Autowired
	MemberDao memberDao;
	
	@Autowired
	MemberService memberService;
	
	public NaverProfileServiceImpl() {}
	
	
	@Override
	public MemberVO doMemberInsert(String accessToken) throws SQLException {
        String header = "Bearer " + accessToken; // Bearer 다음에 공백 추가
        String apiURL = "https://openapi.naver.com/v1/nid/me?query="+accessToken;//json
        Item item = null;
        
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Authorization", header);
        String responseBody = get(apiURL,requestHeaders);

        //{"resultcode":"00","message":"success","response":{"id":"OBb9C5C3HCNatxsH_rPkcvNFnvEfarinsnH7qICMaFU","email":"eunbin620@naver.com","mobile":"010-9406-3269","mobile_e164":"+821094063269","name":"\uc774\uc740\ube48"}}
        LOG.debug(responseBody);
        
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(responseBody);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonElement response = jsonObject.get("response");
        
        LOG.debug("response="+response);
        
        Gson gson = new Gson();
        item = gson.fromJson(response, Item.class);
        
        MemberVO memberVO = new MemberVO();
        
        memberVO.setmNum(item.getId());
        memberVO.setmEmail(item.getEmail());
        memberVO.setmName(item.getName());
        memberVO.setmTel(item.getMobile());
        memberVO.setmGrade("2");	//관리자(1), 회원(2)
        
        LOG.debug("Id: "+item.getId());
        LOG.debug("Email: "+item.getEmail());
        LOG.debug("Name: "+item.getName());
        LOG.debug("Mobile: "+item.getMobile());
		
        return memberVO;
        
    }


    private String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            int responseCode = con.getResponseCode();
            LOG.debug("=responseCode="+responseCode);
            
            BufferedReader br;
            
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 에러 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }


    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }


    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);


        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();


            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
		
	}


	@Override
	public int memberCheck(MemberVO inVO) throws SQLException {
		return memberDao.memberCheck(inVO);
	}





}
