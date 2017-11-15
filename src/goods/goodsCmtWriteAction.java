package goods;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class goodsCmtWriteAction extends ActionSupport{
	
	public static Reader reader; //파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper; //SqlMapClient API를 사용하기 위한 sqlMapper 객체.
	
	private goodsCmtVO cmt_paramClass; //파라미터를 저장할 객체
	private goodsCmtVO cmt_resultClass; //쿼리 결과 값을 저장할 객체
	
	private int currentPage; //현재 페이지
	
	private int goods_cmt_no;            //글번호
	private String goods_cmt_pw;         //글비번
	private String goods_cmt_image;  //원래 파일 이름
	private int goods_cmt_score;      //평점
	private String goods_cmt_subject;    //글제목
	private String goods_cmt_id;       //작성자
	private String goods_cmt_content;    //내용
	Calendar today = Calendar.getInstance(); //오늘 날짜 구하기.
	
	private File upload; //파일 객체
	private String uploadContentType; //컨텐츠 타입
	private String uploadFileName; //파일 이름
	private String fileUploadPath = "E:\\java\\upload\\"; //업로드 경로.
	
	private int ref;
	private int re_step;
	private int re_level;
	
	boolean reply = false;
	
	//생성자
	public goodsCmtWriteAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig_for_board2.xml"); //sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); //sqlMapConfig.xml 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}
	
	public String form() throws Exception
	{
		//등록 폼.
		return SUCCESS;
	}
	
	public String reply() throws Exception
	{
		reply = true;
		cmt_resultClass = new goodsCmtVO();
		
		cmt_resultClass = (goodsCmtVO)sqlMapper.queryForObject("selectOne", getGoods_cmt_no());
		cmt_resultClass.setGoods_cmt_subject("[답변] " + cmt_resultClass .getGoods_cmt_subject());
		cmt_resultClass.setGoods_cmt_pw("");
		cmt_resultClass.setGoods_cmt_id("");
		cmt_resultClass.setGoods_cmt_content("");
		cmt_resultClass.setGoods_cmt_score(0);
		cmt_resultClass.setGoods_cmt_image(null);
		
		return SUCCESS;
	}
	
	//게시판 WRITE 액션
	public String execute() throws Exception
	{
		//파라미터와 리절트 객체 생성.
		cmt_paramClass = new goodsCmtVO();
		cmt_resultClass = new goodsCmtVO();
		
		if(ref == 0)
		{
			cmt_paramClass.setRe_step(0);
			cmt_paramClass.setRe_level(0);
		}
		else
		{
			cmt_paramClass.setRef(getRef());
			cmt_paramClass.setRe_step(getRe_step());
			sqlMapper.update("updateReplyStep", cmt_paramClass);
			
			cmt_paramClass.setRe_step(getRe_step() + 1);
			cmt_paramClass.setRe_level(getRe_level() + 1);
			cmt_paramClass.setRef(getRef());
		}
		
		//등록할 항목 설정.
		cmt_paramClass.setGoods_cmt_pw(getGoods_cmt_pw());
		cmt_paramClass.setGoods_cmt_subject(getGoods_cmt_subject());
		cmt_paramClass.setGoods_cmt_id(getGoods_cmt_id());
		cmt_paramClass.setGoods_cmt_image(getGoods_cmt_image());
		cmt_paramClass.setGoods_cmt_content(getGoods_cmt_content());
		cmt_paramClass.setGoods_cmt_score(getGoods_cmt_score());
		cmt_paramClass.setGoods_cmt_date(today.getTime());
		
		if(ref == 0)
		{
			//등록 쿼리 수행.
			sqlMapper.insert("insertBoard", cmt_paramClass);
		}
		else 
		{
			sqlMapper.insert("insertReplyBoard", cmt_paramClass);
		}
		
		//첨부파일을 선택했다면 파일을 업로드한다.
		if(getUpload() != null)
		{
			//등록한 글 번호 가져오기.
			cmt_resultClass = (goodsCmtVO) sqlMapper.queryForObject("selectLastNo");
			
			//실제 서버에 저장될 파일 이름과 확장자 설정.
			String file_name = "file_" + cmt_resultClass.getGoods_cmt_no();
			String file_ext = getUploadFileName().substring(
							getUploadFileName().lastIndexOf('.') + 1,
							getUploadFileName().length());
			
			//서버에 파일 저장.
			File destFile = new File(fileUploadPath + file_name + "."
							+ file_ext);
			FileUtils.copyFile(getUpload(), destFile);
			
			//파일 정보 파라미터 설정.
			cmt_paramClass.setGoods_cmt_no(cmt_resultClass.getGoods_cmt_no());
			cmt_paramClass.setGoods_cmt_image(getUploadFileName()); //원래 파일 이름
			cmt_paramClass.setGoods_cmt_image(file_name + "." + file_ext); //서버에 저장한 파일 이름
			
			//파일 정보 업데이트.
			sqlMapper.update("updateFile", cmt_paramClass);
		}
		
		return SUCCESS;
	}
	
	public Calendar getToday() { return today; }
	public void setToday(Calendar today) { this.today = today; }
	
	public goodsCmtVO getParamClass() { return cmt_paramClass; }
	public void setParamClass(goodsCmtVO cmt_paramClass) { this.cmt_paramClass = cmt_paramClass; }
	
	public goodsCmtVO getResultClass() { return cmt_resultClass; }
	public void setResultClass(goodsCmtVO cmt_resultClass) { this.cmt_resultClass = cmt_resultClass; }
	
	public File getUpload() { return upload; }
	public void setUpload(File upload) { this.upload = upload; }
	
	public String getUploadContentType() { return uploadContentType; }
	public void setUploadContentType(String uploadContentType) { this.uploadContentType = uploadContentType; }
	
	public String getUploadFileName() { return uploadFileName; }
	public void setUploadFileName(String uploadFileName) { this.uploadFileName = uploadFileName; }
	
	public String getFileUploadPath() { return fileUploadPath; }
	public void setFileUploadPath(String fileUploadPath) { this.fileUploadPath = fileUploadPath; }

	public boolean isReply() { return reply; }
	public void setReply(boolean reply) { this.reply = reply; }
	
	public int getGoods_cmt_no() { return goods_cmt_no; }
	public void setGoods_cmt_no(int goods_cmt_no) { this.goods_cmt_no = goods_cmt_no; }
	
	public String getGoods_cmt_pw() { return goods_cmt_pw; }
	public void setGoods_cmt_pw(String goods_cmt_pw) { this.goods_cmt_pw = goods_cmt_pw; }
	
	public String getGoods_cmt_image() { return goods_cmt_image; }
	public void setGoods_cmt_image(String goods_cmt_image) { this.goods_cmt_image = goods_cmt_image; }
	
	public int getGoods_cmt_score() { return goods_cmt_score; }
	public void setGoods_cmt_score(int goods_cmt_score) { this.goods_cmt_score = goods_cmt_score; }
	
	public String getGoods_cmt_subject() { return goods_cmt_subject; }
	public void setGoods_cmt_subject(String goods_cmt_subject) { this.goods_cmt_subject = goods_cmt_subject; }
	
	public String getGoods_cmt_id() { return goods_cmt_id; }
	public void setGoods_cmt_id(String goods_cmt_id) { this.goods_cmt_id = goods_cmt_id; }
	
	public String getGoods_cmt_content() { return goods_cmt_content; }
	public void setGoods_cmt_content(String goods_cmt_content) { this.goods_cmt_content = goods_cmt_content; }
	
	public int getRef() { return ref; }
	public void setRef(int ref) { this.ref = ref; }
	
	public int getRe_step() { return re_step; }
	public void setRe_step(int re_step) { this.re_step = re_step; }
	
	public int getRe_level() { return re_level; }
	public void setRe_level(int re_level) { this.re_level = re_level; }
	
}
