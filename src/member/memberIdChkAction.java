package member;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import java.io.IOException;
import java.io.Reader;

public class memberIdChkAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private memberbean resultClass;
	private String id;
	private int chkId;
	
	public memberIdChkAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception{
		resultClass = (memberbean)sqlMapper.queryForObject("getMember",getId());
		
		if(resultClass == null){
			return ERROR;
		}
		return SUCCESS;
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
	public int getChkId() {
		return chkId;
	}
	public void setChkId(int chkId) {
		this.chkId = chkId;
	}
}
