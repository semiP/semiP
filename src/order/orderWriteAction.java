package order;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

import java.io.File;
import org.apache.commons.io.FileUtils;

import goods.goodsVO;

public class orderWriteAction extends ActionSupport{
	
	public static Reader reader; //���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper; //SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.
	
	private orderVO paramClass; //�Ķ���͸� ������ ��ü
	private orderVO resultClass; //���� ��� ���� ������ ��ü
	
	private List<orderVO> list = new ArrayList<orderVO>();
	
	private int order_no;
	private int order_goods_no;
	private int order_member_no;
	private int order_goods_amount;
	private String order_goods_size;
	private String order_goods_color;
	private String order_receive_name;
	private String order_zipcode;
	private String order_receive_addr1;
	private String order_receive_addr2;
	private String order_receive_phone;
	private String order_memo;
	private int order_sum_money;
	private int order_status;
	private int order_list_amount;
	private int order_pay_type;
	private String order_pay_name;
	private int order_total_pay;
	Calendar today = Calendar.getInstance(); //���� ��¥ ���ϱ�.

	private File upload; //���� ��ü
	private String uploadContentType; //������ Ÿ��
	private String uploadFileName; //���� �̸�
	private String fileUploadPath = "E:\\java\\upload\\"; //���ε� ���.
	
	//생성자
	public orderWriteAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig_for_board2.xml"); //sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); //sqlMapConfig.xml ������ ������ sqlMapper ��ü ����.
		reader.close();
	}
	
	public String form() throws Exception
	{
		//orderVO <= goodsVO 정보 코딩
		return SUCCESS;
	}

	//주문내역 작성 액션
	public String execute() throws Exception
	{
		//클래스 생성
		paramClass = new orderVO();
		resultClass = new orderVO();
		
		//파라미터값을 받는다.
		//액션에서 jsp에서 받은 값을 vo에 넣는 과정 
		paramClass.setOrder_member_no(getOrder_member_no());
		paramClass.setOrder_goods_no(getOrder_goods_no());
		paramClass.setOrder_goods_amount(getOrder_goods_amount());
		paramClass.setOrder_goods_color(getOrder_goods_color());
		paramClass.setOrder_goods_size(getOrder_goods_size());
		paramClass.setOrder_receive_name(getOrder_receive_name());
		paramClass.setOrder_zipcode(getOrder_zipcode());
		paramClass.setOrder_receive_addr1(getOrder_receive_addr1());
		paramClass.setOrder_receive_addr2(getOrder_receive_addr2());
		paramClass.setOrder_receive_phone(getOrder_receive_phone());
		paramClass.setOrder_memo(getOrder_memo());
		paramClass.setOrder_date(today.getTime());
		paramClass.setOrder_pay_name(getOrder_pay_name());
		
		//받은값을 넣는다.
		sqlMapper.insert("orderInsert", paramClass);
		
		if(getUpload() != null)
		{
			resultClass = (orderVO) sqlMapper.queryForObject("selectLastNo");
			
			String file_name = "file_" + resultClass.getOrder_no();
			String file_ext = getUploadFileName().substring(
					getUploadFileName().lastIndexOf('.') + 1,
					getUploadFileName().length()
					);
			
			File destFile = new File(fileUploadPath + file_name + "." + file_ext);
			FileUtils.copyFile(getUpload(), destFile);
			
			paramClass.setOrder_no(resultClass.getOrder_no());
//			paramClass.setFile_orgname(getUploadFileName());
//			paramClass.setFile_savname(file_name + "." +file_ext);
			
			sqlMapper.update("updateFile", paramClass);
		}
		return SUCCESS;
	}
	
	public List<orderVO> getList() { return list; }
	public void setList(List<orderVO> list) { this.list = list; }
	
	public Calendar getToday() { return today; }
	public void setToday(Calendar today) { this.today = today; }
	
	public orderVO getParamClass() { return paramClass; }
	public void setParamClass(orderVO paramClass) { this.paramClass = paramClass; }
	
	public orderVO getResultClass() { return resultClass; }
	public void setResultClass(orderVO resultClass) { this.resultClass = resultClass; }
	
	public int getOrder_no() { return order_no; }
	public void setOrder_no(int order_no) { this.order_no = order_no; }
	
	public int getOrder_goods_no() { return order_goods_no; }
	public void setOrder_goods_no(int order_goods_no) { this.order_goods_no = order_goods_no; }
	
	public int getOrder_member_no() { return order_member_no; }
	public void setOrder_member_no(int order_member_no) { this.order_member_no = order_member_no; }
	
	public int getOrder_goods_amount() { return order_goods_amount; }
	public void setOrder_goods_amount(int order_goods_amount) { this.order_goods_amount = order_goods_amount; }
	
	public String getOrder_goods_size() { return order_goods_size; }
	public void setOrder_goods_size(String order_goods_size) { this.order_goods_size = order_goods_size; }
	
	public String getOrder_goods_color() { return order_goods_color; }
	public void setOrder_goods_color(String order_goods_color) { this.order_goods_color = order_goods_color; }
	
	public String getOrder_receive_name() { return order_receive_name; }
	public void setOrder_receive_name(String order_receive_name) { this.order_receive_name = order_receive_name; }
	
	public String getOrder_zipcode() { return order_zipcode; }
	public void setOrder_zipcode(String order_zipcode) { this.order_zipcode = order_zipcode; }
	
	public String getOrder_receive_addr1() { return order_receive_addr1; }
	public void setOrder_receive_addr1(String order_receive_addr1) { this.order_receive_addr1 = order_receive_addr1; }
	
	public String getOrder_receive_addr2() { return order_receive_addr2; }
	public void setOrder_receive_addr2(String order_receive_addr2) { this.order_receive_addr2 = order_receive_addr2; }
	
	public String getOrder_receive_phone() { return order_receive_phone; }
	public void setOrder_receive_phone(String order_receive_phone) { this.order_receive_phone = order_receive_phone; }
	
	public String getOrder_memo() { return order_memo; }
	public void setOrder_memo(String order_memo) { this.order_memo = order_memo; }
	
	public int getOrder_sum_money() { return order_sum_money; }
	public void setOrder_sum_money(int order_sum_money) { this.order_sum_money = order_sum_money; }
	
	public int getOrder_status() { return order_status; }
	public void setOrder_status(int order_status) { this.order_status = order_status; }
	
	public int getOrder_list_amount() { return order_list_amount; }
	public void setOrder_list_amount(int order_list_amount) { this.order_list_amount = order_list_amount; }
	
	public int getOrder_pay_type() { return order_pay_type; }
	public void setOrder_pay_type(int order_pay_type) { this.order_pay_type = order_pay_type; }
	
	public String getOrder_pay_name() { return order_pay_name; }
	public void setOrder_pay_name(String order_pay_name) { this.order_pay_name = order_pay_name; }
	
	public int getOrder_total_pay() { return order_total_pay; }
	public void setOrder_total_pay(int order_total_pay) { this.order_total_pay = order_total_pay; }
	
	public File getUpload() { return upload; }
	public void setUpload(File upload) { this.upload = upload; }
	
	public String getUploadContentType() { return uploadContentType; }
	public void setUploadContentType(String uploadContentType) { this.uploadContentType = uploadContentType; }
	
	public String getUploadFileName() { return uploadFileName; }
	public void setUploadFileName(String uploadFileName) { this.uploadFileName = uploadFileName; }
	
	public String getFileUploadPath() { return fileUploadPath; }
	public void setFileUploadPath(String fileUploadPath) { this.fileUploadPath = fileUploadPath; }

}
