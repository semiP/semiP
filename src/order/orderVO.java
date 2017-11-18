package order;

import java.util.Date;

import goods.goodsVO;

public class orderVO {
	
	private int order_no;
	private int order_goods_no;
	private int order_member_no; //
	private int order_goods_amount;
	private String order_goods_size;
	private String order_goods_color;
	private String order_zipcode;
	private String order_receive_name;
	private String order_receive_addr1;
	private String order_receive_addr2;
	private String order_receive_phone;
	private String order_memo;
	private int order_sum_money;			// 이건 무슨 용도??? SQL 에도 안적혀있는데...-동민
	private Date order_date;
	private Date order_trade_date;
	private int order_status;
	private int order_list_amount;
	private int order_pay_type;
	private String order_pay_name;
	private int order_total_pay;
	private int order_invoice_no;		// 171118 디비/SQL 에는 있는데 VO 에 없어서 추가-동민
	
	goodsVO goods_vo = new goodsVO();        //goods테이블의 클래스 객체
	//memeberVO member_vo = new memberVO(); 
	
	public int getOrder_no() { return order_no; }  //get 매소드 => 컬럼값을 리턴
	public void setOrder_no(int order_no) { this.order_no = order_no; }  //set 매소드 => DB컬럼의 값을 java상의 값으로 대입
	
	public int getOrder_goods_no() { return order_goods_no; }
	public void setOrder_goods_no(int order_goods_no) { this.order_goods_no = order_goods_no; }
	
	public int getOrder_member_no() { return order_member_no; }
	public void setOrder_member_no(int order_member_no) { this.order_member_no = order_member_no; }
	
	public int getOrder_goods_amount() { return order_goods_amount; }
	public void setOrder_goods_amount(int order_goods_amount) { this.order_goods_amount = order_goods_amount; }
	
	public String getOrder_goods_size() { return order_goods_size; }
	public void setOrder_goods_size(String order_goods_size) { this.order_goods_size = order_goods_size; }
	
	public String getOrder_goods_color() { return order_goods_color; }
	public void setOrder_goods_color(String order_goods_color) { this.order_goods_color = order_goods_color; }
	
	public String getOrder_zipcode() { return order_zipcode; }
	public void setOrder_zipcode(String order_zipcode) { this.order_zipcode = order_zipcode; }
	
	public String getOrder_receive_name() { return order_receive_name; }
	public void setOrder_receive_name(String order_receive_name) { this.order_receive_name = order_receive_name; }
	
	public String getOrder_receive_addr1() { return order_receive_addr1; }
	public void setOrder_receive_addr1(String order_receive_addr1) { this.order_receive_addr1 = order_receive_addr1; }
	
	public String getOrder_receive_addr2() { return order_receive_addr2; }
	public void setOrder_receive_addr2(String order_receive_addr2) { this.order_receive_addr2 = order_receive_addr2; }
	
	public String getOrder_receive_phone() { return order_receive_phone; }
	public void setOrder_receive_phone(String order_receive_phone) { this.order_receive_phone = order_receive_phone; }
	
	public String getOrder_memo() { return order_memo; }
	public void setOrder_memo(String order_memo) { this.order_memo = order_memo; }
	
	public int getOrder_sum_money() { return order_sum_money; }
	public void setOrder_sum_money(int order_sum_money) { this.order_sum_money = order_sum_money; }
	
	public Date getOrder_date() { return order_date; }
	public void setOrder_date(Date order_date) { this.order_date= order_date; }
	
	public Date getOrder_trade_date() { return order_trade_date; }
	public void setOrder_trade_date(Date order_date) { this.order_date= order_date; }
	
	public int getOrder_status() { return order_status; }
	public void setOrder_status(int order_status) { this.order_status = order_status; }
	
	public int getOrder_list_amount() { return order_list_amount; }
	public void setOrder_list_amount(int order_list_amount) { this.order_list_amount = order_list_amount; }
	
	public int getOrder_pay_type() { return order_pay_type; }
	public void setOrder_pay_type(int order_pay_type) { this.order_pay_type = order_pay_type; }
	
	public String getOrder_pay_name() { return order_pay_name; }
	public void setOrder_pay_name(String order_pay_name) { this.order_pay_name = order_pay_name; }
	
	public int getOrder_total_pay() { return order_total_pay; }
	public void setOrder_total_pay(int order_total_pay) { this.order_total_pay = order_total_pay; }

	public int getOrder_invoice_no() {	return order_invoice_no;	}
	public void setOrder_invoice_no(int order_invoice_no) {	this.order_invoice_no = order_invoice_no;	}
}
