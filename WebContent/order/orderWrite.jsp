<<<<<<< HEAD
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import = "java.util.List" %>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('address1').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('address2').focus();
            }
        }).open();
    }
</script>


<s:if test="resultClass == NULL">
<form action="orderWriteAction.action" method="post" enctype="multipart/form-data" >
</s:if>

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
			<!-- 데이터 넘겨주기 설정 -->
			
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
								<%-- <s:iterator value="orderList"> --%>

								<tr align="center">
									<td width="1%"><input type="checkbox" id="checkbox_<s:property value="#stat.index" /> type="checkbox" onClick="itemSum(<s:property value = "#stat.index" />);" value="<s:property value='goods_no'/>"/></td>
									<td width="10%"><img src="http://cooz.co/semiP/IMG/${goods_category}/${order_goods_no}/0.jpg" style="width:100%;"></td>
									<td width="19%">${goods_name}<br><font style="font-size:0.8em; color:777777">${goods_size},${goods_color}</font></td>
									<td width="15%">₩ ${goods_price}</td>
									<td width="10%">${goods_amount}</td>
									<td width="10%">무료</td>
									<td width="15%">₩ ${order_total_price}</td>
									
									<%-- <td width="10%"><img src="<s:property value="goods_image"/>" style="width:100%;"> --%>
									<%-- <td width="19%"><s:property value="goods_name"/><br><font style="font-size:0.8em; color:777777"><s:property value="order_goods_size"/>&nbsp;<s:property value="order_goods_color"/></font></td> --%>
									<%-- <td width="15%">₩ <s:property value="goods_price"/></td> --%>
									<%-- <td width="10%"><s:property value="order_goods_amount"/></td> --%>
									
									<input type="hidden" name="order_goods_size" value='${resultClass.order_goods_size}' />
									
								</tr>
								<tr><td colspan="9" bgcolor="#f2f2f2" height="1"></td></tr>
								<tr bgcolor="#455b59" style="color:#FFFFFF;" align="center">
									<td colspan="7" height="100px" align="right" style="padding:20px;font-size:1.5em;">
									
									<!-- 	상품구매액 100,000 + 배송비 2,500 = 합계 : 102,500원 -->
									상품구매액 ${goods_price} + 배송비 무료 = 합계 : ${order_total_price}  
									
									</td>
								</tr>
