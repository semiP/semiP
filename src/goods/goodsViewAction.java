package goods;

import com.opensymphony.xwork2.ActionSupport;

import goods.goodsVO;
import goods.goodsCmtVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware; 

public class goodsViewAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private goodsVO resultGoods = new goodsVO();
	private List<goodsCmtVO> listCmt = new ArrayList<goodsCmtVO>();
		
	private int goods_no;
	private Map session;

	
	public goodsViewAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); 
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); 
		reader.close();
	}
	
	public String execute() throws Exception
	{

		resultGoods = (goodsVO) sqlMapper.queryForObject("goods.select-goods-one", goods_no);
		listCmt = sqlMapper.queryForList("goods.select-cmt-all", goods_no);
		return SUCCESS;
	}

	public goodsVO getResultGoods() {
		return resultGoods;
	}

	public void setResultGoods(goodsVO resultGoods) {
		this.resultGoods = resultGoods;
	}

	public List<goodsCmtVO> getListCmt() {
		return listCmt;
	}

	public void setListCmt(List<goodsCmtVO> listCmt) {
		this.listCmt = listCmt;
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
}
