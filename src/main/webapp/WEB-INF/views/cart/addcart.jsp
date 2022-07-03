<%@page import="com.pcwk.ctrl.cmn.CartVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
String price = request.getParameter("price");

 ArrayList<CartVO> cart = null;

Object obj = session.getAttribute("cart");   //세션 객체에서 cart 값을 가져온다.

if(obj == null) {   //세션 정보가 없으면 배열을 생성 : 최초 주문한 경우
     cart = new ArrayList<CartVO>();   
} else {            //세션 정보가 있으면 강제로 캐스팅 : 추가 주문
     cart = (ArrayList<CartVO>) obj;
}

int pos = -1;  //등록된 제품이 없다
//장바구니 세션에 동일한 제품이 있을 경우 : 수량(cnt) 증가
for(int i = 0; i < cart.size(); i++) {
	CartVO dto = cart.get(i);
     if(dto.getName().equals(name)) {
          pos = 1;
          dto.setCnt(dto.getCnt() + 1);
          break;
     }
}

//장바구니 세션에 등록된 제품이 없을 경우 : CartDTO 객체를 생성하여 배열에 등록(add())
if(pos == -1) {
	CartVO dto = new CartVO();
     dto.setName(name);
     dto.setPrice(Integer.parseInt(price.replace(",", "")));     //1,500 ▶ 1500 : 쉼표 제거 후 정수형으로 랩핑
     dto.setCnt(1);
     cart.add(dto);
}

//cart 세션 객체를 만들어 준다.
session.setAttribute("cart", cart);
%>

<script>alert("장바구니에 담았습니다."); location.href = "ShopMallMain.jsp"</script> --%>



<!-- ------------------------------------------------------------------------------------------------------------------------------------ -->
<%-- 

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 
    <%
        request.setCharacterEncoding("UTF-8");
 
        ArrayList<String> arr = (ArrayList<String>) (session.getAttribute("productList"));
 
        String productName = request.getParameter("product");
 
        /* arrayList 안에 아무것도 없으면 arrayList 생성 */
        if (session.getAttribute("productList") == null) {
            arr = new ArrayList<String>();
        }
        arr.add(productName);
        session.setAttribute("productList", arr);
    %>
 
    <script>alert("<%=productName%>가 추가되었습니다.");history.back();</script>
 
</body>
</html> --%>