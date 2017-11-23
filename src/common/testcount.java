package common;

import com.opensymphony.xwork2.ActionSupport;

import goods.goodsVO;
import common.hitVO;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.io.IOException;

import org.apache.struts2.interceptor.SessionAware;



public class testcount extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private List<hitVO> listHit = new ArrayList<hitVO>();	
	private LinkedHashMap<String, List<goodsVO>> categoryMap = new LinkedHashMap<String, List<goodsVO>>();
	
	private Map session;
	
	private int order_goods_no;
	private String goods_name;
	private String goods_size;
	private String goods_color;
	private int goods_price;
	private int goods_category;
	private int goods_amount;
	
	
	public testcount() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); 
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); 
		reader.close();
	}
	
	public String execute() throws Exception {
		// hit 테이블 전부를 가져와서 List 로 만든다. hit 리스트는 7줄로 정해져 있다.
				
		return SUCCESS;
	}

	public List<hitVO> getListHit() {
		return listHit;
	}

	public void setListHit(List<hitVO> listHit) {
		this.listHit = listHit;
	}

	public LinkedHashMap<String, List<goodsVO>> getCategoryMap() {
		return categoryMap;
	}

	public void setCategoryMap(LinkedHashMap<String, List<goodsVO>> categoryMap) {
		this.categoryMap = categoryMap;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public int getOrder_goods_no() {
		return order_goods_no;
	}

	public void setOrder_goods_no(int order_goods_no) {
		this.order_goods_no = order_goods_no;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
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

	public int getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
	}

	public int getBgoods_amount() {
		return goods_amount;
	}

	public void setBgoods_amount(int bgoods_amount) {
		this.goods_amount = bgoods_amount;
	}

	public int getCategory() {
		return goods_category;
	}

	public void setCategory(int category) {
		this.goods_category = category;
	}




}
