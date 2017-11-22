

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import = "java.util.List" %> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>


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
				<form action="orderWriteForm.action" method="post" id="frm" name="frm">
				<input type="hidden" id="basket_no_set" name="basket_no_set" />

				<table width="100%" border="0">
								<tr><td colspan="9" bgcolor="#cccccc" height="1"></td></tr>
								
								<tr bgcolor="#455b59" style="color:#FFFFFF;" align="center">
									<td width="1%"></td>
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
								
								<input type="hidden" id="basket_price_<s:property value = "#stat.index" />" name="basket_price_<s:property value = "#stat.index" />" value="<s:property value='basket_price'/>" />
								<tr align="center" id="basket_list_<s:property value = "#stat.index" />">
									<td width="1%"><input name="chkbox" id="chkbox_<s:property value = "#stat.index" />" type="checkbox" onClick="itemSum(<s:property value = "#stat.index" />);" value="<s:property value='basket_no'/>"/></td>
									<td width="10%">
									<img src="<s:property value="goods_image"/>"><br><font style="width:100%;"></td>
									<td width="19%"><s:property value="goods_name"/><br><font style="font-size:0.8em; color:777777"><s:property value="goods_color"/> / <s:property value="goods_size"/></font></td>
									<td width="15%">
									
									
										<s:property value="goods_price"/>
									
									
									
									</td>
									<td width="10%">
										<!-- <input type="button" id="p_btn" value="+" style="background-color:#cccccc;width:80%;"><br> -->
										<input type="text" id="count" value="<s:property value="bgoods_amount"/>"  style="text-align:center; width:80%;" readonly="readonly"><br>
										<!-- <input type="button" id="m_btn" value="-" style="background-color:#cccccc;width:80%;"> -->
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
										<input type="button" value="삭제하기" style="width:150px;" onClick="javascript:checked_delete();"/>
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
<script language="javascript">



function checked_delete()
{
	/*
   var sum = 0;
   var count = document.frm.chkbox.length;
   var checkbox_list = "";
   
   for(var i=0; i < count; i++ ){
       if( document.frm.chkbox[i].checked == true ){
	    //sum += parseInt(frm.chkbox[i].value);
    	   checkbox_list = checkbox_list + "||" + parseInt(document.frm.chkbox[i].value);
    	   $("#basket_list_"+i).remove();
       }
      
      
   }
   */
	var basket_no_list = "";
   $('input[name=chkbox]:checked').each(function() { 
	   /*
	   $("#basket_list_"+$(this).val()).remove();
	   $("input[name=total_sum]").val($("input[name=total_sum]").val() - $("#basket_price_"+$(this).val()).val());
	   $("input[name=totalOrder_sum]").val($("input[name=totalOrder_sum]").val() - $("#basket_price_"+$(this).val()).val());
	   */
	   basket_no_list = basket_no_list + "||" + $(this).val();
	   
   });
      
   $("#basket_no_set").val(basket_no_list);
   
	document.frm.action="basketDeleteAllAction.action";
	document.frm.submit();
   
   
   //document.frm.total_sum.value = 0;
   //document.frm.totalOrder_sum.value = 0;   
   
      /*
   $("#basket_no_set").val(checkbox_list);

   alert($("#basket_no_set").val());
   
    var array_set = $("#basket_no_set").val();
    
	var array = array_set.split("||");
   
	for(var j=0;j<=array.length;j++)
	{
		//alert(j);
		alert(array[j]);
		//$("#basket_list_")
		$("#basket_list_"+j).remove();
	}
	*/
}

function alldel()
{

}

var basket_price = "";

function itemSum(index)
{
	/*

  */

	
  //for(i=0;i<$("input[name=basket_price]").length;i++)
  //{
	 //alert($("input[name=chkbox_"+index+"]").prop("checked"));
  	if($("input[id=chkbox_"+index+"]").prop("checked") == true) basket_price = Number(basket_price) + Number($("input[name=basket_price_"+index+"]").val());
  	else basket_price = Number(basket_price) - Number($("input[name=basket_price_"+index+"]").val());
  //}  
  document.frm.total_sum.value = basket_price;
  document.frm.totalOrder_sum.value = basket_price;
  
}



</script>

















