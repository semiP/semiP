<%@ page contentType="text/html; charset=utf-8"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" /> <!-- 익스에서 문서보드 IE7 로 고정하는것 방지 -->
<title>Q&A 등록하기</title>
	<link rel="stylesheet" href="/semiP/assets/css/common.css" type="text/css">
	<link rel="stylesheet" href="/semiP/assets/css/board.css" type="text/css">
</head>
<body>
	
<table width="100%">
	<tr><td colspan="4" bgcolor="#cccccc" height="1"></td></tr>
	
	<tr>
		<td class="board-titlebar">Q&A 글 작성하기</td>
	</tr>
	<tr><td bgcolor="#cccccc" height="1"></td></tr>
	<tr>
		<td class="board-titlebar" ><input type="text" style="width:90%;" placeholder="제목을 입력해주세요"></td>
	</tr>
	<tr>
		<td bgcolor="#cccccc" height="1"></td>
	<tr>
		<td class="board-titlebar">
			<textarea style="width:90%; height:300px; resize:none;" placeholder="내용을 입력해주세요"></textarea>
		</td>
	</tr>
	<tr><td bgcolor="#cccccc" height="1"></td></tr>
	<tr>
		<td align="center">
			<input type="button" value="작성완료">
		</td>
	</tr>
</table>	
	
</body>
</html>