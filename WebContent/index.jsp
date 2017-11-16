<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

* 이건 레이아웃 작업만 되어 있는 페이지고, 개발완료 후에 어떤 아웃풋이 나올지 예상해보기 위한 페이지입니다<br>
* 실제 코드 등은 github 에서 최신 소스를 받아서 확인해 주세요.<br>
* 폴더/파일 순서는 abc 순서로 정리했습니다.<br>
<br>
<br>
[ basket 폴더]<br>
<a href="/semiP/basket.tiles" target="_blank">basket</a><br>
<br>

[ common 폴더 ]<br>
<a href="/semiP/common/checkPassword.jsp" onClick="window.open(this.href, '', 'width=400, height=250'); return false;">checkPassword.jsp</a><br>
&nbsp;&nbsp; --> 창 사이즈 지정해서 팝업으로 띄워서 처리합니다. (400*250)<br>
<br>
[ goods 폴더 ]<br> 
<a href="/semiP/goodsList.tiles" target="_blank">goodsList</a><br>
<a href="/semiP/goodsDetail.tiles" target="_blank">goodsDetail</a><br>
** 보드에서 사용하는 아이콘들은 /assets/images/board/ 폴더 안에 있습니다<br>
<a href="/semiP/goods/qnaView.jsp" onClick="window.open(this.href, '', 'width=600, height=430'); return false;">qnaView.jsp</a><br>&nbsp;&nbsp; --> 게시판 보기 및 작성하기 페이지도 새창으로 띄웁니다(600*430)<br>
<a href="/semiP/goods/qnaWrite.jsp" onClick="window.open(this.href, '', 'width=600, height=430'); return false;">qnaWrite.jsp</a><br>&nbsp;&nbsp; --> 게시판 보기 및 작성하기 페이지도 새창으로 띄웁니다(600*430)<br>
<br>
<br>
[ main 폴더 ]<br>
<a href="/semiP/main.tiles" target="_blank">main</a><br>
<a href="/semiP/search.tiles" target="_blank">search</a><br>
<br>
[member 폴더 ]<br>    
<a href="/semiP/idPassInquire.tiles" target="_blank">idPassInquire</a><br>
<a href="/semiP/joinForm.tiles" target="_blank">joinForm</a><br>
<a href="/semiP/loginForm.tiles" target="_blank">loginForm</a><br>
<br>
[mypage 폴더 ]<br>    
<a href="/semiP/orderList.tiles" target="_blank">orderList</a> - 주문/배송현황<br>
<a href="/semiP/profile.tiles" target="_blank">profile</a> - 회원정보<br>
<a href="/semiP/qnaList.tiles" target="_blank">qnaList</a> - 반품/교환<br>
<a href="/semiP/refundList.tiles" target="_blank">refundList</a> - 문의내역<br>
<a href="/semiP/myPage/reviewWrite.jsp" onClick="window.open(this.href, '', 'width=600, height=430'); return false;">reviewWrite.jsp</a><br>&nbsp;&nbsp; --> 새창으로 띄웁니다(600*430)<br>
<a href="/semiP/terminateForm.tiles" target="_blank">terminateForm</a> - 탈퇴폼<br>
<br>
[ order 폴더]<br>
<a href="/semiP/order.tiles" target="_blank">order</a><br>
<a href="/semiP/orderComplete.tiles" target="_blank">orderComplete</a><br>
<a href="/semiP/orderResult.tiles" target="_blank">orderResult</a><br>
<br>
[ support 폴더 ]<br>
<a href="/semiP/support/1on1Write.jsp" onClick="window.open(this.href, '', 'width=600, height=430'); return false;">1on1Write.jsp</a><br>&nbsp;&nbsp; --> 새창으로 띄웁니다(600*430)<br>
<a href="/semiP/faq.tiles" target="_blank">faq</a><br>
<a href="/semiP/notice.tiles" target="_blank">notice</a><br>
<br>





<br>