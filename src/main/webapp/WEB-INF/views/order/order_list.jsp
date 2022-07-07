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
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

 
<c:set var="CP" value="${pageContext.request.contextPath}"/>
<c:set var="resources" value="/resources"/>
<c:set var="CP_RES"    value="${CP}${resources}" />
<!DOCTYPE html>
<html>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 부트스트랩 -->
    <link href="${CP_RES }/css/etc/bootstrap.min.css" rel="stylesheet">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <link rel="shortcut icon" type="image/x-icon" href="${CP }/favicon.ico">
    <link rel="stylesheet" type="text/css" href="${CP_RES }/css/main/main_boot.css">
    <link rel="stylesheet" type="text/css" href="${CP_RES}/css/order/order_list.css">
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="${CP_RES }/js/etc/jquery-1.12.4.js"></script>
    <!-- 사용자 정의 function, callAjax -->
    <script src="${CP_RES }/js/etc/eclass.js"></script>
    <!-- 사용자 정의 function, isEmpty -->
    <script src="${CP_RES }/js/etc/eUtil.js"></script>
     <!-- jquery_bootstrap paging -->
    <script type="text/javascript" src="${CP_RES}/js/etc/jquery.bootpag.js"></script>
    <!-- font awesome -->
    <script src="https://kit.fontawesome.com/2974daa1cb.js"
                        crossorigin="anonymous"></script>
    <script type="text/javascript" src="${CP_RES}/js/login/login_popup.js"></script>

    <title>order_list</title>
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
        $(document).on("click", "#listTable img", function(e){
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
        
        
        //뭔지 모르겠음 -> 안되면 지워보기
        renderingPage('${pageTotal}',1);
        
        // 페이징 시작 ------------------------
        // totalData : 총 데이터 수
        // dataPerPage : 한 페이지에 나타낼 글 수
        // pageCount : 페이징에 나타낼 페이지 수
        // page : 현재 페이지
        function renderingPage(pageTotal, page) {
            console.log("pageTotal : " + pageTotal);
            console.log("page : " + page);
            
            // pageTotal을 int로 변환하기
            pageTotal = parseInt(pageTotal);
            console.log("pageTotal : " + pageTotal);
            
            // 이전 연결된 EventHandler 제거
            $("#page-selection").unbind('page');
            
            // 아마..? 페이지 양옆 ← 와 → 로 나타내기(이해 x)
            $('#page-selection').bootpag({
                total: pageTotal,
                page: page,
                maxVisible: 5,
                leaps: true,
                firstLastUse: true,
                first: '←',
                last: '→',
                wrapClass: 'pagination',
                activeClass: 'active',
                disabledClass: 'disabled',
                nextClass: 'next', // 다음
                prevClass: 'prev', // 이전
                lastClass: 'last',
                firstClass: 'first'
            }).on("page", function(event, num){
                console.log("num : " + num);
                doRetrieve(num);
            }); 
            
        }
        
        function doRetrieve(page) {
            console.log("function doRetrieve");
            console.log("page: " + page);
            
            let url = "${CP}/order/orderList.do";
            let method = "GET";
            let async = true;
            let parameters = {
                    pageSize: 5, // 총몇개?
                    pageNum: page,
                    searchWord: "1",
                    // 뭘로 찾을거냐
            };
            
            EClass.callAjax(url, parameters, method, async, function(data) {
                console.log("EClass.callAjax data : " + data);
        
                
            //1.
            let parsedData = data;
            
             $("#listTable > tbody").empty();
            
             let htmlData = ""; // 동적으로 tbody아래 데이터 생성
             let totalCnt  = 0; // 총글수, 
             let pageTotal = 1; // 총 페이지수
             //let last = pageGroup * pageCount; // 화면에 보여질 마지막 페이지 번호
             
             // 조회 데이터가 있는 경우
                    if(null != parsedData && parsedData.length > 0) {
                 
                // totalCnt = parsedData[0].totalCnt                   
                // console.log('totalCnt : ' + totalCnt);
                // pageTotal = totalCnt/$("#pageSize").val();
                // console.log('pageTotal : ' + pageTotal);
                // pageTotal = Math.ceil(pageTotal);                  
                // console.log('pageTotal : ' + pageTotal);
                 
                $.each(parsedData, function(i, memberVO){
                     htmlData += "<tr> ";
                     htmlData += "<th width='150'  class='oNum' style='text-align:center;' height='99.5'>" +memberVO.oNum+"</th>"
                     htmlData += "<th width='130'><img src='${CP_RES}/img/" +memberVO.pNum+ ".jpg' alt='상품 이미지' width='92'/></th>";
                     htmlData += "<th width='330' style='text-align:center;'><a class='text'>" +memberVO.pName+ "</a></th>";
                     htmlData += "<th width='150' style='text-align:center;'>" +memberVO.pPrice+ "원</th>";
                     htmlData += "<th width='90' style='text-align:center;'>" +memberVO.dBuy+ "개</th>";
                     htmlData += "<th width='150' style='text-align:center;'>"+memberVO.oStatus+ "<br><input class='btn-2 button' type='button' value='리뷰쓰기' ></th>";
                     htmlData += "<th style='display: none;'>" +memberVO.dNum+ "</th>";
                     htmlData += "<th style='display: none;'>"+memberVO.oName+ "</th>";
                     htmlData += "<th style='display: none;'>"+memberVO.pNum+ "</th>";
                     htmlData += "</tr> ";
                 });
             //데이터가 없는 경우
             }else{
                 htmlData += "<tr><td colspan='99' class='text-center'>NO data found</td></tr> ";
             }
             
             //2.
             $("#listTable > tbody").append(htmlData);
             
         })
         
     }
     
     $("#doRetrieve").on("click", function(e) {
         console.log("doRetrieve");
         doRetrieve(1);
     });
 });
             // paging
             // 기존 페이징 지우기
             //$("#page-selection").empty();
             
             // paging 호출
             //renderingPage(pageTotal, page);
             
             // 관리 데이터 초기화
             //init();
             
         
        
        // table click (김주혜)
        $(document).on('click', '#listTable > tbody input', function(e){
            
            let clickInput = $(this); // $(this) : input
            let thArray = clickInput.parents("tr").children(); // th들 지정
            
            // 각각 값을  가져오기
            let oNum = thArray.first().text(); // 주문 번호
            let dNum = thArray.eq(6).text(); // 상세 번호
            let oName = thArray.eq(7).text(); // 회원이름
            let pNum = thArray.last().text(); // 상품번호
            console.log(oNum + "," + dNum + "," + oName + "," + pNum);
            window.open("${CP}/review/reviewPopup.do?oNum="+oNum+"&dNum="+dNum+"&oName="+oName+"&pNum="+pNum,"리뷰작성", "width=800, height=700, left=100, top=100");
            //--table click
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
                         <li><a href="#">장바구니</a></li>
                         <li><a href="#">FAQ</a></li>
                         <li><a href="#">공지사항</a></li>
                        </ul>
                    </c:when>
                    <c:otherwise>
                        <ul>
                         <li>
                           <a href="${CP}/login/login.do">로그인</a>
                         </li>
                         <li><a href="#">마이페이지</a></li>
                         <li><a href="#">장바구니</a></li>
                         <li><a href="#">FAQ</a></li>
                         <li><a href="#">공지사항</a></li>
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



<!------------------------- 주문조회 시작(최유빈) ------------------------------->
<div id="contents">
<!-- ▼▼▼▼▼▼▼▼▼▼▼▼▼ 마이페이지  사각형(최유빈)  ▼▼▼▼▼▼▼▼▼▼▼▼▼ -->
<title>my_page</title>

<div class="my_box">
    <ul>
        <li class="my"><strong>마이페이지</strong><li>
        <li class="info"><a href="${CP}/memberInfo/memberInfo.do">회원정보</a></li>
        <li class="order"><a href="${CP}/order/orderView.do"><strong>주문조회</strong></a></li>
    </ul>
</div>
<!-- ▲▲▲▲▲▲▲▲▲▲▲▲▲ 마이페이지  사각형 끝  ▲▲▲▲▲▲▲▲▲▲▲▲▲-->

  
  <table id="orderTable" class="order2" width = "1000" height="50px">
      <tr>
         <th width="150" style="text-align:center;"> 주문번호</th>
         <th width="130" style="text-align:center;"></th>
         <th width="330" style="text-align:center;">상품정보</th>
         <th width="150" style="text-align:center;">금액</th>
         <th width="90"  style="text-align:center;">수량</th>
         <th width="150" style="text-align:center;">진행상태</th>
         
         <!--  아래 세개는 리뷰 페이지를 위해 필요한 것  : 조회 필요-->
         <th width="100" style="display: none;">상세번호</th>
         <th width="100" style="display: none;">회원이름</th>
         <th width="100" style="display: none;">상품번호</th>
      </tr>
  </table>
      
      <table class="order3" id="listTable" width = "1000" height="98">
      <tbody>
        <c:choose>
         <c:when test="${list.size() > 0}">
             <c:forEach var="list" items="${list}"> 
               <!-- 문자: 왼쪽, 숫자: 오른쪽, 같은면: 가운데 -->
                <tr>
                    <th width="150" class="oNum" style="text-align:center;" height="99.5"> ${list.oNum}</th>
                    <th width="130" ><a href="#"><img src="${CP_RES}/img/${list.pNum}.jpg" alt="상품 이미지" width="92"/></a></th>
                    <th width="330" style="text-align:center;"><a href="#" class="text">${list.pName}</a></th>
                    <th width="150" style="text-align:center;">${list.pPrice}원
                    </th>
                    <th width="90" style="text-align:center;">${list.dBuy}개</th>
                    <th width="150" style="text-align:center;">${list.oStatus}
                      <br><input class="btn-2 button" type="button" value="리뷰쓰기" >
                    </th>
                    <th style="display: none;">${list.dNum}</th>
                    <th style="display: none;">${list.oName}</th>
                    <th style="display: none;">${list.pNum}</th>
                </tr>                                                           
            </c:forEach>
            </c:when>
                 <c:otherwise>
                    <tr><td colspan="99" class="text-center">주문하신 상품이 없습니다.</td></tr>
                </c:otherwise>
        </c:choose> 
        </tbody>
       </table>
       </div>
       
       <!-- pagenation(페이징 1,2,3,4,5 버튼 나타내기) -->
        <div class="text-center col-sm-12 col-md-12 col-lg-12">
            <div id="page-selection" class="text-center page"></div>
        </div>
        <!-- pagenation ---------------------------------------->
<!------------------------- 주문조회 끝(최유빈) ------------------------------->
</body>
</html>