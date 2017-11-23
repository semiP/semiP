package order;

import com.opensymphony.xwork2.ActionSupport;

import goods.goodsVO;

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
	
	private orderVO resultOrder = new orderVO();
	private List<orderVO> list = new ArrayList<orderVO>();
	private int order_no;
	
	private int currentPage = 1; 
	private int totalCount;		 
	private int blockCount = 10; 
	private int blockPage = 5;   
	private String pagingHtml;
	private int num = 0;
	
	//생성자
	public orderListAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); //sqlMapConfig.xml 
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);  //sqlMapConfig.xml
		reader.close();
	}
	
	//��ǰ ��� List �׼�
	public String execute() throws Exception
	{
		//모든 글을 가져와 list에 넣는다.
		/*list = sqlMapper.queryForList("select-join-order");
		
		totalCount = list.size(); //list의 크기를 구한다
*/		
		resultOrder = (orderVO) sqlMapper.queryForObject("order.select-join-order-one", order_no);
		
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

	public int getOrder_no() { return order_no; }
	public void setOrder_no(int order_no) { this.order_no = order_no; }
	
}
