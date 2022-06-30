'use strict';
function showPopUp() {

  //창 크기 지정
  var width = 500;
  var height = 500;

  //pc화면기준 가운데 정렬
  var left = (window.screen.width / 2) - (width / 2);
  var top = (window.screen.height / 4);

  //윈도우 속성 지정
  var windowStatus = 'width=' + width + ', height=' + height + ', left=' + left + ', top=' + top + ', scrollbars=yes, status=yes, resizable=yes, titlebar=yes';

  //연결하고싶은url
  const url = "http://localhost:8081/ctrl/login/login.do";

  //등록된 url로 팝업창을 연다.
  window.open(url, windowStatus);
}

//access_token 이용하여 사용자정보 얻은 후 alert(mName+"님 환영합니다!") -> 확인버튼 -> 팝업클로즈 + 메인새로고침(로그아웃)
function getMemberInfo() {
	
}


