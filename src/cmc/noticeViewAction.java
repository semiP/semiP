package cmc;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
//noticeVO가 같은 클래스내에 있어서 따로 import 지정 안함
import java.io.Reader;
import java.io.IOException;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class noticeViewAction extends ActionSupport {

	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private noticeVO paramClass = new noticeVO();
	private noticeVO resultClass = new noticeVO();

	private int currentPage;

	private int notice_no;

	public noticeViewAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}

	public String execute() throws Exception {

		paramClass.setNotice_no(getNotice_no());
		resultClass = (noticeVO) sqlMapper.queryForObject("notice.selectOne", getNotice_no());

		return SUCCESS;
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
}