<!-- 게시물 하나씩 iterator 끝 -->
								<%-- </s:iterator>	 --%>										
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
							<!-- <td><input type="text" style="width:90%; height:30px;"></td> -->
							<%-- <td><s:textfield name="order_receive_name" theme="simple" value="%{resultClass.order_receive_name}" /></td> --%>
						</tr>
						<tr>
							<!-- <td width="100"><br>&nbsp;&nbsp;휴대전화<br><br></td>
							<td>
								<input type="text" style="width:90px; height:30px;">&nbsp;-&nbsp;<input type="text" style="width:90px; height:30px;">&nbsp;-&nbsp;<input type="text" style="width:90px; height:30px;"><br>
								
							</td> -->
						</tr>
						<tr>
							<%-- <td width="100"><br>&nbsp;&nbsp;이메일<br><br></td>
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
											</select></td> --%>
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
							<!-- <td><input type="text" style="width:90%; height:30px;"></td> -->
							<td><s:textfield name="order_receive_name" theme="simple" value="%{resultClass.order_receive_name}" /></td>
						</tr>
						<tr> <!-- 주소는 멤버의 저장된 주소를 기본값으로 이용해 주세요 -->
							<td width="100"><br>&nbsp;&nbsp;주  소<br><br></td>
							<td>
								<!-- <input type="text" style="width:100px; height:30px;" id="postcode">&nbsp;<input type="button" value="우편번호" onclick="execDaumPostcode()"><br>
								<input type="text" style="width:90%; height:30px;"><br>
								<input type="text" style="width:90%; height:30px;" placeholder="나머지 주소"> -->
								<s:textfield name="order_receive_zipcode" theme="simple" value="%{resultClass.order_receive_zipcode}" id="postcode" />&nbsp;<input type="button" value="우편번호" onclick="execDaumPostcode()"><br>
								<s:textfield name="order_receive_addr1" theme="simple" value="%{resultClass.order_receive_addr1}" id="address1"/>
								<s:textfield name="order_receive_addr2" theme="simple" value="%{resultClass.order_receive_addr2}" id="address2"/>
							</td>
						</tr>
						<tr>
							<td width="100"><br>&nbsp;&nbsp;수령인연락처<br><br></td>
							<td>
								<!-- <input type="text" style="width:90px; height:30px;">&nbsp;-&nbsp;<input type="text" style="width:90px; height:30px;">&nbsp;-&nbsp;<input type="text" style="width:90px; height:30px;"><br> -->
								<s:textfield name="order_receive_phone" theme="simple" value="%{resultClass.order_receive_phone}" />
							</td>
						</tr>
						<tr>
							<td width="100"><br>&nbsp;&nbsp;배송시 요청사항<br><br></td>
							<!-- <td><textarea style="width:90%; height:200px;" placeholder="입력해주세요"></textarea> -->
							<td><s:textarea name="order_memo" theme="simple" value="%{resultClass.order_memo}" cols="50" rows="10"></s:textarea>
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
									<td width="33%" height="100">₩ ${order_total_price}
									</td>
									<td width="34%" height="100">₩ 10%
									</td>
									<td width="33%" height="100">₩ ${order_total_pay}
									</td>
								</tr>
							</table>
						</td>
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
=======
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import = "java.util.List" %>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('address1').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('address2').focus();
            }
        }).open();
    }
</script>


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
			<!-- 데이터 넘겨주기 설정 -->
			<form action="orderWriteAction.action" method="post" enctype="multipart/form-data" >
				<input type="hidden" name="order_goods_size" value='${order_goods_size}' />
				<input type="hidden" name="order_goods_color" value='${order_goods_color}' />
				<input type="hidden" name="order_goods_no" value='${order_goods_no}' />
				<input type="hidden" name="order_member_no" value='${session.session_member_no}' />
				<input type="hidden" name="order_goods_amount" value='${order_goods_amount}' />
				<input type="hidden" name="order_total_pay" value='${order_total_pay}' />
				<input type="hidden" name="order_total_price" value='${order_total_price}' />
								
				<table width="100%" border="0">
								<tr><td colspan="7" bgcolor="#cccccc" height="1"></td></tr>
								
								<tr bgcolor="#455b59" style="color:#FFFFFF;" align="center">
								<!--	<td width="1%"><input type="checkbox"/></td>-->
									<td width="10%">이미지</td>
									<td width="19%">상품정보</td>
									<td width="15%">판매가</td>
									<td width="10%">수량</td>
									<td width="10%">배송비</td>
									<td width="15%">합계</td>
								</tr>
								<tr><td colspan="7" bgcolor="#cccccc" height="1"></td></tr>
