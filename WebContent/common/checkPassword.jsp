<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> yjunlim
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- 본 페이지는 알맞은 사이즈의 팝업 창으로 띄워서 이용합니다 -->

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" /> <!-- 익스에서 문서보드 IE7 로 고정하는것 방지 -->
<title>비밀번호 확인</title>
</head>
<body>

<div style="margin:10% auto auto auto; width:80%; padding:50px 0 50px 0; text-align:center; border:1px solid black;">
	비밀번호를 입력해 주시기 바랍니다<br><br>
	<input type="text" style="width:200px;">
	<input type="submit" value="확인">
</div>

<<<<<<< HEAD
=======
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��й�ȣ Ȯ��</title>
<link rel="stylesheet" href="/StrutsBoard/board/common/css/css.css" type="text/css">
</head>
<body>
	<h2>��й�ȣ Ȯ��</h2>
	
	<form action="checkAction.action" method="post">
	<s:hidden name="no" value="%{no}" />
	<s:hidden name="currentPage" value="%{currentPage}" />
	
	<table width="250" border="0" cellspacing="0" cellpadding="0">
		<tr bgcolor="#777777">
			<td height="1" colspan="2"></td>
		</tr>
		
		<tr>
			<td width="100" bgcolor="#F4F4F4">  ��й�ȣ �Է�</td>
			<td width="150" bgcolor="#FFFFFF">
				&nbsp;&nbsp;<s:textfield name="password" theme="simple" cssStyle="width:100px" maxlength="20"/>
				&nbsp;&nbsp;<input name="submit" type="submit" value="Ȯ��" class="inputb">
			</td>
		</tr>
		
		<tr bgcolor="#777777">
			<td height="1" colspan="2"></td>
		</tr>
	</table>
	</form>
>>>>>>> yjunlim
=======
>>>>>>> yjunlim
</body>
</html>