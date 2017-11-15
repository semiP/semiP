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
				<h2>주문하기</h2>
			</td>
		</tr>
		
		<tr>
			<td height="1" bgcolor="#777777"></td>
		</tr>

		<tr>
			
			<td>
				<table width="100%" border="0">
								<tr><td colspan="7" bgcolor="#cccccc" height="1"></td></tr>

								<tr bgcolor="#455b59" style="color:#FFFFFF;" align="center">
									<td width="1%"><input type="checkbox"/></td>
									<td width="10%">이미지</td>
									<td width="19%">상품정보</td>
									<td width="15%">판매가</td>
									<td width="10%">수량</td>
									<td width="10%">배송비</td>
									<td width="15%">합계</td>
								</tr>
								<tr><td colspan="7" bgcolor="#cccccc" height="1"></td></tr>
<!-- 게시물 하나씩 iterator 시작 -->
								<tr align="center">
									<td width="1%"><input type="checkbox"/></td>
									<td width="10%"><img src="/semiP/assets/images/best1.jpg" style="width:100%;"></td>
									<td width="19%">상품이름이름이름<br><font style="font-size:0.8em; color:777777">상품옵션옵션</font></td>
									<td width="15%">₩ 100,000</td>
									<td width="10%">1</td>
									<td width="10%">₩ 2,500</td>
									<td width="15%">₩ 102,500</td>
								</tr>
								<tr><td colspan="9" bgcolor="#f2f2f2" height="1"></td></tr>
								<tr bgcolor="#455b59" style="color:#FFFFFF;" align="center">
									<td colspan="7" height="100px" align="right" style="padding:20px;font-size:1.5em;">
										상품구매액 100,000 + 배송비 2,500 = 합계 : 102,500원
									</td>
								</tr>
