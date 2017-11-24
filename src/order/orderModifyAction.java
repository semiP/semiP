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
	public static Reader reader; //���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper; //SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.
	
	private orderVO paramClass; //�Ķ���͸� ������ ��ü
	private orderVO resultClass; //���� ��� ���� ������ ��ü
	
	private int currentPage; //���� ������
	
	private int order_no;
	private int order_status;
	
	/*
	private File upload; //���� ��ü
	private String uploadContentType; //������ Ÿ��
	private String uploadFileName; //���� �̸�
	private String fileUploadPath = "E:\\java\\upload\\"; //���ε� ���.
	*/
	
	//������
	public orderModifyAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); //sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); //sqlMapConfig.xml ������ ������ sqlMapper ��ü ����.
		reader.close();
	}
	
	//실행 (admin)
	public String execute() throws Exception
	{
		//�Ķ���Ϳ� ����Ʈ ��ü ����.
		paramClass = new orderVO();
		resultClass = new orderVO();
		
		//������ �׸� ����.
		paramClass.setOrder_status(getOrder_status());

		//�ϴ� �׸� �����Ѵ�.
		sqlMapper.update("orderUpdate", paramClass);
		
		//������ ������ view �������� �̵�.
		resultClass = (orderVO) sqlMapper.queryForObject("select-order", getOrder_no());
		
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
