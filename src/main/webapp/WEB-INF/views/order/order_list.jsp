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
    <!-- 스타일 시트 -->
    <style type="text/css">
    * {
        margin: 0;
        padding: 0;
    }
    table {
        width: 600px;
        border-collapse: collapse;
    }
    td, th {
        border-bottom: 1px solid lightgray;
        padding: 5px;
    }
    th {
        background: gray;
        color: white;
    }
      
    .txt_center {
      text-align: center;
    }

</style>
    
    <title>주문 조회 페이지</title>
    <!-- jQuery -->
    <script src="${CP_RES}/js/jquery-1.12.4.js"></script>

        
    <script type="text/javascript">
      $(document).ready(function(){
        console.log("document.ready");  
        
        // table click
        $('#listTable > tbody > tr').on("click", "input" ,function(){ 
            
            let clickInput = $(this); // $(this) : input
            let tdArray = clickInput.parents("tr").children(); // td들 지정
            
            // 각각 값을  input에 넣음
            let oNum = tdArray.eq(0).text(); // 주문 번호
            let dNum = tdArray.eq(5).text(); // 상세 번호
            let kName = tdArray.last().text(); // 회원이름
            
            console.log(oNum);
            console.log(dNum);
            console.log(kName);

            let frm = document.getElementById("orderListFrm");
            frm.oNum.value = oNum;
            frm.dNum.value = dNum;
            frm.kName.value = kName;
            window.open("${CP}/review/reviewPopup.do","리뷰작성", "width=800, height=700, left=100, top=100");


            //--table click
        });
      });
      
      
    </script>
</head>
<body>
  <h2>주문 조회</h2>
  <hr/>
  
  <div>
    <form action="${CP}/order/orderList.do" name="orderListFrm" method="get" id="orderListFrm">
      <input type="text" name="work_div" id="work_div" style="display: none;">
      <input type="text" name="oNum" id="oNum" style="display: none;">
      <input type="text" name="dNum" id="dNum" style="display: none;">
      <input type="text" name="kName" id="kName" style="display: none;">
    </form> 
  </div>
  list.size : ${list.size()}
  <table id="listTable">
    <thead>
      <tr>
         <th width="80">주문번호</th>
         <th width="200">상품정보</th>
         <th width="80">금액</th>
         <th width="100">수량</th>
         <th width="80">진행상태</th>
         <th width="100" style="display: none;">상세번호</th>
         <th width="100" style="display: none;">회원이름</th>
      </tr>
    </thead>
    <tbody>
        <c:choose>
         <c:when test="${list.size() > 0}">
             <c:forEach var="list" items="${list}"> 
               <!-- 문자: 왼쪽, 숫자: 오른쪽, 같은면: 가운데 -->
                <tr>
                    <td class="text-center">${list.oNum}</td>
                    <td class="txt_center">${list.pName}</td>
                    <td class="txt_center">${list.pPrice}</td>
                    <td class="text-center">${list.dBuy}</td>
                    <td class="text-left">
                      ${list.oStatus}
                      <input type="button" value="리뷰 쓰기"/>
                    </td>
                    <td style="display: none;">${list.dNum}</td>
                    <td style="display: none;">${list.kName}</td>
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