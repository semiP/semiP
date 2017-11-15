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
	private int jumin1;
	private int jumin2;
	private int memberPwFindChk;
		
	
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
		paramClass.setmember_id(id);
		paramClass.setmember_name(name);
		paramClass.setmember_email(email);
		resultClass = new memberbean();
		
	
		resultClass = (memberbean) sqlMapper.queryForObject("pwfind", paramClass);
		
		if(resultClass == null) {
			memberPwFindChk = 0; 
			return INPUT;
		}
		
		else {
			if(resultClass.getmember_email()==(email) && resultClass.getmember_name()==(name)) {
			
				memberPwFindChk = 1; 
				return SUCCESS;
			}
			else {
				memberPwFindChk = -1;
				return INPUT;
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

	public int getJumin1() {
		return jumin1;
	}

	public void setJumin1(int jumin1) {
		this.jumin1 = jumin1;
	}

	public int getJumin2() {
		return jumin2;
	}

	public void setJumin2(int jumin2) {
		this.jumin2 = jumin2;
	}

	public int getMemberPwFindChk() {
		return memberPwFindChk;
	}

	public void setMemberPwFindChk(int memberPwFindChk) {
		this.memberPwFindChk = memberPwFindChk;
	}


}

