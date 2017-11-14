package goods;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.util.Calendar;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class goodsModifyAction extends ActionSupport{
	public static Reader reader; //파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper; //SqlMapClient API를 사용하기 위한 sqlMapper 객체.
	
	private goodsVO paramClass; //파라미터를 저장할 객체
	private goodsVO resultClass; //쿼리 결과 값을 저장할 객체
	
	private int currentPage; //현재 페이지
	
	private int goods_no;
	private String goods_name;
	private String goods_category;
	private String goods_size;
	private String goods_color;
	private String goods_content;
	private int goods_amount;
	private int goods_price;
	private String goods_image_file;
	private String old_file;
	Calendar today = Calendar.getInstance(); //오늘 날짜 구하기.
	
	private File upload; //파일 객체
	private String uploadContentType; //컨텐츠 타입
	private String uploadFileName; //파일 이름
	private String fileUploadPath = "E:\\java\\upload\\"; //업로드 경로.
	
	//생성자
	public goodsModifyAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig_for_board2.xml"); //sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); //sqlMapConfig.xml 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}
	
	//게시글 수정
	public String execute() throws Exception
	{
		//파라미터와 리절트 객체 생성.
		paramClass = new goodsVO();
		resultClass = new goodsVO();
		
		//수정할 항목 설정.
		paramClass.setGoods_no(getGoods_no());      //상품 번호
		paramClass.setGoods_name(getGoods_name());  //상품 이름
		paramClass.setGoods_category(getGoods_category());  //상품 카테고리
		paramClass.setGoods_size(getGoods_size());       //상품 사이즈
		paramClass.setGoods_color(getGoods_color());     //상품 컬러
		paramClass.setGoods_amount(getGoods_amount());   //상품 수량
		paramClass.setGoods_content(getGoods_content()); //상품 설명
		paramClass.setGoods_price(getGoods_price());     //상품 가격
		
		//일단 항목만 수정한다.
		sqlMapper.update("updateBoard", paramClass);
		
		//수정할 파일이 업로드 되었다면 파일을 업로드하고 DB의 file 항목을 수정함.
		if(getUpload() != null)
		{
			//실제 서버에 저장될 파일 이름과 확장자 설정.
			String file_name = "file_" + getGoods_no();
			String file_ext = getUploadFileName().substring(getUploadFileName().lastIndexOf('.')+1,getUploadFileName().length());
			
			//이전 파일 삭제
			File deleteFile = new File(fileUploadPath + getOld_file());
			deleteFile.delete();
			
			//새 파일 업로드
			File destFile = new File(fileUploadPath + file_name + "." + file_ext);
			FileUtils.copyFile(getUpload(), destFile);
			
			//파일 정보 파라미터 설정.
			paramClass.setGoods_image_file(getUploadFileName());
			paramClass.setGoods_image_file(file_name + "." + file_ext);
			
			//파일 정보 업데이터.
			sqlMapper.update("updateFile", paramClass);
		}
		
		//수정이 끝나면 view 페이지로 이동.
		resultClass = (goodsVO) sqlMapper.queryForObject("selectOne", getGoods_no());
		
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
	
	public String getOld_file() { return old_file; }
	public void setOld_file(String oldFile) { old_file = oldFile; }
	
	public File getUpload() { return upload; }
	public void setUpload(File upload) { this.upload = upload; }
	
	public String getUploadContentType() { return uploadContentType; }
	public void setUploadContentType(String uploadContentType) { this.uploadContentType = uploadContentType; }
	
	public String getUploadFileName() { return uploadFileName; }
	public void setUploadFileName(String uploadFileName) { this.uploadFileName = uploadFileName; }
	
	public String getFileUploadPath() { return fileUploadPath; }
	public void setFileUploadPath(String fileUploadPath) { this.fileUploadPath = fileUploadPath; }
	
	public Calendar getToday() { return today; }
	public void setToday(Calendar today) { this.today = today; }
}
