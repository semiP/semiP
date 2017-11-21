package goods;

import com.opensymphony.xwork2.ActionSupport;

import basket.basketVO;
import goods.goodsVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

import java.net.*;

public class goodsListAction extends ActionSupport {
	
	public static Reader reader;        //���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper;      //SqlMapClinet API�� ����ϱ� ���� sqlMapper ��ü.
	
	private List<goodsVO> list = new ArrayList<goodsVO>();
	
	private String searchKeyword;
	private int searchNum;
	
	private int num = 0;
	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 10;
	private int blockPage = 5;
	private String pagingHtml;
//	private pagingAction page;

	//생성자
	public goodsListAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); //sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);  //sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close();
	}
	
	public String execute() throws Exception
	{		
		list = sqlMapper.queryForList("select-goods-all");
		
		totalCount = list.size();
//		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, num, "");
//		pagingHtml = page.getPagingHtml().toString();
	
//		list = list.subList(page.getStartCount(), lastCount);
		
		/*임의의 리스트 만들기. 테스트용
				basketresultClass = new basketVO();
				basketresultClass.setBasket_no(1);
				basketresultClass.setBasket_price(40000);
				basketresultClass.setGoods_size("L");
				basketresultClass.setGoods_color("red");
				basketresultClass.setGoods_name("solid");
				basketresultClass.setBgoods_amount(2);
				basketresultClass.setGoods_price(20000);
				basketresultClass.setGoods_image("image");
			*/			
		
		
		return SUCCESS;
	}

	public List<goodsVO> getList() { return list; }
	public void setList( List<goodsVO> list) { this.list = list; }
	
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
	
}
