<%@ page contentType="text/html; charset=utf-8"%>


<!DOCTYPE html>
<html>
<head>
<title>Q&A</title>
	<link rel="stylesheet" href="/semiP/assets/css/common.css" type="text/css">
	<link rel="stylesheet" href="/semiP/assets/css/board.css" type="text/css">
</head>
<body>
	
	
<!-- 비밀글인지 확인해서 처음에 비밀번호 인풋을 받습니다. -->
	
	
<table width="100%">
	<tr><td colspan="4" bgcolor="#cccccc" height="1"></td></tr>
	
	<tr>
		<td class="board-titlebar" width="8%">번호</td>
		<td class="board-titlebar" width="67%">글제목</td>
		<td class="board-titlebar" width="12%">작성자</td>
		<td class="board-titlebar" width="15%">작성일</td>
	</tr>
	<tr><td colspan="4" bgcolor="#cccccc" height="1"></td></tr>
	<tr>
		<td class="board-titlebar" width="8%">15</td>
		<td class="board-titlebar" width="67%">아 이거 정말 궁금해요 알려주세요</td>
		<td class="board-titlebar" width="12%">호갱님</td>
		<td class="board-titlebar" width="15%">2017/11/11</td>
	</tr>
	<tr><td colspan="4" bgcolor="#cccccc" height="1"></td></tr>
	<tr>
		<td colspan="4" bgcolor="#f2f2f2">
			글 내용을 집어넣는 부분입니다....
		</td>
	</tr>
	<tr><td colspan="4" bgcolor="#cccccc" height="1"></td></tr>
	<tr>
		<td colspan="4" align="right">	<!-- 본인이 게시물 열람하는 경우에만 글삭제 버튼을 넣는걸로 할까나요 -->
			<input type="button" value="글삭제">
		</td>
	</tr>
</table>	
<br><br><br><br>
<table width="100%">
	<tr><td colspan="4" bgcolor="#cccccc" height="1"></td></tr>
	
	<tr>
		<td class="board-titlebar" width="8%">번호</td>
		<td class="board-titlebar" width="67%">글제목</td>
		<td class="board-titlebar" width="12%">작성자</td>
		<td class="board-titlebar" width="15%">작성일</td>
	</tr>
	<tr><td colspan="4" bgcolor="#cccccc" height="1"></td></tr>
	
<!-- 게시물 하나씩 iterator 시작 -->
	<tr>
		<td class="board-titlebar" width="8%">15</td>
		<!-- 글제목을 누르면 팝업으로 표시할까나 싶네요... -->
		<td class="board-titlebar" width="67%">이거 배송 하루만에 되나요</td>
		<td class="board-titlebar" width="12%">돈쓴사람</td>
		<td class="board-titlebar" width="15%">2017/11/09</td>
	</tr>
	<tr><td colspan="4" bgcolor="#f2f2f2" height="1"></td></tr>
	<tr>
		<td class="board-titlebar" width="8%">15</td>
		<!-- 글제목을 누르면 팝업으로 표시할까나 싶네요... ajax 를 안배워서 페이지 리로딩을 할 수밖에 없을듯 하네요 -->
		<td class="board-titlebar" width="67%"><img src="/semiP/assets/images/board-icon/reply.gif">그럴 수도 있겠네요</td>
		<td class="board-titlebar" width="12%">관리자</td>
		<td class="board-titlebar" width="15%">2017/11/10</td>
	</tr>
<!-- 게시물 하나씩 iterator 끝 -->																

	<tr><td colspan="4" bgcolor="#cccccc" height="1"></td></tr>
	<tr>
		<td colspan="4" align="center">
			여기에 테이블 페이징 내용을 넣어주세요
		</td>
	</tr>
</table>
	
</body>
</html>