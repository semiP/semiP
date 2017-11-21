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
	public static Reader reader; //���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper; //SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.
	
	private goodsVO paramClass; //�Ķ���͸� ������ ��ü
	private goodsVO resultClass; //���� ��� ���� ������ ��ü
	
	private int currentPage; //���� ������
	
	private String fileUploadPath = "E:\\java\\upload\\";
	
	private int goods_no;
	
	//생성자
	public goodsDeleteAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig_for_board2.xml"); //sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); //sqlMapConfig.xml ������ ������ sqlMapper ��ü ����.
		reader.close();
	}
	
	public String execute() throws Exception
	{
		paramClass = new goodsVO();
		resultClass = new goodsVO();
		
		resultClass = (goodsVO) sqlMapper.queryForObject("select-goods", getGoods_no());
		
		File deleteFile = new File(fileUploadPath + resultClass.getGoods_image());
		deleteFile.delete();
		
		paramClass.setGoods_no(getGoods_no());
		
		sqlMapper.update("goodsDelete", paramClass);
		
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
