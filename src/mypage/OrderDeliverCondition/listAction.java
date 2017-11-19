package mypage.OrderDeliverCondition;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import mypage.goodsBean;
import mypage.goodsOrderBean;
import mypage.inquiryBean;

public class listAction extends ActionSupport {
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private goodsOrderBean paramClass1;
	private goodsOrderBean resultClass1;

	private goodsBean paramClass2;
	private goodsBean resultClass2;

	private goodsOrderBean paramClass3;
	private goodsOrderBean resultClass3;
	
	private goodsOrderBean paramClass4;
	private goodsOrderBean resultClass4;
	
	private goodsOrderBean paramClass5;
	private goodsOrderBean resultClass5;
	
	private List<mypage.goodsOrderBean> list = new ArrayList<mypage.goodsOrderBean>();
	
	// goodsOrder
		private int order_no;
		private int order_goods_no;
		private int goods_no;
		private int member_no;
		private int order_goods_amount;
		private String order_goods_size;
		private String order_goods_color;
		private String order_receive_name;
		private String order_receive_zipcode;
		private String order_receive_addr1;
		private String order_receive_addr2;
		private String order_receive_phone;
		private String order_memo;
		private int order_total_price;
		private Date order_date;
		private Date order_trade_date;
		private int order_status;
		private int order_list_amount;
		private String order_goods_image;
		private int order_pay_type;
		private String order_pay_name;
		private int order_total_pay;
		private String invoice_no;
		
		// Goods
		//private int goods_no;
		private String goods_name;
		private int goods_category;
		private String goods_size;
		private String goods_color;
		private String goods_content;
		private int goods_amount;
		private int goods_price;
		private String goods_image;
		private Date goods_regdate;
		
		private String searchKeyword1;
		private String searchKeyword2;
		
		//생성자
		public listAction() throws IOException{
			reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져옴
			sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper객체 생성
			reader.close();
		}
		
		//리스트 출력
		public String execute() throws Exception{
			//모든 글을 가져와 list에 넣는다.
			paramClass1 = new goodsOrderBean(); // 파라미터를 저장할 객체
			paramClass2 = new goodsBean();
			
			resultClass1 = new goodsOrderBean(); // 쿼리 결과 값을 저장할 객체
			resultClass2 = new goodsBean();
			/*ActionContext context = ActionContext.getContext();*/
			
			paramClass1.setOrder_status(getOrder_status());
			paramClass1.setOrder_no(getOrder_no());
			paramClass1.setOrder_goods_no(getOrder_goods_no());
			paramClass1.setOrder_goods_amount(getOrder_goods_amount());
			paramClass1.setOrder_goods_size(getOrder_goods_size());
			paramClass1.setOrder_goods_color(getOrder_goods_color());
			paramClass1.setOrder_date(getOrder_date());
			paramClass1.setOrder_list_amount(getOrder_list_amount());
			paramClass1.setOrder_goods_image(getOrder_goods_image());
			paramClass1.setOrder_total_pay(getOrder_total_pay());
			paramClass2.setGoods_price(getGoods_price());
			
			sqlMapper.update("updateMember",paramClass1);
			sqlMapper.update("updatemember",paramClass2);
			
			resultClass1 = (goodsOrderBean)sqlMapper.queryForObject("selectOneGoods_OrderDeliverCondition",getOrder_no());
			resultClass2 = (goodsBean)sqlMapper.queryForObject("selectOneGoodsOrder_OrderDeliverCondition",getGoods_no());
			
			return SUCCESS;
		}
		
		// 기간조회
		public String search() throws Exception{
			paramClass3 = new goodsOrderBean();
			paramClass4 = new goodsOrderBean();
			
			resultClass3 = new goodsOrderBean();
			resultClass4 = new goodsOrderBean();
			
			paramClass3 = (goodsOrderBean) sqlMapper.queryForList(getSearchKeyword1());
			paramClass4 = (goodsOrderBean) sqlMapper.queryForList(getSearchKeyword2());
			
			return SUCCESS;
		}

