package goods;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

import java.net.*;

public class goodsCmtListAction extends ActionSupport{

	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private List<goodsCmtVO> list = new ArrayList<goodsCmtVO>();

	private int num = 0;
	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 10;
	private int blockPage = 5;
	private String pagingHtml;
//	private pagingAction page;
	


	public goodsCmtListAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig_for_board2.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();		
	}
	
	public String execute() throws Exception {
		
		list = sqlMapper.queryForList("select-goods-cmt-all");
		
		totalCount = list.size();
//		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, num, "");
//		pagingHtml = page.getPagingHtml().toString();
		
		int lastCount = totalCount;
		
//		if(page.getEndCount() < totalCount) lastCount = page.getEndCount() + 1;
		
//		list = list.subList(page.getStartCount(), lastCount);
		return SUCCESS;
	}

	public List<goodsCmtVO> getList() { return list; }
	public void setList(List<goodsCmtVO> list) { this.list = list; }

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