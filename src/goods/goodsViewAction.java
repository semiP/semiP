package goods;

import com.opensymphony.xwork2.ActionSupport;

import goods.goodsVO;
import goods.goodsCmtVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class goodsViewAction extends ActionSupport{
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private goodsVO paramClass = new goodsVO(); //�Ķ���͸� ������ ��ü
	private goodsVO resultClass = new goodsVO(); //���� ��� ���� ������ ��ü
	
	private goodsCmtVO cmt_paramClass = new goodsCmtVO();
	private goodsCmtVO cmt_resultClass = new goodsCmtVO();
	
	private List<goodsCmtVO> list = new ArrayList<goodsCmtVO>();
	
	private String fileUploadPath = "E:\\Java\\upload\\";
	
	private InputStream inputStream;
	private String contentDisposition;
	private long contentLength;
	
	private int num = 0;
	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 10;
	private int blockPage = 5;
	private String pagingHtml;
//	private pagingAction page;
	
	private int goods_no;
	private int goods_cmt_no;
	private String goods_cmt_pw;
	
	//������
	public goodsViewAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig_for_board2.xml"); //sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); //sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����
		reader.close();
	}
	
	//�󼼺���
	public String execute() throws Exception
	{
		//�ش� ���� ��ȸ�� +1.
		//paramClass.setNo(getNo());
		//sqlMapper.update("updateReadHit", paramClass);
		
		//�ش� ��ȣ�� ��ǰ ����� �����´�.
		resultClass = (goodsVO) sqlMapper.queryForObject("select-goods", getGoods_no());
		//cmt_resultClass = (goodsCmtVO) sqlMapper.queryForObject("select-goods", getGoods_cmt_no());
		
		//commentlist = sqlMapper.queryForList("selectComment", getNo());
		
		return SUCCESS;
	}

	public int getGoods_no() { return goods_no; }
	public void setGoods_no (int goods_no) { this.goods_no = goods_no; }
	
	public goodsVO getParamClass() { return paramClass; }
	public void setParamClass(goodsVO paramClass) { this.paramClass = paramClass; }
	
	public goodsVO getResultClass() { return resultClass; }
	public void setResultClass(goodsVO resultClass) { this.resultClass = resultClass; }
	
	public String getFileUploadPath() { return fileUploadPath; }
	public void setFileUploadPath(String fileUploadPath) { this.fileUploadPath = fileUploadPath; }

	public InputStream getInputStream() { return inputStream; }
	public void setInputStream(InputStream inputStream) { this.inputStream = inputStream; }
	
	public String getContentDisposition() { return contentDisposition; }
	public void setContentDisposition(String contentDisposition) { this.contentDisposition = contentDisposition; }
	
	public long getContentLength() { return contentLength; }
	public void setContentLength(long contentLength) { this.contentLength = contentLength; }
	
	public List<goodsCmtVO> getList() { return list; }
	public void setList(List<goodsCmtVO> list) { this.list = list; }
	
	public int getCurrentPage() { return currentPage; }
	public void setCurrentPage(int currentPage) { this.currentPage = currentPage; }

	public int getTotalCount() { return totalCount; }
	public void setTotalCount(int totalCount) { this.totalCount = totalCount; }

	public int getBlockCount() { return blockCount; }
	public void setBlockCount(int blockCount) { this.blockCount = blockCount; }

	public int getBlockPage() { return blockPage; }
	public void setBlockPage(int blockPage) { this.blockPage = blockPage; }

	public String getPagingHtml() { return pagingHtml; }
	public void setPagingHtml(String pagingHtml) { this.pagingHtml = pagingHtml; }
	
	public int getGoods_cmt_no() { return goods_cmt_no; }
	public void setGoods_cmt_no(int goods_cmt_no) { this.goods_cmt_no = goods_cmt_no; }
	
	public String getGoods_cmt_pw() { return goods_cmt_pw; }
	public void setGoods_cmt_pw(String goods_cmt_pw) { this.goods_cmt_pw = goods_cmt_pw; }

}
