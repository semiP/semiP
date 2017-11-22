<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div style="position: fixed; left: 5%; top: 90px; width:200px; ">
	<table width="80%">
		<tr><td><font size="3"><strong>CATEGORY</strong></font></td></tr>
		<tr bgcolor="#777777"><td height="1"></td></tr>
		<tr>
			<td>
				<a style="text-decoration:none;" href="search.action?keyword=${keyword }">
					전체 (<input id="cate-total" style="text-align:center;width:20px;border:none;" readonly value="0">)
				</a>
			</td>
		</tr>
		<tr><td height="5"></td></tr>
		
		<s:iterator value="countList" status="stat">
			<tr>
				<td id="left-column-set" style="text-transform:uppercase;">
					<a id="cate-count" style="text-decoration:none;" href="search.action?keyword=${keyword }&category=<s:property value="category_no"/>">
						<s:property value="category_name"/>&nbsp;(<s:property value="cnt"/>)</a>
					<script>
						document.getElementById('cate-total').value = 
							parseInt(document.getElementById('cate-total').value) + parseInt(<s:property value="cnt"/>); 
					</script>
				</td>
			</tr>
		</s:iterator>
		
	</table>

</div>
<div id="content-container">
	<table width="100%" border="0">
		<tr>
			<td rowspan="4" width="180"/>
			<td height="15">
				<form action="search.action">
					<input type="text" name="keyword" style="width:100%; height:30px;" placeholder="검색어를 입력하세요">
				</form>
			</td>
		</tr>
		<tr>
			<td>			
				<s:if test="keyword == null || keyword == ''">
					전체&nbsp;검색결과입니다
				</s:if>
				<s:else>
					"${keyword }"&nbsp;검색결과입니다
				</s:else>
			</td>
		</tr>
		<tr> <!-- 검색내용 넣고... 많은 경우 페이징도 넣고... -->
			<td>
		<!-- 아래는 목록보기 샘플입니다 -->
			<table width="100%" border="0">
				<tr>
					<s:iterator value="goodsList" status="stat">
						<s:if test="#stat.index % 4 == 0">
							</tr>
								<tr bgcolor="#777777"><td height="1" colspan="4"></td></tr>
							<tr>
						</s:if>
						<td width="25%" align="center">
							<s:if test="goods_amount == -10">
								( '3')
							</s:if>
							<s:else>
								<!-- 상품번호 적기 -->
								no.<s:property value="goods_no"/><br>
								<!-- 상품이미지 찍기 -->
								<a href="goodsViewAction.action?goods_no=<s:property value="goods_no" />">
									<img src="http://cooz.co/semiP/IMG/<s:property value="goods_category" />/<s:property value="goods_no" />/0.jpg" style="width:100%;"><br>		
								</a><br>
								<!-- 상품정보 적기 (이름/설명/가격) -->
								<s:property value="goods_name" /><br>
								₩ <s:property value="goods_price" />
							</s:else>
						</td>
						
					</s:iterator>
						
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

