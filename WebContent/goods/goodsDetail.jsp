<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	trimDirectiveWhitespaces="true"%>



<div id="content-container">
	<table width="100%" border="0" style="margin:auto; max-width:1000px;">
		<tr>			
			<td height="10">				
				
			</td>			
		</tr>

		<tr>
			<td height="1" bgcolor="#777777"></td>
		</tr>

		<tr>
			
			<td>
				<table width="100%" border="0">
					<tr>
						<td width="50%" style="vertical-align:top;">
							<table width="100%">
								<tr>
									<td><img src="/semiP/assets/images/best1.jpg" style="width:100%;"></td>
								</tr>
								<tr>
									<td align="center"><img src="/semiP/assets/images/icons/enlarge.png" width="50" height="50" onmouseover="this.src='/semiP/assets/images/icons/enlarge_on.png'" onmouseout="this.src='/semiP/assets/images/icons/enlarge.png'"></td>
								</tr>
							</table>
						</td>
						<td width="15"></td> <!-- 사진과 옵션 사이 여백는 부분 -->
						<td style="vertical-align:top;">
							<table width="100%" border="0">
								<tr>
									<td colspan="2" style="font-size:1.5em;">상품제목을 입력합니다<br><br></td>
								</tr>
								<tr>
									<td width="100" height="40">&nbsp;가격</td>
									<td style="font-size:1.2em;"><strong>상품가격을 입력합니다</strong></td>
								</tr>
								<tr>
									<td width="100" height="40">&nbsp;수량</td>
									<td>
										<input type="button" id="m_btn" value="-" style="background-color:#cccccc;">
										<input type="text" id="count" value="0" style="text-align:center; width:50px;" readonly="readonly">
										<input type="button" id="p_btn" value="+" style="background-color:#cccccc;">
									</td>
								</tr>
								<tr>
									<td width="100" height="40">&nbsp;색상</td>
									<td>
										<select>
											<option value="" selected="selected">선택해 주세요</option>										
											<option value="color1">color 1</option>
											<option value="color2">color 2</option>
											<option value="color3">color 3</option>
										</select>
									</td>
								</tr>
								<tr>
									<td width="100" height="40">&nbsp;사이즈</td>
									<td>
										<select>
											<option value="" selected="selected">선택해 주세요</option>										
											<option value="size1">size 1</option>
											<option value="size2">size 2</option>
											<option value="size3">size 3</option>
										</select>
									</td>
								</tr>
								<tr>
									<td width="100" height="40">&nbsp;할인혜택</td>
									<td></td>
								</tr>
								<tr>
									<td width="100" height="40">&nbsp;할인가</td>
									<td></td>
								</tr>
								<tr>
									<td width="100" height="40">&nbsp;배송비</td>
									<td>무료</td>
								</tr>
								<tr>
									<td width="100" height="40">&nbsp;배송 가능 지역</td>
									<td>전국</td>
								</tr>
								<tr height="30">
								</tr>
								<tr>
									<td colspan="2" align="center" >
										<input type="button" class="btn-custom" value="장바구니 담기" style="width:150px;">
										&nbsp;&nbsp;&nbsp;
										<input type="button" class="btn-custom1" value="구매하기" style="width:150px;">
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="1" bgcolor="#777777"></td>
		</tr>
		<tr>
			<td align="center">
				이미지 1 <br>
				이미지 2 <br>
				이미지 3 <br>
				등등 <br>
			</td>
		</tr>
		<tr>
			<td height="1" bgcolor="#777777"></td>
		</tr>
		<tr>
			<td></td>
		</tr>
	</table>
</div>
<script type="text/javascript" src="/semiP/assets/js/goodsCount.js"></script>