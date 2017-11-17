package basket;

import java.io.Reader;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;


import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class basketAddAction extends ActionSupport {
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private basketVO basketparamClass;
	/*private basketVO basketresultClass;*/
	
	/*private String goods_name; // 없애고 goods_no
	private String goods_image; // 없애고 goods_no
*/	private int basket_price;
	/*private int goods_price; // 없애고 goods_no
*/	private int bgoods_amount;
	private String goods_size;
	private String goods_color;
	/*private String member_id;*/
	private Date basket_date;
	private int goods_no;
	
	public basketAddAction() throws Exception{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception{
		basketparamClass = new basketVO();
		/*basketresultClass= new basketVO();*/
		
		/*basketparamClass.setMember_id(getMember_id());*/
		/*basketparamClass.setGoods_name(getGoods_name()); // vo에는 있지만, table에 없는 정보
		basketparamClass.setGoods_image(getGoods_image());// vo에는 있지만, table에 없는 정보
*/		basketparamClass.setBasket_price(getBasket_price());
		/*basketparamClass.setGoods_price(getGoods_price());// vo에는 있지만, table에 없는 정보
*/		basketparamClass.setBgoods_amount(getBgoods_amount());
		basketparamClass.setGoods_size(getGoods_size());
		basketparamClass.setGoods_color(getGoods_color());
		basketparamClass.setBasket_date(getBasket_date());
		basketparamClass.setGoods_no(getGoods_no());
//		basketparamClass.setMember_no(세션에서 가져오기);
		sqlMapper.insert("insertBasket", basketparamClass);

		return SUCCESS;
		
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		basketAddAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		basketAddAction.sqlMapper = sqlMapper;
	}

	public basketVO getBasketparamClass() {
		return basketparamClass;
	}

	public void setBasketparamClass(basketVO basketparamClass) {
		this.basketparamClass = basketparamClass;
	}

	public int getBasket_price() {
		return basket_price;
	}

	public void setBasket_price(int basket_price) {
		this.basket_price = basket_price;
	}

	public int getBgoods_amount() {
		return bgoods_amount;
	}

	public void setBgoods_amount(int bgoods_amount) {
		this.bgoods_amount = bgoods_amount;
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

	public Date getBasket_date() {
		return basket_date;
	}

	public void setBasket_date(Date basket_date) {
		this.basket_date = basket_date;
	}

	public int getGoods_no() {
		return goods_no;
	}

	public void setGoods_no(int goods_no) {
		this.goods_no = goods_no;
	}


	
	
	
	
	
	
	
}





































