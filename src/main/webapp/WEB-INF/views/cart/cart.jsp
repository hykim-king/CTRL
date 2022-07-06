<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="CP" value="${pageContext.request.contextPath}" />
<c:set var="resources" value="/resources" />
<c:set var="CP_RES" value="${CP}${resources}" />
<%@page import="java.io.*"%>

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
<link rel="stylesheet" type="text/css"
     href="${CP_RES}/css/cart/cart.css">
<!-- 부트스트랩 -->
<link href="${CP_RES }/css/etc/bootstrap.min.css" rel="stylesheet">

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
     <br />
     <br />
     <br />
     <br />
     <br />
     <br />
     <br />
     <br /> ${inquiry[0].pName} ${inquiry[0].pName}



     <div class="name_1">
          <span class="name_2"
               style="border-radius: 15px 15px 15px 0; border: 3px solid #FFAD5B; padding: 0.5em 0.6em; color: #FF8000;">장바구니</span>
     </div>



     <table class="type11">
          <thead>
               <tr>
                    <th scope="cols">타이틀</th>
                    <th scope="cols">타이틀</th>
                    <th scope="cols">타이틀</th>
               </tr>
          </thead>
          <tbody>
               <tr>
                    <td>내용</td>
                    <td>내용</td>
                    <td>내용</td>
               </tr>
          </tbody>
     </table>
     <!-- 장바 구니 -->
     <!--//장바 구니 ------------------------------------------->

     <c:choose>
          <c:when test="${NoticeVO.size()  > 0}">
               <c:forEach var="NoticeVO" items="${NoticeVO }">

                    <div class="faq">
                         <div class="faq_question">${NoticeVO.nTitle }</div>
                         <div class="faq_answer_container">
                              <div class="faq_answer">${NoticeVO.nContent}</div>
                         </div>
                    </div>
                    <td>${inquiry[0].pName}</td>
                    <td>${inquiry[0].pPrice}</td>
                    <td>${inquiry[1].pName}</td>

               </c:forEach>
          </c:when>
     </c:choose>


</body>
</html>