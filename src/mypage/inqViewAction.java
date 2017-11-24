package mypage;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
//noticeVO�� ���� Ŭ�������� �־ ���� import ���� ����
import java.io.Reader;
import java.io.IOException;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class inqViewAction extends ActionSupport {

	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private inquiryVO paramClass = new inquiryVO();
	private inquiryVO resultClass = new inquiryVO();

	private int currentPage;

	private int inquiry_no;

	public inqViewAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}

	public String execute() throws Exception {

		paramClass.setInquiry_no(getInquiry_no());
		resultClass = (inquiryVO) sqlMapper.queryForObject("inq.selectOne", getInquiry_no());

		return SUCCESS;
	}

	

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public inquiryVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(inquiryVO paramClass) {
		this.paramClass = paramClass;
	}

	public inquiryVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(inquiryVO resultClass) {
		this.resultClass = resultClass;
	}

	public int getInquiry_no() {
		return inquiry_no;
	}

	public void setInquiry_no(int inquiry_no) {
		this.inquiry_no = inquiry_no;
	}
	
	

}
