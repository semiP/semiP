package cmc;

import com.opensymphony.xwork2.ActionSupport;

//import cmc.inquiryVO; 경로 같아서 굳이 필요없음
//미완성

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
	//나중에 관리자 할떄(메모장에 소스 넣어둠)
	private Map session;
	
	public inquiryWriteAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
//	로그인하고 동일 사이트에서 페이지 2개로 사용하다가 한페이지에서 로그아웃하면 다른 페이지에서 상품문의 할 시 로그인창으로 넘겨버림
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
