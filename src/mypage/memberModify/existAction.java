package mypage.memberModify;

import java.io.Reader;
import java.util.Date;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import mypage.memberBean;

public class existAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private memberBean paramClass;
	private memberBean paramClass2;
	private memberBean resultClass;
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
	
	private Map session;
	
	//생성자
	public existAction() throws Exception{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져옴
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper객체 생성
		reader.close();
	}
	
	// 회원 탈퇴 전 비밀번호 체크 폼 이동
	public String checkForm() throws Exception{
		return SUCCESS;
	}
	
	// 비밀번호 확인 후 SUCCESS시 경고문 이동 ERROR시 pwError.jsp이동
	public String checkAction() throws Exception{
		paramClass = new memberBean();
		resultClass = new memberBean();
		
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		
		String session_member_no = (String)session.get("session_member_no");
		
		// 비밀번호 입력값 파라미터 설정.
		paramClass.setMember_pw(getMember_pw());
		paramClass.setMember_no(getMember_no());
		
		// 현재글의 비밀번호 가져오기
		resultClass = (memberBean)sqlMapper.queryForObject("pwCheck",paramClass);
		
		if(resultClass != null) {
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
	
	// 회원탈퇴 처리 => MEMBER_LEVEL
	public String execute() throws Exception{
		// 파라미터와 리절트 객체 생성
		paramClass2 = new memberBean();
		resultClass2 = new memberBean();
		
		// 수정할 항목 설정
		paramClass2.setMember_level(getMember_level());
		
		// 항목 수정
		sqlMapper.update("updateMemberDelete");
		
		return SUCCESS;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		existAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		existAction.sqlMapper = sqlMapper;
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
	
	
}
