package mypage.memberModify;

import java.io.Reader;
import java.util.Date;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import mypage.memberBean;

public class modifyPWAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private memberBean paramClass;
	private memberBean resultClass;
	
	private memberBean paramClass2;
	private memberBean resultClass2;
	
	private int member_no;
	private String member_name;
	private String member_id;
	private String member_pw;
	private String member_zipcode;
	private String member_address1;
	private String member_address2;
	private String member_phone;
	private String member_email;
	private Date member_regdate;
	private int member_level;
	private String member_deletereason;
	
	private Map session;
	
	//생성자
	public modifyPWAction() throws Exception{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	// 비밀번호수정
		public String execute() throws Exception{
			// 파라미터와 리절트 객체 생성
			paramClass = new memberBean();
			resultClass = new memberBean();
			
			// 비밀번호 입력값 파라미터 설정
			paramClass.setMember_no((int)session.get("session_member_no"));
			
			//수정할 항목 설정
			paramClass.setMember_pw(getMember_pw());
			paramClass.setMember_no(getMember_no());
			
			// 일단 항목만 수정한다.
			sqlMapper.update("updateMemberPW",paramClass);
			
			//수정이 끝나면 view페이지로 이동
			resultClass = (memberBean) sqlMapper.queryForObject("showPW", getMember_no());
			
			return SUCCESS;
		}

		public static Reader getReader() {
			return reader;
		}

		public static void setReader(Reader reader) {
			modifyAction.reader = reader;
		}

		public static SqlMapClient getSqlMapper() {
			return sqlMapper;
		}

		public static void setSqlMapper(SqlMapClient sqlMapper) {
			modifyAction.sqlMapper = sqlMapper;
		}

		public memberBean getParamClass() {
			return paramClass;
		}

		public void setParamClass(memberBean paramClass) {
			this.paramClass = paramClass;
		}

		public memberBean getResultClass() {
			return resultClass;
		}

		public void setResultClass(memberBean resultClass) {
			this.resultClass = resultClass;
		}

		public int getMember_no() {
			return member_no;
		}

		public void setMember_no(int member_no) {
			this.member_no = member_no;
		}

		public String getMember_name() {
			return member_name;
		}

		public void setMember_name(String member_name) {
			this.member_name = member_name;
		}

		public String getMember_id() {
			return member_id;
		}

		public void setMember_id(String member_id) {
			this.member_id = member_id;
		}

		public String getMember_pw() {
			return member_pw;
		}

		public void setMember_pw(String member_pw) {
			this.member_pw = member_pw;
		}

		public String getMember_zipcode() {
			return member_zipcode;
		}

		public void setMember_zipcode(String member_zipcode) {
			this.member_zipcode = member_zipcode;
		}

		public String getMember_address1() {
			return member_address1;
		}

		public void setMember_address1(String member_address1) {
			this.member_address1 = member_address1;
		}

		public String getMember_address2() {
			return member_address2;
		}

		public void setMember_address2(String member_address2) {
			this.member_address2 = member_address2;
		}

		public String getMember_phone() {
			return member_phone;
		}

		public void setMember_phone(String member_phone) {
			this.member_phone = member_phone;
		}

		public String getMember_email() {
			return member_email;
		}

		public void setMember_email(String member_email) {
			this.member_email = member_email;
		}

		public Date getMember_regdate() {
			return member_regdate;
		}

		public void setMember_regdate(Date member_regdate) {
			this.member_regdate = member_regdate;
		}

		public int getMember_level() {
			return member_level;
		}

		public void setMember_level(int member_level) {
			this.member_level = member_level;
		}

		public Map getSession() {
			return session;
		}

		public void setSession(Map session) {
			this.session = session;
		}

		public memberBean getParamClass2() {
			return paramClass2;
		}

		public void setParamClass2(memberBean paramClass2) {
			this.paramClass2 = paramClass2;
		}

		public memberBean getResultClass2() {
			return resultClass2;
		}

		public void setResultClass2(memberBean resultClass2) {
			this.resultClass2 = resultClass2;
		}

		public String getMember_deletereason() {
			return member_deletereason;
		}

		public void setMember_deletereason(String member_deletereason) {
			this.member_deletereason = member_deletereason;
		}
		
		
	}
