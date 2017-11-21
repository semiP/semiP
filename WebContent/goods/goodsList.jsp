<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content-container">
		
	<h1 align="center"><strong>상품 목록</strong></h1><br>
	<h2 align="center"><strong>
		<c:choose>
			<c:when test="${category == 1}">OUTER</c:when>
			<c:when test="${category == 2}">TOP</c:when>
			<c:when test="${category == 3}">PANTS</c:when>
			<c:when test="${category == 4}">SKIRT</c:when>
			<c:when test="${category == 5}">DRESS</c:when>
			<c:when test="${category == 6}">SHOES</c:when>
			<c:when test="${category == 7}">BAGS</c:when>
		</c:choose>
		&nbsp;카테고리 상품입니다</strong>
	</h2><br>
	<table width="100%" border="0">
				<tr>
				<s:if test="goodsList.size == 0">
					<td align="center">
					해당 카테고리에 상품이 없습니다.
					</td>
				</s:if>
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
								<a href="#">
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
<!-- 카테고리별 베스트 4개 상품 표시 끝 -->