package goods;

import com.opensymphony.xwork2.ActionSupport;

import goods.goodsVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class goodsWriteAction extends ActionSupport{
	
	public static Reader reader; //파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper; //SqlMapClient API를 사용하기 위한 sqlMapper 객체.
	
	private goodsVO paramClass; //파라미터를 저장할 객체
	private goodsVO resultClass; //쿼리 결과 값을 저장할 객체
	
    private int currentPage;
	
	private int goods_no;
	private String goods_name;
	private String goods_category;
	private String goods_size;
	private String goods_color;
	private String goods_content;
	private int goods_amount;
	private int goods_price;
	private String goods_image_file;  //파일 원래 이름
	Calendar today = Calendar.getInstance(); //오늘 날짜 구하기.
	
	private File upload; //파일 객체
	private String uploadContentType; //컨텐츠 타입
	private String uploadFileName; //파일 이름
	private String fileUploadPath = "E:\\java\\upload\\"; //업로드 경로.
	
	//생성자
	public goodsWriteAction() throws IOException
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
	
	//상품상세보기 WRITE 액션
	public String execute() throws Exception
	{
		//파라미터와 리절트 객체 생성.
		paramClass = new goodsVO();
		resultClass = new goodsVO();
			
		//등록할 항목 설정.
		paramClass.setGoods_name(getGoods_name());				  //상품 이름
		paramClass.setGoods_category(getGoods_category());        //상품 카테고리
		paramClass.setGoods_size(getGoods_size());				  //상품 사이즈
		paramClass.setGoods_color(getGoods_color());              //상품 컬러
		paramClass.setGoods_content(getGoods_content());		  //상품 내용
		paramClass.setGoods_amount(getGoods_amount());            //상품 수량
		paramClass.setGoods_price(getGoods_price());			  //상품 가격
		paramClass.setGoods_date(today.getTime());				  //상품 등록날짜
		
		//등록 쿼리 수행.
		sqlMapper.insert("goodsBoard", paramClass);
			
		//첨부파일을 선택했다면 파일을 업로드한다. (상품 파일명)
		if(getUpload() != null)
		{
			//등록한 글 번호 가져오기.
			resultClass = (goodsVO) sqlMapper.queryForObject("selectLastNo");
			
			//실제 서버에 저장될 파일 이름과 확장자 설정.
			String file_name = "file_" + resultClass.getGoods_no();
			String file_ext = getUploadFileName().substring(
							getUploadFileName().lastIndexOf('.') + 1,
							getUploadFileName().length());
			
			//서버에 파일 저장.
			File destFile = new File(fileUploadPath + file_name + "."
							+ file_ext);
			FileUtils.copyFile(getUpload(), destFile);
			
			//파일 정보 파라미터 설정.
			paramClass.setGoods_no(resultClass.getGoods_no());
			paramClass.setGoods_image_file(getUploadFileName()); //원래 파일 이름
			paramClass.setGoods_image_file(file_name + "." + file_ext); //서버에 저장한 파일 이름
		    
			//파일 정보 업데이트.
			sqlMapper.update("fileDownloadAction", paramClass);
		}
			
		return SUCCESS;
	}
	
	public goodsVO getParamClass() { return paramClass; }
	public void setParamClass(goodsVO paramClass) { this.paramClass = paramClass; }
	
	public goodsVO getResultClass() { return resultClass; }
	public void setResultClass(goodsVO resultClass) { this.resultClass = resultClass; }
	
	public int getCurrentPage() { return currentPage; }
	public void setCurrentPage(int currentPage) { this.currentPage = currentPage; }

	public int getGoods_no() { return goods_no; }
	public void setGoods_no (int goods_no) { this.goods_no = goods_no; }
	
	public String getGoods_name() { return goods_name; }
	public void setGoods_name(String goods_name) { this.goods_name = goods_name; }
	
	public String getGoods_category() { return goods_category; }
	public void setGoods_category(String goods_category) { this.goods_category = goods_category; }
	
	public String getGoods_size() { return goods_size; }
	public void setGoods_size(String goods_size) { this.goods_size = goods_size; }
	
	public String getGoods_color() { return goods_color; }
	public void setGoods_color(String goods_color) { this.goods_color = goods_color; }
	
	public String getGoods_content() { return goods_content; }
	public void setGoods_content(String goods_content) { this.goods_content = goods_content; }
	
	public int getGoods_amount() { return goods_amount; }
	public void setGoods_amount(int goods_amount) { this.goods_amount = goods_amount; }
	
	public int getGoods_price() { return goods_price; }
	public void setGoods_price(int goods_price) { this.goods_price = goods_price; }
	
	public String getGoods_image_file() { return goods_image_file; }
	public void setGoods_image_file(String goods_image_file) { this.goods_image_file = goods_image_file; }
	
	public Calendar getToday() { return today; }
	public void setToday(Calendar today) { this.today = today; }
	
	public File getUpload() { return upload; }
	public void setUpload(File upload) { this.upload = upload; }
	
	public String getUploadContentType() { return uploadContentType; }
	public void setUploadContentType(String uploadContentType) { this.uploadContentType = uploadContentType; }
	
	public String getUploadFileName() { return uploadFileName; }
	public void setUploadFileName(String uploadFileName) { this.uploadFileName = uploadFileName; }
	
	public String getFileUploadPath() { return fileUploadPath; }
	public void setFileUploadPath(String fileUploadPath) { this.fileUploadPath = fileUploadPath; }
	
}
