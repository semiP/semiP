package goods;

import java.util.Date;

public class goodsVO {
	
	private int goods_no;                      //상품 넘버
	private String goods_name;                 //상품명
	private String goods_category;			   //카테고리
	private String goods_size;				   //사이즈
	private String goods_color;				   //컬러
	private String goods_content;			   //컨텐츠
	private int goods_amount;				   //수량
	private int goods_price;				   //가격
	private String goods_image_file;	       //이미지명
	private Date goods_date;				   //등록날짜
	
	public int getGoods_no() { return goods_no; }
	public void setGoods_no (int goods_no) { this.goods_no = goods_no; }
	
	public String getGoods_name() { return goods_name; }
	public void setGoods_name(String goods_name) { this.goods_name = goods_name; }
	
	public String getGoods_category() { return goods_category; }
	public void setGoods_category(String goods_category) { this.goods_category = goods_category; }
	
	public String getGoods_size() { return goods_size; }
	public void setGoods_size(String goods_size) { this.goods_size = goods_size; }
	
	public String getGoods_color() { return goods_color; }
	public void setGoods_color(String goods_color) { this.goods_color = goods_color; }
	
	public String getGoods_content() { return goods_content; }
	public void setGoods_content(String goods_content) { this.goods_content = goods_content; }
	
	public int getGoods_amount() { return goods_amount; }
	public void setGoods_amount(int goods_amount) { this.goods_amount = goods_amount; }
	
	public int getGoods_price() { return goods_price; }
	public void setGoods_price(int goods_price) { this.goods_price = goods_price; }
	
	public String getGoods_image_file() { return goods_image_file; }
	public void setGoods_image_file(String goods_image_file) { this.goods_image_file = goods_image_file; }
	
	public Date getGoods_date() { return goods_date; }
	public void setGoods_date(Date goods_date) { this.goods_date = goods_date; }
	
}