<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1">
    <tr bgcolor="#455b59" style="color:#FFFFFF;" align="center">
        <td><input type="checkbox" id="checkall" /></td>
        							<td width="10%">�̹���</td>
									<td width="19%">��ǰ����</td>
									<td width="15%">�ǸŰ�</td>
									<td width="10%">����</td>
									<td width="10%">��۱���</td>
									<td width="10%">��ۺ�</td>
									<td width="15%">�հ�</td>
									<td width="10%">����</td>
    </tr>
    <tr>
        <td><input type="checkbox" name="chk" /></td>
        <td>1</td>
    </tr>
    <tr>
        <td><input type="checkbox" name="chk" /></td>
        <td>2</td>
    </tr>
</table>



</body>
</html>

<script language="javascript">
<!--$(document).ready(function(){
    //�ֻ�� üũ�ڽ� Ŭ��
    $("#checkall").click(function(){
        //Ŭ���Ǿ�����
        if($("#checkall").prop("checked")){
            //input�±��� name�� chk�� �±׵��� ã�Ƽ� checked�ɼ��� true�� ����
            $("input[name=chk]").prop("checked",true);
            //Ŭ���� �ȵ�������
        }else{
            //input�±��� name�� chk�� �±׵��� ã�Ƽ� checked�ɼ��� false�� ����
            $("input[name=chk]").prop("checked",false);
        }
    })
}) -->
</script>

