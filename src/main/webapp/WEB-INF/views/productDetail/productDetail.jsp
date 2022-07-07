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
<%@page import="java.util.Date"%>
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
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <!-- 부트스트랩 -->
    <link href="${CP_RES }/css/etc/bootstrap.min.css" rel="stylesheet">
    <link rel="shortcut icon" type="image/x-icon" href="${CP }/favicon.ico">
    <link rel="stylesheet" type="text/css" href="${CP_RES}/css/main/main_boot.css">
    <link rel="stylesheet" type="text/css" href="${CP_RES }/css/productDetail/productDetail.css">
    
    <title>제품 상세 페이지</title>
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="${CP_RES }/js/etc/jquery-1.12.4.js"></script>
    <!-- 사용자 정의 function, callAjax -->
    <script src="${CP_RES }/js/etc/eclass.js"></script>
    <!-- 사용자 정의 function, isEmpty -->
    <script src="${CP_RES }/js/etc/eUtil.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<%--     <script src="${CP_RES }/js/etc/bootstrap.min.js"></script> --%>
    <script type="text/javascript" src="${CP_RES}/js/productDetail/productDetail.js"></script>
    <!-- jquery_bootstrap paging -->
    <script type="text/javascript" src="${CP_RES}/js/etc/jquery.bootpag.js"></script>
    
    <!-- font awesome -->
    <script src="https://kit.fontawesome.com/2974daa1cb.js" crossorigin="anonymous"></script>
	<script type="text/javascript" src="${CP_RES}/js/login/login_popup.js"></script>
    <script type="text/javascript">
       $(document).ready(function(){
           console.log("document.ready");
           
           /*----------------- 헤더에서 각 카테고리로 이동하는 기능 시작(최유빈)-------------------*/
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
           /*----------------- 헤더에서 각 카테고리로 이동하는 기능 끝(최유빈)-------------------*/
           
           /*----------------- 리뷰(김주혜) 시작-------------------*/
           
           // 리뷰 - 버튼 누르면 관리자 댓글 나오게 하기
           $("#review_table").on("click", ".rdButton", function() {
               console.log("rdButton");
              console.log($('#buy_number').text());
               $(this).toggleClass('open').siblings().removeClass('open');
               $(this).next(".manager_comment").stop().slideToggle(250);
           });
           

           renderingPage('${pageTotal}', 1);
           
           let productImgSrc = $('#productImg').attr("src");
           let pNum = productImgSrc.substring(productImgSrc.lastIndexOf('/')+1,productImgSrc.lastIndexOf('.'));
           
           // 몇일전, 몇시간전..등을 구하는 함수
           function timeForToday(value) {
               const today = new Date();
               const timeValue = new Date(value);
               
               const betweenTime = Math.floor((today.getTime() - timeValue.getTime()) / 1000 / 60);
               if (betweenTime < 1) return '방금전';
               if (betweenTime < 60) {
                   return betweenTime+'분전';
               }

               const betweenTimeHour = Math.floor(betweenTime / 60);
               if (betweenTimeHour < 24) {
                   return betweenTimeHour+'시간전';
               }

               const betweenTimeDay = Math.floor(betweenTime / 60 / 24);
               if (betweenTimeDay < 365) {
                   return betweenTimeDay+'일전';
               }

               return Math.floor(betweenTimeDay / 365)+'년전';
           }
           
           // paging
           function renderingPage(pageTotal, page) {
               console.log("pageTotal : " + pageTotal); // 소숫점
               console.log("page : " + page);
               
               pageTotal = parseInt(pageTotal); // 정수
               console.log("pageTotal : " + pageTotal);
               
               // 이전 연결된 EventHandler 제거
               $("#page-selection").unbind('page');

               $('#page-selection').bootpag({
                   total: pageTotal,
                   page: page,
                   maxVisible: 10,
                   leaps: true,
                   firstLastUse: true,
                   first: '←',
                   last: '→',
                   wrapClass: 'pagination',
                   activeClass: 'active',
                   disabledClass: 'disabled',
                   nextClass: 'next',
                   prevClass: 'prev',
                   lastClass: 'last',
                   firstClass: 'first'
               }).on("page", function(event, num){
                   console.log("num : " + num);
                   doReviewsRetrieve(num);
               }); 
           }
           
           function doReviewsRetrieve(page) {
               console.log("**function doRetrieve**");
               console.log("page: " + page);
               
               let url = "${CP}/productDetail/doReviewsRetrieve.do";
               let method = "GET";
               let async = true;
               let parameters = {
                       pageSize: 7,
                       pageNum: page,
                       searchWord: pNum
               };
               
               EClass.callAjax(url, parameters, method, async, function(data) {
                   console.log("EClass.callAjax data : " + data);
                   
                   // 기존 table 데이터 삭제
                   // 동적으로 table 데이터 표시
                   
                   let parsedData = data;
                   
                   $("#review_table").empty(); // 기존 데이터 삭제
                   
                   console.log("parsedData.length : " + parsedData.length);
                   
                   let htmlData = ""; // 동적으로 #review_table 아래 데이터 생성
                   
                   // 조회 데이터가 있는 경우
                   if(null != parsedData && parsedData.length > 0) {
                       
                       $.each(parsedData, function(i, reviewVO){
                           let rContent = reviewVO.rContent;
                           let rdCon = reviewVO.rdCon;
                           let cnt = reviewVO.cnt;
                           let memberNum = reviewVO.mNum;
                           let rdReg = reviewVO.rdReg;
                           
                           htmlData += " <div class='reivew_data'>                                                     ";
                           htmlData += "   <div style='display:none;' id='reviewNum'>"+reviewVO.rNum+"</div>";
                           htmlData += "   <div style='display:none;' id='reviewOname'>"+reviewVO.oName+"</div>";
                            if(memberNum == "${sessionScope.member.mNum}") {  // 작성한 회원과 로그인한 사람이 같으면
                              htmlData += "  <input type='button' id='reviewDelete' value='삭제' class='btn-1 button'>";
                              htmlData += "  <input type='button' id='reviewUpdate' value='수정' class='btn-1 button'>";
                            } 
                           htmlData += "     <div class='review_head'>";
                           htmlData += "        <strong class='customer_name'>"+ <c:out value='reviewVO.oName' />+"</strong> ";
                           htmlData += "        <div class='review_contents'>" + timeForToday(reviewVO.rDt) +"</div>        ";
                           htmlData += "     </div> ";
                           htmlData += "     <p class='review_contents'>" + rContent.replaceAll('\n', '<br/>') +"</p>        ";
                           htmlData += " </div>";
                                   
                           htmlData += " <p class='rdButton'></p>        ";
                           htmlData += " <div class='manager_comment'> ";  
                           htmlData += "   <div style='display:none;' id='reviewNum'>"+reviewVO.rNum+"</div>";
                           if(cnt == 1) {  // 로그인한 사람이 관리자일때   
                                if('N' == rdCon){ // 댓글 내용이 없을 때 
                                   htmlData += " <input type='button' id='rdInsert' value='등록' class='btn-1 button'>";                                           
                                }else {
                                   htmlData += " <input type='button' id='rdDelete' value='삭제' class='btn-1 button'>";
                                   htmlData += " <input type='button' id='rdUpdate' value='수정' class='btn-1 button'>";
                                }
                           } 
                           htmlData += "   <div class='review_head'>";
                           if('N' != reviewVO.rdName) {
                             htmlData += "      <strong id='rdName' class='customer_name'>"+<c:out value='reviewVO.rdName' />+"</strong>";
                           }
                           if(null != reviewVO.rdReg) {
                             htmlData += "      <div class='review_contents'>" + timeForToday(reviewVO.rdReg)  +"</div>        ";
                           }
                           htmlData += "   </div> ";
                           if('N' != rdCon){
                                htmlData += "   <div class='review_contents'>"+ rdCon.replaceAll('\n', '<br/>')+"</div>";
                           }
                           htmlData += " </div>"; 

                       });
                       
                   }else {
                       htmlData += " <div class='reivew_data'>                                                     ";
                       htmlData += "     <p class='review_contents rAlign'>리뷰가 없습니다!</p>";
                       htmlData += " </div>                                                                       ";
                   }
                   // 조회 데이터가 없는 경우
                   $("#review_table").append(htmlData); 
                  
               }); 
            }
           
           $(".accord_title").on("click", function(e) {
               console.log("doReviewsRetrieve");
               doReviewsRetrieve(1);
           });
           
            // 회원 리뷰 수정
           $(document).on("click", '#review_table #reviewUpdate', function(e) {
               console.log('reviewUpdate');
               
               
               var reviewDataTag = $(this).parents('.reivew_data').html();
               
               var rNumber = reviewDataTag.substring(reviewDataTag.indexOf('>')+1, reviewDataTag.indexOf('/')-1);
               rNumber = parseInt(rNumber);
               console.log("rNumber : " + rNumber);
               
               var tagCut = reviewDataTag.substring(reviewDataTag.indexOf('O')+1);
               var oName = tagCut.substring(tagCut.indexOf('>')+1, tagCut.indexOf('/')-1);
               console.log("tagCut : " + tagCut);
               
               
               window.open("${CP}/review/reviewUpdatePopup.do?rNum="+rNumber+"&oName="+oName,"댓글 작성", "width=800, height=700, left=100, top=100");
               
           });
            
           // 회원 리뷰 삭제 
           $(document).on("click", '#review_table #reviewDelete', function(e) {
               var reviewDataTag = $(this).parents('.reivew_data').html();
               
               var rNumber = reviewDataTag.substring(reviewDataTag.indexOf('>')+1, reviewDataTag.indexOf('/')-1);
               rNumber = parseInt(rNumber);
               console.log("rNumber : " + rNumber);
               
               let url = "${CP}/review/reviewDelete.do";
               let method = "GET";
               let async = true;
               let parameters = {
                       rNum : rNumber
               };
               
               EClass.callAjax(url, parameters, method, async, function(data) {
                   
                   console.log("data.msgId :"+ data.msgId);
                   console.log("data.msgContents :"+ data.msgContents);
                   
                   if("1" == data.msgId){
                       alert(data.msgContents);
                       window.location.reload();
                    }else{
                       alert(data.msgContents);
                       window.location.reload();
                    } 
               });
           });
           
           // 관리자 댓글 삭제 
           $(document).on("click", '#review_table #rdDelete', function(e) {
               var managerCommentTag = $(this).parents('.manager_comment').html();
               var rNumber = managerCommentTag.substring(managerCommentTag.indexOf('>')+1, managerCommentTag.indexOf('/')-1);
               rNumber = parseInt(rNumber);
               console.log("rNumber : " + rNumber);
               
               
               let url = "${CP}/review/rdDelete.do";
               let method = "GET";
               let async = true;
               let parameters = {
                       rNum : rNumber
               };
               
               EClass.callAjax(url, parameters, method, async, function(data) {
                   
                   console.log("data.msgId :"+ data.msgId);
                   console.log("data.msgContents :"+ data.msgContents);
                   
                   if("1" == data.msgId){
                       alert(data.msgContents);
                       window.location.reload();
                    }else{
                       alert(data.msgContents);
                       window.location.reload();
                    } 
               });
           });
           
            // 관리자 댓글 입력
           $(document).on("click", '#review_table #rdInsert', function(e) {
               console.log('rdInsert');
               var managerCommentTag = $(this).parents('.manager_comment').html();
               var rNumber = managerCommentTag.substring(managerCommentTag.indexOf('>')+1, managerCommentTag.indexOf('/')-1);
               rNumber = parseInt(rNumber);
               console.log("rNumber : " + rNumber);
               window.open("${CP}/review/rdPopup.do?rNum="+rNumber,"댓글 작성", "width=800, height=700, left=100, top=100");
                
           });
           
           // 관리자 댓글 수정
           $(document).on("click", '#review_table #rdUpdate', function(e) {
               console.log('rdUpdate');
               
               var managerCommentTag = $(this).parents('.manager_comment').html();
               var rNumber = managerCommentTag.substring(managerCommentTag.indexOf('>')+1, managerCommentTag.indexOf('/')-1);
               rNumber = parseInt(rNumber);
               window.open("${CP}/review/rdUpdatePopup.do?rNum="+rNumber,"댓글 작성", "width=800, height=700, left=100, top=100");
               
           });   
          
           
           /*----------------- 리뷰(김주혜) 끝-------------------*/
       });

    </script>
    <body>
      <!-- 메인 헤더 영역 시작 (이은빈)----------------------------------------------->
    <div id="header">
            <div id="logo">
                <a href="${CP}/main/main.do"><img src="${CP_RES}/img/tableware_logo.png" alt="로고이미지"></a>
            </div>
        <div id="top">
            <div class="menu_left">
                <ul>
                    <li><a href="#" id="bowls">접시</a></li>
                    <li><a href="#" id="cup">머그컵</a></li>
                    <li><a href="#" id="glass">유리잔</a></li>
                    <li><a href="#" id="plate">보울/면기</a></li>
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
                         <li><a href="${CP}/memberInfo/memberInfo.do">마이페이지</a></li>
                         <li><a href="#">장바구니</a></li>
                         <li><a href="#">FAQ</a></li>
                         <li><a href="#">공지사항</a></li>
                        </ul>
                    </c:otherwise>
                </c:choose>
            <!-- 상품 검색 영역 시작(이은빈) ----------------------------------------->             
                <form action="${CP}/productSearch/View.do" method="get" id="search" name="search">
                    <input type="text" id="searchWord" class="searchWord" name="searchWord" value=""/>
                    <button id="doRetrive">
                        <i class="fas fa-search fa-lg" ></i>
                    </button>
                </form>
             <!-- 상품 검색 영역 끝(이은빈) ----------------------------------------->          
            </div>
        </div>
    </div>

    <!-- 메인 헤더 영역 끝 (이은빈)-------------------------------------------------->
    
    <!-- 콘텐츠 영역 시작(김주혜) -->
    <div id="contents">
      <!-- 상품 상세 콘텐츠 영역 첫번째 시작 (이미지, 이름, 가격, 버튼들)(김주혜)-->
        <div class="product_contents">
          <img alt="상품 이미지" src="${CP_RES}/img/${productInfo.pNum}.jpg" id="productImg">
            
          <div class="info">
                <!-- 상품 이름, 용량, 가격 -->
                <strong class="product_name">${productInfo.pName}</strong><br/>
                <hr/>
                <p class="product_price"><fmt:formatNumber type="number" maxFractionDigits="3" value="${productInfo.pPrice}"/>원</p>
            
                <!-- 수량 -->
                <div id="amount">
                  <div id="buy_number">0</div>
                        <div class="number_buttons">
                            <input type="button" id="plus" name="plus" value="+"/>              
                            <input type="button" id="minus" name="minus" value="-"/>
                        </div>
                </div>
                <!--// 수량 -->
                
                <!-- 총금액 -->  
                <div class="totalDiv">
	                <p class="total_price">Total price :  </p>
	                <div id="total_num"> 0</div><br/>
                </div>
                <!-- 배송비 무료 공지 -->
                <p id="delivery_free">배송비 무료</p>
                
                <!-- 장바구니, 구매 버튼 -->
                <div class="submit_buttons">
                     <input class="btn-2 button" type="submit" value="CART" >
                     <input class="btn-1 button" type="submit" value="BUY">          
                </div>            
            </form>
          </div> <!-- .info -->
        </div> <!-- .product_contents -->
      <!-- 상품 상세 콘텐츠 영역 첫번째 끝 (이미지, 이름, 가격, 버튼들)(김주혜)-->  
    
    <!-- 아코디언 메뉴(상세설명, 리뷰)(김주혜) -->
    <div id="Accord_container">
        <!-- 상세설명 시작 (김주혜)-->
        <div id="Accordion_wrap">
           <div class="accord_title">
            <span>제품 정보</span>
           </div>
           <div class="contents">
                        상품 이름 : <span>${productInfo.pName}</span>
             <br/><br/>
                        용량 : <span>${productInfo.pSize}</span></br/>
                        가격 : <span class="detail_price"><fmt:formatNumber type="number" maxFractionDigits="3" value="${productInfo.pPrice}"/>원</span>
           </div>
           <!-- 상세설명 끝 (김주혜)-->
           
           <!-- review 시작 (김주혜)-->
           <div class="accord_title">
            <span>고객 리뷰(${totalCnt})</span>
           </div>
           
           <div id="reviewDiv" class="contents">
                <div id="review_table">
                </div>
                <!-- pagenation(김주혜) -->
                  <div class="rAlign">
                      <div id="page-selection" class="page"></div>
                  </div>             
                <!--//pagenation(김주혜) ------------------------------------------------------>                
           </div>
           <!-- review 끝(김주혜)-->
        </div>
    </div>
    <!--// 아코디언 메뉴(상세설명, 리뷰)(김주혜) -->
    </div> 
    <!-- 콘텐츠 영역 끝(김주혜) -->
    
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
    
    <!-- payBefore로 GET방식으로 값 넘기기(김병완) -->
    <script type="text/javascript">
    $(".btn-1").on("click", function(){
    	let productPrice = $(".product_price").text(); // 상품 금액
  	  	let minusComma = productPrice.replace(",", ""); // 상품금액에서 , 제거
  	  	let priceNumber = minusComma.substring(0, minusComma.indexOf("원"));
  	  	
    	let totalNum = $("#total_num").text(); // 상품 금액
  	  	let mminusComma = totalNum.replace(",", ""); // 상품금액에서 , 제거
  	  	let total = mminusComma.substring(0, mminusComma.indexOf("원"));

        let productImgSrc = $('#productImg').attr("src");
        let pNum = productImgSrc.substring(productImgSrc.lastIndexOf('/')+1,productImgSrc.lastIndexOf('.'));
        let product_name = $(".product_name").text();
        let buy_number = $("#buy_number").text();
        
        location.href = "/ctrl/pay/payBefore.do?pNum=" + pNum + "&product_name=" + product_name
                + "&product_price=" + priceNumber + "&buy_number=" + buy_number +
                "&totalNum=" + total;
    });
    </script>
    <!-- //payBefore로 GET방식으로 값 넘기기(김병완) -->
    
    <!-- addcart 에 get방식으로 값 넘기기 ( 김태민 ) -->
    
  <script type="text/javascript">
           $(".btn-2").on("click", function(){
                 let productImgSrc = $('#productImg').attr("src");
                 let pNum = productImgSrc.substring(productImgSrc.lastIndexOf('/')+1,productImgSrc.lastIndexOf('.'));
                 location.href = "/ctrl/cart/addcart.do?pNum=" + pNum ;
           });
  </script>
  
    <!-- addcart 에 get방식으로 값 넘기기 ( 김태민 ) -->
    
    </body>
</html> 
    