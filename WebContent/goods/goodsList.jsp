<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.util.HashMap" %>

<!-- 카테고리별 베스트 4개 상품 표시 시작 -->

<div id="content-container">
		
	<h1 align="center"><strong>상품 목록</strong></font></h1><br>
	<table width="100%" border="0">
		<tr bgcolor="#777777">
			<td height="1" colspan="4"></td>
		</tr>
		
		<s:iterator value="list" status="stat">
			<s:url id="viewURL" action="goodsViewAction">
				<s:param name="no">
					<s:property value="goods_no" />
				</s:param>
				<s:param name="currentPage">
					<s:property value="currentPage" />
				</s:param>
			</s:url>
			
			<tr><!-- 상품번호 적기 -->
				<td>no.<s:property value="goods_no" /></td>
			</tr>
			
			<tr><!-- 상품이미지 찍기 -->
				<td><s:property value="goods_image_file" /></td>
			</tr>
			
			<tr><!-- 상품정보 적기 (이름/설명/가격) -->
				<td><s:property value="goods_name" /><br>
				<s:property value="goods_price" /></td>
			</tr>
			
			<tr > <!-- 공란 만들기 -->
				<td height="10" colspan="4"></td>
			</tr>
			
		</s:iterator>
		
<!-- 이전에 사용한 샘플코드 -->
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
<!-- 이전에 사용한 샘플코드 -->

</div>
<!-- 카테고리별 베스트 4개 상품 표시 끝 -->