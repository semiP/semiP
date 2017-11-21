package basket;

import com.opensymphony.xwork2.ActionSupport;
//import cmc.noticeVO; ������ζ�...

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import support.noticeVO;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

import common.pagingAction;

public class basketListAction extends ActionSupport {

	public static Reader reader; // ���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper; // SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.

	private basketVO basketparamClass;
	private basketVO basketresultClass;
	
	private List<basketVO> basketlist = new ArrayList<basketVO>();
	
	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 10;
	private int blockPage = 5;
	private String pagingHtml;
	private pagingAction page;
	//private Map session;
	private long basket_Price=0;
	private int member_no;
	private String basket_no_set;

	public String getBasket_no_set() {
		return basket_no_set;
	}

	public void setBasket_no_set(String basket_no_set) {
		this.basket_no_set = basket_no_set;
	}

	// ������
	public basketListAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close(); // �о� ������ �ݱ�
	}

	public String execute() throws Exception {

		setMember_no(1);
		
		basketlist = sqlMapper.queryForList("basketSet.selectAll", getMember_no());
		
		totalCount = basketlist.size();
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, pagingHtml);
		pagingHtml = page.getPageHtml().toString();
	
		int lastCount = totalCount;
	
	
		if(page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;
	
		basketlist = basketlist.subList(page.getStartCount(),lastCount);

		return SUCCESS;
	}

	public String deletebasket() throws Exception {
		
		StringTokenizer st = new StringTokenizer(getBasket_no_set(), "||"); 
				
		while(st.hasMoreTokens()) 
		{ 
			int no_set = Integer.parseInt(st.nextToken());
			sqlMapper.update("basketSet.deleteBasket", no_set);
			
		}
		
		return SUCCESS;
	}
	
	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
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

	public List<basketVO> getBasketlist() {
		return basketlist;
	}
	public void setBasketlist(List<basketVO> basketlist) {
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
	/*public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}*/
	public long getBasket_Price() {
		return basket_Price;
	}
	public void setBasket_Price(long basket_Price) {
		this.basket_Price = basket_Price;
	}

}