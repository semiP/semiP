package mypage.memberModify;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Date;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import mypage.memberBean;

public class viewAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private memberBean paramClass;
	private memberBean paramClass1;
	private memberBean paramClass2;

	private memberBean resultClass;
	private memberBean resultClass1;
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
	
	private InputStream inputStream;
	
	/*private Map session;*/
	
	// 생성자
	public viewAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져옴
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper객체 생성
		reader.close();
	}
	
	// 비밀번호 체크 폼으로 이동
	public String checkForm() throws Exception{
		return SUCCESS;
	}
	
	// 비밀번호 체크 액션
	public String checkAction() throws Exception{
		// 비밀번호 입력값 파라미터 설정
		paramClass1.setMember_no(getMember_no());
		paramClass1.setMember_pw(getMember_pw());
		
		// 현재 글의 비밀번호 가져오기
		resultClass1 = (memberBean) sqlMapper.queryForObject("mypage.pwCheck",paramClass1);
		
		// 입력한 비밀번호가 틀리면 ERROR리턴
		if(resultClass1 == null) return ERROR;
		
		return SUCCESS;
	}
	
	// 비밀번호 확인 후 맞을시 수정폼 이동 아닐 시 에러페이지
	public String form() throws Exception{
		paramClass2 = new memberBean(); // 파라미터를 저장할 객체
		resultClass2 = new memberBean(); // 쿼리 결과 값을 저장할 객체
		
		// session 얻어오기(ServletActionContext, ActionContext => getContext()메서드를 갖고 있음) < 클라이언트와 웹서버 간 네트워크 연결이 지속 유지되고 있는 상태
				ActionContext context = ActionContext.getContext(); 
				Map session = context.getSession();
				
				String session_member_no = (String) session.get("session_member_no");
				paramClass2.setMember_pw(member_pw);
				paramClass2.setMember_id(member_id);
				
				resultClass2 = (memberBean)sqlMapper.queryForObject("mypage.selectOneMember",paramClass2);
				
				if(resultClass2 != null){
					/*checkPass = 1;*/
					return SUCCESS;
				}
				else{
					/*checkPass = 0;*/
					return ERROR;
				}
		}
			
			// 수정내용처리
			public String execute() throws Exception{
				ActionContext context = ActionContext.getContext();
				/*session = context.getSession();
				
				if(session.get("session_id")==null) {
					return LOGIN;
				}
				
				String session_member_no = (String)session.get("session_member_no");*/
				paramClass = new memberBean();
				/*paramClass.setMember_id(session_member_no);*/
				paramClass.setMember_email(getMember_email());
				paramClass.setMember_zipcode(getMember_zipcode());
				paramClass.setMember_address1(getMember_address1());
				paramClass.setMember_address2(getMember_address2());
				paramClass.setMember_phone(getMember_phone());
				paramClass.setMember_pw(getMember_pw());
				paramClass.setMember_no(getMember_no());
		
				sqlMapper.update("updateMember",paramClass);
				
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

			public InputStream getInputStream() {
				return inputStream;
			}

			public void setInputStream(InputStream inputStream) {
				this.inputStream = inputStream;
			}

			/*public Map getSession() {
				return session;
			}

			public void setSession(Map session) {
				this.session = session;
			}
			*/
			
		} 