<!-- 게시물 하나씩 iterator 끝 -->																
								<tr><td colspan="7" bgcolor="#cccccc" height="1"></td></tr>
								<tr>	<td height="50"></td>	</tr>
								
				</table>
				
				<table width="100%">
					<tr>
						<td align="center">
							<h2>주문자 정보</h2>
						</td>
					</tr>
					
					<tr>
						<td height="1" bgcolor="#777777"></td>
					</tr>
					<table width="80%" border="0" align="center">
						<tr>
							<td width="100"><br>&nbsp;&nbsp;주문자<br><br></td>
							<td><input type="text" style="width:90%; height:30px;"></td>
						</tr>
						<tr>
							<td width="100"><br>&nbsp;&nbsp;휴대전화<br><br></td>
							<td>
								<input type="text" style="width:90px; height:30px;">&nbsp;-&nbsp;<input type="text" style="width:90px; height:30px;">&nbsp;-&nbsp;<input type="text" style="width:90px; height:30px;"><br>
								
							</td>
						</tr>
						<tr>
							<td width="100"><br>&nbsp;&nbsp;이메일<br><br></td>
							<td><input type="text" style="width:100px; height:30px;">&nbsp;@&nbsp;<input type="text" id="email2" style="width:100px; height:30px;">
							<select name="select" onchange="document.getElementById('email2').value=this.value;if(this.value==''){document.getElementById('email2').focus();}">
												<option value="" selected="selected">직접입력</option>										
												<option value="gmail.com">gmail.com</option>
												<option value="naver.com">naver.com</option>
												<option value="netian.com">netian.com</option>
												<option value="paran.com">paran.com</option>
												<option value="daum.net">daum.net</option>
												<option value="hanmail.net">hanmail.net</option>
												<option value="me.com">me.com</option>
												<option value="lycos.co.kr">lycos.co.kr</option>
												<option value="yahoo.co.kr">yahoo.co.kr</option>
												<option value="yahoo.com">yahoo.com</option>
												<option value="icloud.com">icloud.com</option>
												<option value="cyworld.com">cyworld.com</option>
												<option value="dreamwiz.com">dreamwiz.com</option>
												<option value="nate.com">nate.com</option>
												<option value="empal.com">empal.com</option>
												<option value="orgio.net">orgio.net</option>
												<option value="unitel.co.kr">unitel.co.kr</option>
												<option value="chol.com">chol.com</option>
												<option value="kornet.net">kornet.net</option>
												<option value="korea.com">korea.com</option>
												<option value="freechal.com">freechal.com</option>
												<option value="hanafos.com">hanafos.com</option>
												<option value="hitel.net">hitel.net</option>
												<option value="hanmir.com">hanmir.com</option>
												<option value="hotmail.com">hotmail.com</option>
											</select></td>
						</tr>
						<tr>
							<td height="30px"/>
						</tr>
						
						</table>
						<tr><td colspan="7" bgcolor="#cccccc" height="1"></td></tr>
						<tr>	<td height="50"></td>	</tr>
								
								
								
				</table>
				
				
				<table width="100%">
					<tr>
						<td align="center">
							<h2>배송지 정보</h2>
						</td>
					</tr>
					
					<tr>
						<td height="1" bgcolor="#777777"></td>
					</tr>
					<table width="80%" border="0" align="center">
						<tr>
							<td width="100"><br>&nbsp;&nbsp;수령인<br><br></td>
							<td><input type="text" style="width:90%; height:30px;"></td>
						</tr>
						<tr> <!-- 주소는 멤버의 저장된 주소를 기본값으로 이용해 주세요 -->
							<td width="100"><br>&nbsp;&nbsp;주  소<br><br></td>
							<td>
								<input type="text" style="width:100px; height:30px;">&nbsp;<input type="button" value="우편번호"><br>
								<input type="text" style="width:90%; height:30px;"><br>
								<input type="text" style="width:90%; height:30px;" placeholder="나머지 주소">
							</td>
						</tr>
						<tr>
							<td width="100"><br>&nbsp;&nbsp;수령인연락처<br><br></td>
							<td>
								<input type="text" style="width:90px; height:30px;">&nbsp;-&nbsp;<input type="text" style="width:90px; height:30px;">&nbsp;-&nbsp;<input type="text" style="width:90px; height:30px;"><br>
								
							</td>
						</tr>
						<tr>
							<td width="100"><br>&nbsp;&nbsp;배송시 요청사항<br><br></td>
							<td><textarea style="width:90%; height:200px;" placeholder="입력해주세요"></textarea>
							</td>
						</tr>
						<tr>
							<td height="30px"/>
						</tr>
						
					</table>
						
						
						
						
						
						<tr><td colspan="7" bgcolor="#cccccc" height="1"></td></tr>
						<tr>	<td height="50"></td>	</tr>
								
								
								
				</table>


				<table width="100%">
					<tr>
						<td colspan="3" align="center">
							<h2>결제예정 금액</h2>
						</td>
					</tr>
					<tr>
						<td colspan="3" height="1" bgcolor="#777777"></td>
					</tr>
					<tr>	<td colspan="3"/>	</tr>
					<tr>
						<td width="12%"/>
						<td>
							<table width="100%" border="1" style="border:1px solid black; border-collapse:collapse;text-align:center;font-size:1.5em;">
								<tr>
									<td width="33%" height="50">총 주문금액
									</td>
									<td width="34%" height="50">할인/부가결제 금액
									</td>
									<td width="33%" height="50">총 결제 예정금액
									</td>
								</tr>
								<tr>
									<td width="33%" height="100">₩
									</td>
									<td width="34%" height="100">₩
									</td>
									<td width="33%" height="100">₩
									</td>
								</tr>
							</table>
						</td>
						<td width="12%"/>
					</tr>
					<tr>	<td></td>	</tr>
					<tr><td colspan="3" bgcolor="#cccccc" height="1"></td></tr>
					<tr>	<td height="30"></td>	</tr>
					<tr>
						<td colspan="3" align="center">
							<input type="submit" class="btn-custom" value="결제하기">
						</td>
					</tr>
								
								
								
				</table>
				
				
				
			</table>
								
			<table width="100%">					
				<tr><td height="50"/></tr>
				<tr>
					<td width="12%" />
					<td style="border:1px solid black; padding:20px;">
<p><strong>세금계산서 발행 안내</strong></p>
<ol>
	<li>부가가치세법 제 54조에 의거하여 세금계산서는 배송완료일로부터 다음달 10일까지만 요청하실 수 있습니다.</li>
	<li>세금계산서는 사업자만 신청하실 수 있습니다.</li>
	<li>배송이 완료된 주문에 한하여 세금계산서 발행신청이 가능합니다.</li>
</ol>
					</td>
					<td width="12%"/>
				</tr>
			</table>						
<script type="text/javascript" src="/semiP/assets/js/goodsCount.js"></script>