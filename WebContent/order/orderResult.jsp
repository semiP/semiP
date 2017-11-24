<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import = "java.util.List" %>

<div id="content-container">
	<table width="100%" border="0" style="margin:auto; max-width:1000px;">
		<tr>			
			<td height="10"></td>			
		</tr>

		<tr>
			<td align="center">
				<h2>주문결과</h2>
			</td>
		</tr>
		
		<tr>
			<td height="1" bgcolor="#777777"></td>
		</tr>

		<tr>
			
			<td>
				<table width="100%">					
					<tr><td height="20"/></tr>
					<tr>
						<td width="12%" />
						<td style="border:1px solid black; padding:20px;" align="center">
						
							<p><strong>
							<!-- 주문번호: 3213213213212131321 -->
							주문번호 : ${order_no}
							
							
							</strong></p>
							<!-- 주문날짜: 날짜날짜날짜<br> -->
							주문날짜 : ${order_date}
							
							<br>
							<p><strong>
							고객님의 주문이 완료되었습니다
							</strong></p>
							주문내역 및 배송에 관한 안내는 <a href="#">주문조회</a>를 통하여 확인가능합니다<br>
							<br>
						
						</td>
						<td width="12%"/>
					</tr>
					<tr><td colspan="3" height="150"/></tr>
				</table>
				
				<table width="100%">
					<tr>
						<td align="center">
							<h2>결제 정보</h2>
						</td>
					</tr>
					
					<tr>
						<td height="1" bgcolor="#777777"></td>
					</tr>
					<table width="80%" border="0" align="center">
						<tr>
							<td width="100"><br>&nbsp;&nbsp;최종결제금액<br><br></td>
							<!-- <td>₩ 77,800</td> -->
							<td>₩ <s:property value="order_total_price" /></td>
							
							
						</tr>
						<tr>
							<td width="100"><br>&nbsp;&nbsp;결제수단<br><br></td>
							<td>
								<!-- 무통장입금<br>
								입금자: 나은이,<br>
								계좌번호: 831209-123-1221321 프랑스은행 (주)미뇽꼬삔느 -->
								<s:property value="order_pay_type" /><br>
								<s:property value="order_pay_name" /><br>
								계좌번호: ?
							</td>
						</tr>						
					</table>
					<tr><td colspan="7" bgcolor="#cccccc" height="1"></td></tr>
					<tr>	<td height="50"></td>	</tr>

				</table>
				
				
				<table width="100%">
					<tr>
						<td align="center">
							<h2>주문상품 정보</h2>
						</td>
					</tr>
					
					<tr>
						<td height="1" bgcolor="#777777"></td>
					</tr>
					<table width="100%" border="0">
						<tr><td colspan="6" bgcolor="#cccccc" height="1"></td></tr>
	
						<tr bgcolor="#455b59" style="color:#FFFFFF;" align="center">
							<td width="10%">이미지</td>
							<td width="19%">상품정보</td>
							<td width="15%">판매가</td>
							<td width="10%">수량</td>
							<td width="10%">배송비</td>
							<td width="15%">합계</td>
						</tr>
						<tr><td colspan="6" bgcolor="#cccccc" height="1"></td></tr>
	<!-- 게시물 하나씩 iterator 시작 -->
	
	
						<tr align="center">
							<!-- <td width="10%"><img src="/semiP/assets/images/best1.jpg" style="width:100%;"></td>
							<td width="19%">상품이름이름이름<br><font style="font-size:0.8em; color:777777">상품옵션옵션</font></td>
							<td width="15%">₩ 100,000</td>
							<td width="10%">1</td>
							<td width="10%">₩ 2,500</td>
							<td width="15%">₩ 102,500</td> -->
							
							<td width="10%"><img src="<s:property value="goods_image"/>" style="width:100%;"></td>
							<td width="19%"><s:property value="goods_name" /><br><font style="font-size:0.8em; color:777777"><s:property value="goods_size" /><s:property value="goods_color" /></font></td>
							<td width="15%">₩ <s:property value="goods_price" /></td>
							<td width="10%"><s:property value="order_goods_amount" /></td>
							<td width="10%">무료</td>
							<td width="15%">₩ ${goods_price} * ${order_goods_amount}</td> 
							
							
						</tr>
						
						
						<!-- <tr><td colspan="6" bgcolor="#f2f2f2" height="1"></td></tr>
						<tr bgcolor="#455b59" style="color:#FFFFFF;" align="center">
							<td colspan="6" height="50" align="right" style="padding:20px;font-size:1.5em;">
								상품구매액 100,000 + 배송비 2,500 = 합계 : 102,500원
							</td>
						</tr> -->
						
						<tr><td colspan="6" bgcolor="#f2f2f2" height="1"></td></tr>
						<tr bgcolor="#455b59" style="color:#FFFFFF;" align="center">
							<td colspan="6" height="50" align="right" style="padding:20px;font-size:1.5em;">
								상품구매액 ${goods_price} * ${order_goods_amount} + 배송비 무료 = 합계 : ${order_total_price}원
							</td>
						</tr>
						
	<!-- 게시물 하나씩 iterator 끝 -->																
						<tr><td colspan="7" bgcolor="#cccccc" height="1"></td></tr>
						<tr>	<td height="50"></td>	</tr>
								
					</table>
						
						<tr><td colspan="7" bgcolor="#cccccc" height="1"></td></tr>
						<tr>	<td height="50"></td>	</tr>
								
				</table>

				<table width="100%">
					<tr>
						<td colspan="3" align="center">
							<h2>배송지 정보</h2>
						</td>
					</tr>
					<tr>
						<td colspan="3" height="1" bgcolor="#777777"></td>
					</tr>
					<tr>	<td colspan="3"/>	</tr>
					<tr>
						<td width="12%"/>
						<td>
							<table width="100%" border="1" style="border:1px solid black; border-collapse:collapse;"> <!-- 2*5 테이블 -->
								<tr>
									<td bgcolor="#455b59" style="color:#FFFFFF;" align="center" width="30%" height="35">
										받으시는분
									</td>
									<td align="center">
										<!-- 나은이 -->
										<s:property value="order_receive_name" />
									</td>
								</tr>
								<tr>
									<td bgcolor="#455b59" style="color:#FFFFFF;" align="center" width="30%" height="35">
										우편번호
									</td>
									<td align="center">
										<!-- 06253 -->
										<s:property value="order_receive_zipcode" />
									</td>
								</tr>
								<tr>
									<td bgcolor="#455b59" style="color:#FFFFFF;" align="center" width="30%" height="35">
										주  소
									</td>
									<td align="center">
										<!-- 서울특별시 영등포구 당산동 국회대로34길 -->
										<s:property value="order_receive_addr1" />
										<s:property value="order_receive_addr2" />
									</td>
								</tr>
								<tr>
									<td bgcolor="#455b59" style="color:#FFFFFF;" align="center" width="30%" height="35">
										연락처
									</td>
									<td align="center">
										<!-- 010-8282-8282 -->
										<s:property value="order_receive_phone" />
									</td>
								</tr>	
								<tr>
									<td bgcolor="#455b59" style="color:#FFFFFF;" align="center" width="30%" height="35">
										배송메세지
									</td>
									<td align="center">
										<!-- M이라서 안맞겠지만 꽉끼게입어볼께요 빠른배송 -->
										<s:property value="order_memo" />
									</td>
								</tr>								
							</table>
						</td>
						<td width="12%"/>
					</tr>
					<tr>	<td></td>	</tr>
					<tr><td colspan="3" bgcolor="#cccccc" height="1"></td></tr>
					<tr>	<td height="30"></td>	</tr>
				</table>
			</table>
								
			<table width="100%">					
				<tr><td height="50"/></tr>
				<tr>
					<td width="12%" />
					<td style="border:1px solid black; padding:20px;">
비회원 주문의 경우, 주문번호를 꼭 기억하세요. 주문번호로 주문조회가 가능합니다.<br>
배송은 결제완료 후 지역에 따라 3일 ~ 10일 가량이 소요됩니다. <br>
상품별 자세한 배송과정은 주문조회를 통하여 조회하실 수 있습니다.<br>
주문의 취소 및 환불, 교환에 관한 사항은 이용안내의 내용을 참고하십시오<br>

					</td>
					<td width="12%"/>
				</tr>
			</table>						
<script type="text/javascript" src="/semiP/assets/js/goodsCount.js"></script>