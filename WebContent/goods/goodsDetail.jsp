<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet" href="/semiP/assets/css/board.css" type="text/css">
<script type="text/javascript">
	<!--
	function imagePopup(opage, x, y){
		farwindow = window.open('', 'Images', 'width=' + x + ', height=' + y + ', toolbar=0, scrollbars=0, resizable=no');
		if (farwindow != null) {
			if (farwindow.opener == null) {
				farwindow.opener = self;
			}
			farwindow.location.href = opage;
		}
	}
	//--> 
</script>
<script>
	function check(){
		var f = document.orderWriteAction;
				
		if(f.goods_amount.value == 0){
			alert("수량을 입력해 주세요");
			return false;
		}
		if(f.goods_color.value == ""){
			alert("색상을 선택해 주세요");
			return false;
		}
		if(f.goods_size.value == ""){
			alert("사이즈를 선택해 주세요.");
			return false;
		}
		return true;
	}
</script>
<div id="content-container">
	<table width="100%" border="0" style="margin:auto; max-width:1000px;">
		<tr>			
			<td height="10">				
				
			</td>			
		</tr>

		<tr>
			<td height="1" bgcolor="#777777"></td>
		</tr> 

		<tr>
			
			<td>
				<table width="100%" border="0">
					<tr>
						<td width="50%" style="vertical-align:top;">
							<table width="100%">
								<tr>
									<td><img src="http://cooz.co/semiP/IMG/<s:property value="resultGoods.goods_category" />/<s:property value="goods_no" />/1.jpg" style="width:100%;"/></td>
								</tr>
								<tr>
									<td align="center">
										<img id="detail"
										src="/semiP/assets/images/icons/enlarge.png" width="50" height="50" 
										onmouseover="this.src='/semiP/assets/images/icons/enlarge_on.png'" 
										onmouseout="this.src='/semiP/assets/images/icons/enlarge.png'"
										onclick="imagePopup('http://cooz.co/semiP/IMG/<s:property value="resultGoods.goods_category" />/<s:property value="goods_no" />/1.jpg')">
									</td>
								</tr>
							</table>
						</td>
						<td width="15"></td> <!-- 사진과 옵션 사이 여백는 부분 -->
						<td style="vertical-align:top;">
							<form name="orderWriteAction" action="orderWriteForm.action" method="post" onSubmit="return check();">
							<input type="hidden" name="order_goods_no" value="${goods_no }"/>
							<input type="hidden" name="goods_name" value="<s:property value='resultGoods.goods_name' />"/>
							<input type="hidden" name="goods_category" value="<s:property value='resultGoods.goods_category' />"/>
							<input type="hidden" name="goods_price" value="<s:property value='resultGoods.goods_price' />"/>
							<table width="100%" border="0">
								<tr>
									<td colspan="2" style="font-size:1.5em;">상품이름 : <s:property value="resultGoods.goods_name" /><br><br></td>
								</tr>
								<tr>
									<td width="100" height="40">&nbsp;가격</td>
									<td style="font-size:1.2em;"><strong><s:property value="resultGoods.goods_price" /></strong></td>
								</tr>
								<tr>
									<td width="100" height="40">&nbsp;수량</td>
									<td>
										<input type="button" id="m_btn" value="-" style="background-color:#cccccc;">
										<input type="text" name="goods_amount" id="count" value="0" style="text-align:center; width:50px;" readonly="readonly">
										<input type="button" id="p_btn" value="+" style="background-color:#cccccc;">
									</td>
								</tr>
								<tr>
								
									<td width="100" height="40">&nbsp;색상</td>
									
									<td>
										<select name="goods_color">

											<option value="" selected="selected">선택해 주세요</option>										
											<c:forTokens var="color" items="${resultGoods.goods_color}" delims=",">
												<option value=${fn:trim(color)}>
													${fn:trim(color)}
												</option>
											</c:forTokens>
										</select>
									</td>
								</tr>
								<tr>
									<td width="100" height="40">&nbsp;사이즈</td>
					
									<td>
										<select name="goods_size">
											<option value="" selected="selected">선택해 주세요</option>										
											<c:forTokens var="size" items="${resultGoods.goods_size}" delims=",">
												<option value=${fn:trim(size)}>
													${fn:trim(size)}
												</option>
											</c:forTokens>
										</select>
									</td>
								</tr>
								<tr>
									<td width="100" height="40">&nbsp;배송비</td>
									<td>무료</td>
								</tr>
								<tr>
									<td width="100" height="40">&nbsp;배송 가능 지역</td>
									<td>전국</td>
								</tr>
								<tr height="30">
								</tr>
								<tr>
									<td align="center" style="padding:5px;" >
										<input type="button" class="btn-custom" value="장바구니 담기" style="width:150px;" 
											onClick="javascript:
														var selectedSize = document.getElementsByName('goods_size')[0].value;
														var selectedColor = document.getElementsByName('goods_color')[0].value;
														var selectedAmount = document.getElementById('count').value;
														
														console.log(selectedSize);
														console.log(selectedColor);
														console.log(selectedAmount);
														
														location.href='basketAddAction.action?goods_size='+selectedSize+'&goods_color='+selectedColor+'&goods_price=<s:property value='resultGoods.goods_price' />&bgoods_amount='+selectedAmount+'&goods_name=<s:property value='resultGoods.goods_name' />&goods_no=${goods_no }&category=<s:property value='resultGoods.goods_category' />' ">
									</td>
									<td align="left" style="padding:5px;">
										<input type="submit" class="btn-custom1" value="구매하기" style="width:150px;"/>

									</td>
								</tr>
							</table>
							</form>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="1" bgcolor="#777777"></td>
		</tr>
		<tr>
			<td>
				<table width="100%" border="0"> <!-- 1번째 박스 : 상품상세정보 -->
					<tr>
						<td class="content-cellstyle-selected">	<a href="#detail">상품상세정보</a>	</td>
						<td class="content-cellstyle-noSelect">	<a href="#review">고객상품평</a>	</td>
						<td class="content-cellstyle-noSelect">	<a href="#qna">상품 QnA</a>	</td>
						<td class="content-cellstyle-noSelect">	<a href="#notice">NOTICE</a>	</td>
					</tr>
					
					<tr>
						<td align="center" colspan="4" style="border:1px solid #000000;">
							<c:forTokens var="detailIMG" items="${resultGoods.goods_image}" delims=",">
								<c:if test="${detailIMG >= 3}">
									<img width="100%" src="http://cooz.co/semiP/IMG/<s:property value="resultGoods.goods_category" />/<s:property value="goods_no" />/${fn:trim(detailIMG)}.jpg"><br>
								</c:if>
							</c:forTokens>
							
						</td>
					</tr>
				</table>
				<div id="review"></div>
				<br><br>
				<table width="100%" border="0"> <!-- 2번째 박스 : 고객상품평 -->
					<tr>
						<td class="content-cellstyle-noSelect">	<a href="#detail">상품상세정보</a>	</td>  
						<td class="content-cellstyle-selected">	<a href="#review">고객상품평</a>	</td>      
						<td class="content-cellstyle-noSelect">	<a href="#qna">상품 QnA</a>	</td>      
						<td class="content-cellstyle-noSelect">	<a href="#notice">NOTICE</a>	</td>  
					</tr>                                                                              
					
					<tr>
						<td align="center" colspan="4" style="border:1px solid #000000;">
							<p align="center">
								본 상품을 구매하신 회원님들의 후기입니다
							</p>
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
								<s:iterator value="listCmt" status="stat">
									<tr>
										<td class="board-titlebar" width="8%"><s:property value="goods_cmt_no"/></td>
										<td class="board-titlebar" width="67%"><s:property value="goods_cmt_subject"/></td>
										<td class="board-titlebar" width="12%"><s:property value="comment_author"/></td>
										<td class="board-titlebar" width="15%"><s:property value="goods_cmt_date"/></td>
									</tr>
									<tr><td colspan="4" bgcolor="#f2f2f2" height="1"></td></tr>
								</s:iterator>
