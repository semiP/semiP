package basket;

import java.io.Reader;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class basketDeleteAction extends ActionSupport implements SessionAware {
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private basketVO basketparamClass;
	private basketVO basketresultClass;
	private int basket_no;
	private String member_id;
	//private int goods_no;
	private int currentPage;
	
	private Map session;
	
	public basketDeleteAction() throws Exception {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	/*public String deleteAll() throws SQLException{
		sqlMapper.delete("Basket.basketDeleteAll", member_id);
		return SUCCESS;
	}*/
	
	public String execute() throws Exception{
		basketparamClass = new basketVO();
		basketresultClass = new basketVO();
		
		basketresultClass = (basketVO)sqlMapper.queryForObject("basketSet.selectOne",getBasket_no());
		
		basketparamClass.setBasket_no(getBasket_no());
		
		basketparamClass.setBasket_no(basket_no);
		sqlMapper.delete("basketSet.deleteBasket", basketparamClass.getBasket_no());
		return SUCCESS;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		basketDeleteAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		basketDeleteAction.sqlMapper = sqlMapper;
	}

	public basketVO getBasketparamClass() {
		return basketparamClass;
	}

	public void setBasketparamClass(basketVO basketparamClass) {
		this.basketparamClass = basketparamClass;
	}

	public basketVO getBasketresultClass() {
		return basketresultClass;
	}

	public void setBasketresultClass(basketVO basketresultClass) {
		this.basketresultClass = basketresultClass;
	}

	public int getBasket_no() {
		return basket_no;
	}

	public void setBasket_no(int basket_no) {
		this.basket_no = basket_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}
	
	
	
	
}
