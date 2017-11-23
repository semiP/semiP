package member;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;

import java.io.Reader;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class memberendAction extends ActionSupport {
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private static final long serialVersionUID = 1L;
	memberbean paramClass;
	
	private memberbean resultClass;
	private String name;
	private String id;
	private String passwd;
	private String zipcode;
	private String address1;
	private String address2;
	private String email;
	private String phone;
	private String tel1,tel2,tel3;
	private int level;
	private String deletereason;



	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getDeletereason() {
		return deletereason;
	}

	public void setDeletereason(String deletereason) {
		this.deletereason = deletereason;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	// 생성자
	public memberendAction() throws Exception{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception{
		
		phone = tel1+tel2+tel3;
		paramClass = new memberbean();
		paramClass.setMember_name(name);
		paramClass.setMember_id(id);
		paramClass.setMember_pw(passwd);
		paramClass.setMember_zipcode(zipcode);
		paramClass.setMember_address1(address1);
		paramClass.setMember_address2(address2);
		paramClass.setMember_phone(phone);
		paramClass.setMember_email(email);
		paramClass.setMember_level(level);
		paramClass.setMember_deletereason(deletereason);
		
		sqlMapper.insert("mypage.insertlogin",paramClass);
		
		
		return SUCCESS;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		memberendAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		memberendAction.sqlMapper = sqlMapper;
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



	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getTel3() {
		return tel3;
	}

	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel() {
		this.level = 1;
	}

	public String getdeletereason() {
		return deletereason;
	}

	public void setdeletereason() {
		this.deletereason = "";
	}

}