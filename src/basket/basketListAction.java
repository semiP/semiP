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
	
	//������
	public void baksetListAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	//�Խ��� List�׼�
	public String execute() throws Exception{
		list = sqlMapper.queryForList("basket.selectAll");
		totalCount = list.size();
		page = new pagingAction(currentPage,totalCount,blockCount,blockPage, pagingHtml);
		pagingHtml = page.getPagingHtml().toString();
		
		//���� ���������� ������ ������ ���ǹ�ȣ ����
		int lastCount = totalCount;
		
		//���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������
		//lastCount�� +1��ȣ�� ����
		if(page.getEndCount() < totalCount)
			lastCount = page.getBlockCount() + 1;
		
		///��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�
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
	
	//������
	public void baksetListAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	//�Խ��� List�׼�
	public String execute() throws Exception{
	/*basketlist = sqlMapper.queryForList("selectAll");
	totalCount = basketlist.size();
	page = new pagingAction(currentPage, totalCount, blockCount, blockPage, pagingHtml);
	pagingHtml = page.getPagingHtml().toString();

	//���� ���������� ������ ���������� ��ȣ ����
	int lastCount = totalCount;
	//������������ ���������� ��ȣ�� ��ü�� �������� ��ȣ���� ������
	//lastCount�� +1��ȣ�� ����
	if(page.getEndCount() < totalCount)
		lastCount = page.getEndCount() + 1;

	//��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
	basketlist = basketlist.subList(page.getStartCount(),lastCount);*/
		
		
		//임의의 리스트 만들기. 테스트용
		basketresultClass = new basketVO();
		basketresultClass.setBasket_no(1);
		basketresultClass.setBasket_price(40000);
		basketresultClass.setGoods_size("L");
		basketresultClass.setGoods_color("red");
		basketresultClass.setGoods_name("solid");
		basketresultClass.setBgoods_amount(2);
		basketresultClass.setGoods_price(20000);
		basketresultClass.setGoods_image("image");
				
		basketlist.add(basketresultClass);
		
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





































