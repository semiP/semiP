package member;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;

import java.io.Reader;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class memberendAction extends ActionSupport implements Preparable,ModelDriven{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private static final long serialVersionUID = 1L;
	memberbean paramClass;
	
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
	
	// 생성자
	public memberendAction() throws Exception{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception{
		
		paramClass = new memberbean();
		paramClass.setMember_no(member_no);
		paramClass.setMember_name(member_name);
		paramClass.setMember_id(member_id);
		paramClass.setMember_pw(member_pw);
		paramClass.setMember_zipcode(member_zipcode);
		paramClass.setMember_address1(member_address1);
		paramClass.setMember_address2(member_address2);
		paramClass.setMember_phone(member_phone);
		paramClass.setMember_email(member_email);
		paramClass.setMember_regdate(member_regdate);
		paramClass.setMember_level(member_level);
		paramClass.setMember_deletereason(member_deletereason);
		
		
		sqlMapper.insert("mypage.insertlogin",paramClass);
		
		return SUCCESS;
	}
	
	public String getMember_deletereason() {
		return member_deletereason;
	}

	public void setMember_deletereason(String member_deletereason) {
		this.member_deletereason = member_deletereason;
	}

	
	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		memberendAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		memberendAction.sqlMapper = sqlMapper;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setParamClass(memberbean paramClass) {
		this.paramClass = paramClass;
	}
	
	public memberbean getParamClass(){
		return paramClass;
	}
	
	public void prepare() throws Exception{
		paramClass = new memberbean();
	}
	public memberbean getModel(){
		return paramClass;
	}
}