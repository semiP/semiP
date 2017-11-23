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
						<td class="myPageMenuItem"><a href="../InfoView.action" >
							회원정보</a></td>
						<td class="myPageMenuItem" bgcolor="#591522"><strong><a href="./orderList.tiles" >
							주문/배송현황</a></strong></td>
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

		<table width="100%" border="0">
			<tr>
				<td align="left" colspan="7">
					<h2>> 주문/배송현황</h2>
				</td>
			</tr>
			<tr>
				<td align="right" colspan="7">
					검색기간:	<input type="date" name="startDate" id="startDate"> ~ <input type="date" name="endDate" id="endDate" >&nbsp;&nbsp;
							<input type="submit" name="dateSearchBtn" value="조회">
				</td>
			</tr>
			<tr><td colspan="7" bgcolor="#cccccc" height="1"></td></tr>
			
			<tr bgcolor="#455b59" style="color:#FFFFFF;" align="center">
				<td width="10%">주문날짜</td>
				<td width="10%">이미지</td>
				<td width="28%">상품정보</td>
				<td width="15%">판매가</td>
				<td width="5%">수량</td>
				<td width="20%">배송현황</td>
				<td width="12%">반품/교환</td>
			</tr>
			<tr><td colspan="7" bgcolor="#cccccc" height="1"></td></tr>
<!-- 게시물 하나씩 iterator 시작 -->
			<tr align="center">
				<td width="10%"><s:property value="resultClass.order_date"/></td>
				<td width="10%"><s:property value="resultClass.order_goods_image"/><img style="width:100%;"></td>
				<td width="28%"><s:property value="resultClass.goods_name"/><br><font style="font-size:0.8em; color:777777"><s:property value="resultClass.goods_size"/><s:property value="resultClass.goods_color"/></font></td>
				<td width="15%"><s:property value="resultClass.goods_price"/></td>
				<td width="5%"><s:property value="resultClass.order_goods_amount"/></td>
				<td width="20%">
					<s:property value="resultClass.order_status"/><br>
					우체국택배<br>
					<s:property value="resultClass.invoice_no"/><br><br>
					<input type="button" value="구매후기" style="width:60%;">
				</td>
				<td width="12%">
					<input type="button" value="요청하기" style="width:80%;"><br><br>
					완료
				</td>
			</tr>
			<tr><td colspan="7" bgcolor="#f2f2f2" height="1"></td></tr>
			
<!-- 게시물 하나씩 iterator 끝 -->																
			<tr><td colspan="7" bgcolor="#cccccc" height="1"></td></tr>
			<tr>	<td height="50"></td>	</tr>
			
		</table>
		
	</table>