<!-- 게시물 하나씩 iterator 끝 -->																
								<tr><td colspan="4" bgcolor="#cccccc" height="1"></td></tr>
								<tr>
									<td colspan="4" align="center">
										여기에 테이블 페이징 내용을 넣어주세요
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<div id="qna"></div>
				<br><br>
				<table width="100%" border="0"> <!-- 3번째 박스 : 상품 QnA -->
					<tr>
						<td class="content-cellstyle-noSelect">	<a href="#detail">상품상세정보</a>	</td>  
						<td class="content-cellstyle-noSelect">	<a href="#review">고객상품평</a>	</td>      
						<td class="content-cellstyle-selected">	<a href="#qna">상품 QnA</a>	</td>      
						<td class="content-cellstyle-noSelect">	<a href="#notice">NOTICE</a>	</td>  
					</tr>                                                                              
					
					<tr>
						<td align="center" colspan="4" style="border:1px solid #000000;">
							<p align="center">
								<h2>Q&A</h2>
								상품에 대한 문의사항을 남겨주시면, 빠른 답변으로 궁금한 사항을 해결해 드리겠습니다<br>
								<input type="button" value="질문작성하기" onClick="window.open('goodQaWriteForm.action?goods_no=${goods_no}', '', 'width=600, height=430'); return false;">
							</p>
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
								<s:iterator value="listCmt" status="stat">
									<tr>
										<td class="board-titlebar" width="8%"><s:property value="goods_cmt_no"/></td>
										<td class="board-titlebar" width="67%"><s:property value="goods_cmt_subject"/></td>
										<td class="board-titlebar" width="12%"><s:property value="comment_author"/></td>
										<td class="board-titlebar" width="15%"><s:property value="goods_cmt_date"/></td>
									</tr>
									<tr><td colspan="4" bgcolor="#f2f2f2" height="1"></td></tr>
								</s:iterator>
