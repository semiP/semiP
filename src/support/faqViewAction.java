package support;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.io.IOException;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class faqViewAction extends ActionSupport {
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private faqVO paramClass = new faqVO();
	private faqVO resultClass = new faqVO();

	private int currentPage;

	private int faq_no;

	public faqViewAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}

	public String execute() throws Exception {

		paramClass.setFaq_no(getFaq_no());
		resultClass = (faqVO) sqlMapper.queryForObject("faq.selectOne", getFaq_no());

		return SUCCESS;
	}

	public faqVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(faqVO paramClass) {
		this.paramClass = paramClass;
	}

	public faqVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(faqVO resultClass) {
		this.resultClass = resultClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getFaq_no() {
		return faq_no;
	}

	public void setFaq_no(int faq_no) {
		this.faq_no = faq_no;
	}

}
