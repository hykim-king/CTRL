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
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
   <title>TableWare</title>
    <!-- 부트스트랩 -->
    <link href="${CP_RES}/css/etc/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${CP_RES}/css/main/main_boot.css">
    <link rel="stylesheet" type="text/css" href="${CP_RES}/css/menu/menu.css">
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="${CP_RES}/js/etc/jquery-1.12.4.js"></script>
    <!-- 사용자 정의 function, callAjax -->
    <script src="${CP_RES }/js/etc/eclass.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="${CP_RES}/js/etc/bootstrap.min.js"></script>
    <!-- font awesome -->
    <script src="https://kit.fontawesome.com/2974daa1cb.js"
                        crossorigin="anonymous"></script>
    <script type="text/javascript" src="${CP_RES}/js/login/login_popup.js"></script>
    
    
    <script type="text/javascript">
      $(document).ready(function(){
         console.log("document.ready");
         
         /* 카테고리 누르면 이동 (최유빈) */
         // bowls 카테고리로 이동
         $("#bowls").on("click", function(e){
             console.log("bowls:");
             console.log("pCategory:" + $("#pCategory").val());
             window.location.href = "${CP}/menu/menuMove.do?pCategory=bowls";
         });
         // cup 카테고리로 이동
         $("#cup").on("click", function(e){
             console.log("cup:");
             console.log("pCategory:" + $("#pCategory").val());
             window.location.href = "${CP}/menu/menuMove.do?pCategory=cup";
         });
         // glass 카테고리로 이동
         $("#glass").on("click", function(e){
             console.log("glass:");
             console.log("pCategory:" + $("#pCategory").val());
             window.location.href = "${CP}/menu/menuMove.do?pCategory=glass";
         });
         // plate 카테고리로 이동
         $("#plate").on("click", function(e){
             console.log("plate:");
             console.log("pCategory:" + $("#pCategory").val());
             window.location.href = "${CP}/menu/menuMove.do?pCategory=plate";
         });
         /* 카테고리 누르면 이동 (최유빈) */
          
         
         /* 이미지 클릭시 상세페이지로 이동 (김주혜)*/
         $(document).on("click", "#list img", function(e){
             console.log('클릭');
             let productImgSrc = $(this).attr("src");
             let pNum = productImgSrc.substring(productImgSrc.lastIndexOf('/')+1,productImgSrc.lastIndexOf('.'));
             console.log(productImgSrc);
             console.log(pNum);
             
             let url = "${CP}/productDetail/doSelect.do";
             let method = "GET";
             let parameters = {
                     pNum : pNum
             }; 
             
             let async = true;
             
             EClass.callAjax(url, parameters, method, async, function(data){
                 console.log(data);
                 // {"pNum":"glass01","pName":"뚱뚱이 고블렛잔 ","pPrice":27700,"pSize":"530ml","no":0}
                 let pNum = data.pNum;
                 let pName = data.pName;
                 let pPrice = data.pPrice;
                 let pSize = data.pSize;
                 
                 let pageSize = 7;
                 let pageNum = 1;
                 
                 window.location.href="${CP}/productDetail/view.do?pNum=" + pNum + "&pName=" + pName + 
                         "&pPrice="+pPrice + "&pSize="+pSize+ "&pageSize="+pageSize + "&pageNum=" + pageNum;
                 
             }); 
             
         });
         /* 이미지 클릭시 상세페이지로 이동 (김주혜)*/
      });
    </script>
