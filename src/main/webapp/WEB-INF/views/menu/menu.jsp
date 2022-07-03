<%--
/**
	Class Name:
	Description:
	Modification information
	
	수정일     수정자      수정내용
    -----   -----  -------------------------------------------
    2022. 7. 2.        최초작성 
    
    author ehr CTRL
    since 202211.27
    Copyright (C) by KandJang All right reserved.
*/
 --%>
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CP" value="${pageContext.request.contextPath}" />
<c:set var="resources" value="/resources/" />
<c:set var="CP_RES" value="${CP}${resources}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
	<link rel="shortcut icon" type="image/x-icon" href="${CP }/favicon.ico">
	<title>부트 스트랩-boot_list</title>
    <!-- 부트스트랩 -->
    <link href="${CP_RES}/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="${CP_RES}/js/jquery-1.12.4.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="${CP_RES}/js/bootstrap.min.js"></script>
    
    <script type="text/javascript">
      $(document).ready(function(){
    	  console.log("document.ready");
      });
    </script>
</head>
<body>

    <table>
      <c:choose>
         <c:when test="${list.size() > 0}">
             <c:forEach var="list" items="${list}"> 
			      <th width="130"><img src="${CP_RES}/img/${list.pNum}.jpg" alt="상품 이미지" width="400"/></th>
             </c:forEach>
            </c:when>
      </c:choose>
    </table>
</body>
</html>