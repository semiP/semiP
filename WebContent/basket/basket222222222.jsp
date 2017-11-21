basket.jsp
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import = "java.util.List" %> 
<script  type="text/javascript" src="./jquery.js"></script>




<div id="content-container">
	<table width="100%" border="0" style="margin:auto; max-width:1000px;">
		<tr>			
			<td height="10">				
				
			</td>			
		</tr>

		<tr>
			<td align="center">
				<h2>장바구니</h2>
			</td>
		</tr>
		
		<tr>
			<td height="1" bgcolor="#777777"></td>
		</tr>

		<tr>
			
			<td>
				<form action="order.action" method="post" id="frm">
				<table width="100%" border="0">
								<tr><td colspan="9" bgcolor="#cccccc" height="1"></td></tr>
								
								<tr bgcolor="#455b59" style="color:#FFFFFF;" align="center">
									<td width="1%"><input type="checkbox" id="checkall" /></td>
									<td width="10%">이미지</td>
									<td width="19%">상품정보</td>
									<td width="15%">판매가</td>
									<td width="10%">수량</td>
									<td width="10%">배송구분</td>
									<td width="10%">배송비</td>
									<td width="15%">합계</td>
									<td width="10%">선택</td>
								</tr>
								<tr><td colspan="9" bgcolor="#cccccc" height="1"></td></tr>
<!-- 게시물 하나씩 iterator 시작 -->	
								<s:iterator value="basketlist" status="stat">
								<tr align="center">
									<td width="1%"><input name="chk" type="checkbox" onClick="itemSum(this.form);" value="<s:property value='basket_price'/>"/></td>
									<td width="10%">
									<img src="<s:property value="goods_image"/>"><br><font style="width:100%;"></td>
									<td width="19%"><s:property value="goods_name"/><br><font style="font-size:0.8em; color:777777"><s:property value="goods_color"/> / <s:property value="goods_size"/></font></td>
									<td width="15%">
									
									
										<s:property value="goods_price"/>
									
									
									
									</td>
									<td width="10%">
										<input type="button" id="p_btn" value="+" style="background-color:#cccccc;width:80%;"><br>
										<input type="text" id="count" value="<s:property value="bgoods_amount"/>"  style="text-align:center; width:80%;" readonly="readonly"><br>
										<input type="button" id="m_btn" value="-" style="background-color:#cccccc;width:80%;">
									</td>
									<td width="10%">택배</td>
									<td width="10%">무료</td>
									<td width="15%">₩ <s:property value="basket_price"/></td>
									<td width="10%">
										<input type="submit" value="주문하기" style="width:80%;"><br><br>
										<input type="button" value="삭제하기" style="width:150px;" onClick="alert('삭제되었습니다.'); 
											location.href='basketDeleteAction.action?basket_no=<s:property value="basket_no"/>'"/>
									</td>
								</tr>
								</s:iterator>
<!-- 게시물 하나씩 iterator 끝 -->	
								<tr><td colspan="9" bgcolor="#f2f2f2" height="1"></td></tr>
								




							
								<tr bgcolor="#455b59" style="color:#FFFFFF;" align="center">
									<td colspan="3" width="50%" height="100px" style="font-size:1.5em;">
										[ 기본배송 ]
									</td>
									
									<td colspan="6" width="50%" height="100px" align="right" style="padding:20px;font-size:1.5em;">
									 상품구매액 <input name="total_sum" value="" style="width:100px;text-align:center;background-color:transparent;border:none;color:#FFFFFF;" readonly></font>  +  배송비 무료 = 합계 :  <input name="totalOrder_sum" value="" style="width:100px;text-align:center;background-color:transparent;border:none;color:#FFFFFF;" readonly>   원
									</td>
								</tr>
						



															
								<tr><td colspan="9" bgcolor="#cccccc" height="1"></td></tr>
								<tr>
									<td colspan="9" align="left" style="font-size:1.5em;">
										선택상품을&nbsp;
										<input type="submit" value="주문하기" style="width:150px;">&nbsp;
										<input type="button" value="삭제하기" style="width:150px;" id="del" onClick="alert('삭제되었습니다.'); 
											location.href='basketDeleteAction.action?basket_no=<s:property value="basket_no"/>'"/>
											
										


											
									</td>
								</tr>
								<tr>	<td height="50"></td>	</tr>
								<tr>
									<td colspan="9" style="border:1px solid black; padding:20px;">
<p><strong>장바구니 이용안내</strong></p>
선택하신 상품의 수량을 변경하시려면 수량변경 후 [변경] 버튼을 누르시면 됩니다.<br>
<strong>[쇼핑계속하기]</strong> 버튼을 누르시면 쇼핑을 계속 하실 수 있습니다.<br>
장바구니와 관심상품을 이용하여 원하시는 상품만 주문하거나 관심상품으로 등록하실 수 있습니다.<br>
<br>
<p><strong>무이자할부 이용안내</strong></p>
상품별 무이자할부 혜택을 받으시려면 무이자할부 상품만 선택하여 <strong>[주문하기]</strong> 버튼을 눌러 주문/결제 하시면 됩니다.<br>
<strong>[전체 상품 주문]</strong> 버튼을 누르시면 장바구니의 구분없이 선택된 모든 상품에 대한 주문/결제가 이루어집니다.<br>
단, 전체 상품을 주문/결제하실 경우, 상품별 무이자할부 혜택을 받으실 수 없습니다.<br>

									</td>
								</tr>
							</table>
							</form>
<script type="text/javascript" src="/semiP/assets/js/goodsCount.js"></script>


<%-- <script type="text/javascript">
function delete01(){

	var chk = document.getElementsByName("pidx1");  //name="pidx1" 값을 모두 가져옴.
	var data = "";
	var chk_check = false;

	 for (i=0;i<chk.length ;i++ )                   //for 문으로 돌리고..
	 {
	 if (chk[i].checked == true )               //checked 된 것만
	 {
	  data = data + ", " +chk[i].value;            // 값을 가져와서 data 넣는다.
	     if(chk[i].checked) chk_check = true;    // 하나라도 체크 됐다면 chk_check = true 값 반환
	 }
	}
	 if (chk_check)              // chk_check 값이 true 라면
	 {
	    if(confirm("삭제하시겠습니까?")){
//		  alert("넘어가는 값은="+data);

	   document.formName.action = "delete_ok2.asp?idx1="+data
	   document.formName.submit();

	    }
	 }else{                         // chk_check 값이 false 라면
	  alert('하나이상을 체크하여 주십시오');
	  return;
	 }
	}
</script> --%>

<script type="text/javascript">
<!--
$(document).ready(function(){
    //최상단 체크박스 클릭
    $("#checkall").click(function(){
        //클릭되었으면
        if($("#checkall").prop("checked")){
            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
            $("input[name=chk]").prop("checked",true);
            //클릭이 안되있으면
        }else{
            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
            $("input[name=chk]").prop("checked",false);
        }
    })
})
-->
</script>

























