package mypage.inquiry;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import mypage.goodsBean;
import mypage.goodsOrderBean;
import mypage.inquiryBean;
import mypage.memberBean;

public class listAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private inquiryBean paramClass1;
	private inquiryBean resultClass1;
	
	private inquiryBean paramClass2;
	private inquiryBean resultClass2;
	
	private inquiryBean paramClass3;
	private inquiryBean resultClass3;
	
	private List<mypage.inquiryBean> list = new ArrayList<mypage.inquiryBean>();
	
	// inquiry
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
	
	private String searchKeyword1;
	private String searchKeyword2;
	
	//생성자
	public listAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져옴
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper객체 생성
		reader.close();
	}
	
	//리스트 출력
	public String execute() throws Exception{
		//모든 글을 가져와 list에 넣는다.
		paramClass1 = new inquiryBean(); // 파라미터를 저장할 객체
		resultClass1 = new inquiryBean(); // 쿼리 결과 값을 저장할 객체
	
		/*ActionContext context = ActionContext.getContext();*/
				
		paramClass1.setInquiry_no(getInquiry_no());
		paramClass1.setInquiry_category(getInquiry_category());
		paramClass1.setInquiry_subject(getInquiry_subject());
		paramClass1.setInquiry_content(getInquiry_content());
		paramClass1.setInquiry_regdate(getInquiry_regdate());
		paramClass1.setInquiry_addfile(getInquiry_addfile());
		
		resultClass1 = (inquiryBean)sqlMapper.queryForObject("inquiry_no",paramClass1);
		
		return SUCCESS;
	}
	
	// 기간조회
		public String search() throws Exception{
			paramClass2 = new inquiryBean();
			paramClass3 = new inquiryBean();
			
			resultClass2 = new inquiryBean();
			resultClass3 = new inquiryBean();
			
			paramClass2 = (inquiryBean) sqlMapper.queryForList(getSearchKeyword1());
			paramClass3 = (inquiryBean) sqlMapper.queryForList(getSearchKeyword2());
			
			return SUCCESS;
		}
		
		//문의내역 상세 보기 page로 이동	
		public String inquiryDetailForm() throws Exception{
			return SUCCESS;
		}		

		public static Reader getReader() {
			return reader;
		}

		public static void setReader(Reader reader) {
			listAction.reader = reader;
		}

		public static SqlMapClient getSqlMapper() {
			return sqlMapper;
		}

		public static void setSqlMapper(SqlMapClient sqlMapper) {
			listAction.sqlMapper = sqlMapper;
		}

		public inquiryBean getParamClass1() {
			return paramClass1;
		}

		public void setParamClass1(inquiryBean paramClass1) {
			this.paramClass1 = paramClass1;
		}

		public inquiryBean getResultClass1() {
			return resultClass1;
		}

		public void setResultClass1(inquiryBean resultClass1) {
			this.resultClass1 = resultClass1;
		}

		public inquiryBean getParamClass2() {
			return paramClass2;
		}

		public void setParamClass2(inquiryBean paramClass2) {
			this.paramClass2 = paramClass2;
		}

		public inquiryBean getResultClass2() {
			return resultClass2;
		}

		public void setResultClass2(inquiryBean resultClass2) {
			this.resultClass2 = resultClass2;
		}

		public inquiryBean getParamClass3() {
			return paramClass3;
		}

		public void setParamClass3(inquiryBean paramClass3) {
			this.paramClass3 = paramClass3;
		}

		public inquiryBean getResultClass3() {
			return resultClass3;
		}

		public void setResultClass3(inquiryBean resultClass3) {
			this.resultClass3 = resultClass3;
		}

		public List<mypage.inquiryBean> getList() {
			return list;
		}

		public void setList(List<mypage.inquiryBean> list) {
			this.list = list;
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

		public String getInquiry_email() {
			return inquiry_email;
		}

		public void setInquiry_email(String inquiry_email) {
			this.inquiry_email = inquiry_email;
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

		public String getSearchKeyword1() {
			return searchKeyword1;
		}

		public void setSearchKeyword1(String searchKeyword1) {
			this.searchKeyword1 = searchKeyword1;
		}

		public String getSearchKeyword2() {
			return searchKeyword2;
		}

		public void setSearchKeyword2(String searchKeyword2) {
			this.searchKeyword2 = searchKeyword2;
		}
}

