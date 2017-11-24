<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" /> <!-- 익스에서 문서보드 IE7 로 고정하는것 방지 -->
<script type="text/javascript">
	function validation()
	{
		var frm = document.forms(0);

		if(frm.inquiry_subject.value == "")
		{
			alert("입력해주세요");
			return false;
		}
		else if(frm.inquiry_content.value == "")
		{
			alert("입력해주세요");
			return false;
		}
		else
		
		return true;
	}	
	
	 $(document).ready(function(){
		 $("#inquiry_content").cleditor();
		 
	 });
	 
</script>


<title>1:1 문의하기</title>
	<link rel="stylesheet" href="/semiP/assets/css/common.css" type="text/css">
	<link rel="stylesheet" href="/semiP/assets/css/board.css" type="text/css">
</head>
<body>
	
<table width="100%">
	<tr><td bgcolor="#cccccc" height="1"></td></tr>
	
	<tr>
		<td class="board-titlebar">1:1 문의하기</td>
	</tr>
	<tr><td bgcolor="#cccccc" height="1"></td></tr>
	<!-- 넘어가기 전에 alert창 띄우기 -->
	<form action="inqWriteAction.action" method="post" enctype="multipart/form-data" >
	<tr>
		<td style="padding: 0 0 0 5%;">
			문의분류&nbsp;&nbsp;
			<select name="category">										
				<option value="1">주문/배송 문의</option>
				<option value="2">반품/교환 문의</option>
			</select>
		</td>
	</tr>
	<tr> <!-- value에 inquiry.inquiry_subject / mypage.inquiry_subject 중 뭐가맞는지 확인해보기 -->
		<td class="board-titlebar" >
		<input name="inquiry_subject" type="text" style="width:90%;" placeholder="제목을 입력해주세요" value="<s:property value='inquiry_subject'/>"></td>
		
	</tr>

	<tr>
		<td bgcolor="#cccccc" height="1"></td>
	</tr>
	<tr>
		<td class="board-titlebar">
			<textarea style="width:90%; height:200px; resize:none;" placeholder="내용을 입력해주세요" value="<s:property value='inquiry_content'/>"></textarea>
		</td>
	</tr>
	<tr><td bgcolor="#cccccc" height="1"></td></tr>
	<tr>
		<td align="center">
			<table width="90%" border="0">
				<tr>
					<td width="100">
					<!--<form><input type="button" value="사진추가"></td>
					 <td width="100"><input type="submit" value="사진추가"></form></td> 
					<td>여기에 등록된 파일들 이름을 br 태그로 나열합니다</td>-->
					<td><s:file name="uploadFile" theme="simple"/>
					<s:if test="resultClass.inquiry_addfile != NULL">
						<s:property value="resultClass.inquiry_addfile" /> 파일이 이미 등록되어 있음
					</s:if>
					</td>
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
	</form>
</table>	
	
</body>
</html>