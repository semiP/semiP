<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" /> <!-- 익스에서 문서보드 IE7 로 고정하는것 방지 -->
<title>NOTICE</title>
	<link rel="stylesheet" href="/semiP/assets/css/common.css" type="text/css">
	<link rel="stylesheet" href="/semiP/assets/css/board.css" type="text/css">
</head>
<body>
	
<table width="100%">
	<tr><td colspan="4" bgcolor="#cccccc" height="1"></td></tr>
	<tr>
		<td class="board-titlebar" width="8%">번호</td>
		<td class="board-titlebar" width="67%">글제목</td>
		<td class="board-titlebar" width="12%">작성자</td>
		<td class="board-titlebar" width="15%">작성일</td>
	</tr>
	<tr><td colspan="4" bgcolor="#cccccc" height="1"></td></tr>
	<tr><td colspan="4" bgcolor="#cccccc" height="1"></td></tr>
	<tr>
		<td class="board-titlebar" width="8%"><s:property value="resultClass.notice_no" /></td>
		<td class="board-titlebar" width="67%"><s:property value="resultClass.notice_subject" /></td>
		<td class="board-titlebar" width="12%">관리자</td>
		<td class="board-titlebar" width="15%"><s:property value="resultClass.notice_regdate" /></td>
	</tr>
	<tr><td colspan="4" bgcolor="#cccccc" height="1"></td></tr>
	<tr>
		<td colspan="4" bgcolor="#f2f2f2"><s:property value="resultClass.notice_content" />
			<td colspan="4" class="board-titlebar" width="67%"></td>
	</tr>
	<tr><td colspan="4" bgcolor="#cccccc" height="1"></td></tr>
	<tr>
		<td colspan="4" align="right">	<!-- 차후 관리자는 수정/삭제 -->
			<input type="button" value="글삭제">
		</td>
	</tr>
</table>	
<%-- <br><br><br><br>
<table width="100%">
	<tr>
		<td colspan="4" align="center">
			<div class="paging">
				<s:property value="pagingHtml" escape="false"/>
			</div>
		</td>
	</tr>
</table> --%>
	
</body>
</html>