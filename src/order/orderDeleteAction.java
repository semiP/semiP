package order;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.File;
import java.io.Reader;
import java.io.IOException;

import order.orderVO;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public abstract class orderDeleteAction extends ActionSupport implements SessionAware{
	
	
	private static final long serialVersionUID = 1L;
	private Map session;
	
	public static Reader reader; //���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper; //SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.
	
	private orderVO paramClass; //�Ķ���͸� ������ ��ü
	private orderVO resultClass; //���� ��� ���� ������ ��ü
	
	private int currentPage; //���� ������
	
	private String fileUploadPath = "E:\\java\\upload\\";
	
	private int order_no;         //�ֹ� ��ȣ
	
	//생성자
	public orderDeleteAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); //sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); //sqlMapConfig.xml ������ ������ sqlMapper ��ü ����.
		reader.close();
	}
	
	//주문내역삭제(admin) 
	public String execute() throws Exception
	{
		//�Ķ���Ϳ� ����Ʈ ��ü ����.
		paramClass = new orderVO();
		resultClass = new orderVO();
		
		//�ش� ��ȣ�� �ֹ��� �����´�.
		resultClass = (orderVO) sqlMapper.queryForObject("selectOne", getOrder_no());
		
//		File deleteFile = new File(fileUploadPath + resultClass.getFile_savname());
//		deleteFile.delete();
		
		//������ �׸� ����.
		paramClass.setOrder_no(getOrder_no());
		
		//���� ���� ����.
		sqlMapper.update("orderDelete", paramClass);
		
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
