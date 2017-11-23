package mypage;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

import java.io.File;
import org.apache.commons.io.FileUtils;


public class inqWriteAction extends ActionSupport{
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private inquiryVO paramClass;
	private inquiryVO resultClass;

	
	private int currentPage;
	
	private int inquiry_no;
	private int inquiry_category;
	private String inquiry_subject;
	private String inquiry_content;
	private Date inquiry_regdate;
	private String inquiry_addfile;
	private String member_name;
	private Map session;
	
	Calendar today = Calendar.getInstance();
	
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String fileUploadPath="C:\\Java\\upload\\";
	
	
	public inqWriteAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();

	}
	
	public String form() throws Exception
	{
		return SUCCESS;
		
	}
	

	public String execute() throws Exception {
		
		paramClass = new inquiryVO();
		resultClass = new inquiryVO();
		/*if(ref == 0)
		{
			paramClass.setRe_step(0);
			paramClass.setRe_level(0);
		}
		else
		{
			paramClass.setRef(getRef());
			paramClass.setRe_step(getRe_step());
			sqlMapper.update("updateReplyStep", paramClass);
			
			paramClass.setRe_step(getRe_step() + 1);
			paramClass.setRe_level(getRe_level() + 1);
			paramClass.setRef(getRef());
		}*/
		paramClass.setInquiry_no(getInquiry_no());
		paramClass.setInquiry_category(getInquiry_category());
		paramClass.setInquiry_subject(getInquiry_subject());
		paramClass.setInquiry_content(getInquiry_content());
		paramClass.setInquiry_regdate(today.getTime());
		
		sqlMapper.insert("inq.insert", paramClass);
		
		if(getUpload() != null)
		{
			resultClass = (inquiryVO) sqlMapper.queryForObject("inq.selectLastNo");
			
			String file_name = "file_" + resultClass.getInquiry_no();
			String file_ext = getUploadFileName().substring(
					getUploadFileName().lastIndexOf('.') + 1,
					getUploadFileName().length()
					);
			
			File destFile = new File(fileUploadPath + file_name + "." + file_ext);
			FileUtils.copyFile(getUpload(), destFile);
			
			paramClass.setInquiry_no(resultClass.getInquiry_no());
			paramClass.setInquiry_addfile(getUploadFileName());
			
			sqlMapper.update("updateFile", paramClass);
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

	public Date getInquiry_regdate() {
		return inquiry_regdate;
	}

	public void setInquiry_regdate(Date inquiry_regdate) {
		this.inquiry_regdate = inquiry_regdate;
	}

	public String getInquiry_addfile() {
		return inquiry_addfile;
	}

	public void setInquiry_addfile(String inquiry_addfile) {
		this.inquiry_addfile = inquiry_addfile;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}


	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
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
	

}
