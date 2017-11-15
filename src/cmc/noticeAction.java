package cmc;

import com.opensymphony.xwork2.ActionSupport;
//import cmc.noticeVO; 같은경로라...

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

import common.pagingAction;

public class noticeAction extends ActionSupport {

	public static Reader reader; // 파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper; // SqlMapClient API를 사용하기 위한 sqlMapper 객체.

	private List<noticeVO> list = new ArrayList<noticeVO>();;
	private int currentPage = 1; // 현재 페이지
	private int totalCount; // 총 게시물의 수
	private int blockCount = 10; // 한 페이지의 게시물 수
	private int blockPage = 5; // 한 화면에 보여줄 페이지 수
	private String pagingHtml; // 페이징을 구현한 html
	private pagingAction page; // 페이징 클래스

	private String searchS;

	// 생성자
	public noticeAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close(); // 읽어 왔으면 닫기
	}

	public String execute() throws Exception {
		if (getSearchS() != null) {
			return search();
		}

		list = sqlMapper.queryForList("notice.selectAll"); // list에 모든 글 내용을 넣음

		totalCount = list.size(); // 전체 글의 개수를 totalcount에
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, "notice", "");
		pagingHtml = page.getPageHtml().toString(); // pagingHtml 생성
		int lastCount = totalCount; // 현재 페이지에서 보여줄 마지막 글 번호 설정

		if (page.getEndCount() < totalCount) // 현재 페이지의 마지막 글의 번호가 전체의 마지막 글 번호보다 작으면
			lastCount = page.getEndCount() + 1; // lastCount를 +1 번호로 설정.

		list = list.subList(page.getStartCount(), lastCount); // 전체 리스트에서 현재 리스트만큼의 리스트만 가져옴

		return SUCCESS;
	}

	// 검색 메소드 추가
	public String search() throws Exception {
		totalCount = list.size();
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, getSearchS(), "");
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