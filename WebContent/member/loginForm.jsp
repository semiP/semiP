<%@ page contentType="text/html; charset=utf-8"%>


<div id="blog-container">
	<table width="100%" border="0">
		<tr> <!-- 타이틀 텍스트 넣기 -->
			<td width="25%"/>
			<td align="center"><h1>LOGIN</h1></td>
			<td width="25%"/>
		</tr>
		<tr> <!-- 폼 테이블 넣기 -->
			<td width="25%"/>
			<td>
				<form action="login.action" method="post">
					<table width="100%" height="200" border="0" class="inputForm" style="border:3px solid black;">
						<tr>
							<td align="right" width="100">아이디&nbsp;&nbsp;&nbsp;</td>
							<td><input type="text" id="id" name="id" style="width: 100%; height:30px;"></td>
							<td width="15"></td>
						</tr>
						<tr>
							<td align="right" width="100">비밀번호&nbsp;&nbsp;&nbsp;</td>
							<td><input type="password" id="pw" name="passwd" style="width: 100%; height:30px;"></td>
							<td width="15"></td>
						</tr>
						<tr align="center">
							<td colspan="3"><input type="submit" value="로그인" class="btn-custom" ></td>
						</tr>
					</table>
				</form>
			</td>
			<td width="25%"/>
		</tr>
		<tr> <!-- 추가링크 넣기 -->
			<td width="25%"/>
			<td align="center">
				<a href="#">아이디 비밀번호 찾기</a>
				&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="#">회원가입</a>
			</td>
			<td width="20%" />
		</tr>
		<tr>
			<td height="200"/>
		</tr>
	</table>
</div>
