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
		<s:iterator value="categoryMap" status="stat">	
			<tr>
				<td colspan="4">
					<font size="1">BEST COLLECTION FROM </font><font size="2"><strong></strong></font>
				</td>
			</tr>
			<tr bgcolor="#777777">
				<td height="1" colspan="4"></td>
			</tr>
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
		</s:iterator>
	</table>

</div>

<!-- 카테고리별 베스트 4개 상품 표시 끝 -->
</body>

