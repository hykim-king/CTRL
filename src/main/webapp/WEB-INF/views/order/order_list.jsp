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
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <link rel="shortcut icon" type="image/x-icon" href="${CP }/favicon.ico">
    <link rel="stylesheet" type="text/css" href="${CP_RES}/css/order/order_list.css">
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="${CP_RES }/js/etc/jquery-1.12.4.js"></script>
    <!-- 사용자 정의 function, callAjax -->
    <script src="${CP_RES }/js/etc/eclass.js"></script>
    <!-- 사용자 정의 function, isEmpty -->
    <script src="${CP_RES }/js/etc/eUtil.js"></script>
 

    <title>주문 조회 페이지</title>
    <script type="text/javascript">
        $(document).ready(function(){
        console.log("document.ready"); 
        
        // table click(김주혜)
        $('#listTable > tbody > tr').on("click", "input" ,function(){ 
            
            let clickInput = $(this); // $(this) : input
            let tdArray = clickInput.parents("tr").children(); // td들 지정
            
            // 각각 값을  가져오기
            let oNum = tdArray.eq(0).text(); // 주문 번호
            let dNum = tdArray.eq(5).text(); // 상세 번호
            let oName = tdArray.eq(6).text(); // 회원이름
            let pNum = tdArray.last().text(); // 상품번호
            
            window.open("${CP}/review/reviewPopup.do?oNum="+oNum+"&dNum="+dNum+"&oName="+oName+"&pNum="+pNum,"리뷰작성", "width=800, height=700, left=100, top=100");
            //--table click(김주혜)
        });
      });
      
      
    </script>

</head>
<body>
 <!-- 메인 헤더 영역 시작 -->
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



<!-- 마이페이지 시작 -->

<!-- ▼▼▼▼▼▼▼▼▼▼▼▼▼ 마이페이지  사각형  ▼▼▼▼▼▼▼▼▼▼▼▼▼ -->
<title>my_page</title>

<div class="all">

<div class="square">

<div class="my_box">
    <ul>
        <li class="my"><strong>마이페이지</strong><li>
        <li class="info"><a href="${CP}/my_page.do">회원정보</a></li>
        <li class="order"><a href="${CP}/order/orderList.do"><strong>주문조회</strong></a></li>
    </ul>
</div>
<!-- ▲▲▲▲▲▲▲▲▲▲▲▲▲ 마이페이지  사각형 끝  ▲▲▲▲▲▲▲▲▲▲▲▲▲-->

  
  <table class="order2">
      <tr>
         <th width="160" height="60"> 주문번호</th>
         <th width="500">상품정보</th>
         <th width="150">금액</th>
         <th width="70">수량</th>
         <th width="200">진행상태</th>
         
         <!--  아래 세개는 리뷰 페이지를 위해 필요한 것  : 조회 필요(김주혜)-->
         <th width="100" style="display: none;">상세번호</th>
         <th width="100" style="display: none;">회원이름</th>
         <th width="100" style="display: none;">상품번호</th>
         <!--//  아래 세개는 리뷰 페이지를 위해 필요한 것  : 조회 필요(김주혜)-->
         
      </tr>
      
      <table class="order3" id="listTable">
        <c:choose>
         <c:when test="${list.size() > 0}">
             <c:forEach var="list" items="${list}"> 
               <!-- 문자: 왼쪽, 숫자: 오른쪽, 같은면: 가운데 -->
                <tr>
                    <th width="160" height="100" class="oNum"> ${list.oNum}</th>
                    <th width="500" class="txt_center"><img src="${CP_RES}/img/bowls01.jpg" width=18% alt="bowls01"><a class="text">${list.pName}</a></th>
                    <th width="150" class="txt_center">${list.pPrice}원</th>
                    <th width="70" class="text-center">${list.dBuy}개</th>
                    <th width="200" class="text-left">${list.oStatus}
                      <br><input type="button" value="리뷰 쓰기"/>
                    </th>
                    <!--  아래 세개는 리뷰 페이지를 위해 필요한 것  : 조회 필요(김주혜)-->
                    <th style="display: none;">${list.dNum}</th>
                    <th style="display: none;">${list.oName}</th>
                    <th style="display: none;">${list.pNum}</th>
                    <!--//  아래 세개는 리뷰 페이지를 위해 필요한 것  : 조회 필요(김주혜)-->
                    
                </tr>                                                           
             </c:forEach>
         </c:when>
             <c:otherwise>
                <tr><td colspan="99" class="text-center">주문하신 상품이 없습니다.</td></tr>
             </c:otherwise>
        </c:choose>    
        </tbody>
       </table>
</body>
</html>