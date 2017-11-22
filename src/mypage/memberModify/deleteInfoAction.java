package mypage.memberModify;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import member.memberbean;

public class deleteInfoAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private Map session;
	
	private memberbean paramClass;
	private memberbean resultClass;
	
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
	
	//생성자
	public deleteInfoAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져옴
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper객체 생성
		reader.close();
	}
		

	//
	public String execute() throws Exception{
		paramClass = new memberbean();
		resultClass = new memberbean();
		
		// 비밀번호 입력값 파라미터 설정
		paramClass.setMember_no((int)session.get("session_member_no"));
		paramClass.setMember_pw(getMember_pw());
		paramClass.setMember_deletereason(getMember_deletereason());
			
		//탈퇴사유에 대한 이유를 넣는다.
		sqlMapper.insert("insertMemberDeleteReason", getMember_no());
			
		//Member_level에 대한 상태변환
		sqlMapper.update("updateMemberDelete", getMember_no());
			
		// 현재 글의 비밀번호 가져오기
		resultClass = (memberbean)sqlMapper.queryForObject("pwCheck",getMember_no());
						
		// 입력한 비밀번호가 없으면 입력창
		if(resultClass == null) return ERROR;
					
		return SUCCESS;
	}


	public static Reader getReader() {
		return reader;
	}


	public static void setReader(Reader reader) {
		deleteInfoAction.reader = reader;
	}


	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}


	public static void setSqlMapper(SqlMapClient sqlMapper) {
		deleteInfoAction.sqlMapper = sqlMapper;
	}


	public Map getSession() {
		return session;
	}


	public void setSession(Map session) {
		this.session = session;
	}


	public memberbean getParamClass() {
		return paramClass;
	}


	public void setParamClass(memberbean paramClass) {
		this.paramClass = paramClass;
	}


	public memberbean getResultClass() {
		return resultClass;
	}


	public void setResultClass(memberbean resultClass) {
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


	public String getMember_deletereason() {
		return member_deletereason;
	}


	public void setMember_deletereason(String member_deletereason) {
		this.member_deletereason = member_deletereason;
	}
	
	
}
