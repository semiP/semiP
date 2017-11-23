package mypage;


//�亯�ޱ�. �亯����.����. ���� ������ ������ �� ��� �߰�(���� ����Ʈ ��ɸ�)
import com.opensymphony.xwork2.ActionSupport;

//import cmc.inquiryVO; ��� ���Ƽ� ���� �ʿ����

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import org.apache.struts2.interceptor.SessionAware;

import java.util.*;
import java.io.IOException;
import java.io.Reader;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class inqWriteAction extends ActionSupport implements SessionAware {
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private mypage.inquiryVO paramClass;
	private mypage.inquiryVO resultClass;

	private int currentPage;

	private int inquiry_no;
	private int inquiry_category;
	private String inquiry_subject;
	private String inquiry_content;
	private Date inquiry_regdate;
	private String inquiry_addfile;
	private Map session;
	
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String fileUploadPath = "C:\\Java\\upload\\";

	public inqWriteAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}

	// �α����ϰ� ���� ����Ʈ���� ������ 2���� ����ϴٰ� ������������ �α׾ƿ��ϸ� �ٸ�
	// ���������� ��ǰ���� �� �� �α���â���� �Ѱܹ���
	public String form() throws Exception {
		if (session.get("session_member_id") == null) {
			return LOGIN;
		}
		return SUCCESS;
	}


	public String execute() throws Exception {

		paramClass = new mypage.inquiryVO();
		resultClass = new mypage.inquiryVO();

		paramClass.setInquiry_no(getInquiry_no());
		paramClass.setInquiry_category(getInquiry_category());
		paramClass.setInquiry_subject(getInquiry_subject());
		paramClass.setInquiry_content(getInquiry_content());
		paramClass.setInquiry_regdate(getInquiry_regdate());
		paramClass.setInquiry_addfile(getInquiry_addfile());
		

		sqlMapper.insert("inq.insert", paramClass);
		
		if (getUpload() != null) {

			//등록한 글 번호 가져오기.
			resultClass = (inquiryVO) sqlMapper.queryForObject("inq.selectLastNo");

			//실제 서버에 저장될 파일 이름과 확장자 설정.
			String file_name = "file_" + resultClass.getInquiry_no();
			String file_ext = getUploadFileName().substring(
					getUploadFileName().lastIndexOf('.') + 1,
					getUploadFileName().length());

			//서버에 파일 저장.
			File destFile = new File(fileUploadPath + file_name + "."
					+ file_ext);
			FileUtils.copyFile(getUpload(), destFile);
		}

		return SUCCESS;
	}
	

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
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

	public mypage.inquiryVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(mypage.inquiryVO paramClass) {
		this.paramClass = paramClass;
	}

	public mypage.inquiryVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(mypage.inquiryVO resultClass) {
		this.resultClass = resultClass;
	}

	public Date getInquiry_regdate() {
		return inquiry_regdate;
	}

	public void setInquiry_regdate(Date inquiry_regdate) {
		this.inquiry_regdate = inquiry_regdate;
	}



}
