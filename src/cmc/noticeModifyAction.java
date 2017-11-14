/*package cmc;  관리자 작업시 주석 풀고 리턴 밑줄 확인

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.io.IOException;

public class noticeModifyAction {
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private noticeVO paramClass;
	private noticeVO resultClass;

	private int currentPage;

	private int notice_no;
	private String notice_subject;
	private String notice_content;

	public noticeModifyAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}

	public String execute() throws Exception {
		paramClass = new noticeVO();
		resultClass = new noticeVO();

		paramClass.setNotice_no(getNotice_no());
		paramClass.setNotice_subject(getNotice_subject());
		paramClass.setNotice_content(getNotice_content());

		sqlMapper.update("notice.update", paramClass);

		resultClass = (noticeVO) sqlMapper.queryForObject("notice.selectOne", getNotice_no());

		return SUCCESS;    //SUCCESS 밑줄감 확인해야함

	}

	public noticeVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(noticeVO paramClass) {
		this.paramClass = paramClass;
	}

	public noticeVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(noticeVO resultClass) {
		this.resultClass = resultClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}

	public String getNotice_subject() {
		return notice_subject;
	}

	public void setNotice_subject(String notice_subject) {
		this.notice_subject = notice_subject;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

}
*/