package mypage.memberModify;

import java.io.Reader;
import java.util.Date;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import member.memberbean;

public class InfoViewAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 1L;
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private memberbean paramClass;
	private memberbean resultClass;
	
	//session값 관련 객체
	private int member_no;
	private String member_name;
	private String member_id;
	
	//비밀번호 변경
	private String member_pw;

	private String member_phone;
	private String member_email;
	
	//email개별번수
	private String email1;
	private String email2;
	
	//phone개별변수
	private String phone1;
	private String phone2;
	private String phone3;
	
	private Map session;
	
	//생성자
	public InfoViewAction() throws Exception{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	//화면에 list출력
	public String execute() throws Exception{
	
		if(session.get("session_member_id").equals("") || session.get("session_member_id") == null) {
			return LOGIN;
		}
		
		member_no = (int)session.get("session_member_no");
		resultClass = (memberbean)sqlMapper.queryForObject("mypageMemberModify.selectOneMember",member_no);		
		
		member_email = resultClass.getMember_email();
		
		email1 = getMember_email().substring(0, getMember_email().indexOf("@"));				// StringIndexOutOfBoundsException 난다. 3/3 으로 로그인 하면 진입이 안됨. 정보가 부족해서인듯.
		email2 = getMember_email().substring(getMember_email().indexOf("@") + 1);
		
		member_phone = resultClass.getMember_phone();
		
		phone1 = getMember_phone().substring(0,3);
		phone2 = getMember_phone().substring(3,7);
		phone3 = getMember_phone().substring(7,11);

		return SUCCESS;
		
		
	}
	
/*	// 개인정보 폼 보여주는 처리
	public String infoView() throws Exception{
		
		if(session.get("session_member_id").equals("") || session.get("session_member_id") == null) {
			return LOGIN;
		}
		
		member_no = (int)session.get("session_member_no");
		resultClass = (memberbean)sqlMapper.queryForObject("mypageMemberModify.selectOneMember",member_no);	
		
		return SUCCESS;
	}*/
	
	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		InfoViewAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		InfoViewAction.sqlMapper = sqlMapper;
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

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}


}
