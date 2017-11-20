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
	
	public static Reader reader; //���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper; //SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.
	
	private goodsVO paramClass; //�Ķ���͸� ������ ��ü
	private goodsVO resultClass; //���� ��� ���� ������ ��ü
	
    private int currentPage;
	
	private int goods_no;
	private String goods_name;
	private String goods_category;
	private String goods_size;
	private String goods_color;
	private String goods_content;
	private int goods_amount;
	private int goods_price;
	private String goods_image_file;  //���� ���� �̸�
	Calendar today = Calendar.getInstance(); //���� ��¥ ���ϱ�.
	
	private File upload; //���� ��ü
	private String uploadContentType; //������ Ÿ��
	private String uploadFileName; //���� �̸�
	private String fileUploadPath = "E:\\java\\upload\\"; //���ε� ���.
	
	//������
	public goodsWriteAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); //sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); //sqlMapConfig.xml ������ ������ sqlMapper ��ü ����.
		reader.close();
	}
	
	public String form() throws Exception
	{
		//��� ��.
		return SUCCESS;
	}
	
	//��ǰ�󼼺��� WRITE �׼�
	public String execute() throws Exception
	{
		//�Ķ���Ϳ� ����Ʈ ��ü ����.
		paramClass = new goodsVO();
		resultClass = new goodsVO();
			
		//����� �׸� ����.
		paramClass.setGoods_name(getGoods_name());				  //��ǰ �̸�
		paramClass.setGoods_category(getGoods_category());        //��ǰ ī�װ�
		paramClass.setGoods_size(getGoods_size());				  //��ǰ ������
		paramClass.setGoods_color(getGoods_color());              //��ǰ �÷�
		paramClass.setGoods_content(getGoods_content());		  //��ǰ ����
		paramClass.setGoods_amount(getGoods_amount());            //��ǰ ����
		paramClass.setGoods_price(getGoods_price());			  //��ǰ ����
		paramClass.setGoods_date(today.getTime());				  //��ǰ ��ϳ�¥
		
		//��� ���� ����.
		sqlMapper.insert("goodsInsert", paramClass);
			
		//파일 업로드
		if(getUpload() != null)
		{
			resultClass = (goodsVO) sqlMapper.queryForObject("selectLastNo");
			
			String file_name = "file_" + resultClass.getGoods_no();
			String file_ext = getUploadFileName().substring(
							getUploadFileName().lastIndexOf('.') + 1,
							getUploadFileName().length());
			
			File destFile = new File(fileUploadPath + file_name + "."
							+ file_ext);
			FileUtils.copyFile(getUpload(), destFile);
			
			paramClass.setGoods_no(resultClass.getGoods_no());
			paramClass.setGoods_image_file(getUploadFileName()); //���� ���� �̸�
			paramClass.setGoods_image_file(file_name + "." + file_ext); //������ ������ ���� �̸�
		    
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