		// 구매후기로 이동
		public String reviewForm() throws Exception{
			return SUCCESS;
		}		
		
		public static Reader getReader() {
			return reader;
		}

		public static void setReader(Reader reader) {
			listAction.reader = reader;
		}

		public static SqlMapClient getSqlMapper() {
			return sqlMapper;
		}

		public static void setSqlMapper(SqlMapClient sqlMapper) {
			listAction.sqlMapper = sqlMapper;
		}

		public goodsOrderBean getParamClass1() {
			return paramClass1;
		}

		public void setParamClass1(goodsOrderBean paramClass1) {
			this.paramClass1 = paramClass1;
		}

		public goodsOrderBean getResultClass1() {
			return resultClass1;
		}

		public void setResultClass1(goodsOrderBean resultClass1) {
			this.resultClass1 = resultClass1;
		}

		public goodsBean getParamClass2() {
			return paramClass2;
		}

		public void setParamClass2(goodsBean paramClass2) {
			this.paramClass2 = paramClass2;
		}

		public goodsBean getResultClass2() {
			return resultClass2;
		}

		public void setResultClass2(goodsBean resultClass2) {
			this.resultClass2 = resultClass2;
		}

		public goodsOrderBean getParamClass3() {
			return paramClass3;
		}

		public void setParamClass3(goodsOrderBean paramClass3) {
			this.paramClass3 = paramClass3;
		}

		public goodsOrderBean getResultClass3() {
			return resultClass3;
		}

		public void setResultClass3(goodsOrderBean resultClass3) {
			this.resultClass3 = resultClass3;
		}

		public goodsOrderBean getParamClass4() {
			return paramClass4;
		}

		public void setParamClass4(goodsOrderBean paramClass4) {
			this.paramClass4 = paramClass4;
		}

		public goodsOrderBean getResultClass4() {
			return resultClass4;
		}

		public void setResultClass4(goodsOrderBean resultClass4) {
			this.resultClass4 = resultClass4;
		}

		public int getOrder_no() {
			return order_no;
		}

		public void setOrder_no(int order_no) {
			this.order_no = order_no;
		}

		public int getOrder_goods_no() {
			return order_goods_no;
		}

		public void setOrder_goods_no(int order_goods_no) {
			this.order_goods_no = order_goods_no;
		}

		public int getGoods_no() {
			return goods_no;
		}

		public void setGoods_no(int goods_no) {
			this.goods_no = goods_no;
		}

		public int getMember_no() {
			return member_no;
		}

		public void setMember_no(int member_no) {
			this.member_no = member_no;
		}

		public int getOrder_goods_amount() {
			return order_goods_amount;
		}

		public void setOrder_goods_amount(int order_goods_amount) {
			this.order_goods_amount = order_goods_amount;
		}

		public String getOrder_goods_size() {
			return order_goods_size;
		}

		public void setOrder_goods_size(String order_goods_size) {
			this.order_goods_size = order_goods_size;
		}

		public String getOrder_goods_color() {
			return order_goods_color;
		}

		public void setOrder_goods_color(String order_goods_color) {
			this.order_goods_color = order_goods_color;
		}

		public String getOrder_receive_name() {
			return order_receive_name;
		}

		public void setOrder_receive_name(String order_receive_name) {
			this.order_receive_name = order_receive_name;
		}

		public String getOrder_receive_zipcode() {
			return order_receive_zipcode;
		}

		public void setOrder_receive_zipcode(String order_receive_zipcode) {
			this.order_receive_zipcode = order_receive_zipcode;
		}

		public String getOrder_receive_addr1() {
			return order_receive_addr1;
		}

		public void setOrder_receive_addr1(String order_receive_addr1) {
			this.order_receive_addr1 = order_receive_addr1;
		}

		public String getOrder_receive_addr2() {
			return order_receive_addr2;
		}

