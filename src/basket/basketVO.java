package basket;

import java.util.Date;

public class basketVO{
	
	private int basket_no;
	private int member_no;
	private String goods_size;
	private String goods_color;
	private int basket_price;
	private int bgoods_amount;
	private Date basket_date;
	private String goods_name;
	private String goods_image;
	
	public int getBasket_no(){
		return basket_no;
	}

	public void setBasket_no(int basket_no){
		this.basket_no = basket_no;
	}

	public int getMember_no(){
		return member_no;
	}

	public void setMember_no(int member_no){
		this.member_no = member_no;
	}

	public String getGoods_size(){
		return goods_size;
	}

	public void setGoods_size(String goods_size){
		this.goods_size = goods_size;
	}

	public String getGoods_color(){
		return goods_color;
	}

	public void setGoods_color(String goods_color){
		this.goods_color = goods_color;
	}

	public int getBasket_price(){
		return basket_price;
	}

	public void setBasket_price(int basket_price){
		this.basket_price = basket_price;
	}

	public int getBgoods_amount(){
		return bgoods_amount;
	}

	public void setBgoods_amount(int bgoods_amount){
		this.bgoods_amount = bgoods_amount;
	}

	public Date getBasket_date(){
		return basket_date;
	}

	public void setBasket_date(Date basket_date){
		this.basket_date = basket_date;
	}

	public String getGoods_name(){
		return goods_name;
	}

	public void setGoods_name(String goods_name){
		this.goods_name = goods_name;
	}

	public String getGoods_image(){
		return goods_image;
	}

	public void setGoods_image(String image){
		this.goods_image = goods_image;
	}
	
}