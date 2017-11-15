package order;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.util.Calendar;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class orderModifyAction extends ActionSupport{
	public static Reader reader; //파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper; //SqlMapClient API를 사용하기 위한 sqlMapper 객체.
	
	private orderVO paramClass; //파라미터를 저장할 객체
	private orderVO resultClass; //쿼리 결과 값을 저장할 객체
	
	private int currentPage; //현재 페이지
	
	private int order_no;
	private int order_status;
	
	/*
	private File upload; //파일 객체
	private String uploadContentType; //컨텐츠 타입
	private String uploadFileName; //파일 이름
	private String fileUploadPath = "E:\\java\\upload\\"; //업로드 경로.
	*/
	
	//생성자
	public orderModifyAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig_for_board2.xml"); //sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); //sqlMapConfig.xml 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}
	
	//주문내역 수정 (admin)
	public String execute() throws Exception
	{
		//파라미터와 리절트 객체 생성.
		paramClass = new orderVO();
		resultClass = new orderVO();
		
		//수정할 항목 설정.
		paramClass.setOrder_status(getOrder_status());

		//일단 항목만 수정한다.
		sqlMapper.update("updateBoard", paramClass);
		
		//수정할 파일이 업로드 되었다면 파일을 업로드하고 DB의 file 항목을 수정함.
		/*
		if(getUpload() != null)
		{
			//실제 서버에 저장될 파일 이름과 확장자 설정.
			String file_name = "file_" + getOrder_no();
			String file_ext = getUploadFileName().substring(getUploadFileName().lastIndexOf('.')+1,getUploadFileName().length());
			
			//이전 파일 삭제
			File deleteFile = new File(fileUploadPath + getOld_file());
			deleteFile.delete();
			
			//새 파일 업로드
			File destFile = new File(fileUploadPath + file_name + "." + file_ext);
			FileUtils.copyFile(getUpload(), destFile);
			
			//파일 정보 파라미터 설정.
			paramClass.setFile_orgname(getUploadFileName());
			paramClass.setFile_savname(file_name + "." + file_ext);
			
			//파일 정보 업데이터.
			sqlMapper.update("updateFile", paramClass);
		}
		*/
		
		//수정이 끝나면 view 페이지로 이동.
		resultClass = (orderVO) sqlMapper.queryForObject("selectOne", getOrder_no());
		
		return SUCCESS;
	}
	
	public orderVO getParamClass() { return paramClass; }
	public void setParamClass(orderVO paramClass) { this.paramClass = paramClass; }
	
	public orderVO getResultClass() { return resultClass; }
	public void setResultClass(orderVO resultClass) { this.resultClass = resultClass; }
	
	public int getOrder_status() { return order_status; }
	public void setOrder_status(int order_status) { this.order_status = order_status; }
	
	public int getOrder_no() { return order_no; }
	public void setOrder_no(int order_no) { this.order_no = order_no; }

}
