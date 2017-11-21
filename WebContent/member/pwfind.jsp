<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<script type="text/javascript">
	function windowclose() {
		opener.document.loginform.id.value="${resultClass.id}";
		opener.document.loginform.passwd.value="${resultClass.passwd}>";
		self.close();
	}
</script>

<div class="tac">
	<h3 class="sub_tit">비밀번호 찾기</h3>
	<p class="fz15">${resultClass.id}님의 비밀번호은 <strong>${resultClass.passwd}</strong>입니다.</p>
</div>