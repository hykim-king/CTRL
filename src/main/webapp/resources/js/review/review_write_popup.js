 'use strict';

 $(document).ready(function(){
     /* 리뷰 팝업창 내용에 맞게 크기 조절 */
     var strDocumentWidth = $(document).outerWidth();
     var strDocumentHeight = $(document).outerHeight();
     
     console.log(strDocumentWidth, strDocumentHeight);
     window.resizeTo ( strDocumentWidth, strDocumentHeight );
     
     var strMenuWidth = strDocumentWidth - $(window).width();
     var strMenuHeight = strDocumentHeight - $(window).height();

     var strWidth = $('#container').outerWidth() + strMenuWidth;
     var strHeight = $('#container').outerHeight() + strMenuHeight;
     
     window.resizeTo( strWidth, strHeight );
     
     /* 주문 번호, 주문 상세 번호 받아오기 */
     var detailNumVal = opener.$("#dNum").val(); // 주문 조회 페이지에서 주문 상세 번호 가져오기
     var orderNumVal = opener.$("#oNum").val(); // 주문 조회 페이지에서 주문번호 가져오기
     var kakaomNameVal = opener.$("#kName").val(); // 주문 조회 페이지에서 회원 이름 가져오기
     console.log(detailNumVal);
     console.log("kakaomNameVal : " + kakaomNameVal);
     
     
     // input에 주문 번호, 주문 상세 번호, 회원이름 넣기
     $("#dNum").val(detailNumVal);
     $("#oNum").val(orderNumVal);
     $("#oName").val(kakaomNameVal);
     console.log($("#dNum").val());
//--$(document).ready
});
 