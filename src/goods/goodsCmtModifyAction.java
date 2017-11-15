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
	public static Reader reader; //파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper; //SqlMapClient API를 사용하기 위한 sqlMapper 객체.
	
	private goodsCmtVO paramClass; //파라미터를 저장할 객체
	private goodsCmtVO resultClass; //쿼리 결과 값을 저장할 객체
	
	private int currentPage; //현재 페이지
	
	private int goods_cmt_no;
	private String goods_cmt_subject;
	private String goods_cmt_id;
	private String goods_cmt_pw;
	private String goods_cmt_content;
	private String goods_cmt_image;
	private int goods_cmt_score;
	private String old_file;
	
	private File upload; //파일 객체
	private String uploadContentType; //컨텐츠 타입
	private String uploadFileName; //파일 이름
	private String fileUploadPath = "E:\\java\\upload\\"; //업로드 경로.
	
	//생성자
	public goodsCmtModifyAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); //sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); //sqlMapConfig.xml 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}
	
	//게시글 수정
	public String execute() throws Exception
	{
		//파라미터와 리절트 객체 생성.
		paramClass = new goodsCmtVO();
		resultClass = new goodsCmtVO();
		
		//수정할 항목 설정.
		paramClass.setGoods_cmt_no(getGoods_cmt_no());
		paramClass.setGoods_cmt_pw(getGoods_cmt_pw());
		paramClass.setGoods_cmt_subject(getGoods_cmt_subject());
		paramClass.setGoods_cmt_id(getGoods_cmt_id());
		paramClass.setGoods_cmt_score(getGoods_cmt_score());
		paramClass.setGoods_cmt_content(getGoods_cmt_content());
		
		//일단 항목만 수정한다.
		sqlMapper.update("updateBoard", paramClass);
		
		//수정할 파일이 업로드 되었다면 파일을 업로드하고 DB의 file 항목을 수정함.
		if(getUpload() != null)
		{
			//실제 서버에 저장될 파일 이름과 확장자 설정.
			String file_name = "file_" + getGoods_cmt_no();
			String file_ext = getUploadFileName().substring(getUploadFileName().lastIndexOf('.')+1,getUploadFileName().length());
			
			//이전 파일 삭제
			File deleteFile = new File(fileUploadPath + getOld_file());
			deleteFile.delete();
			
			//새 파일 업로드
			File destFile = new File(fileUploadPath + file_name + "." + file_ext);
			FileUtils.copyFile(getUpload(), destFile);
			
			//파일 정보 파라미터 설정.
			paramClass.setGoods_cmt_image(getUploadFileName());
			paramClass.setGoods_cmt_image(file_name + "." + file_ext);
			
			//파일 정보 업데이터.
			sqlMapper.update("updateFile", paramClass);
		}
		
		//수정이 끝나면 view 페이지로 이동.
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
