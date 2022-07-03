<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="CP" value="${pageContext.request.contextPath}" />
<c:set var="resources" value="/resources" />
<c:set var="CP_RES" value="${CP}${resources}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<link rel="shortcut icon" type="image/x-icon" href="${CP}/favicon.ico">
<link rel="stylesheet" type="text/css"
	href="${CP_RES}/css/main/main.css">

<title>TableWare</title>

<!-- font awesome -->
<script src="https://kit.fontawesome.com/2974daa1cb.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="${CP_RES}/js/login/login_popup.js"></script>
<body>
	<!-- 메인 헤더 영역 시작 -->
	<div id="header">
		<div id="top">
			<div id="logo">
				<a href="#"><img src="${CP_RES}/img/tableware_logo.png"
					alt="로고이미지"></a>
			</div>
			<div class="menu_left">
				<ul>
					<li><a href="#">접시</a></li>
					<li><a href="#">머그컵</a></li>
					<li><a href="#">유리잔</a></li>
					<li><a href="#">보울/면기</a></li>
				</ul>
			</div>
			<div class="menu_right">
				<ul>
					<li><a href="javascript:showPopUp()">로그인</a></li>



					<li><a href="${CP}/my_page.do">마이페이지</a></li>
					<li><a href="${CP}/order/orderList.do">장바구니</a></li>
					<li><a href="#">FAQ</a></li>
					<li><a href="#">공지사항</a></li>
				</ul>
				<form action="#" method="post" id="search" name="search">
					<input type="text" />
					<button>
						<i class="fas fa-search fa-lg"></i>
					</button>
				</form>
			</div>
		</div>
	</div>

	<!-- 메인 헤더 영역 끝 -->

	<!-- 장바구니  -->

	<form name="orderform" id="orderform" method="post" class="orderform"
		action="/Order">
		<div class="basket" id="basket">

			<!-- "장바구니 헤더" -->

			<div class="row head">
				<div class="check">선택</div>
				<div class="img">이미지</div>
				<div class="pname">상품명</div>
				<div class="basketprice">가격</div>
				<div class="num">수량</div>
				<div class="sum">합계</div>
				<div class="basketcmd">삭제</div>
			</div>

			<!-- "장바구니 상품 목록" -->

			<div class="row data">
				<div class="check">
					<input type="checkbox" name="buy" value="260" checked="">&nbsp;
				</div>
				<div class="img">
					<img src="./img/basket1.jpg" width="60">
				</div>
				<div class="pname">
					<span>이름</span>
				</div>
				<div class="basketprice">
					<input type="hidden" name="p_price" id="p_price1" class="p_price"
						value="20000">20,000원
				</div>
				<div class="num">

					<!-- "장바구니 수량 변경" -->
					<div class="updown">
						<input type="text" name="p_num1" id="p_num1" size="2"
							maxlength="4" class="p_num" value="2"> <span><i
							class="fas fa-arrow-alt-circle-up up"></i></span> <span><i
							class="fas fa-arrow-alt-circle-down down"></i></span>
					</div>
				</div>

				<!-- "장바구니 상품 합계" -->

				<div class="sum">40,000원</div>
				<div class="basketcmd">
					<a href="#" class="abutton">삭제</a>
				</div>
			</div>
		</div>

		<!-- "장바구니 기능 버튼" -->

		<div class="right-align basketrowcmd">
			<a href="#" class="abutton">선택상품삭제</a> <a href="#" class="abutton">장바구니비우기</a>
		</div>

		<!-- "장바구니 전체 합계 정보" -->

		<div class="bigtext right-align sumcount" id="sum_p_num">상품갯수:
			4개</div>
		<div class="bigtext right-align box blue summoney" id="sum_p_price">합계금액:
			74,200원</div>
		<div id="goorder" class="">
			<div class="clear"></div>
			<div class="buttongroup center-align cmd">
				<a href="#">선택한 상품 주문</a>
			</div>
		</div>
	</form>
	<!-- 장바구니  -->
