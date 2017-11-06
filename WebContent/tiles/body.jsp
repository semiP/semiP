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
	이곳에 표를 그려서 상품을 표시해주면 됩니다. <br>
	카테고리별 4개씩 베스트 상품 보여주기 부분
</div>

<!-- 카테고리별 베스트 4개 상품 표시 시작 -->
</body>

