<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript">
<!-- 차후 에이작스 변경 -->
	function go()
	{
		var form = document.searchForm;
		
		form.action = "./faqListAction.action";
		form.submit();
	}
</script>

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
		<!-- <tr>
			<td colspan="3" height="1" bgcolor="#777777"></td>
		</tr> -->

		<tr>
			<td width="15%"/>			
			<td>
				<table width="100%" border="0">
					<tr><td colspan="2" bgcolor="#cccccc" height="1"></td></tr>

					<tr bgcolor="#455b59" align="center">
						<td class="myPageMenuItem"><a href="support/noticeAction.action" >
							공지사항</a></td>
						<td class="myPageMenuItem" bgcolor="#591522"><strong><a href="support/faqListAction.action" >
							자주하는 질문</a></strong></td>
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
					<h2>> 자주하는 질문</h2>
				</td>
			</tr>
			<tr>
				<td>
				<!-- 차후 에이작스 변경 -->
				<form id="searchForm" name="searchForm">
					<select name=searchNum onchange="javascript:go();">
						<option value="1">모두보기</option>
						<option value="2">주문/배송</option>
						<option value="3">반품/교환</option>
					</select>
					</form>
				</td>
				
				<td align="right" colspan="2">
					<form>
					검색기간:	<input type="date" name="startDate" > ~ <input type="date" name="endDate">&nbsp;&nbsp;
							<input type="submit" name="dateSearchBtn" value="조회">
					</form>
							
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
							<td class="board-titlebar" width="15%" height="30" >날짜</td>
							<td class="board-titlebar" width="15%" height="30" >구분</td>
							<td class="board-titlebar" width="55%" height="30" >글제목</td>
							<td class="board-titlebar" width="15%" height="30" >작성자</td>
						</tr>
						<tr><td colspan="4" bgcolor="#cccccc" height="1"></td></tr>
	<!-- 게시물 하나씩 iterator 시작 -->
	<!-- 완성 -->
		<s:iterator value="list" status="stat">
			<%--href에서 스크립트로 처리해서 필요없음
			 <s:url id="viewURL" action="faqViewAction" >
				<s:param name="faq_no">
					<s:property value="faq_no" />
				</s:param>
				<s:param name="currentPage">
					<s:property value="currentPage" />
				</s:param>
			</s:url> --%>	
			
     	      <tr bgcolor="#FFFFFF"  align="center">
				<td><s:property value="faq_regdate" /></td>
				<%-- 벨류가 1이면 주문배송 2면 반품교환--%>
				<td>
				<s:if test="%{faq_category.equals(1)}">주문/배송</s:if>
				<s:else>반품/교환</s:else></td>
				<td class="faq_subject"><a href="javascript:window.open('faqViewAction.action?faq_no=<s:property value="faq_no"/>','_blank', 'width=600, height=400');">
						<s:property value="faq_subject"/></a>
				</td>
        		<td>관리자</td>
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
	<!-- 게시물 하나씩 iterator 끝 -->														
						<tr><td colspan="4" bgcolor="#cccccc" height="1"></td></tr>
						<tr>
							<td colspan="4" align="center">
							<!-- paging -->
						<div class="paging">
							<s:property value="pagingHtml" escape="false"/>
						</div>
							<!-- // paging -->
							</td>
							
						</tr>
						<tr>
							<td colspan="4">
								<br>
								<form>
								<select name="searchSC">										
									<option value="1">글 제목</option>
									<option value="2">글 내용</option>
								</select>
								&nbsp;&nbsp;
								
								<s:textfield name="searchKeyword" theme="simple" value="" cssStyle="width:100px" maxlength="20" />
								<input name="submit" type="submit" value="검색" class="inputb">	
								</form>
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