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
				<h2>고객지원</h2>
			</td>
		</tr>
		
		<tr>
			<td colspan="3" height="1" bgcolor="#777777"></td>
		</tr>

		<tr>
			<td width="15%"/>			
			<td>
				<table width="100%" border="0">
					<tr><td colspan="2" bgcolor="#cccccc" height="1"></td></tr>

					<tr bgcolor="#455b59" align="center">
						<td class="myPageMenuItem" bgcolor="#591522"><strong><a href="./notice.tiles" >
							공지사항</a></strong></td>
						<td class="myPageMenuItem" ><a href="./faq.tiles" >
							자주하는 질문</a></td>
					</tr>
					<tr><td colspan="2" bgcolor="#cccccc" height="1"></td></tr>
					<tr>	<td height="30"></td>	</tr>
								
				</table>
			</td>
			<td width="15%"/>
		</tr>
		
		
		
		
		<table width="80%" border="0" align="center">
			<tr>
				<td align="left" colspan="2">
					<h2>> 공지사항</h2>
				</td>
			</tr>
			<tr>
				<td>
					<select name="searchType">										
						<option value="1">모두 보기</option>
						<option value="2">주문/배송</option>
						<option value="2">반품/교환</option>
					</select>
				</td>
				<td align="right" colspan="2">
					검색기간:	<input type="date" name="startDate"> ~ <input type="date" name="endDate">&nbsp;&nbsp;
							<input type="button" name="dateSearchBtn" value="조회">
				</td>
			</tr>
			<tr>
				<td colspan="3" height="1" bgcolor="#777777"></td>
			</tr>
			<tr>
				<td colspan="3">
					<table width="100%" style="text-align:center;">
						<tr><td colspan="4" bgcolor="#cccccc" height="1"></td></tr>
						
						<tr>
							<td class="board-titlebar" width="15%" height="30">날짜</td>
							<td class="board-titlebar" width="15%" height="30">구분</td>
							<td class="board-titlebar" width="55%" height="30">글제목</td>
							<td class="board-titlebar" width="15%" height="30">작성자</td>
						</tr>
						<tr><td colspan="4" bgcolor="#cccccc" height="1"></td></tr>
	<!-- 게시물 하나씩 iterator 시작 -->
						<tr>
							<td class="board-titlebar" width="15%" height="30">2017/11/10</td>
							<td class="board-titlebar" width="15%" height="30">[주문/배송]</td>
							<td class="board-titlebar" width="55%" height="30">이거 배송 하루만에 되나요</td>
							<td class="board-titlebar" width="15%" height="30">돈쓴사람</td>
						</tr>
						<tr><td colspan="4" bgcolor="#f2f2f2" height="1"></td></tr>
						<tr>
							<td class="board-titlebar" width="15%" height="30">2017/11/10</td>
							<td class="board-titlebar" width="15%" height="30"></td>
							<td class="board-titlebar" width="55%" height="30"><img src="/semiP/assets/images/board-icon/reply.gif">그럴 수도 있겠네요</td>
							<td class="board-titlebar" width="15%" height="30">관리자</td>
						</tr>
	<!-- 게시물 하나씩 iterator 끝 -->																
						<tr><td colspan="4" bgcolor="#cccccc" height="1"></td></tr>
						<tr>
							<td colspan="4" align="center">
								여기에 테이블 페이징 내용을 넣어주세요
							</td>
						</tr>
						<tr>
							<td colspan="4">
								<br>
								<select name="searchType">										
									<option value="1">글 제목</option>
									<option value="2">글 내용</option>
								</select>
								&nbsp;&nbsp;
								<input type="text" name="searchKeyword" style="width:100px;">
								<input type="button" value="검색">
							</td>
						</tr>
					</table>
				</td>
			</tr>			
			
			<tr>
				<td height="30px"/>
			</tr>	
					
		</table>
	</table>