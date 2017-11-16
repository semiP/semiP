package goods;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.File;
import java.io.Reader;
import java.util.Date;
import java.io.IOException;

public class goodsCmtDeleteAction extends ActionSupport{
	public static Reader reader; //���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper; //SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.
	
	private goodsCmtVO paramClass; //�Ķ���͸� ������ ��ü
	private goodsCmtVO resultClass; //���� ��� ���� ������ ��ü
	
	private int currentPage; //���� ������
	
	private String fileUploadPath = "E:\\java\\upload\\";
	
	private int goods_cmt_no;            //�۹�ȣ
	
	//생성자
	public goodsCmtDeleteAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); //sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); //sqlMapConfig.xml ������ ������ sqlMapper ��ü ����.
		reader.close();
	}
	
	public String execute() throws Exception
	{
		paramClass = new goodsCmtVO();
		resultClass = new goodsCmtVO();
		
		resultClass = (goodsCmtVO) sqlMapper.queryForObject("selectOne", getGoods_cmt_no());
		
		File deleteFile = new File(fileUploadPath + resultClass.getGoods_cmt_image());
		deleteFile.delete();
		
		paramClass.setGoods_cmt_no(getGoods_cmt_no());
		
		sqlMapper.update("goodsCmtDelete", paramClass);
		
		return SUCCESS;
	}

	public goodsCmtVO getParamClass() { return paramClass; }
	public void setParamClass(goodsCmtVO paramClass) { this.paramClass = paramClass; }
	
	public goodsCmtVO getResultClass() { return resultClass; }
	public void setResultClass(goodsCmtVO resultClass) { this.resultClass = resultClass; }
	
	public int getCurrentPage() { return currentPage; }
	public void setCurrentPage(int currentPage) { this.currentPage = currentPage; }
	
	public String getFileUploadPath() { return fileUploadPath; }
	public void setFileUploadPath(String fileUploadPath) { this.fileUploadPath = fileUploadPath; }
	
	public int getGoods_cmt_no() { return goods_cmt_no; }
	public void setGoods_cmt_no(int goods_cmt_no) { this.goods_cmt_no = goods_cmt_no; }
}
