<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
     // 특정 쿠키만 삭제하기
     Cookie kc = new Cookie("pNum", null) ;
     kc.setMaxAge(0) ;
     response.addCookie(kc) ;
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>