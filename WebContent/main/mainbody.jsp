<%@ page contentType="text/html; charset=utf-8"%>

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

	<a class="prev" onclick="plusSlides(-1)">&#10094;</a> <a class="next"
		onclick="plusSlides(1)">&#10095;</a>
		
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

	function showSlides() {
		var i;
		var slides = document.getElementsByClassName("mySlides");
		for (i = 0; i < slides.length; i++) {
			slides[i].style.display = "none";
		}
		slideIndex++;
		if (slideIndex > slides.length) {
			slideIndex = 1
		}
		slides[slideIndex - 1].style.display = "block";
		setTimeout(showSlides, 5000); // Change image every 2 seconds
	}
</script>

<!-- 캐러셀 슬라이드쇼 끝 -->


<!-- 카테고리별 베스트 4개 상품 표시 시작 -->

<div id="blog-container">
	이곳에 표를 그려서 상품을 표시해주면 됩니다.	카테고리별 4개씩 베스트 상품 보여주기 부분 <br><br>
	
	<font size="1">BEST COLLECTION FROM </font><font size="2"><strong>카테고리 이름</strong></font><br>
	<table width="100%" border="0">
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
		
	</table>
		
		
	
</div>

<!-- 카테고리별 베스트 4개 상품 표시 끝 -->
</body>

