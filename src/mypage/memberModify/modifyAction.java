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
	
	//생성자
	public modifyAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	// 회원정보 수정
	public String execute() throws Exception{
		// 파라미터와 리절트 객체 생성
		paramClass = new memberBean();
		resultClass = new memberBean();
		
		//수정할 항목 설정
		paramClass.setMember_no(member_no);
		paramClass.setMember_name(member_name);
		paramClass.setMember_email(member_email);
		paramClass.setMember_zipcode(member_zipcode);
		paramClass.setMember_address1(member_address1);
		paramClass.setMember_address2(member_address2);
		paramClass.setMember_phone(member_phone);
		paramClass.setMember_pw(member_pw);
		
		// 일단 항목만 수정한다.
		sqlMapper.update("updateMember",paramClass);
		
		
		
		return null; //빨간줄 없애려고 임의로 넣은 return 입니다.
	}
}
