package goods;

import com.opensymphony.xwork2.ActionSupport;

import goods.goodsVO;
import goods.goodsCmtVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.io.InputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class goodsViewAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	
	private goodsVO resultGoods = new goodsVO();
	private List<goodsCmtVO> listCmt = new ArrayList<goodsCmtVO>();
		
	private int goods_no;

	
	public goodsViewAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); 
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); 
		reader.close();
	}
	
	
	public String execute() throws Exception
	{
		resultGoods = (goodsVO) sqlMapper.queryForObject("goods.select-goods-one", goods_no);
		listCmt = 
		
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
