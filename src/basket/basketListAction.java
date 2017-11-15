package basket;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;


/*public class basketListAction extends ActionSupport {
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private basketVO basketparamClass;
	private basketVO basketresultClass;
	
	private List<basketVO> list = new ArrayList<basketVO>();
	
	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 10;
	private int blockPage = 5;
	private String pagingHtml;
	private pagingAction page;
	private Map session;
	private long basket_Price=0;
	
	//생성자
	public void baksetListAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	//게시판 List액션
	public String execute() throws Exception{
		list = sqlMapper.queryForList("basket.selectAll");
		totalCount = list.size();
		page = new pagingAction(currentPage,totalCount,blockCount,blockPage, pagingHtml);
		pagingHtml = page.getPagingHtml().toString();
		
		//현재 페이지에서 보여줄 마지막 글의번호 설정
		int lastCount = totalCount;
		
		//현재 페이지의 마지막 글의 번호가 전체의 마지막 글 번호보다 작으면
		//lastCount를 +1번호로 설정
		if(page.getEndCount() < totalCount)
			lastCount = page.getBlockCount() + 1;
		
		///전체 리스트에서 현재 페이지만큼의 리스트만 가져온다
		list = list(page.getStartCount(),lastCount);
		
		return SUCCESS;
		}
	private List<basketVO> list(int startCount, int lastCount) {
		// TODO Auto-generated method stub
		return null;
	}*/



public class basketListAction extends ActionSupport implements SessionAware {
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private basketVO basketparamClass;
	private basketVO basketresultClass;
	
	private List<basketVO> basketlist = new ArrayList<basketVO>();
	
	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 10;
	private int blockPage = 5;
	private String pagingHtml;
	private pagingAction page;
	private Map session;
	private long basket_Price=0;
	
	//생성자
	public void baksetListAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	//게시판 List액션
	public String execute() throws Exception{
	basketlist = sqlMapper.queryForList("selectAll");
	totalCount = basketlist.size();
	page = new pagingAction(currentPage, totalCount, blockCount, blockPage, pagingHtml);
	pagingHtml = page.getPagingHtml().toString();

	//현재 페이지에서 보여줄 마지막글의 번호 설정
	int lastCount = totalCount;
	//현재페이지의 마지막글의 번호가 전체의 마지막글 번호보다 작으면
	//lastCount를 +1번호로 설정
	if(page.getEndCount() < totalCount)
		lastCount = page.getEndCount() + 1;

	//전체 리스트에서 현재 페이지만큼의 리스트만 가져온다.
	basketlist = basketlist.subList(page.getStartCount(),lastCount);
		return SUCCESS;
	}


	public static Reader getReader() {
		return reader;
	}
	public static void setReader(Reader reader) {
		basketListAction.reader = reader;
	}
	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}
	public static void setSqlMapper(SqlMapClient sqlMapper) {
		basketListAction.sqlMapper = sqlMapper;
	}
	public List<basketVO> getList() {
		return basketlist;
	}
	public void setList(List<basketVO> list) {
		this.basketlist = basketlist;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getBlockCount() {
		return blockCount;
	}
	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}
	public int getBlockPage() {
		return blockPage;
	}
	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}
	public String getPagingHtml() {
		return pagingHtml;
	}
	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}
	public pagingAction getPage() {
		return page;
	}
	public void setPage(pagingAction page) {
		this.page = page;
	}
	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}
	public long getBasket_Price() {
		return basket_Price;
	}
	public void setBasket_Price(long basket_Price) {
		this.basket_Price = basket_Price;
	}
	
	
	

}





































