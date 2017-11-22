<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<script type="text/javascript">
	function windowclose() {
		opener.document.loginform.id.value = "${resultClass.id}";
		opener.document.loginform.passwd.value = "${resultClass.passwd}";
		self.close();
}
</script>
<div class="tac">
	<h3 class="sub_tit">아이디 찾기</h3>
	<p class="fz15">${resultClass.name}님의 아이디는 <strong>${resultClass.id}</strong>입니다.</p>
		</a>
	</div>
</div>