package goods;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.File;
import java.io.Reader;
import java.util.Date;
import java.io.IOException;

public class goodsDeleteAction extends ActionSupport{
	public static Reader reader; //파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper; //SqlMapClient API를 사용하기 위한 sqlMapper 객체.
	
	private goodsVO paramClass; //파라미터를 저장할 객체
	private goodsVO resultClass; //쿼리 결과 값을 저장할 객체
	
	private int currentPage; //현재 페이지
	
	private String fileUploadPath = "E:\\java\\upload\\";
	
	private int goods_no;
	
	//생성자
	public goodsDeleteAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig_for_board2.xml"); //sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); //sqlMapConfig.xml 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}
	
	//게시글 글 삭제
	public String execute() throws Exception
	{
		//파라미터와 리절트 객체 생성.
		paramClass = new goodsVO();
		resultClass = new goodsVO();
		
		//해당 번호의 글을 가져온다.
		resultClass = (goodsVO) sqlMapper.queryForObject("selectOne", getGoods_no());
		
		//서버 파일 삭제
		File deleteFile = new File(fileUploadPath + resultClass.getGoods_image_file());
		deleteFile.delete();
		
		//삭제할 항목 설정.
		paramClass.setGoods_no(getGoods_no());
		
		//삭제 쿼리 수행.
		sqlMapper.update("deleteBoard", paramClass);
		
		return SUCCESS;
	}	
	
	public goodsVO getParamClass() { return paramClass; }
	public void setParamClass(goodsVO paramClass) { this.paramClass = paramClass; }
	
	public goodsVO getResultClass() { return resultClass; }
	public void setResultClass(goodsVO resultClass) { this.resultClass = resultClass; }
	
	public int getCurrentPage() { return currentPage; }
	public void setCurrentPage(int currentPage) { this.currentPage = currentPage; }
	
	public String getFileUploadPath() { return fileUploadPath; }
	public void setFileUploadPath(String fileUploadPath) { this.fileUploadPath = fileUploadPath; }
	
	public int getGoods_no() { return goods_no; }
	public void setGoods_no (int goods_no) { this.goods_no = goods_no; }
	
}
