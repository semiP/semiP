package member;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.io.Reader;
import java.util.Map;

public class loginAction extends ActionSupport implements SessionAware {

	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String passwd;
	private Map session;
	private memberbean paramClass = new memberbean();
	private memberbean resultClass = new memberbean();
	
	public loginAction() throws Exception{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String index() throws Exception{
		if(session.get("session_member_id") == null){
			return LOGIN;
		}else{
			return SUCCESS;
		}
	}
	public String execute() throws Exception{
		paramClass.setMember_id(id);
		paramClass.setMember_pw(passwd);
		
		resultClass = (memberbean)sqlMapper.queryForObject("select-login",paramClass);
		
		if(resultClass != null){
			session.put("session_member_id", resultClass.getMember_id());
			session.put("session_member_name", resultClass.getMember_name());
			session.put("session_member_no", resultClass.getMember_no());
			
			if(session.get("session_member_id").equals("admin1")){
				return "adminlog";
			}
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String logout() throws Exception{
		if(session.get("session_member_id") != null){
			session.remove("session_member_id");
			session.remove("session_member_name");
			session.remove("session_member_no");
		}
		return SUCCESS;
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

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}
	
}
