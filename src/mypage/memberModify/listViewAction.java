package mypage.memberModify;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import mypage.memberBean;

public class listViewAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private Map session;
	
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
	
	
	//email개별번수
	private String email1;
	private String email2;
	
	//phone개별변수
	private String phone1;
	private String phone2;
	private String phone3;
	
	//생성자
	public listViewAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져옴
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper객체 생성
		reader.close();
	}
	
	// 기존 비밀번호를 제외한 다른 항목들의 내용 list 출력
		public String execute() throws Exception{
			paramClass = new memberBean(); // 파라미터를 저장할 개게
			resultClass = new memberBean(); // 쿼리 결과값을 저장할 객체
			
			// 목록을 화면에 출력
			resultClass = (memberBean)sqlMapper.queryForObject("memberModifyList",paramClass);
			
			phone1 = getMember_phone().substring(0,3);
			phone2 = getMember_phone().substring(3,7);
			phone3 = getMember_phone().substring(7,9);
			
			if(session.get("session_member_no") == null){
				return LOGIN;
			}
			
			return SUCCESS;
		}

		public static Reader getReader() {
			return reader;
		}

		public static void setReader(Reader reader) {
			listViewAction.reader = reader;
		}

		public static SqlMapClient getSqlMapper() {
			return sqlMapper;
		}

		public static void setSqlMapper(SqlMapClient sqlMapper) {
			listViewAction.sqlMapper = sqlMapper;
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

		public Map getSession() {
			return session;
		}

		public void setSession(Map session) {
			this.session = session;
		}

		public String getMember_deletereason() {
			return member_deletereason;
		}

		public void setMember_deletereason(String member_deletereason) {
			this.member_deletereason = member_deletereason;
		}

		public String getEmail1() {
			return email1;
		}

		public void setEmail1(String email1) {
			this.email1 = email1;
		}

		public String getEmail2() {
			return email2;
		}

		public void setEmail2(String email2) {
			this.email2 = email2;
		}

		public String getPhone1() {
			return phone1;
		}

		public void setPhone1(String phone1) {
			this.phone1 = phone1;
		}

		public String getPhone2() {
			return phone2;
		}

		public void setPhone2(String phone2) {
			this.phone2 = phone2;
		}

		public String getPhone3() {
			return phone3;
		}

		public void setPhone3(String phone3) {
			this.phone3 = phone3;
		}
		
	}
