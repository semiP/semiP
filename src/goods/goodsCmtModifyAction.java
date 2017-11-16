package goods;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.util.Calendar;
import java.util.Date;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class goodsCmtModifyAction extends ActionSupport{
	public static Reader reader; //���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper; //SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.
	
	private goodsCmtVO paramClass; //�Ķ���͸� ������ ��ü
	private goodsCmtVO resultClass; //���� ��� ���� ������ ��ü
	
	private int currentPage; //���� ������
	
	private int goods_cmt_no;
	private String goods_cmt_subject;
	private String goods_cmt_id;
	private String goods_cmt_pw;
	private String goods_cmt_content;
	private String goods_cmt_image;
	private int goods_cmt_score;
	private String old_file;
	
	private File upload; //���� ��ü
	private String uploadContentType; //������ Ÿ��
	private String uploadFileName; //���� �̸�
	private String fileUploadPath = "E:\\java\\upload\\"; //���ε� ���.
	
	//생성자
	public goodsCmtModifyAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); //sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); //sqlMapConfig.xml ������ ������ sqlMapper ��ü ����.
		reader.close();
	}
	
	public String execute() throws Exception
	{
		paramClass = new goodsCmtVO();
		resultClass = new goodsCmtVO();
		
		paramClass.setGoods_cmt_no(getGoods_cmt_no());
		paramClass.setGoods_cmt_pw(getGoods_cmt_pw());
		paramClass.setGoods_cmt_subject(getGoods_cmt_subject());
		paramClass.setGoods_cmt_id(getGoods_cmt_id());
		paramClass.setGoods_cmt_score(getGoods_cmt_score());
		paramClass.setGoods_cmt_content(getGoods_cmt_content());
		
		sqlMapper.update("updateBoard", paramClass);
		
		//파일 업로드
		if(getUpload() != null)
		{
			String file_name = "file_" + getGoods_cmt_no();
			String file_ext = getUploadFileName().substring(getUploadFileName().lastIndexOf('.')+1,getUploadFileName().length());
			
			File deleteFile = new File(fileUploadPath + getOld_file());
			deleteFile.delete();
			
			File destFile = new File(fileUploadPath + file_name + "." + file_ext);
			FileUtils.copyFile(getUpload(), destFile);
			
			paramClass.setGoods_cmt_image(getUploadFileName());
			paramClass.setGoods_cmt_image(file_name + "." + file_ext);
			
			sqlMapper.update("goodsCmtUpdate", paramClass);
		}
		
		resultClass = (goodsCmtVO) sqlMapper.queryForObject("selectOne", getGoods_cmt_no());
		
		return SUCCESS;
	}
	
	public goodsCmtVO getParamClass() { return paramClass; }
	public void setParamClass(goodsCmtVO paramClass) { this.paramClass = paramClass; }
	
	public goodsCmtVO getResultClass() { return resultClass; }
	public void setResultClass(goodsCmtVO resultClass) { this.resultClass = resultClass; }
	
	public File getUpload() { return upload; }
	public void setUpload(File upload) { this.upload = upload; }
	
	public String getUploadContentType() { return uploadContentType; }
	public void setUploadContentType(String uploadContentType) { this.uploadContentType = uploadContentType; }
	
	public String getUploadFileName() { return uploadFileName; }
	public void setUploadFileName(String uploadFileName) { this.uploadFileName = uploadFileName; }
	
	public String getFileUploadPath() { return fileUploadPath; }
	public void setFileUploadPath(String fileUploadPath) { this.fileUploadPath = fileUploadPath; }
	
	public int getCurrentpage() { return currentPage; }
	public void setCurrentPage(int currentPage) { this.currentPage = currentPage; }
	
	public int getGoods_cmt_no() { return goods_cmt_no; }
	public void setGoods_cmt_no(int goods_cmt_no) { this.goods_cmt_no = goods_cmt_no; }
	
	public String getGoods_cmt_pw() { return goods_cmt_pw; }
	public void setGoods_cmt_pw(String goods_cmt_pw) { this.goods_cmt_pw = goods_cmt_pw; }
	
	public String getGoods_cmt_id() { return goods_cmt_id; }
	public void setGoods_cmt_id(String goods_cmt_id) { this.goods_cmt_id = goods_cmt_id; }
	
	public String getGoods_cmt_image() { return goods_cmt_image; }
	public void setGoods_cmt_image(String goods_cmt_image) { this.goods_cmt_image = goods_cmt_image; }
	
	public int getGoods_cmt_score() { return goods_cmt_score; }
	public void setGoods_cmt_score(int goods_cmt_score) { this.goods_cmt_score = goods_cmt_score; }
	
	public String getGoods_cmt_subject() { return goods_cmt_subject; }
	public void setGoods_cmt_subject(String goods_cmt_subject) { this.goods_cmt_subject = goods_cmt_subject; }
	
	public String getGoods_cmt_content() { return goods_cmt_content; }
	public void setGoods_cmt_content(String goods_cmt_content) { this.goods_cmt_content = goods_cmt_content; }
	
	public String getOld_file() { return old_file; }
	public void setOld_file(String oldFile) { old_file = oldFile; }
	
}
