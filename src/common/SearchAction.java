package common;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import goods.goodsVO;

import java.io.Reader;
import java.util.List;
import java.util.ArrayList;

public class SearchAction extends ActionSupport {
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private static final long serialVersionUID = 1L;
	private String keyword;
	private int category_no;
	private goodsVO paramClass;
	private List<goodsVO> goodsList = new ArrayList<goodsVO>();
	private List<countVO> countList = new ArrayList<countVO>();
	
	
	// 생성자
		public SearchAction() throws Exception{
			reader = Resources.getResourceAsReader("sqlMapConfig.xml");
			sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		}
		
		public String execute() throws Exception{
			 goodsVO emptyGoods = new goodsVO();
			 emptyGoods.setGoods_amount(-10);
			
			if("".equals(keyword) || keyword == null) {
				goodsList = sqlMapper.queryForList("mainSearch.select-all-goods");
				countList = sqlMapper.queryForList("mainSearch.count-all-goods");
			}else {
				goodsList = sqlMapper.queryForList("mainSearch.select-search-goods",keyword);
				countList = sqlMapper.queryForList("mainSearch.count-search-goods",keyword);
			}
			
			if(goodsList.size() % 4 != 0) {
				for(int i=0; i<(goodsList.size() % 4); i++) {
					goodsList.add(emptyGoods);
				}
			}
			
			return SUCCESS;
		}

		
		
		
		
		
		public String getKeyword() {
			return keyword;
		}

		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}

		public int getCategory_no() {
			return category_no;
		}

		public void setCategory_no(int category_no) {
			this.category_no = category_no;
		}

		public goodsVO getParamClass() {
			return paramClass;
		}

		public void setParamClass(goodsVO paramClass) {
			this.paramClass = paramClass;
		}

		public List<goodsVO> getGoodsList() {
			return goodsList;
		}

		public void setGoodsList(List<goodsVO> goodsList) {
			this.goodsList = goodsList;
		}

		public List<countVO> getCountList() {
			return countList;
		}

		public void setCountList(List<countVO> countList) {
			this.countList = countList;
		}
	}
