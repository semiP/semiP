package support;

import com.opensymphony.xwork2.ActionSupport;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import common.pagingAction;

public class faqListAction extends ActionSupport {
	public static Reader reader; // ���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper; // SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.

	private List<faqVO> list = new ArrayList<faqVO>();
	private int currentPage = 1; // ���� ������
	private int totalCount; // �� �Խù��� ��
	private int blockCount = 3; // �� �������� �Խù� ��
	private int blockPage = 5; // �� ȭ�鿡 ������ ������ ��
	private String pagingHtml; // ����¡�� ������ html
	private pagingAction page; // ����¡ Ŭ����

	private String searchKeyword;
	private int searchSC;
	private int searchNum;
	
	private int num=0;

	// ������
	public faqListAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close(); // �о� ������ �ݱ�
	}

//	execute() / search() 차후 변경
	public String execute() throws Exception {
		if (getSearchKeyword() != null || getSearchNum() == 1 || getSearchNum() == 2 || getSearchNum() == 3) {
			return search();
		}
		

		list = sqlMapper.queryForList("faq.selectAll"); // list�� ��� �� ������ ����

		totalCount = list.size(); // ��ü ���� ������ totalcount��
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, "faqListAction", num, num, "");
		pagingHtml = page.getPageHtml().toString(); // pagingHtml ����
		int lastCount = totalCount; // ���� ���������� ������ ������ �� ��ȣ ����

		if (page.getEndCount() < totalCount) // ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������
			lastCount = page.getEndCount() + 1; // lastCount�� +1 ��ȣ�� ����.

		list = list.subList(page.getStartCount(), lastCount); // ��ü ����Ʈ���� ���� ����Ʈ��ŭ�� ����Ʈ�� ������

		return SUCCESS;
	}

	// �˻� �޼ҵ� �߰�
	public String search() throws Exception {
		if(searchSC == 0){
			list = sqlMapper.queryForList("faq.selectSearch-s", "%"+getSearchKeyword()+"%");
		}
		if(searchSC == 1){
			list = sqlMapper.queryForList("faq.selectSearch-c", "%"+getSearchKeyword()+"%");
		}
		if(searchNum == 1) {
			list = sqlMapper.queryForList("faq.selectAll");
		}
		if(searchNum == 2) {
			list = sqlMapper.queryForList("faq.selectSearch-o");
		}
		if(searchNum == 3) {
			list = sqlMapper.queryForList("faq.selectSearch-t");
		}
			
		totalCount = list.size();
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, "faqListAction", searchSC, searchNum, getSearchKeyword());
		pagingHtml = page.getPageHtml().toString();
		int lastCount = totalCount;

		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;
		list = list.subList(page.getStartCount(), lastCount);
		return SUCCESS;
	}
	
	
	public int getSearchNum() {
		return searchNum;
	}

	public void setSearchNum(int searchNum) {
		this.searchNum = searchNum;
	}

	public List<faqVO> getList() {
		return list;
	}

	public void setList(List<faqVO> list) {
		this.list = list;
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

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

}
