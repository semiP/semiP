package goods;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class goodsCmtViewAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private goodsCmtVO paramClass = new goodsCmtVO(); //파라미터를 저장할 객체
	private goodsCmtVO resultClass = new goodsCmtVO(); //쿼리 결과 값을 저장할 객체
	
	private int currentPage;
	
	private int goods_cmt_no;            //글번호
	
	private String goods_cmt_pw;         //글비번
	
	private String fileUploadPath = "E:\\Java\\upload\\";
	
	private InputStream inputStream;
	private String contentDisposition;
	private long contentLength;
	
	//생성자
	public goodsCmtViewAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); //sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); //sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성
		reader.close();
	}
	
	//상세보기
	public String execute() throws Exception
	{
		//해당 번호의 글을 가져온다.
		resultClass = (goodsCmtVO) sqlMapper.queryForObject("selectOne", getGoods_cmt_no());
		
		return SUCCESS;
	}
	
	//비밀번호 체크 폼
	public String checkForm() throws Exception { return SUCCESS; }
	
	//비밀번호 체크 액션
	public String checkAction() throws Exception
	{
		//비밀번호 입력값 파라미터 설정.
		paramClass.setGoods_cmt_no(getGoods_cmt_no());
		paramClass.setGoods_cmt_pw(getGoods_cmt_pw());
		
		//현재 글의 비밀번호 가져오기.
		resultClass = (goodsCmtVO) sqlMapper.queryForObject("selectPassword", paramClass);
		
		//입력한 비밀번호가 틀리면 ERROR 리턴.
		if(resultClass == null) return ERROR;
		
		return SUCCESS;
	}

	public goodsCmtVO getParamClass() { return paramClass; }
	public void setParamClass(goodsCmtVO paramClass) { this.paramClass = paramClass; }
	
	public goodsCmtVO getResultClass() { return resultClass; }
	public void setResultClass(goodsCmtVO resultClass) { this.resultClass = resultClass; }
	
	public String getFileUploadPath() { return fileUploadPath; }
	public void setFileUploadPath(String fileUploadPath) { this.fileUploadPath = fileUploadPath; }
	
	public InputStream getInputStream() { return inputStream; }
	public void setInputStream(InputStream inputStream) { this.inputStream = inputStream; }
	
	public String getContentDisposition() { return contentDisposition; }
	public void setContentDisposition(String contentDisposition) { this.contentDisposition = contentDisposition; }
	
	public long getContentLength() { return contentLength; }
	public void setContentLength(long contentLength) { this.contentLength = contentLength; }
	
	public int getCurrentPage() { return currentPage; }
	public void setCurrentPage(int currentPage) { this.currentPage = currentPage; }
	
	public int getGoods_cmt_no() { return goods_cmt_no; }
	public void setGoods_cmt_no(int goods_cmt_no) { this.goods_cmt_no = goods_cmt_no; }
	
	public String getGoods_cmt_pw() { return goods_cmt_pw; }
	public void setGoods_cmt_pw(String goods_cmt_pw) { this.goods_cmt_pw = goods_cmt_pw; }
	
}
