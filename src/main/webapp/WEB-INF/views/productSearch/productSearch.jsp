<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CP" value="${pageContext.request.contextPath}"/>
<c:set var="resources" value="/resources"/>
<c:set var="CP_RES"    value="${CP }${resources}" />
<!DOCTYPE html>
<html>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <link rel="shortcut icon" type="image/x-icon" href="${CP}/favicon.ico">
    <link rel="stylesheet" type="text/css" href="${CP_RES }/css/main/main.css">
    <link rel="stylesheet" type="text/css" href="${CP_RES}/css/productSearch/productSearch.css">    
    <title>상품 검색</title>
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script src="${CP_RES }/js/etc/jquery-1.12.4.js"></script>
<!-- 사용자 정의 function, callAjax -->
<script src="${CP_RES }/js/etc/eclass.js"></script>
<!-- 사용자 정의 function, isEmpty -->
<script src="${CP_RES }/js/etc/eUtil.js"></script>

    <!-- jquery_bootstrap paging -->
    <script type="text/javascript" src="${CP_RES}/js/etc/jquery.bootpag.js"></script>
        
    <script type="text/javascript">
      $(document).ready(function(){
        console.log("document.ready");  
        
        
      //document.ready    
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
                         <li><a href="${CP}/memberInfo/memberInfo.do">마이페이지</a></li>
                         <li><a href="#">장바구니</a></li>
                         <li><a href="#">FAQ</a></li>
                         <li><a href="#">공지사항</a></li>
                        </ul>
                    </c:otherwise>
                </c:choose>
                <form action="#" method="get" id="search" name="search">
                    <input type="text" id="searchWord" class="searchWord"/>
                    <button>
                        <i class="fas fa-search fa-lg" id="doRetrive"></i>
                    </button>
                </form>
            </div>
        </div>
    </div>

<!-- 메인 헤더 영역 끝 (이은빈)-------------------------------------------------->
<!-- 상품검색 페이지 시작(이은빈) -------------------------------------------------->



  <!-- div container -->
       <div class="container">
          <!-- 제목 -->
          <div class="page-header">
              <h2>${searchWord}에 대한 검색결과입니다.</h2>
          </div>
          <!--// 제목 ----------------------------------------------------------->
                 
       <!-- 검색영역 -->
          <div class="row">
            <form action="#" class="form-inline col-sm-12 col-md-12 col-lg-12 text-right">
               <div class="form-group">
                 <select class="form-control  input-sm" name="searchDiv" id="searchDiv"> 
                    <option value="">전체</option>
                    <option value="10">제목</option>
                    <option value="20">내용</option>
                 </select>
                 <input type="text" class="form-control input-sm"  name="searchWord" id=""   placeholder="검색어" />
                 <select class="form-control  input-sm" name="pageSize"  id="pageSize"> 
                    <option value="10">10</option>
                    <option value="20">20</option>
                    <option value="30">30</option>
                 </select>  
               <input type="button" class="btn btn-primary btn-sm" value="목록" id="" />
               <input type="button" class="btn btn-primary btn-sm" value="등록" id="moveToReg"/>                              
               </div>
            </form>
          
          </div>
          <!--// 검색영역 ----------------------------------------------------------->
          
          <div class="page_name" >상품검색</div>
        <div id="contents">
             <c:choose>
                <c:when test="${list.size()> 0 }">
                  <c:forEach var="list"  items="${list }">
                     <div id="list" style="float:left;padding:30px;width:33%">
                   <img src="${CP_RES}/img/${list.pNum}.jpg" class="img_list" alt="상품 이미지" />
                   <p class="p1">${list.pName}</p><br/>
                   <p class="p1">${list.pPrice}원</p>
                </div>
                  </c:forEach>
                </c:when>
                <c:otherwise>
                 <tr>
                    <td colspan="99">No data found</td>
                 </tr>
                </c:otherwise>
             </c:choose>         
        </div>
          <!-- pagenation -->
          <div  class="text-center col-sm-12 col-md-12 col-lg-12">
              <div id="page-selection" class="text-center page"></div>
          </div>                    
          <!--//pagenation ------------------------------------------------------>
       </div>
       <!--// div container --------------------------------------------------->
   
     
<!-- 상품검색 페이지 끝(이은빈) -------------------------------------------------->    
</body>
</html>