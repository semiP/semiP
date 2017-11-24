package order;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

import java.net.*;

public class orderGoodsListAction extends ActionSupport{

	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private List<orderVO> list = new ArrayList<orderVO>();
	
	private int num = 0;
	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 10;
	private int blockPage = 5;
	private String pagingHtml;
//	private pagingAction page;
	


	public orderGoodsListAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();		
		
	}
	
	public String execute() throws Exception 
	{
		list = sqlMapper.queryForList("select-order");
		
		totalCount = list.size();
	
		return SUCCESS;
	}

	public List<orderVO> getList() { return list; }
	public void setList(List<orderVO> list) { this.list = list; }

	public int getCurrentPage() { return currentPage; }
	public void setCurrentPage(int currentPage) { this.currentPage = currentPage; }

	public int getTotalCount() { return totalCount; }
	public void setTotalCount(int totalCount) { this.totalCount = totalCount; }

	public int getBlockCount() { return blockCount; }
	public void setBlockCount(int blockCount) { this.blockCount = blockCount; }

	public int getBlockPage() { return blockPage; }
	public void setBlockPage(int blockPage) { this.blockPage = blockPage; }

	public String getPagingHtml() { return pagingHtml; }
	public void setPagingHtml(String pagingHtml) { this.pagingHtml = pagingHtml; }

}