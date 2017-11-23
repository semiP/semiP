<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
						<td class="myPageMenuItem" ><a href="액션명으로 변경" >
							회원정보</a></td>
						<td class="myPageMenuItem" ><a href="액션명으로 변경" >
							주문/배송현황</a></td>
						<td class="myPageMenuItem"><a href="액션명으로 변경" >
							반품/교환</a></td>
						<td class="myPageMenuItem" bgcolor="#591522"><strong><a href="inqListAction.action" >
							문의내역</a></strong></td>
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
					<h2>> 1:1 문의내역</h2>
				</td>
			</tr>
			<tr>
				<td align="right" colspan="7">
					검색기간:	<input type="date" name="startDate"> ~ <input type="date" name="endDate">&nbsp;&nbsp;
							<input type="button" name="dateSearchBtn" value="조회">
				</td>
			</tr>
			<tr>
				<td colspan="3" height="1" bgcolor="#777777"></td>
			</tr>
			<tr>
				<td>
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
			<s:iterator value="list" status="stat">
     	   		<tr bgcolor="#FFFFFF"  align="center">
					<td><s:property value="inquiry_regdate" /></td>
					<td><s:if test="%{inquiry_category.equals(1)}">주문/배송</s:if>
						<s:else>반품/교환</s:else></td>
					<td class="inquiry_subject"><a href="javascript:window.open('inqViewAction.action?inquiry_no=<s:property value="inquiry_no"/>','_blank', 'width=600, height=400');">
						<s:property value="inquiry_subject"/></a>
				</td>
        		<td><s:property value="member_name" /></td>
        		
      	      	</tr>
      	      	<tr bgcolor="#777777">
        			<td height="1" colspan="5"></td>
      	      	</tr>
      
	      	</s:iterator>
			
		      <s:if test="list.size() <= 0">
					
		      <tr bgcolor="#FFFFFF"  align="center">
					<td colspan="5">등록된 게시물이 없습니다.</td>
	           	</tr>						
		      	<tr bgcolor="#777777">
	      			<td height="1" colspan="5"></td>
	    	  	</tr>
	    		
		      </s:if>
						<tr><td colspan="4" bgcolor="#cccccc" height="1"></td></tr>
						<tr>
							<td colspan="4" align="center">
							<!-- paging -->
							<div class="paging">
								<s:property value="pagingHtml" escape="false"/>
							</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>			
			<tr>
				<td colspan="3" height="1" bgcolor="#777777"></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="submit" class="btn-custom" value="질문하기" onClick="location.href='inqFormAction.action'">
				</td>
			</tr>
			<tr>
				<td height="30px"/>
			</tr>	
					
		</table>
	</table>
</div>