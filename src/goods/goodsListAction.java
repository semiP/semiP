package goods;

import com.opensymphony.xwork2.ActionSupport;

import goods.goodsVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

import java.net.*;

public class goodsListAction extends ActionSupport {
	
	public static Reader reader;        //파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper;      //SqlMapClinet API를 사용하기 위한 sqlMapper 객체.
	
	private List<goodsVO> list = new ArrayList<goodsVO>();
	
	private String searchKeyword;
	private int searchNum;
	
	private int num = 0;
	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 10;
	private int blockPage = 5;
	private String pagingHtml;
//	private pagingAction page;

	//생성자
	public goodsListAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig_for_board2.xml"); //sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);  //sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}
	
	//게시판 LIST 액션
	public String execute() throws Exception
	{		
		//모든 글을 가져와 list에 넣는다.
		list = sqlMapper.queryForList("select-goods");
		
		totalCount = list.size();
//		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, num, "");
//		pagingHtml = page.getPagingHtml().toString();
	
//		list = list.subList(page.getStartCount(), lastCount);
		return SUCCESS;
	}

	public List<goodsVO> getList() { return list; }
	public void setList( List<goodsVO> list) { this.list = list; }
	
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
