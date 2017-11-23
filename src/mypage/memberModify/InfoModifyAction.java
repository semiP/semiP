package mypage.memberModify;

import java.io.Reader;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionContext;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import member.memberbean;

public class InfoModifyAction extends ActionSupport implements SessionAware{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	//회원정보 확인
	private memberbean paramClass;
	private memberbean resultClass;
	//정보수정
	private memberbean paramClass2;
	private memberbean resultClass2;
	
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
	
	
	//비밀번호 확인
	private int checkPW;
	
	private Map session;
	
	//생성자
	public InfoModifyAction() throws Exception{
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	//회원정보 확인 후 맞을시 수정폼 이동 아닐시 에러페이지
	//이거 현재 안쓰는 액션이네요...
	public String form() throws Exception{
		paramClass = new memberbean();
		resultClass = new memberbean();
		
		String session_id = (String)session.get("session_member_id");
		int session_no = (int)session.get("session_member_no");
		String session_name = (String)session.get("session_member_name");
		
		paramClass.setMember_no(session_no);
		paramClass.setMember_pw(getMember_pw());
		
		resultClass = (memberbean)sqlMapper.queryForObject("mypageMemberModify.modifyPass", paramClass);
		
		if(resultClass != null) {
			return SUCCESS;
		}else {
			checkPW = -1;
			return ERROR;
		}
	}
	
	
	// 정보수정
	public String execute() throws Exception{
		
		ActionContext context = ActionContext.getContext();
		session = context.getSession();

		// 시작 [비번 틀릴때 처리 form() 에 있던 내용 옮겨오기 - 동민]
		paramClass = new memberbean();
		resultClass = new memberbean();
		
		paramClass.setMember_no((int)session.get("session_member_no"));
		paramClass.setMember_pw(getMember_pw());
		
		resultClass = (memberbean)sqlMapper.queryForObject("mypageMemberModify.modifyPass", paramClass);
		
		if(resultClass == null) {
			checkPW = -1;
			return ERROR;
		}
		// 끝 [비번 틀릴때 처리 form() 에 있던 내용 옮겨오기 - 동민]
		
		
		
		paramClass2 = new memberbean();
		resultClass2 = new memberbean();
		
		member_no = (int)session.get("session_member_no");
		resultClass = (memberbean)sqlMapper.queryForObject("mypageMemberModify.selectOneMember",getMember_no());	
		
		/*member_email=getEmail1().concat("@");
		member_email=member_email.concat (getEmail2 ());*/
		
		member_email = getEmail1() + "@" +getEmail2();
		
		/*member_phone=getPhone1().concat(getPhone2());
		member_phone=member_phone.concat(getPhone3());*/
		
		member_phone=getPhone1() + getPhone2() + getPhone3();

		//수정할 항목 설정
		paramClass2.setMember_email(getMember_email());
		paramClass2.setMember_zipcode(getMember_zipcode());
		paramClass2.setMember_address1(getMember_address1());
		paramClass2.setMember_address2(getMember_address2());
		paramClass2.setMember_phone(getMember_phone());
		paramClass2.setMember_no(getMember_no());
		
		// 일단 항목만 수정한다.
		System.out.println(getMember_zipcode());
		sqlMapper.update("mypageMemberModify.updateMember",paramClass2);
		
		//수정이 끝나면 view페이지로 이동
		resultClass2 = (memberbean) sqlMapper.queryForObject("mypageMemberModify.selectOneMember", getMember_no());
		
		checkPW = 1;
		return SUCCESS;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		InfoModifyAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		InfoModifyAction.sqlMapper = sqlMapper;
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

	public memberbean getParamClass2() {
		return paramClass2;
	}

	public void setParamClass2(memberbean paramClass2) {
		this.paramClass2 = paramClass2;
	}

	public memberbean getResultClass2() {
		return resultClass2;
	}

	public void setResultClass2(memberbean resultClass2) {
		this.resultClass2 = resultClass2;
	}

	public int getCheckPW() {
		return checkPW;
	}

	public void setCheckPW(int checkPW) {
		this.checkPW = checkPW;
	}
	
}
