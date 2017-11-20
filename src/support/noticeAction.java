package support;

import com.opensymphony.xwork2.ActionSupport;
//import cmc.noticeVO; ������ζ�...

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

import common.pagingAction;

public class noticeAction extends ActionSupport {

	public static Reader reader; // ���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper; // SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.

	private List<noticeVO> list = new ArrayList<noticeVO>();;
	private int currentPage = 1; // ���� ������
	private int totalCount; // �� �Խù��� ��
	private int blockCount = 10; // �� �������� �Խù� ��
	private int blockPage = 5; // �� ȭ�鿡 ������ ������ ��
	private String pagingHtml; // ����¡�� ������ html
	private pagingAction page; // ����¡ Ŭ����

	private String searchS;

	// ������
	public noticeAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close(); // �о� ������ �ݱ�
	}

	public String execute() throws Exception {
		if (getSearchS() != null) {
			return search();
		}

		list = sqlMapper.queryForList("notice.selectAll"); // list�� ��� �� ������ ����

		totalCount = list.size(); // ��ü ���� ������ totalcount��
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, "notice");
		pagingHtml = page.getPageHtml().toString(); // pagingHtml ����
		int lastCount = totalCount; // ���� ���������� ������ ������ �� ��ȣ ����

		if (page.getEndCount() < totalCount) // ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������
			lastCount = page.getEndCount() + 1; // lastCount�� +1 ��ȣ�� ����.

		list = list.subList(page.getStartCount(), lastCount); // ��ü ����Ʈ���� ���� ����Ʈ��ŭ�� ����Ʈ�� ������

		return SUCCESS;
	}

	// �˻� �޼ҵ� �߰�
	public String search() throws Exception {
		totalCount = list.size();
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, getSearchS());
		pagingHtml = page.getPageHtml().toString();
		int lastCount = totalCount;

		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;
		list = list.subList(page.getStartCount(), lastCount);
		return SUCCESS;
	}

	public List<noticeVO> getList() {
		return list;
	}

	public void setList(List<noticeVO> list) {
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

	public String getSearchS() {
		return searchS;
	}

	public void setSearchS(String searchS) {
		this.searchS = searchS;
	}

}