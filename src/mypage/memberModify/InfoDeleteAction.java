package mypage.memberModify;

import java.io.Reader;
import java.util.Date;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import member.memberbean;

public class InfoDeleteAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private memberbean paramClass;
	private memberbean resultClass;
	
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
	
	private Map session;
	
	//생성자
	public InfoDeleteAction() throws Exception{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	//회원탈퇴 전 비밀번호 체크
	public String checkPW() throws Exception{
		return SUCCESS;
	}
	
	//비밀번호 확인 후 SUCCESS시 회원탈퇴, Error시 passerror.jsp로 이동
	public String form() throws Exception{
		paramClass = new memberbean();
		resultClass = new memberbean();
		
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		
		String session_id = (String)session.get("session_member_id");
		int session_no = (int)session.get("session_member_no");
		String session_name = (String)session.get("session_member_name");
		
		paramClass.setMember_no(session_no);
		paramClass.setMember_id(session_id);
		
		resultClass = (memberbean)sqlMapper.queryForObject("mypageMemberModify.modifyPass", paramClass);
		
		if(resultClass != null) {
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
	
	public String execute() throws Exception{
		paramClass2 = new memberbean();
		resultClass2 = new memberbean();
		
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();

		/*로그인 값 얻어오기
		String session_id = (String)session.get("session_member_id");
		resultClass2 = (memberbean)sqlMapper.queryForObject("mypageMemberModify.UserCheck",session_id);*/
		
		paramClass2.setMember_deletereason(getMember_deletereason());
		sqlMapper.insert("mypageMemberModify.insertMemberDeleteReason",getMember_deletereason());
		
		paramClass2.setMember_level(getMember_level());
		sqlMapper.update("mypageMemberModify.updateMemberDelete",getMember_level());
		
		context.getSession().clear();
		return SUCCESS;
	}
	public static Reader getReader() {
		return reader;
	}
	public static void setReader(Reader reader) {
		InfoDeleteAction.reader = reader;
	}
	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}
	public static void setSqlMapper(SqlMapClient sqlMapper) {
		InfoDeleteAction.sqlMapper = sqlMapper;
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
	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}
	
	
}
