<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<meta http-equiv="X-UA-Compatible" content="IE=edge" /> <!-- 익스에서 문서보드 IE7 로 고정하는것 방지 -->
<title>Q&A 등록하기</title>
	<link rel="stylesheet" href="/semiP/assets/css/common.css" type="text/css">
	<link rel="stylesheet" href="/semiP/assets/css/board.css" type="text/css">
</head>


<SCRIPT type="text/javascript">
	function validation()
	{
		var frm = document.forms(0);
				
		if(frm.subject.value == "")
		{
			alert("제목을 입력해주세요.");
			return false;
		}
				
		else if(frm.goods_name.value == "")
		{
			alert("상품이름을 입력해주세요.");
			return false;
		}
				
		else if(frm.goods_size.value == "")
		{
			alert("사이즈를 입력해주세요.");
			return false;
		}
				
		else if(frm.goods_color.value == "")
		{
			alert("컬러를 입력해주세요.");
			return false;
		}
				
		return true;
	}
</SCRIPT>

	<s:if test="resultClass == NULL">
		<form action="goodsWriteAction.action" method="post" enctype="multipart/form-data" onsubmit="return validation();">
	</s:if>
	
	<s:if test="resultClass == 1">
		<form action="goodsWriteAction.action" method="post" enctype="multipart/form-data" onsubmit="return validation();">
	</s:if>

	<s:else>
		<form action="goodsModifyAction.action" method="post" enctype="multipart/form-data">
		<s:hidden name="goods_no" value="%{resultClass.goods_no}" />
		<s:hidden name="currentPage" value="%{currentPage}" />
		<s:hidden name="old_file" value="%{resultClass.goods_image}" />
	</s:else>

<div id="content-container">
	<table width="100%" border="0" style="margin:auto; max-width:1000px;">
		<tr>			
			<td height="10">				
				
			</td>			
		</tr>

		<tr>
			<td align="left">
				<h2>상품 등록 폼 (admin)</h2>
			</td>
		</tr>
	
	</table>

		<tr>
			<td colspan="3" height="1" bgcolor="#777777"></td>
		</tr>
		
		<table width="80%" border="0" align="center">
			<tr>
				<td align="left" colspan="2">
					<h2>> 입력하기</h2>
				</td>
			</tr>
			
			<tr>
				<td colspan="3" height="1" bgcolor="#777777"></td>
			</tr>
			<tr>
				<td width="100"><br>&nbsp;&nbsp;상품이름<br><br></td>
				<td><s:textfield name="goods_name" theme="simple" value="%{resultClass.goods_name}" cssStyle="width:100px" maxlength="20"/></td>
			</tr>
			<tr>
				<td width="100"><br>&nbsp;&nbsp;카테고리<br><br></td>
				<td>
<!-- 				<input type="text" id="goods_category" style="width:100px; height:30px;"> -->
					<s:textfield name="goods_category" theme="simple" value="%{resultClass.goods_category}" cssStyle="width:100px" maxlength="20"/>
					<select name="select" onchange="document.getElementById('goods_category').value=this.value;if(this.value==''){document.getElementById('goods_category').focus();}">
						<option value="" selected="selected">직접입력</option>										
						<option value="1">1.outer</option>
						<option value="2">2.top</option>
						<option value="3">3.pants</option>
						<option value="4">4.skirt</option>
						<option value="5">5.dress</option>
						<option value="6">6.shoes</option>
						<option value="7">7.bag</option>
					</select>					
				</td>
			</tr>
			
			<tr>
				<td width="150"><br>&nbsp;&nbsp;사이즈 (,)로 구분<br><br></td>
				<td><s:textfield name="goods_size" theme="simple" value="%{resultClass.goods_size}" cssStyle="width:100px" maxlength="20"/></td>
			</tr>
			
			<tr>
				<td width="150"><br>&nbsp;&nbsp;컬러 (,)로 구분<br><br></td>
				<td><s:textfield name="goods_color" theme="simple" value="%{resultClass.goods_color}" cssStyle="width:100px" maxlength="20"/></td>
			</tr>
			
			<tr>
				<td width="150" height="40">&nbsp;수량(재고입력)</td>
				<td>
					<input type="button" id="m_btn" value="-" style="background-color:#cccccc;">
<!-- 				<input type="text" id="count" value="0" style="text-align:center; width:50px;" readonly="readonly"> -->	
					<s:textfield name="goods_amount" theme="simple" value="%{resultClass.goods_amount}" cssStyle="width:100px" maxlength="20"/>
					<input type="button" id="p_btn" value="+" style="background-color:#cccccc;">
				</td>
			</tr>
			
			<tr>
				<td width="100"><br>&nbsp;&nbsp;가격<br><br></td>
				<td><s:textfield name="goods_price" theme="simple" value="%{resultClass.goods_price}" cssStyle="width:100px" maxlength="20"/></td>
			</tr>
			
			<tr>
				<td width="200"><br>&nbsp;&nbsp;내용<br><br></td>
				<td><s:textarea name="goods_content" theme="simple" value="%{resultClass.goods_content}" cols="50" rows="10"/></td>
			</tr>
			
			<tr>
				<td bgcolor="#F4F4F4">&nbsp;&nbsp;이미지등록</td>
				<td bgcolor="#FFFFFF">
				<s:file name="upload" theme="simple" />
				
				<s:if test="resultClass.goods_image != NULL">
					&nbsp; * <s:property value="resultClass.goods_image" /> 파일이 등록되어 있습니다. 다시 업로드하면 기존의 파일은 삭제됩니다.
				</s:if>
				</td>
			</tr>
			
		<tr>
			<td colspan="3" height="1" bgcolor="#777777"></td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<input type="submit" class="btn-custom" value="등록하기">&nbsp;&nbsp;
				<input type="button" class="btn-custom" value="리셋">&nbsp;&nbsp;
<!-- 				<form action="goodsListAction.action" method="post"> -->
				<input type="button" class="btn-custom" value="목록" onClick="javascript:location.href='goodsListAction.action'">
			</td>
		</tr>
		<tr>
			<td height="30px"/>
		</tr>
		</table>
		
	</table>