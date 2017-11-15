package mypage.memberModify;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import mypage.memberBean;

public class modifyAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private memberBean paramClass;
	private memberBean resultClass;
	
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
	
	private Map session;
	
	//�깮�꽦�옄
	public modifyAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml �뙆�씪�쓽 �꽕�젙�궡�슜�쓣 媛��졇�삩�떎.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	// �쉶�썝�젙蹂� �닔�젙
	public String execute() throws Exception{
		// �뙆�씪誘명꽣�� 由ъ젅�듃 媛앹껜 �깮�꽦
		paramClass = new memberBean();
		resultClass = new memberBean();
		
		//�닔�젙�븷 �빆紐� �꽕�젙
		paramClass.setMember_no(member_no);
		paramClass.setMember_name(member_name);
		paramClass.setMember_email(member_email);
		paramClass.setMember_zipcode(member_zipcode);
		paramClass.setMember_address1(member_address1);
		paramClass.setMember_address2(member_address2);
		paramClass.setMember_phone(member_phone);
		paramClass.setMember_pw(member_pw);
		
		// �씪�떒 �빆紐⑸쭔 �닔�젙�븳�떎.
		sqlMapper.update("updateMember",paramClass);
		return SUCCESS;
	}
}
