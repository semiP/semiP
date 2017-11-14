package member;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

public class DeleteAction extends ActionSupport {

	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private memberbean paramClass;
	private memberbean resultClass;
	private String id;
	private String passwd;
	private int deleteChk;
	private Map session;
	
	public DeleteAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception{
		paramClass = new memberbean();
		resultClass = new memberbean();
		
		id = ActionContext.getContext().getSession().get("session_member_id").toString();
		resultClass = (memberbean)sqlMapper.queryForObject("getMember",getId());
		
		if(resultClass.getmember_pw().equals(passwd)){
			deleteChk = 1;
			paramClass.setmember_id(getId());
			sqlMapper.update("deleteMember",paramClass);
			ActionContext.getContext().getSession().clear();
		}else{
			deleteChk = -1;
		}
		return SUCCESS;
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

	public int getDeleteChk() {
		return deleteChk;
	}

	public void setDeleteChk(int deleteChk) {
		this.deleteChk = deleteChk;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}
	
}
