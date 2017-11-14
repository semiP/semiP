package order;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

import java.net.*;

public class orderListAction extends ActionSupport{
	
	public static Reader reader;        //���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper;      //SqlMapClinet API�� ����ϱ� ���� sqlMapper ��ü.
	
	private List<orderVO> list = new ArrayList<orderVO>();
	
	private int currentPage = 1; //���� ������
	private int totalCount;		 //�� �Խù��� ��
	private int blockCount = 10; //�� �������� �Խù��� ��
	private int blockPage = 5;   //�� ȭ�鿡 ������ ������ ��
	private String pagingHtml;   //����¡�� ������ HTML
	private int num = 0;
	
	//������
	public orderListAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig_for_board2.xml"); //sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);  //sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close();
	}
	
	//��ǰ ��� List �׼�
	public String execute() throws Exception
	{
		//��� ���� ������ list�� �ִ´�.
		list = sqlMapper.queryForList("selectAll");
		
		totalCount = list.size(); //��ü �� ������ ���Ѵ�.
		//pagingAction ��ü ����.
//		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, num, "");
//		pagingHtml = page.getPagingHtml().toString(); //������ HTML ����.
		
		//���� ���������� ������ ������ ���� ��ȣ ����.
//		int lastCount = totalCount;
		
		//���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������
		//lastCount�� + 1 ��ȣ�� ����.
//		if(page.getEndCount() < totalCount) lastCount = page.getEndCount() + 1;
		
		//��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
//		list = list.subList(page.getStartcount(), lastCount);
		
		return SUCCESS;
	}
	
	public List<orderVO> getList() { return list; }
	public void setList(List<orderVO> list) { this.list = list; }
	
	public int getCurrentPage() { return currentPage; }
	public void setCurrentPage(int currentPage) { this.currentPage = currentPage; }
	
	public int getTotalCount() { return totalCount; }
	public void setTotalcount(int totalCount) { this.totalCount = totalCount; }
	
	public int getBlockCount() { return blockCount; }
	public void setBlockCount(int blockCount) { this.blockCount = blockCount; }
	
	public int getBlockPage() { return blockPage; }
	public void setBlockPage(int blockPage) { this.blockPage = blockPage; }
	
	public String getPagingHtml() { return pagingHtml; }
	public void setPagingHtml(String pagingHtml) { this.pagingHtml = pagingHtml; }
	
}
