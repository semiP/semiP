package basket;

import java.io.Reader;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionContext;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class basketAddAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private basketVO basketparamClass;
	/*private basketVO basketresultClass;*/
	
	
	private int basket_price;
	private int goods_price;
	private int bgoods_amount;
	private String goods_size;
	private String goods_color;
	
	private Date basket_date;
	private int goods_no;
	private int member_no;
	
	private Map session;
	
	public basketAddAction() throws Exception{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception{
		ActionContext context = ActionContext.getContext();
		session = context.getSession();
		
		if(session.get("session_member_id") == null){
			return LOGIN;
		}else{
			basket_price = goods_price * bgoods_amount;
			member_no = (int) session.get("session_member_no");
		
			basketparamClass = new basketVO();
			/*basketresultClass= new basketVO();*/
					
			/*basketparamClass.setGoods_image(getGoods_image());// vo에는 있지만, table에 없는 정보
	*/		basketparamClass.setBasket_price(getBasket_price());
			/*basketparamClass.setGoods_price(getGoods_price());// vo에는 있지만, table에 없는 정보
	*/		basketparamClass.setBgoods_amount(getBgoods_amount());
			basketparamClass.setGoods_size(getGoods_size());
			basketparamClass.setGoods_color(getGoods_color());
			basketparamClass.setBasket_date(getBasket_date());
			basketparamClass.setGoods_no(getGoods_no());
			//basketparamClass.setGoods_no(getGoods_no());
	
			basketparamClass.setMember_no(member_no);
	
			sqlMapper.insert("basketSet.insertBasket", basketparamClass);
	
			return SUCCESS;
		}	
		
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

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public int getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
	}

	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	
		
}





































