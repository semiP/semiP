<%@ page contentType="text/html; charset=utf-8"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" /> <!-- 익스에서 문서보드 IE7 로 고정하는것 방지 -->
<title>상품후기 작성</title>
	<link rel="stylesheet" href="/semiP/assets/css/common.css" type="text/css">
	<link rel="stylesheet" href="/semiP/assets/css/board.css" type="text/css">
</head>
<body>
	
<table width="100%">
	<tr><td bgcolor="#cccccc" height="1"></td></tr>
	
	<tr>
		<td class="board-titlebar">상품후기 작성 (상품정보: [상품이름 적어주기])</td>
	</tr>
	<tr><td bgcolor="#cccccc" height="1"></td></tr>
	<tr>
		<td class="board-titlebar" ><input type="text" style="width:90%;" placeholder="제목을 입력해주세요"></td>
	</tr>

	<tr>
		<td bgcolor="#cccccc" height="1"></td>
	</tr>
	<tr align="center">
		<td>만족하신 만큼 평가해 주세요 :</td>
	</tr>
	<tr align="center">
		<td>
			<input type="range" name="range" value="50" step="1" min="0" max="100" onchange='document.getElementById("rangeText").value=value'>
			&nbsp;&nbsp;
			<input type="text" id="rangeText" name="rangeText" style="width:30px">
		</td>
	</tr> 	

	<tr>
		<td bgcolor="#cccccc" height="1"></td>
	</tr>
	<tr>
		<td class="board-titlebar">
			<textarea style="width:90%; height:200px; resize:none;" placeholder="내용을 입력해주세요"></textarea>
		</td>
	</tr>
	<tr><td bgcolor="#cccccc" height="1"></td></tr>
	<tr>
		<td align="center">
			<table width="90%" border="0">
				<tr>
					<td width="100"><input type="button" value="사진추가"></td>
					<td>여기에 등록된 파일들 이름을 br 태그로 나열합니다</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr><td bgcolor="#cccccc" height="1"></td></tr>
	<tr>
		<td align="center">
			<input type="submit" value="작성완료">
		</td>
	</tr>
</table>	
	
</body>
</html>