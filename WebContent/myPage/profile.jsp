<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<head>
	
				<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample6_address').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('sample6_address2').focus();
            }
        }).open();
    }
</script>
</head>
<body>
<div id="content-container">
	<table width="100%" border="0" style="margin:auto; max-width:1000px;">
		<tr>			
			<td height="10">				
				
			</td>			
		</tr>

		<tr>
			<td align="left">
				<h2>MY PAGE</h2>
			</td>
		</tr>
		
		<tr>
			<td colspan="3" height="1" bgcolor="#777777"></td>
		</tr>

		<tr>
			<td width="15%"/>			
			<td>
				<table width="100%" border="0">
					<tr><td colspan="7" bgcolor="#cccccc" height="1"></td></tr>

					<tr bgcolor="#455b59" align="center">
						<td class="myPageMenuItem" bgcolor="#591522"><strong><a href="/semiP/InfoView.action" >
							회원정보</a></strong></td>
						<td class="myPageMenuItem" ><a href="/semiP/OrderlistClassify.action" >
							주문/배송현황</a></td>
						<td class="myPageMenuItem"><a href="/semiP/ReturnChangeCondition.action" >
							반품/교환</a></td>
						<td class="myPageMenuItem"><a href="/semiP/myPage/qnaList.jsp" >
							문의내역</a></td>
					</tr>
					<tr><td colspan="7" bgcolor="#cccccc" height="1"></td></tr>
					<tr>	<td height="30"></td>	</tr>
								
				</table>
			</td>
			<td width="15%"/>
		</tr>
		
		
		
		<form action="InfoModifyPro.action" method="post">
		<table width="80%" border="0" align="center">
			<tr>
				<td align="left" colspan="2">
					<h2>> 기본정보 수정</h2>
				</td>
			</tr>
			
			<tr>
				<td colspan="3" height="1" bgcolor="#777777"></td>
			</tr>
			<tr>
				<td class="memberinfo1" width="100"><br>&nbsp;&nbsp;이름<br><br></td>
				<td>${session.session_member_name }</td>
			</tr>
			<tr>
				<td class="memberinfo1" width="100" id="m_saved_email"><br>&nbsp;&nbsp;이메일<br><br></td>
				<td>
					<input type="text" id=m_email1  style="width:100px; height:30px;" value="<s:property value="email1"/>">&nbsp;@&nbsp;
					<input type="text" id="m_email2" style="width:100px; height:30px;" value="<s:property value="email2"/>">
					<select name="select" onchange="document.getElementById('m_email2').value=this.value;if(this.value==''){document.getElementById('m_email2').focus();}">		
						<option value="" selected="selected">직접입력</option>										
						<option value="gmail.com">gmail.com</option>
						<option value="naver.com">naver.com</option>
						<option value="netian.com">netian.com</option>
						<option value="paran.com">paran.com</option>
						<option value="daum.net">daum.net</option>
						<option value="hanmail.net">hanmail.net</option>
						<option value="me.com">me.com</option>
						<option value="lycos.co.kr">lycos.co.kr</option>
						<option value="yahoo.co.kr">yahoo.co.kr</option>
						<option value="yahoo.com">yahoo.com</option>
						<option value="icloud.com">icloud.com</option>
						<option value="cyworld.com">cyworld.com</option>
						<option value="dreamwiz.com">dreamwiz.com</option>
						<option value="nate.com">nate.com</option>
						<option value="empal.com">empal.com</option>
						<option value="orgio.net">orgio.net</option>
						<option value="unitel.co.kr">unitel.co.kr</option>
						<option value="chol.com">chol.com</option>
						<option value="kornet.net">kornet.net</option>
						<option value="korea.com">korea.com</option>
						<option value="freechal.com">freechal.com</option>
						<option value="hanafos.com">hanafos.com</option>
						<option value="hitel.net">hitel.net</option>
						<option value="hanmir.com">hanmir.com</option>
						<option value="hotmail.com">hotmail.com</option>
					</select>					
				</td>
			</tr>
			<tr>
				<td width="100"><br>&nbsp;&nbsp;우편번호<br><br></td>
				<td><input type="text" id="sample6_postcode" style="width:100px; height:30px;" value="<s:property value="resultClass.member_zipcode"/>">&nbsp;&nbsp;<input type="button" onclick="sample6_execDaumPostcode()" value="찾기"></td>
			
			</tr>
			<tr>
				<td width="100"><br>&nbsp;&nbsp;주소<br><br></td>
				<td><input type="text" id="sample6_address" style="width:90%; height:30px;" value="<s:property value="resultClass.member_address1"/>"></td>
			</tr>
			<tr>
				<td width="100"><br>&nbsp;&nbsp;상세주소<br><br></td>
				<td><input type="text" id="sample6_address2" style="width:90%; height:30px;" value="<s:property value="resultClass.member_address2"/>"></td>
			</tr>
			<tr>
				<td width="100"><br>&nbsp;&nbsp;연락처<br><br></td>
				<td><input type="text" style="width:90px; height:30px;" value="<s:property value="phone1"/>">&nbsp;-&nbsp;<input type="text" style="width:90px; height:30px;"value="<s:property value="phone2"/>">&nbsp;-&nbsp;<input type="text" style="width:90px; height:30px;"value="<s:property value="phone3"/>"><br>
				</td>
			</tr>
			<tr>
				<td width="100"><br>&nbsp;&nbsp;기존 비밀번호<br><br></td>
				<td><input type="password" style="width:90%; height:30px;" value="<s:property value="resultClass.member_pw"/>"></td>
			</tr>
			<tr>
				<td colspan="3" height="1" bgcolor="#777777"></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="submit" name="submit_member" class="btn-custom" value="변경하기" >&nbsp;&nbsp;
					<input type="reset" class="btn-custom" value="리셋">
				</td>
			</tr>
			<tr>
				<td height="30px"/>
			</tr>	
					
		</table>
		</form>
		<form action="InfoModifyPWPro.action" method="post">
		<table width="80%" border="0" align="center">
			<tr>
				<td align="left" colspan="2">
					<h2>> 비밀번호 수정</h2>
				</td>
			</tr>
			
			<tr>
				<td colspan="3" height="1" bgcolor="#777777"></td>
			</tr>
			<tr>
				<td width="100"><br>&nbsp;&nbsp;기존 비밀번호<br><br></td>
				<td><input type="password" style="width:90%; height:30px;" value="<s:property value="resultClass.member_pw"/>"></td>
				<%-- <s:hidden name="member_pw" value="%{resultClass.member_pw}"/> --%>
			</tr>
			<tr>
				<td width="100"><br>&nbsp;&nbsp;새 비밀번호<br><br></td>
				<td><input type="password" style="width:90%; height:30px;"></td>
			</tr>
			<tr>
				<td width="100"><br>&nbsp;&nbsp;비밀번호 확인<br><br></td>
				<td><input type="password" style="width:90%; height:30px;"></td>
			</tr>
			<tr>
				<td colspan="3" height="1" bgcolor="#777777"></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="submit" name="submit_pw" class="btn-custom" value="변경하기">&nbsp;&nbsp;
					<input type="reset" class="btn-custom" value="리셋">
				</td>
			</tr>
			<tr>
				<td height="30px"/>
			</tr>
			<tr>
				<td colspan="2" align="right"><a href="/semiP/myPage/terminateForm.jsp">회원탈퇴</a></td>
			</tr>		
		</table>
	</table>
	</form>
</body>

<script type="text/javascript">
function changModify(){
	document.action="InfoModifyAction.action";
	document.method="form";
	docuemtn.submit();
}
</script> 

<!-- onClick="location='InfoModifyForm.action',session_member_no,resultClass.member_pw" -->