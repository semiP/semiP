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



public class MainAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private List<hitVO> listHit = new ArrayList<hitVO>();	
	private LinkedHashMap<String, List<goodsVO>> categoryMap = new LinkedHashMap<String, List<goodsVO>>();
	
	private Map session;
	
	
	public MainAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); 
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); 
		reader.close();
	}
	
	public String execute() throws Exception {
		// hit 테이블 전부를 가져와서 List 로 만든다. hit 리스트는 7줄로 정해져 있다.
		if(session.get("session_member_id") == null){
			return LOGIN;
		}
		
		listHit = sqlMapper.queryForList("mainSearch.select-hit-list");
				
		for(int i=0; i<listHit.size(); i++) {				// 매 히트 카테고리마다 반복한다.
			List<goodsVO> listGoods = new ArrayList<goodsVO>();
			hitVO hitvo = listHit.get(i);												// List 안의 hitVO 를 하나 꺼내온다
			StringTokenizer st = new StringTokenizer(hitvo.getGoods_content(),",");		// 꺼낸 상품content 를 콤마를 기준으로 자른다
			
			while(st.hasMoreTokens()) {						// 해당 카테고리의 각 히트상품마다(4개) 반복한다
				listGoods.add( (goodsVO) sqlMapper.queryForObject("mainSearch.select-single-item",Integer.parseInt(st.nextToken())) );
			}
			categoryMap.put(hitvo.getName(),listGoods);
		}
		
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


}