</head>
<body>
<!-- 메인 헤더 영역 시작 (이은빈)----------------------------------------------->
    <div id="header">
            <div id="logo">
                <a href="${CP}/main/main.do"><img src="${CP_RES}/img/tableware_logo.png" alt="로고이미지"></a>
            </div>
        <div id="top">
            <div class="menu_left">
                <ul>
                    <li><a href="#" id="plate">접시</a></li>
                    <li><a href="#" id="cup">머그컵</a></li>
                    <li><a href="#" id="glass">유리잔</a></li>
                    <li><a href="#" id="bowls">보울/면기</a></li>
                </ul>
            </div>
            <div class="menu_right">
                <c:choose>
                    <c:when test="${null !=sessionScope.member}">
                        <ul>
                         <li>
                           <a href="${CP}/login/doLogout.do">
                            <span>${sessionScope.member.mName}님 환영합니다.</span>
                            <span>&nbsp;로그아웃</span></a>
                         </li>
                         <li><a href="${CP}/memberInfo/memberInfo.do">마이페이지</a></li>
                         <li><a href="${CP}/cart/cart.do">장바구니</a></li>
                         <li><a href="${CP}/faq/faq.do">FAQ</a></li>
                         <li><a href="${CP}/notice/notice.do">공지사항</a></li>
                        </ul>
                    </c:when>
                    <c:otherwise>
                        <ul>
                         <li>
                           <a href="${CP}/login/login.do">로그인</a>
                         </li>
                         <li><a href="#"><p onclick="alert('로그인이 필요한 서비스 입니다.')">마이페이지<p></a></li>
                         <li><a href="${CP}/cart/cart.do">장바구니</a></li>
                         <li><a href="${CP}/faq/faq.do">FAQ</a></li>
                         <li><a href="${CP}/notice/notice.do">공지사항</a></li>
                        </ul>
                    </c:otherwise>
                </c:choose>
                <form action="${CP}/productSearch/View.do" method="get" id="search" name="search">
                    <input type="text" id="searchWord" class="searchWord" name="searchWord" value=""/>
                    <button id="doRetrive">
                        <i class="fas fa-search fa-lg" ></i>
                    </button>
                </form>
            </div>
        </div>
    </div>

<!-- 메인 헤더 영역 끝 (이은빈)-------------------------------------------------->
<!-- menu 영역 시작(최유빈) -------------------------------------------------->
      <div class="menu_name" style="color:#ddd; width:5%; text-decoration: underline;
           text-underline-offset: 7px;
           text-decoration-style: wavy;
           text-decoration-thickness: 2.5px;
           letter-spacing: 1.5px;
           line-height: 40px;
           text-align: center;">&nbsp;${menuName}&nbsp;</div>
    <div id="contents">
      <tbody>
        <c:choose>
         <c:when test="${list.size() > 0}">
             <c:forEach var="list" items="${list}"> 
                  <div id="list" style="float:left;padding:30px;width:33%">
                     <a href="#"><img src="${CP_RES}/img/${list.pNum}.jpg" class="img_list" alt="상품 이미지" /></a>
                     <p class="p1">${list.pName}</p><br/>
                     <p class="p1"><fmt:formatNumber type="number" maxFractionDigits="3" value="${list.pPrice }"/>원</p>
                  </div>
            </c:forEach>
            </c:when>
        </c:choose> 
        </tbody>
        </div>
<!-- menu영역 끝 (최유빈) ---------------------------------------------------->        
        
<!-- footer 시작(이은빈) ---------------------------------------------------->
         <div id="footer">
                <div class="ft_content">
                   <div class="logoNcopy">
                       <div class="logo_text">
                           Table<br>Ware
                       </div>
                       <p>
                           CopyRright &copy; <br>All right reserved by CTRL
                       </p>
                   </div>
                    
                    <div class="ft_top ">
                            <div class="fsec01 sec">
                                <p class="tit">CS CENTER</p>
                                <span class="first">02-313-7300</span>
                                <span>WEEKDAY AM 9:00 ~ PM 6:00</span>
                                <span>LUNCH PM 12:00 ~ PM 1:00</span>
                                <span>WEEKEND &amp; HOLYDAY OFF</span>
                            </div>
                            <div class="fsec02 sec">
                                <p class="tit">RETURN &amp; EXCHANGE</p>
                                <span>반품 : 04100 서울특별시 마포구 서강로 136 아이비타워 3층 <br/> 반드시 고객센터에 접수 후 교환 및 반품해주세요.</span>
                                <span>cj대한통운 고객센터 1588-1255</span> 
                            </div>
                    </div>
                    <div class="util">
                        <div class="util_inner">
                            <ul class="menu">
                                <li><a href="#"><span>이용약관</a></li>
                                <li><a href="#">개인정보취급방침</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="ft_bottom ">
                    <p class="address">
                        <span>COMPANY : (주)TableWare CEO : CTRL    PHONE : 010-1234-5678</span></br> 
                        <span>CONTACT : <strong><a href="https://github.com/hykim-king/CTRL.git" id="git">https://github.com/hykim-king/CTRL.git</a></strong></span></br>
                        <span>BUSINESS LICENCE : [123-45-67890] | ADDRESS : 04100 서울특별시 마포구 서강로 136 아이비타워 3층 TableWare</span>
                    </p>
                </div>
            </div>
    
        <!-- footer 끝 ------------------------------------------------------------->

        
        
</body>
</html>