</body>
</html>


<!-- ----------------------------------------------------------------------------------------------------------------------------------- -->

<%-- <%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 
    <% request.setCharacterEncoding("UTF-8"); %>
 
    <% ArrayList<String> arrr = (ArrayList) (session.getAttribute("productList")); %>
    <center>
        <h1>상품 결과</h1>
        <hr>
        <%=session.getAttribute("login")%>님의 장바구니 목록
        <hr>
        <% if (arrr == null) { %>
        장바구니에 넣은 상품이 없습니다.
        <% } else {
                for (String i : arrr) {
                    out.println(i); %><br>
                <% }
        } %>
        <br><br><hr>
        <table>
            <tr>
                <td><input type=button onClick="history.back()" value="뒤로가기"></td>
                <td>
                    <form action=Login.jsp method=post>
                        <input value=로그아웃 type=submit></td>
                    </form>
            </tr>
        </table>
    </center>
</body>
</html> --%>

<!-- --------------------------------------------------------------------------------------------------------------------------------------- -->
<%-- 

<%@page import="java.text.DecimalFormat"%>
<%@page import="com.hanul.cart.CartDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
ArrayList<CartDTO> cart = null;

Object obj = session.getAttribute("cart");   //세션 객체에서 cart 값을 가져온다.

if(obj == null) {   //세션 정보가 없으면 배열을 생성 : 주문한 제품이 없다
     cart = new ArrayList<CartDTO>();   
} else {            //세션 정보가 있으면 강제로 캐스팅 : 주문한 제품이 있다
     cart = (ArrayList<CartDTO>) obj;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart View</title>
<script type="text/javascript">
function fnPay(){
     alert("결제 API를 발급 받으시기 바랍니다.");
}

function fnClear(){
     if(confirm("장바구니를 비우시겠습니까?")) {
          location.href = "CartClear.jsp";   
     }
}

function fnGo(){
     location.href = "ShopMallMain.jsp";
}
</script>
</head>
<body>
<div align="center">
     <h3>[장바구니 보기]</h3>
     <table border="1">
          <tr>
               <th>번호</th>
               <th>과일명</th>
               <th>단가</th>
               <th>주문 수량</th>
               <th>가격</th>
          </tr>
          <%
          if(cart.size() == 0) {
               out.println("<tr align='center'>");
                    out.println("<td colspan= '5'>");
                         out.println("장바구니에 담긴 상품이 없습니다.");
                         out.println("<a href= 'ShopMallMain.jsp'>주문하기</a>");
                    out.println("</td>");
               out.println("</tr>");
          } else {
               int totalSum = 0, total = 0;
               DecimalFormat df = new DecimalFormat("￦#,##0");
               for(int i = 0; i < cart.size(); i++) {
                    CartDTO dto = cart.get(i);
                    out.println("<tr align= 'center'>");
                         out.println("<td>" + (i + 1) + "</td>");
                         out.println("<td>" + dto.getName() + "</td>");
                         out.println("<td>" + df.format(dto.getPrice()) + "</td>");
                         out.println("<td>" + dto.getCnt() + "</td>");
                         total = dto.getPrice() * dto.getCnt();
                         out.println("<td>" + df.format(total) + "</td>");
                    out.println("</tr>");
                    totalSum += total;
               }
          out.println("<tr align = 'center'>");
               out.println("<td colspan= '4'>");
                    out.println("<input type='button' value='결제하기' onclick='fnPay()' />");
                    out.println("<input type='button' value='장바구니 비우기' onclick='fnClear()' />");
                    out.println("<input type='button' value='쇼핑 계속하기' onclick='fnGo()' />");
               out.println("</td>");
               out.println("<td>");
               out.println(df.format(totalSum));
               out.println("</td>");
          out.println("</tr>");
          }//if else
          %>
     </table>
</div>
</body>
</html> --%>