<!-- 게시물 하나씩 iterator 끝 -->			


							</table>
						</td>
					</tr>
				</table>
				<div id="notice"></div>
				<br><br>
				<table width="100%" border="0"> <!-- 4번째 박스 : NOTICE -->
					<tr>
						<td class="content-cellstyle-noSelect">	<a href="#detail">상품상세정보</a>	</td>  
						<td class="content-cellstyle-noSelect">	<a href="#review">고객상품평</a>	</td>      
						<td class="content-cellstyle-noSelect">	<a href="#qna">상품 QnA</a>	</td>      
						<td class="content-cellstyle-selected">	<a href="#notice">NOTICE</a>	</td>  
					</tr>                                                                              
					
					<tr>
						<td align="center" colspan="4" style="border:1px solid #000000;">
							<table width="100%" height="300" border="0">
								<tr>
									<td rowspan="3" class="content-notice-cellstyle">
<h3>배송안내</h3>
<p>배송방법 :<br>
	<li>택배발송 CJ대한통운택배</li>
<p>배송비용 :<br>
	<li>5만원이상 결제시 무료배송</li>
	<li>5만원 미만 결제시 2,500원 추가</li>
<p>배송기간 :
	<li>결제확인 후 평균 2~5일 소요</li>
	<li>택배사 사정상 배송지연 될 수 있음 (주말/공휴일 제외)</li>
									</td>
									<td width="1" height="50"></td>
									<td rowspan="3" class="content-notice-cellstyle">
<h3>교환/반품안내</h3>
<p>교환/취소/반품/환불의 경우 :</p>

<p>상품 수령 후 7일이내에 고객센터에 연락 or 문의게시판에 글을 남겨주세요</p>
<p>단, 상품의 내용이 표시, 광고내용과 다를경우	수령일로부터 3개월 이내 가능</p>

									</td>
									<td width="1" height="50"></td>
									<td rowspan="3" class="content-notice-cellstyle">
<h3>교환/반품 배송안내</h3>
<p>상품의 불량/하자 및 오배송일 경우 :<br>
회수비용 무료 (단, 대한통운택배 이용시만!)
<p>고객님의 단순변심, 생상/사이즈 불만인 경우 :<br>
택배비 고객님부담
<p>배송비 선결제 하셨을 경우 :<br>
환불진행 시 배송비도 같이 환불되어 5,000원 동봉
<p>최종 구매금액이 5만원 미만일 경우 :<br>
최초 배송비는 고객님부담이므로 5,000원 동봉
<p>타택배 이용시 :<br>
선불로 보내주시고 2,500원 동봉<br>
반드시 구매금액대별 이벤트 사은품도
함께 보내주셔야 합니다
									</td>
									<td width="1" height="50"></td>
									<td rowspan="3" class="content-notice-cellstyle">
<h3>교환/반품이 불가한 경우</h3>
<p>고객님의 단숨변심으로 인한 교환/반품 신청이 상품 수령일로부터 7일이 경과한 경우</li>
<p>고객님의 사용 또는 일부 소비로 인해 상품의 가치가 훼손된 경우</li>
<p>세탁과 수선으로 인한 외형적 변화가 있을 경우</li>
<p>고객님의 부주의 및 고의로 인한 상품 파손 및 포장용기 파손의 경우 (단, 내용확인을 위해 포장등을 훼손한 경우는 제외)</li>
<p>구매한 상품의 구성품이 누락된 경우 (의류 부착 악세사리/화장품세트/사은품 등)</li>

									</td>
								</tr>
								<tr>									
									<td bgcolor="#cccccc"></td>
									<td bgcolor="#cccccc"></td>
									<td bgcolor="#cccccc"></td>
								</tr>
								<tr>
									<td height="50"></td>
									<td height="50"></td>
									<td height="50"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="1" bgcolor="#777777"></td>
		</tr>
		<tr>
			<td></td>
		</tr>
	</table>
</div>
<script type="text/javascript" src="/semiP/assets/js/goodsCount.js"></script>