<!-- 게시물 하나씩 iterator 시작 -->
								<%-- <s:iterator value="orderList"> --%>

								<tr align="center">
								<!--<td width="1%"><input type="checkbox" id="checkbox_<s:property value="#stat.index" /> type="checkbox" onClick="itemSum(<s:property value = "#stat.index" />);" value="<s:property value='goods_no'/>"/></td>-->
									<td width="10%"><img src="http://cooz.co/semiP/IMG/${goods_category}/${order_goods_no}/0.jpg" style="width:100%;"></td>
									<td width="19%">${goods_name}<br><font style="font-size:0.8em; color:777777">${goods_size},${goods_color}</font></td>
									<td width="15%">₩ ${goods_price}</td>
									<td width="10%">${goods_amount}</td>
									<td width="10%">무료</td>
									<td width="15%">₩ ${order_total_price}</td>
									
									<%-- <td width="10%"><img src="<s:property value="goods_image"/>" style="width:100%;"> --%>
									<%-- <td width="19%"><s:property value="goods_name"/><br><font style="font-size:0.8em; color:777777"><s:property value="order_goods_size"/>&nbsp;<s:property value="order_goods_color"/></font></td> --%>
									<%-- <td width="15%">₩ <s:property value="goods_price"/></td> --%>
									<%-- <td width="10%"><s:property value="order_goods_amount"/></td> --%>
									
									
									
								</tr>
								<tr><td colspan="9" bgcolor="#f2f2f2" height="1"></td></tr>
								<tr bgcolor="#455b59" style="color:#FFFFFF;" align="center">
									<td colspan="7" height="100px" align="right" style="padding:20px;font-size:1.5em;">
									
									<!-- 	상품구매액 100,000 + 배송비 2,500 = 합계 : 102,500원 -->
									상품구매액 ${order_total_price} + 배송비 무료 = 합계 : ${order_total_price}  
									
									</td>
								</tr>
<!-- 게시물 하나씩 iterator 끝 -->
								<%-- </s:iterator>	 --%>										
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
							<!-- <td><input type="text" style="width:90%; height:30px;"></td> -->
							<td><s:textfield name="order_receive_name" theme="simple" value="%{resultClass.order_receive_name}" /></td>
						</tr>
						<tr> <!-- 주소는 멤버의 저장된 주소를 기본값으로 이용해 주세요 -->
							<td width="100"><br>&nbsp;&nbsp;주  소<br><br></td>
							<td>
								<!-- <input type="text" style="width:100px; height:30px;" id="postcode">&nbsp;<input type="button" value="우편번호" onclick="execDaumPostcode()"><br>
								<input type="text" style="width:90%; height:30px;"><br>
								<input type="text" style="width:90%; height:30px;" placeholder="나머지 주소"> -->
								<s:textfield name="order_receive_zipcode" theme="simple" value="%{resultClass.order_receive_zipcode}" id="postcode" />&nbsp;<input type="button" value="우편번호" onclick="execDaumPostcode()"><br>
								<s:textfield name="order_receive_addr1" theme="simple" value="%{resultClass.order_receive_addr1}" id="address1"/>
								<s:textfield name="order_receive_addr2" theme="simple" value="%{resultClass.order_receive_addr2}" id="address2"/>
							</td>
						</tr>
						<tr>
							<td width="100"><br>&nbsp;&nbsp;수령인연락처<br><br></td>
							<td>
								<!-- <input type="text" style="width:90px; height:30px;">&nbsp;-&nbsp;<input type="text" style="width:90px; height:30px;">&nbsp;-&nbsp;<input type="text" style="width:90px; height:30px;"><br> -->
								<s:textfield name="order_receive_phone" theme="simple" value="%{resultClass.order_receive_phone}" />
							</td>
						</tr>
						<tr>
							<td width="100"><br>&nbsp;&nbsp;배송시 요청사항<br><br></td>
							<!-- <td><textarea style="width:90%; height:200px;" placeholder="입력해주세요"></textarea> -->
							<td><s:textarea name="order_memo" theme="simple" value="%{resultClass.order_memo}" cols="50" rows="10"></s:textarea>
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
									<td width="33%" height="100">₩ ${order_total_price}
									</td>
									<td width="34%" height="100">₩ 10%
									</td>
									<td width="33%" height="100">₩ ${order_total_pay}
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
				</form>
			</table>
			
								
			<table width="100%">
				<tr><td height="50"/></tr>
				<tr>
					<td width="12%" />
					<td style="border:1px solid black; padding:20px;">
<p align="center">시간관계상, "결제하기" 버튼을 통해 주문완료 및 결제까지 이루어졌다고 가정합니다 ㅠ_ㅜ</p><br><br>
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
>>>>>>> master
<script type="text/javascript" src="/semiP/assets/js/goodsCount.js"></script>