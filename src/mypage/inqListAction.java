package mypage;

import com.opensymphony.xwork2.ActionSupport;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import common.pagingAction;

public class inqListAction extends ActionSupport {
	public static Reader reader; // ���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper; // SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.

	private List<inquiryVO> list = new ArrayList<inquiryVO>();
	private int currentPage = 1; // ���� ������
	private int totalCount; // �� �Խù��� ��
	private int blockCount = 3; // �� �������� �Խù� ��
	private int blockPage = 5; // �� ȭ�鿡 ������ ������ ��
	private String pagingHtml; // ����¡�� ������ html
	private pagingAction page; // ����¡ Ŭ����
	private int lastCount;

	// ������
	public inqListAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close(); // �о� ������ �ݱ�
	}

	public String execute() throws Exception {

		list = sqlMapper.queryForList("inq.selectAll"); // list�� ��� �� ������ ����

		totalCount = list.size(); // ��ü ���� ������ totalcount��
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, "inqListAction");
		pagingHtml = page.getPageHtml().toString(); // pagingHtml ����
		int lastCount = totalCount; // ���� ���������� ������ ������ �� ��ȣ ����

		if (page.getEndCount() < totalCount) // ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������
			lastCount = page.getEndCount() + 1; // lastCount�� +1 ��ȣ�� ����.

		list = list.subList(page.getStartCount(), lastCount); // ��ü ����Ʈ���� ���� ����Ʈ��ŭ�� ����Ʈ�� ������

		return SUCCESS;
	}
	
	

	public int getLastCount() {
		return lastCount;
	}

	public void setLastCount(int lastCount) {
		this.lastCount = lastCount;
	}

	public List<inquiryVO> getList() {
		return list;
	}

	public void setList(List<inquiryVO> list) {
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

	

}
