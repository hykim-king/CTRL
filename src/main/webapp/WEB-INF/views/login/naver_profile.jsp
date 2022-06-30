<%--
/**
        Class Name:
        Description:
        Modification information
        
        수정일     수정자      수정내용
    -----   -----  -------------------------------------------
    2022. 6. 23.        최초작성 
    
    author ehr 개발팀
    since 2022.01.27
    Copyright (C) by KandJang All right reserved.
*/
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.io.InputStream"%>
<%@ page import="java.io.InputStreamReader"%>
<%@page import="java.net.MalformedURLException"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<!-- 네이버api -->
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.net.HttpURLConnection"%>
<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.InputStreamReader"%>
<c:set var="CP" value="${pageContext.request.contextPath}" />
<c:set var="resources" value="/resources" />
<c:set var="CP_RES" value="${CP}${resources}" />
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<link rel="shortcut icon" type="image/x-icon" href="${CP }/favicon.ico">
<title>네이버 로그인</title>
<!-- 부트스트랩 -->
<link href="${CP_RES}/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script src="${CP_RES}/js/jquery-1.12.4.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="${CP_RES}/js/bootstrap.min.js"></script>
<!-- jquery_bootstrap paging -->
<script type="text/javascript" src="${CP_RES}/js/jquery.bootpag.js"></script>

<script type="text/javascript">
$(document).ready(function(){
     console.log("document.ready");
   
     let url = "${CP}/login/doMemberInsert.do";
     let method = "POST";
     let parameters = {
    		 "mNum" : $("#mNum").val(),
             "mName" : $("#mName").val(),
             "mEmail" : $("#mEmail").val(),
             "mTel" : $("#mTel").val(),
             "mAddr" : $("#mAddr").val(),
             "mGrade" : $("#mGrade").val()
     };
     let async;
     
     EClass.callAjax(url, method, parameters, async, function(data){
         console.log("data.msgId :"+ data.msgId);
         console.log("data.msgContents :"+ data.msgContents);
         if("1" == data.msgId){//수정성공
             alert(data.msgContents);
             //목록 조회
             //trigger통한 호출
             //$("#doRetrieve").trigger("click");
             
             doRetrieve(1);
             //하단 초기화
             init();
         }else{
             alert(data.msgContents);
         }
     });
     
     
});    
</script>       

</head>
<body>
    <!-- 제목  -->
    <div class="">
      <h2></h2>
    </div>
    <!--// 제목  ---------------------------------------------------------------->
    
     <!-- table -->
     <div class="table-responsive">
         <table id="user_table" class="table table-striped table-bordered table-hover table-condensed">
             <thead class="bg-primary">
                 <tr>
                 <th class="text-center col-sm-1 col-md-1 col-lg-1">번호</th>
                 <th class="text-center col-sm-2 col-md-6 col-lg-2">회원번호</th>
                 <th class="text-center col-sm-2 col-md-6 col-lg-2">이름</th>
                 <th class="text-center col-sm-2 col-md-6 col-lg-2">이메일</th>
                 <th class="text-center col-sm-3 col-md-6 col-lg-3">연락처</th>
                 <th class="text-center col-sm-2 col-md-6 col-lg-2">주소</th>
                 <th class="text-center col-sm-2 col-md-6 col-lg-2">등급</th>
                 </tr>
             </thead>
             <tbody>
                 <c:choose>
                     <c:when test="${list.size() > 0 }">
                     <c:forEach var="vo" items="${list }">
                         <tr>
                         <td class="text-center col-sm-1 col-md-1 col-lg-1">${vo.num }</td>
                         <td class="text-left col-sm-2 col-md-6 col-lg-2">${vo.mNum }</td>
                         <td class="text-left col-sm-2 col-md-6 col-lg-2">${vo.mName }</td>
                         <td class="text-center col-sm-2 col-md-6 col-lg-2">${vo.mEmail }</td>
                         <td class="text-left col-sm-3 col-md-6 col-lg-3">${vo.mTel }</td>
                         <td class="text-center col-sm-2 col-md-6 col-lg-2">${vo.mAddr }</td>
                         <td class="text-center col-sm-2 col-md-6 col-lg-2">${vo.mGrade }</td>
                         </tr>
                     </c:forEach>
                     </c:when>
                         <c:otherwise>
                             <tr><td colspan="99" class="text-center">NO data found</td></tr>
                         </c:otherwise>
                 </c:choose>
             </tbody>
         </table>
     </div>
     <!-- table ---------------------------------------->
	
</body>
</html>