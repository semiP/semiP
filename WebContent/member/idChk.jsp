<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link rel="stylesheet" type="text/css" href="/MTicket/css/import.css" />

<script type="text/javascript">
	function windowclose(){
		opener.document.joinform.id.value = "${id}";
		self.close();
	}
	
	function check(){
		var f = document.checkIdForm;
		var idPs = /^[a-z0-9_]{4,8}$/;
		
		if(f.id.value == ""){
			alert("아이디를 입력해주세요.");
			f.id.focus();
			return false;
		}
		if(!idPs.test(f.id.value)){
			alert("유효한 아이디 형식이 아닙니다.");
			f.id.value = "";	// id 작성했던 값을 비워줌
			f.id.focus();
			return false;
		}
	}
</script>

<div class="sign_grp">
	<div class="idpw_grp tac">
		<h3 class="sub_tit">아이디 확인</h3>
		<s:if test="chkId == 1">
		<p class="fz15 mb10"><strong>${id}</strong> 은(는) 이미 사용중인 아이디 입니다.</p>
		<form action="memberIdChkAction.action" method="post" name="checkForm" >
			<fieldset>
				<legend>아이디 확인</legend>
				<p class="mb10">다른 아이디를 선택하세요.</p>
				<input type="text"  class="txt w200" name="id" />
				<span class="btn btnC_05 btnF_04">
					<input type="submit" value="중복확인" />
				</span>
			</fieldset>
		</form>
		</s:if>
		<s:else>
		<p class="fz15">입력하신 <strong>${id}</strong> 은(는) 사용할 수 있는 아이디 입니다.</p>
		<div class="btn_type_04">
			<a href="#none" class="btn btnC_03 btnF_02" onclick="windowclose();">
				<span>닫기</span>
			</a>
		</div>
		</s:else>
	</div>
</div>