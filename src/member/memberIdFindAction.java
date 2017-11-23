package member;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class memberIdFindAction extends ActionSupport {

	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private memberbean paramClass;
	private memberbean resultClass;
	
	private String name;
	private String email;		
	
	public memberIdFindAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); //sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); //sqlMapConfig.xml ������ ������ sqlMapper ��ü ����
		reader.close();
	}
	
	public String form() throws Exception {
		return SUCCESS;
	}
	
	public String execute() throws Exception {
		
		paramClass = new memberbean();
		paramClass.setMember_name(name);
		paramClass.setMember_email(email);
		resultClass = new memberbean();
		
	
		resultClass = (memberbean) sqlMapper.queryForObject("mypage.select-login-id", paramClass); //쿼리문 수정
		
		if(resultClass == null) {
			return ERROR;
		}
		else {
			if(resultClass.getMember_email().equals(email) && resultClass.getMember_name().equals(name)) {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}

