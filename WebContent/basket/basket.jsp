<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	trimDirectiveWhitespaces="true"%>

<div id="content-container">
	<table width="100%" border="0" style="margin:auto; max-width:1000px;">
		<tr>			
			<td height="10">				
				
			</td>			
		</tr>

		<tr>
			<td align="center">
				<h2>장바구니</h2>
			</td>
		</tr>
		
		<tr>
			<td height="1" bgcolor="#777777"></td>
		</tr>

		<tr>
			
			<td>
				<table width="100%" border="0">
								<tr><td colspan="9" bgcolor="#cccccc" height="1"></td></tr>
								
								<tr bgcolor="#455b59" style="color:#FFFFFF;" align="center">
									<td width="1%"><input type="checkbox"/></td>
									<td width="10%">이미지</td>
									<td width="19%">상품정보</td>
									<td width="15%">판매가</td>
									<td width="10%">수량</td>
									<td width="10%">배송구분</td>
									<td width="10%">배송비</td>
									<td width="15%">합계</td>
									<td width="10%">선택</td>
								</tr>
								<tr><td colspan="9" bgcolor="#cccccc" height="1"></td></tr>
<!-- 게시물 하나씩 iterator 시작 -->
								<tr align="center">
									<td width="1%"><input type="checkbox"/></td>
									<td width="10%"><img src="/semiP/assets/images/best1.jpg" style="width:100%;"></td>
									<td width="19%">상품이름이름이름<br><font style="font-size:0.8em; color:777777">상품옵션옵션</font></td>
									<td width="15%">₩ 100,000</td>
									<td width="10%">
										<input type="button" id="p_btn" value="+" style="background-color:#cccccc;width:80%;"><br>
										<input type="text" id="count" value="0" style="text-align:center; width:80%;" readonly="readonly"><br>
										<input type="button" id="m_btn" value="-" style="background-color:#cccccc;width:80%;">
									</td>
									<td width="10%">택배</td>
									<td width="10%">₩ 2,500</td>
									<td width="15%">₩ 102,500</td>
									<td width="10%">
										<input type="button" value="주문하기" style="width:80%;"><br><br>
										<input type="button" value="삭제" style="width:80%;">
									</td>
								</tr>
								<tr><td colspan="9" bgcolor="#f2f2f2" height="1"></td></tr>
								<tr bgcolor="#455b59" style="color:#FFFFFF;" align="center">
									<td colspan="3" width="50%" height="100px" style="font-size:1.5em;">
										[ 기본배송 ]
									</td>
									<td colspan="6" width="50%" height="100px" align="right" style="padding:20px;font-size:1.5em;">
										상품구매액 100,000 + 배송비 2,500 = 합계 : 102,500원
									</td>
								</tr>
<!-- 게시물 하나씩 iterator 끝 -->																
								<tr><td colspan="9" bgcolor="#cccccc" height="1"></td></tr>
								<tr>
									<td colspan="9" align="left" style="font-size:1.5em;">
										선택상품을&nbsp;
										<input type="button" value="주문하기" style="width:150px;">&nbsp;
										<input type="button" value="주문하기" style="width:150px;">
									</td>
								</tr>
								<tr>	<td height="50"></td>	</tr>
								<tr>
									<td colspan="9" style="border:1px solid black; padding:20px;">
<p><strong>장바구니 이용안내</strong></p>
선택하신 상품의 수량을 변경하시려면 수량변경 후 [변경] 버튼을 누르시면 됩니다.<br>
<strong>[쇼핑계속하기]</strong> 버튼을 누르시면 쇼핑을 계속 하실 수 있습니다.<br>
장바구니와 관심상품을 이용하여 원하시는 상품만 주문하거나 관심상품으로 등록하실 수 있습니다.<br>
<br>
<p><strong>무이자할부 이용안내</strong></p>
상품별 무이자할부 혜택을 받으시려면 무이자할부 상품만 선택하여 <strong>[주문하기]</strong> 버튼을 눌러 주문/결제 하시면 됩니다.<br>
<strong>[전체 상품 주문]</strong> 버튼을 누르시면 장바구니의 구분없이 선택된 모든 상품에 대한 주문/결제가 이루어집니다.<br>
단, 전체 상품을 주문/결제하실 경우, 상품별 무이자할부 혜택을 받으실 수 없습니다.<br>

									</td>
								</tr>
							</table>
<script type="text/javascript" src="/semiP/assets/js/goodsCount.js"></script>