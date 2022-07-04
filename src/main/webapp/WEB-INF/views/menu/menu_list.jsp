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
    <link href="${CP_RES}/css/etc/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${CP_RES }/css/main/main.css">
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
<!-- 메인 헤더 영역 시작(이은빈) -->
    <div id="header">
        <div id="top">
            <div id="logo">
                <a href="#"><img src="${CP_RES}/img/tableware_logo.png" alt="로고이미지"></a>
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
                    <li>로그아웃</li>

                    <li><a href="#">마이페이지</a></li>
                    <li><a href="#">장바구니</a></li>
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
    <!-- menu 영역 시작(최유빈) -->
    <div id="contents">
      <tbody>
        <c:choose>
         <c:when test="${list.size() > 0}">
             <c:forEach var="list" items="${list}"> 
                  <div id="list" style="float:left;padding:30px;width:28%">
                     <img src="${CP_RES}/img/${list.pNum}.jpg" class="img_list" alt="상품 이미지" />
                     <p class="p1">${list.pName }</p><br/>
                     <p class="p1">${list.pPrice }</p>
                  </div>
            </c:forEach>
            </c:when>
        </c:choose> 
        </tbody>
        </div>
</body>
</html>