<%@page import="org.eclipse.core.internal.runtime.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<%@page import="com.pcwk.ctrl.cmn.ProductVO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

     <%
     
          ProductVO product = new ProductVO();

     // 상품번호 가져오기
     //   String pNum = product.getpNum();
     String pNum =request.getParameter("pNum");

     // 상품번호 쿠키에 지정한다
     Cookie c = new Cookie("pNum", pNum);

     // 쿠키에 설명을 추가한다
     c.setComment("상품번호");

     // 쿠키 유효기간을 설정한다. 초단위 : 60*60*24= 1일 
     c.setMaxAge(60 * 5);

     // 응답헤더에 쿠키를 추가한다.
     response.addCookie(c);

     Cookie[] cookies = request.getCookies();


     System.out.println("--------------------------" + (String) request.getParameter("pNum"));
     
     %>
     
     
     <script type="text/javascript">
     alert("장바구니에 추가되었습니다");
     history.back();
     </script>


</body>
</html>