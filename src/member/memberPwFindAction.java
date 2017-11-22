package member;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class memberPwFindAction extends ActionSupport {

	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private memberbean paramClass;
	private memberbean resultClass;
	
	private String id;
	private String name;
	private String email;		
	
	public memberPwFindAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); //sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); //sqlMapConfig.xml ������ ������ sqlMapper ��ü ����
		reader.close();
	}
	
	public String form() throws Exception {
		return SUCCESS;
	}
	
	public String execute() throws Exception {
		
		paramClass = new memberbean();
		paramClass.setMember_id(id);
		paramClass.setMember_name(name);
		paramClass.setMember_email(email);
		resultClass = new memberbean();
		
	
		resultClass = (memberbean) sqlMapper.queryForObject("pwfind", paramClass); //쿼리문 바꾸기
		
		if(resultClass == null) {
			return ERROR;
		}
		else {
			if(resultClass.getMember_email()==(email) && resultClass.getMember_name()==(name) && resultClass.getMember_id()==(id)) {
				return SUCCESS;
			}
			else {
				return ERROR;
			}
		}
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		memberPwFindAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		memberPwFindAction.sqlMapper = sqlMapper;
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

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
}

