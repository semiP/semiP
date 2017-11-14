package order;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.File;
import java.io.Reader;
import java.io.IOException;

import order.orderVO;

public class orderDeleteAction extends ActionSupport{
	public static Reader reader; //파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper; //SqlMapClient API를 사용하기 위한 sqlMapper 객체.
	
	private orderVO paramClass; //파라미터를 저장할 객체
	private orderVO resultClass; //쿼리 결과 값을 저장할 객체
	
	private int currentPage; //현재 페이지
	
	private String fileUploadPath = "E:\\java\\upload\\";
	
	private int order_no;         //주문 번호
	
	//생성자
	public orderDeleteAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); //sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); //sqlMapConfig.xml 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}
	
	//주문내역 삭제 (admin용) - 주문완료후 (수경 - 주문내역) 
	public String execute() throws Exception
	{
		//파라미터와 리절트 객체 생성.
		paramClass = new orderVO();
		resultClass = new orderVO();
		
		//해당 번호의 주문을 가져온다.
		resultClass = (orderVO) sqlMapper.queryForObject("selectOne", getOrder_no());
		
//		File deleteFile = new File(fileUploadPath + resultClass.getFile_savname());
//		deleteFile.delete();
		
		//삭제할 항목 설정.
		paramClass.setOrder_no(getOrder_no());
		
		//삭제 쿼리 수행.
		sqlMapper.update("deleteBoard", paramClass);
		
		return SUCCESS;
	}

	public orderVO getParamClass() { return paramClass; }
	public void setParamClass(orderVO paramClass) { this.paramClass = paramClass; }
	
	public orderVO getResultClass() { return resultClass; }
	public void setResultClass(orderVO resultClass) { this.resultClass = resultClass; }
	
	public int getCurrentPage() { return currentPage; }
	public void setCurrentPage(int currentPage) { this.currentPage = currentPage; }
	
	public String getFileUploadPath() { return fileUploadPath; }
	public void setFileUploadPath(String fileUploadPath) { this.fileUploadPath = fileUploadPath; }

	public int getOrder_no() { return order_no; }
	public void setOrder_no(int order_no) { this.order_no = order_no; }
	
}
