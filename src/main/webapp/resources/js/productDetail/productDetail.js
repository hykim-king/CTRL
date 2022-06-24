'use strict';

$(document).ready(function(){
  $(".accord_title").click(function() {
    $(this).next(".contents").stop().slideToggle(300);
    $(this).toggleClass('on').siblings().removeClass('on');
    $(this).next(".contents").siblings(".contents").slideUp(300); // 1개씩 펼치기
  });
  
});

/* 구매 수량 증가&감소 함수 - 수량과 total price가 같이 증가&감소 */ 
function count(type)  { 
  // 현재 화면에 표시된 값
  var bNumber = $("#buy_number").text(); // 구매 수량
  var productPrice = $(".product_price").text(); // 상품 금액
  
  // 더하기/빼기
  if(type === "plus") {
	  if(bNumber < 999) {
		  $("#buy_number").text(parseInt(bNumber) + 1);
		  bNumber = parseInt(bNumber) + 1;  
	  }
    
    
  }else if(type === "minus")  {
    if(bNumber == 1) {
      $("#buy_number").text('1');
      return;
    }
    
    $("#buy_number").text(parseInt(bNumber) - 1);
    bNumber = parseInt(bNumber) - 1;
  }
  
  // 총 금액 변경 
  $("#total_num").text(bNumber * productPrice);
}
