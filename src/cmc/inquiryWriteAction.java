package cmc;

import com.opensymphony.xwork2.ActionSupport;

//import cmc.inquiryVO; ��� ���Ƽ� ���� �ʿ����
//�̿ϼ�

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import org.apache.struts2.interceptor.SessionAware;

import java.util.*;
import java.io.IOException;
import java.io.Reader;

public class inquiryWriteAction extends ActionSupport implements SessionAware {
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private inquiryVO paramClass;
	private inquiryVO resultClass;
	
	private int currentPage;
	
	private int inquiry_no;
	private int inquiry_category;
	private String inquiry_subject;
	private String inquiry_content;
	private String inquiry_email;
	private String inquiry_addfile;
	//���߿� ������ �ҋ�(�޸��忡 �ҽ� �־��)
	private Map session;
	
	public inquiryWriteAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
//	�α����ϰ� ���� ����Ʈ���� ������ 2���� ����ϴٰ� ������������ �α׾ƿ��ϸ� �ٸ� ���������� ��ǰ���� �� �� �α���â���� �Ѱܹ���
	public String form() throws Exception{
		if(session.get("session_member_id") == null){
			return LOGIN;
		}
		return SUCCESS;
	}
	
	public inquiryVO getParamClass() {
		return paramClass;
	}
	public void setParamClass(inquiryVO paramClass) {
		this.paramClass = paramClass;
	}
	public inquiryVO getResultClass() {
		return resultClass;
	}
	public void setResultClass(inquiryVO resultClass) {
		this.resultClass = resultClass;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getInquiry_no() {
		return inquiry_no;
	}
	public void setInquiry_no(int inquiry_no) {
		this.inquiry_no = inquiry_no;
	}
	public int getInquiry_category() {
		return inquiry_category;
	}
	public void setInquiry_category(int inquiry_category) {
		this.inquiry_category = inquiry_category;
	}
	public String getInquiry_subject() {
		return inquiry_subject;
	}
	public void setInquiry_subject(String inquiry_subject) {
		this.inquiry_subject = inquiry_subject;
	}
	public String getInquiry_content() {
		return inquiry_content;
	}
	public void setInquiry_content(String inquiry_content) {
		this.inquiry_content = inquiry_content;
	}
	public String getInquiry_email() {
		return inquiry_email;
	}
	public void setInquiry_email(String inquiry_email) {
		this.inquiry_email = inquiry_email;
	}
	public String getInquiry_addfile() {
		return inquiry_addfile;
	}
	public void setInquiry_addfile(String inquiry_addfile) {
		this.inquiry_addfile = inquiry_addfile;
	}
	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}
	
}
