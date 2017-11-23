<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<!-- 익스에서 문서보드 IE7 로 고정하는것 방지 -->
<script type="text/javascript">
	function validation() {
		var frm = document.forms(0);

		if (frm.inquiry_subject.value == "") {
			alert("입력해주세요");
			return false;
		} else if (frm.inquiry_content.value == "") {
			alert("입력해주세요");
			return false;
		}

		return true;
	}
</script>


<title>1:1 문의하기</title>
<link rel="stylesheet" href="/semiP/assets/css/common.css"
	type="text/css">
<link rel="stylesheet" href="/semiP/assets/css/board.css"
	type="text/css">
</head>
<body>
		<table width="100%">
			<tr>
				<td bgcolor="#cccccc" height="1"></td>
			</tr>

			<tr>
				<td class="board-titlebar">1:1 문의하기</td>
			</tr>
			<tr>
				<td bgcolor="#cccccc" height="1"></td>
			</tr>
			<form action="inqWriteAction.action" method="post" enctype="multipart/form-data" >
			<tr>
				<td style="padding: 0 0 0 5%;">문의분류&nbsp;&nbsp;
				<select name="category">
						<option value="1">주문/배송 문의</option>
						<option value="2">반품/교환 문의</option>
				</select>
				</td>
			</tr>
			<tr>
				<td class="board-titlebar"><input type="text"
					style="width: 90%;" placeholder="제목을 입력해주세요"
					value="<s:property value='%{resultClass.inquiry_subject}'/>"></td>
				<%-- <s:textfield name="subject" theme="simple" value="%{resultClass.subject}" cssClass="txt"/> --%>
			</tr>

			<tr>
				<td bgcolor="#cccccc" height="1"></td>
			</tr>
			<tr>
				<td class="board-titlebar">
				
				<s:textarea cssStyle="width: 90%; height: 200px; resize: none;" name="content" theme="simple" value="%{resultClass.inquiry_content}"/>
				<!-- <textarea style="width: 90%; height: 200px; resize: none;"	placeholder="내용을 입력해주세요"></textarea> -->
				
				</td>
			</tr>
			<tr>
				<td bgcolor="#cccccc" height="1"></td>
			</tr>
			<tr>
				<td align="center">
					<table width="90%" border="0">
						<tr>
							<td width="100"><!-- <input type="button" value="사진추가">
							</td> -->
							<s:file name="upload" theme="simple"/>
							<td><s:property value="resultClass.inquiry_addfile" /></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td bgcolor="#cccccc" height="1"></td>
			</tr>
			<tr>
				<td align="center">
				<input type="submit" value="작성완료" >
				</td>	
			</tr>

		</table>
	</form>
</body>
</html>