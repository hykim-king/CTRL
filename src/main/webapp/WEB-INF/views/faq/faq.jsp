<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" type="text/css" href="${CP_RES}/css/main/main.css">
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script src="${CP_RES }/js/etc/jquery-1.12.4.js"></script>
<!-- 사용자 정의 function, callAjax -->
<script src="${CP_RES }/js/faq/faq.js"></script>
<!-- 사용자 정의 function, isEmpty -->
<script src="${CP_RES }/css/faq/faq.css"></script>

<!-- font awesome -->
<script src="https://kit.fontawesome.com/2974daa1cb.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="${CP_RES}/js/login/login_popup.js"></script>


<head>
<title>Insert title here</title>
</head>
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
	
<span id="faq-title">자주 묻는 질문(FAQ)</span>
<div class="faq-content">
  <button class="question" id="que-1"><span id="que-1-toggle">+</span><span>접혀있을 때</span></button>
  <div class="answer" id="ans-1">펼쳐진 부분</div>
</div>
<div class="faq-content">
  <button class="question" id="que-2"><span id="que-2-toggle">+</span><span>접혀있을 때</span></button>
  <div class="answer" id="ans-2">펼쳐진 부분</div>
</div>
<div class="faq-content">
  <button class="question" id="que-3"><span id="que-3-toggle">+</span><span>접혀있을 때</span></button>
  <div class="answer" id="ans-3">펼쳐진 부분</div>
</div>


</body>
</html>