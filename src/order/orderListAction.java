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
	
	public static Reader reader;        //파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper;      //SqlMapClinet API를 사용하기 위한 sqlMapper 객체.
	
	private List<orderVO> list = new ArrayList<orderVO>();
	
	private int currentPage = 1; //현재 페이지
	private int totalCount;		 //총 게시물의 수
	private int blockCount = 10; //한 페이지의 게시물의 수
	private int blockPage = 5;   //한 화면에 보여줄 페이지 수
	private String pagingHtml;   //페이징을 구현한 HTML
	private int num = 0;
	
	//생성자
	public orderListAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig_for_board2.xml"); //sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);  //sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}
	
	//상품 목록 List 액션
	public String execute() throws Exception
	{
		//모든 글을 가져와 list에 넣는다.
		list = sqlMapper.queryForList("selectAll");
		
		totalCount = list.size(); //전체 글 갯수를 구한다.
		//pagingAction 객체 생성.
//		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, num, "");
//		pagingHtml = page.getPagingHtml().toString(); //페이지 HTML 생성.
		
		//현재 페이지에서 보여줄 마지막 글의 번호 설정.
//		int lastCount = totalCount;
		
		//현재 페이지의 마지막 글의 번호가 전체의 마지막 글 번호보다 작으면
		//lastCount를 + 1 번호로 설정.
//		if(page.getEndCount() < totalCount) lastCount = page.getEndCount() + 1;
		
		//전체 리스트에서 현재 페이지만큼의 리스트만 가져온다.
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
