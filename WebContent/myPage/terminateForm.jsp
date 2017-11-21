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
						<td class="myPageMenuItem" bgcolor="#591522"><strong><a href="/semiP/myPage/profile.jsp" >
							회원정보</a></strong></td>
						<td class="myPageMenuItem" ><a href="/semiP/myPage/orderList.jsp" >
							주문/배송현황</a></td>
						<td class="myPageMenuItem"><a href="/semiP/myPage/refundList.jsp" >
							반품/교환</a></td>
						<td class="myPageMenuItem"><a href="/semiP/myPage/qnaList.jsp" >
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
					<h2>> 회원탈퇴</h2>
				</td>
			</tr>
			
			<tr>
				<td colspan="3" height="1" bgcolor="#777777"></td>
			</tr>
			<tr>
				<td width="100"><br>&nbsp;&nbsp;현재 비밀번호<br><br></td>
				<td><input type="password" style="width:90%; height:30px;"></td>
			</tr>
			<tr>
				<td width="100"><br>&nbsp;&nbsp;비밀번호 확인<br><br></td>
				<td><input type="password" style="width:90%; height:30px;"></td>
			</tr>
			<tr>
				<td width="100"><br>&nbsp;&nbsp;탈퇴사유<br><br></td>
				<td>
					<textarea style="width:90%; height:300px; resize:none;" placeholder="꼭 입력해 주세요"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="3" height="1" bgcolor="#777777"></td>
			</tr>
			<tr>
				<td height="30px"/>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="submit" class="btn-custom" value="탈퇴하기">&nbsp;&nbsp;
					<input type="reset" class="btn-custom" value="리셋">
				</td>
			</tr>
			<tr>
				<td height="30px"/>
			</tr>	
					
		</table>
		
	</table>