		public void setOrder_receive_addr2(String order_receive_addr2) {
			this.order_receive_addr2 = order_receive_addr2;
		}

		public String getOrder_receive_phone() {
			return order_receive_phone;
		}

		public void setOrder_receive_phone(String order_receive_phone) {
			this.order_receive_phone = order_receive_phone;
		}

		public String getOrder_memo() {
			return order_memo;
		}

		public void setOrder_memo(String order_memo) {
			this.order_memo = order_memo;
		}

		public int getOrder_total_price() {
			return order_total_price;
		}

		public void setOrder_total_price(int order_total_price) {
			this.order_total_price = order_total_price;
		}

		public Date getOrder_date() {
			return order_date;
		}

		public void setOrder_date(Date order_date) {
			this.order_date = order_date;
		}

		public Date getOrder_trade_date() {
			return order_trade_date;
		}

		public void setOrder_trade_date(Date order_trade_date) {
			this.order_trade_date = order_trade_date;
		}

		public int getOrder_status() {
			return order_status;
		}

		public void setOrder_status(int order_status) {
			this.order_status = order_status;
		}

		public int getOrder_list_amount() {
			return order_list_amount;
		}

		public void setOrder_list_amount(int order_list_amount) {
			this.order_list_amount = order_list_amount;
		}

		public String getOrder_goods_image() {
			return order_goods_image;
		}

		public void setOrder_goods_image(String order_goods_image) {
			this.order_goods_image = order_goods_image;
		}

		public int getOrder_pay_type() {
			return order_pay_type;
		}

		public void setOrder_pay_type(int order_pay_type) {
			this.order_pay_type = order_pay_type;
		}

		public String getOrder_pay_name() {
			return order_pay_name;
		}

		public void setOrder_pay_name(String order_pay_name) {
			this.order_pay_name = order_pay_name;
		}

		public int getOrder_total_pay() {
			return order_total_pay;
		}

		public void setOrder_total_pay(int order_total_pay) {
			this.order_total_pay = order_total_pay;
		}

		public String getInvoice_no() {
			return invoice_no;
		}

		public void setInvoice_no(String invoice_no) {
			this.invoice_no = invoice_no;
		}

		public String getGoods_name() {
			return goods_name;
		}

		public void setGoods_name(String goods_name) {
			this.goods_name = goods_name;
		}

		public int getGoods_category() {
			return goods_category;
		}

		public void setGoods_category(int goods_category) {
			this.goods_category = goods_category;
		}

		public String getGoods_size() {
			return goods_size;
		}

		public void setGoods_size(String goods_size) {
			this.goods_size = goods_size;
		}

		public String getGoods_color() {
			return goods_color;
		}

		public void setGoods_color(String goods_color) {
			this.goods_color = goods_color;
		}

		public String getGoods_content() {
			return goods_content;
		}

		public void setGoods_content(String goods_content) {
			this.goods_content = goods_content;
		}

		public int getGoods_amount() {
			return goods_amount;
		}

		public void setGoods_amount(int goods_amount) {
			this.goods_amount = goods_amount;
		}

		public int getGoods_price() {
			return goods_price;
		}

		public void setGoods_price(int goods_price) {
			this.goods_price = goods_price;
		}

		public String getGoods_image() {
			return goods_image;
		}

		public void setGoods_image(String goods_image) {
			this.goods_image = goods_image;
		}

		public Date getGoods_regdate() {
			return goods_regdate;
		}

		public void setGoods_regdate(Date goods_regdate) {
			this.goods_regdate = goods_regdate;
		}

		public String getSearchKeyword1() {
			return searchKeyword1;
		}

		public void setSearchKeyword1(String searchKeyword1) {
			this.searchKeyword1 = searchKeyword1;
		}

		public String getSearchKeyword2() {
			return searchKeyword2;
		}

		public void setSearchKeyword2(String searchKeyword2) {
			this.searchKeyword2 = searchKeyword2;
		}
		
		
}
