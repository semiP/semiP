package mypage.inquiryDetail;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import mypage.inquiryBean;

public class viewAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private inquiryBean paramClass;
	private inquiryBean resultClass;
	
	private int inquiry_no;
	private int member_no;
	private int inquiry_category;
	private String inquiry_subject;
	private String inquiry_content;
	private Date inquiry_regdate;
	private String inquiry_email;
	private String inquiry_addfile;
	private int inquiry_ref;
	private int inquiry_re_step;
	private int inquiry_level;
	
	//생성자
	public viewAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	// 상세보기 문의 폼 출력
	public String execute() throws Exception{
		//모든 글을 가져와 list에 넣는다.
		paramClass = new inquiryBean(); // 파라미터를 저장할 객체
		resultClass = new inquiryBean(); // 쿼리 결과 값을 저장할 객체
	
		/*ActionContext context = ActionContext.getContext();*/
				
		paramClass.setInquiry_no(getInquiry_no());
		paramClass.setInquiry_category(getInquiry_category());
		paramClass.setInquiry_subject(getInquiry_subject());
		paramClass.setInquiry_content(getInquiry_content());
		paramClass.setInquiry_regdate(getInquiry_regdate());
		paramClass.setInquiry_addfile(getInquiry_addfile());
		
		resultClass = (inquiryBean)sqlMapper.queryForObject("inquiry_no",paramClass);
		
		return SUCCESS;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		viewAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		viewAction.sqlMapper = sqlMapper;
	}

	public inquiryBean getParamClass() {
		return paramClass;
	}

	public void setParamClass(inquiryBean paramClass) {
		this.paramClass = paramClass;
	}

	public inquiryBean getResultClass() {
		return resultClass;
	}

	public void setResultClass(inquiryBean resultClass) {
		this.resultClass = resultClass;
	}

	public int getInquiry_no() {
		return inquiry_no;
	}

	public void setInquiry_no(int inquiry_no) {
		this.inquiry_no = inquiry_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public int getInquiry_category() {
		return inquiry_category;
	}

	public void setInquiry_category(int inquiry_category) {
		this.inquiry_category = inquiry_category;
	}

	public String getInquiry_subject() {
		return inquiry_subject;
	}

	public void setInquiry_subject(String inquiry_subject) {
		this.inquiry_subject = inquiry_subject;
	}

	public String getInquiry_content() {
		return inquiry_content;
	}

	public void setInquiry_content(String inquiry_content) {
		this.inquiry_content = inquiry_content;
	}

	public Date getInquiry_regdate() {
		return inquiry_regdate;
	}

	public void setInquiry_regdate(Date inquiry_regdate) {
		this.inquiry_regdate = inquiry_regdate;
	}

	public String getInquiry_addfile() {
		return inquiry_addfile;
	}

	public void setInquiry_addfile(String inquiry_addfile) {
		this.inquiry_addfile = inquiry_addfile;
	}

	public int getInquiry_ref() {
		return inquiry_ref;
	}

	public void setInquiry_ref(int inquiry_ref) {
		this.inquiry_ref = inquiry_ref;
	}

	public int getInquiry_re_step() {
		return inquiry_re_step;
	}

	public void setInquiry_re_step(int inquiry_re_step) {
		this.inquiry_re_step = inquiry_re_step;
	}

	public int getInquiry_level() {
		return inquiry_level;
	}

	public void setInquiry_level(int inquiry_level) {
		this.inquiry_level = inquiry_level;
	}
	
	
}
