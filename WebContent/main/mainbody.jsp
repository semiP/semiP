<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!-- 캐러셀 슬라이드쇼 시작 -->

<div class="slideshow-container">
	<div class="mySlides fade">
		<div class="numbertext">1 / 3</div>
		<img src="/semiP/assets/images/slideshow/1.jpg" style="width: 100%">
	</div>

	<div class="mySlides fade">
		<div class="numbertext">2 / 3</div>
		<img src="/semiP/assets/images/slideshow/2.jpg" style="width: 100%">
	</div>

	<div class="mySlides fade">
		<div class="numbertext">3 / 3</div>
		<img src="/semiP/assets/images/slideshow/3.jpg" style="width: 100%">
	</div>

	<div style="text-align: center">
	<span class="dot" onclick="currentSlide(1)"></span> <span class="dot"
		onclick="currentSlide(2)"></span> <span class="dot"
		onclick="currentSlide(3)"></span>
</div>
</div>
<br>


<script>
var slideIndex = 0;
showSlides();

function currentSlide(){}

function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none"; 
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1} 
    slides[slideIndex-1].style.display = "block"; 
    setTimeout(showSlides, 2000); // Change image every 2 seconds
}
</script>

<!-- 캐러셀 슬라이드쇼 끝 -->


<!-- 카테고리별 베스트 4개 상품 표시 시작 -->

<div id="blog-container">
	
	<table width="100%" border="0">
		<s:iterator value="categoryMap">	
			<tr>
				<td colspan="4" style="text-transform:uppercase;">
					<font size="1">BEST COLLECTION FROM </font><font size="2"><strong><s:property value="key" /></strong></font>
				</td>
			</tr>
			<tr bgcolor="#777777">
						<td height="1" colspan="4"></td>
			</tr>
			<tr>
				<s:iterator value="value">
					<td align="center" width="25%">
					<!-- 상품번호 적기 -->
					no.<s:property value="goods_no" /><br>		
					<!-- 상품이미지 찍기 -->
					<a href="#">
						<img src="http://cooz.co/semiP/IMG/<s:property value="goods_category" />/<s:property value="goods_no" />/0.jpg" style="width:100%;"><br>		
					</a>
					<!-- 상품정보 적기 (이름/설명/가격) -->
					<s:property value="goods_name" /><br>
					₩ <s:property value="goods_price" />
					</td>
				</s:iterator>
			</tr>
			<tr>
				<td height="30" colspan="4"></td>		<!-- 공란 만들기 -->
			</tr>
		</s:iterator>
	</table>

</div>

<!-- 카테고리별 베스트 4개 상품 표시 끝 -->
</body>

