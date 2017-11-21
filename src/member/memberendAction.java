package member;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;

import java.io.Reader;
import java.sql.Timestamp;
import java.util.List;

public class memberendAction extends ActionSupport implements Preparable,ModelDriven{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private static final long serialVersionUID = 1L;
	memberbean paramClass;
	
	// 생성자
	public memberendAction() throws Exception{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception{
		sqlMapper.insert("insertMember",paramClass); //쿼리문수정
		return SUCCESS;
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
