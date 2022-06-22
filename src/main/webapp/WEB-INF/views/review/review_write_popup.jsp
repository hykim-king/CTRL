<%--
/**
    Class Name:
    Description:
    Modification information
        
        수정일     수정자      수정내용
    -----   -----  -------------------------------------------
    2022. 6. 21.   최초작성 
    
    author CTRL 개발팀
    since 2022.01.27
    Copyright (C) by KandJang All right reserved.
*/
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CP" value="${pageContext.request.contextPath}"/>
<c:set var="resources" value="/resources"/>
<c:set var="CP_RES"    value="${CP}${resources}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <link rel="shortcut icon" type="image/x-icon" href="${CP }/favicon.ico">
	<link rel="stylesheet" type="text/css" href="${CP_RES }/css/review_write_popup.css">
	<title>상품 리뷰</title>
	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="${CP_RES }/js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="${CP_RES }/js/review_write_popup.js"></script>
</head>
<body>
   <div class="container">
     <p>상품에 대한 리뷰를 작성해주세요</p>
	   <form method="get" action="${CP}/review/reviewInsert.do" name="reviewFrm" id="reviewFrm" onsubmit="submit();">
	      <!--주문 번호-->
	      <input type="text" id="o_num" name="o_num"/> 
	      <!--주문 상세 번호-->
	      <input type="text" id="d_num" name="d_num"/> 
	      
	      <!-- 입력받는 부분 -->
	      <ul>
	        <li><label for="o_name">작성자</label></li>
	        <li class="border_bottom"><input type="text" name="o_name" id="o_name" readonly="readonly" required="required"></li>
	        <li><label for="contents">내용</label></li>
	        <li><textarea rows="10" cols="40" name="contents" id="contents" required="required"></textarea></li>
		      <li><input class="btn-1 button" type="submit" value="REVIEW WRITE"></li>
	      </ul>
	      <!--// 입력받는 부분 -->
	      
	   </form>
   </div>

</body>
</html>