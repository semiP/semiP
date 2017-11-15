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

					<tr bgcolor="#455b59" align="center"> <!-- a href 링크를 tiles 에서 action 으로 바꿔주기 -->
						<td class="myPageMenuItem" ><a href="./profile.tiles" >
							회원정보</a></td>
						<td class="myPageMenuItem" ><a href="./orderList.tiles" >
							주문/배송현황</a></td>
						<td class="myPageMenuItem" bgcolor="#591522"><strong><a href="./refundList.tiles">
							반품/교환</a></strong></td>
						<td class="myPageMenuItem"><a href="./qnaList.tiles" >
							문의내역</a></td>
					</tr>
					<tr><td colspan="7" bgcolor="#cccccc" height="1"></td></tr>
					<tr>	<td height="30"></td>	</tr>
								
				</table>
			</td>
			<td width="15%"/>
		</tr>
		
		
		
		
		<table width="100%" border="0">
			<tr>
				<td align="left" colspan="7">
					<h2>> 반품/교환</h2>
				</td>
			</tr>
			<tr>
				<td align="right" colspan="7">
					검색기간:	<input type="date" name="startDate" value="한달 전 날짜"> ~ <input type="date" name="endDate" value="오늘날짜">&nbsp;&nbsp;
							<input type="button" name="dateSearchBtn" value="조회">
				</td>
			</tr>
			<tr><td colspan="7" bgcolor="#cccccc" height="1"></td></tr>
			
			<tr bgcolor="#455b59" style="color:#FFFFFF;" align="center">
				<td width="10%">주문날짜</td>
				<td width="10%">이미지</td>
				<td width="28%">상품정보</td>
				<td width="15%">판매가</td>
				<td width="5%">수량</td>
				<td width="20%">처리상태</td>
				<td width="12%">반품/교환</td>
			</tr>
			<tr><td colspan="7" bgcolor="#cccccc" height="1"></td></tr>
<!-- 게시물 하나씩 iterator 시작 -->
			<tr align="center">
				<td width="10%">주문날짜</td>
				<td width="10%"><img src="/semiP/assets/images/best1.jpg" style="width:100%;"></td>
				<td width="28%">상품이름이름이름<br><font style="font-size:0.8em; color:777777">상품옵션옵션</font></td>
				<td width="15%">₩ 100,000</td>
				<td width="5%">
					1
				</td>
				<td width="20%">
					처리대기중. <!-- 상태가 뭐뭐있는지 정의가 필요 -->
				</td>
				<td width="12%">
					교환<br>
					반품
				</td>
			</tr>
			<tr><td colspan="7" bgcolor="#f2f2f2" height="1"></td></tr>
			
<!-- 게시물 하나씩 iterator 끝 -->																
			<tr><td colspan="7" bgcolor="#cccccc" height="1"></td></tr>
			<tr>	<td height="50"></td>	</tr>
			
		</table>
		
	</table>