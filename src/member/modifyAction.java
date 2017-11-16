package member;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;

public class modifyAction extends ActionSupport implements SessionAware{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private memberbean paramClass;
	private memberbean resultClass;
	
	private String id;
	private String passwd;
	private String name;
	private String zipcode;
	private String addr1;
	private String addr2;
	private String phone;
	private String email;
	private Map session;
	
	public modifyAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception{
		if(session.get("session_member_id") == null){
			return LOGIN;
		}
		
		paramClass = new memberbean();
		resultClass = new memberbean();
		ActionContext context = ActionContext.getContext();
		Map<String,Object> session = context.getSession();
		
		if(session.size() > 0){
			String id = (String)session.get("id");
			resultClass = (memberbean)sqlMapper.queryForObject("getMember",id);
			//System.out.println(getId()+ getName() + getZipcode() + getAddr1() + 123);
			paramClass.setMember_id(getId());
			paramClass.setMember_name(getName());
			paramClass.setMember_zipcode(getzipcode());
			paramClass.setMember_address1(getAddr1());
			paramClass.setMember_address2(getAddr2());
			paramClass.setMember_phone(getPhone());
			paramClass.setMember_pw(getPasswd());
			
			sqlMapper.update("updateMember",paramClass);
			return SUCCESS;
		}else{
			return INPUT;
		}
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}
	public String getzipcode() {
		return zipcode;
	}
	public void setzipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}
