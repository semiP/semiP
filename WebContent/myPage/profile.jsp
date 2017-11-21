<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	trimDirectiveWhitespaces="true"%>

<div id="content-container">
	<table width="100%" border="0" style="margin:auto; max-width:1000px;">
		<tr>			
			<td height="10">				
				
			</td>			
		</tr>

		<tr>
			<td align="left">
				<h2>MY PAGE</h2>
			</td>
		</tr>
		
		<tr>
			<td colspan="3" height="1" bgcolor="#777777"></td>
		</tr>

		<tr>
			<td width="15%"/>			
			<td>
				<table width="100%" border="0">
					<tr><td colspan="7" bgcolor="#cccccc" height="1"></td></tr>

					<tr bgcolor="#455b59" align="center">
						<td class="myPageMenuItem" bgcolor="#591522"><strong><a href="./profile.tiles" >
							회원정보</a></strong></td>
						<td class="myPageMenuItem" ><a href="./orderList.tiles" >
							주문/배송현황</a></td>
						<td class="myPageMenuItem"><a href="./refundList.tiles" >
							반품/교환</a></td>
						<td class="myPageMenuItem"><a href="./qnaList.tiles" >
							문의내역</a></td>
					</tr>
					<tr><td colspan="7" bgcolor="#cccccc" height="1"></td></tr>
					<tr>	<td height="30"></td>	</tr>
								
				</table>
			</td>
			<td width="15%"/>
		</tr>
		
		
		
		
		<table width="80%" border="0" align="center">
			<tr>
				<td align="left" colspan="2">
					<h2>> 기본정보 수정</h2>
				</td>
			</tr>
			
			<tr>
				<td colspan="3" height="1" bgcolor="#777777"></td>
			</tr>
			<tr>
				<td width="100"><br>&nbsp;&nbsp;이름<br><br></td>
				<td>김명준</td>
			</tr>
			<tr>
				<td width="100"><br>&nbsp;&nbsp;이메일<br><br></td>
				<td>
					<input type="text" style="width:100px; height:30px;">&nbsp;@&nbsp;<input type="text" id="email2" style="width:100px; height:30px;">
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
					</select>					
				</td>
			</tr>
			<tr>
				<td width="100"><br>&nbsp;&nbsp;우편번호<br><br></td>
				<td><input type="text" style="width:100px; height:30px;">&nbsp;&nbsp;<input type="button" value="찾기"></td>
			</tr>
			<tr>
				<td width="100"><br>&nbsp;&nbsp;주소<br><br></td>
				<td><input type="text" style="width:90%; height:30px;"></td>
			</tr>
			<tr>
				<td width="100"><br>&nbsp;&nbsp;상세주소<br><br></td>
				<td><input type="text" style="width:90%; height:30px;"></td>
			</tr>
			<tr>
				<td width="100"><br>&nbsp;&nbsp;연락처<br><br></td>
				<td><input type="text" style="width:90px; height:30px;">&nbsp;-&nbsp;<input type="text" style="width:90px; height:30px;">&nbsp;-&nbsp;<input type="text" style="width:90px; height:30px;"><br>
				</td>
			</tr>
			<tr>
				<td width="100"><br>&nbsp;&nbsp;기존 비밀번호<br><br></td>
				<td><input type="password" style="width:90%; height:30px;"></td>
			</tr>
			<tr>
				<td colspan="3" height="1" bgcolor="#777777"></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="submit" class="btn-custom" value="변경하기">&nbsp;&nbsp;
					<input type="button" class="btn-custom" value="리셋">
				</td>
			</tr>
			<tr>
				<td height="30px"/>
			</tr>	
					
		</table>
		<table width="80%" border="0" align="center">
			<tr>
				<td align="left" colspan="2">
					<h2>> 비밀번호 수정</h2>
				</td>
			</tr>
			
			<tr>
				<td colspan="3" height="1" bgcolor="#777777"></td>
			</tr>
			<tr>
				<td width="100"><br>&nbsp;&nbsp;기존 비밀번호<br><br></td>
				<td><input type="password" style="width:90%; height:30px;"></td>
			</tr>
			<tr>
				<td width="100"><br>&nbsp;&nbsp;새 비밀번호<br><br></td>
				<td><input type="password" style="width:90%; height:30px;"></td>
			</tr>
			<tr>
				<td width="100"><br>&nbsp;&nbsp;비밀번호 확인<br><br></td>
				<td><input type="password" style="width:90%; height:30px;"></td>
			</tr>
			<tr>
				<td colspan="3" height="1" bgcolor="#777777"></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="submit" class="btn-custom" value="변경하기">&nbsp;&nbsp;
					<input type="button" class="btn-custom" value="리셋">
				</td>
			</tr>
			<tr>
				<td height="30px"/>
			</tr>
			<tr>
				<td colspan="2" align="right"><a href="/semiP/myPage/terminateForm.jsp">회원탈퇴</a></td>
			</tr>		
		</table>
	</table>
	