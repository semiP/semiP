<%@ page contentType="text/html; charset=utf-8"%>

<div style="position: fixed; left: 5%; top: 90px; width:200px; ">
	<table width="80%">
		<tr><td><font size="3"><strong>CATEGORY</strong></font></td></tr>
		<tr bgcolor="#777777"><td height="1"></td></tr>
		<tr><td>전체 (000)</td></tr>
		<tr><td height="5"></td></tr>
		<tr><td>OUTER (000)</td></tr>
		<tr><td>TOP (000)</td></tr>
		<tr><td>PANTS (000)</td></tr>
		<tr><td>SKIRT (000)</td></tr>
		<tr><td>DRESS (000)</td></tr>
		<tr><td>SHOES (000)</td></tr>
		<tr><td>BAGS (000)</td></tr>
	</table>

</div>
<div id="content-container">
	<table width="100%" border="0">
		<tr>
			<td rowspan="4" width="180"/>
			<td height="15">
				<form action="">
					<input type="text" name="keyword" style="width:100%; height:30px;" placeholder="검색어를 입력하세요">
				</form>
			</td>
		</tr>
		<tr>
			<td>			
			"<%= request.getParameter("keyword") %>" 에 대한 검색결과 (00 건)
			</td>
		</tr>
		<tr bgcolor="#777777">
			<td height="1"></td>
		</tr>
		<tr> <!-- 검색내용 넣고... 많은 경우 페이징도 넣고... -->
			<td>
		<!-- 아래는 목록보기 샘플입니다 -->
			<table width="100%" border="0">
				
				<tr><!-- 상품번호 적기 -->
					<td>no.123</td>			
					<td>no.123</td>
					<td>no.123</td>
					<td>no.123</td>
				</tr>
				<tr><!-- 상품이미지 찍기 -->
					<td><img src="/semiP/assets/images/best1.jpg" style="width:100%;"></td>			
					<td><img src="/semiP/assets/images/best2.jpg" style="width:100%;"></td>
					<td><img src="/semiP/assets/images/best3.jpg" style="width:100%;"></td>
					<td><img src="/semiP/assets/images/best4.jpg" style="width:100%;"></td>
				</tr>
				<tr><!-- 상품정보 적기 (이름/설명/가격) -->
					<td>이릉이름<br>₩ 100,000</td>			
					<td>이릉이름<br>₩ 100,000</td>	
					<td>이릉이름<br>₩ 100,000</td>	
					<td>이릉이름<br>₩ 100,000</td>	
				</tr>
				<tr > <!-- 공란 만들기 -->
					<td height="10" colspan="4"></td>
				</tr>
				
			</table>
		<!-- 목록보기 샘플 종료 -->
			</td>
		</tr>
		<tr>
			<td height="150">
			</td>
		</tr>
	</table>
</div>


</body>

