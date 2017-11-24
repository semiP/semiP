package mypage.OrderDeliverCondition;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionContext;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import goods.goodsVO;
import order.orderVO;

public class mypageOrderlistAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private Map session;
	private List<orderVO> orderList = new ArrayList<orderVO>();
	
	private orderVO paramClass1;
	private orderVO resultClass1;

	private orderVO paramClass2;
	private orderVO resultClass2;
	
	private goodsVO paramClass3;
	private goodsVO resultClass3;
	
/*	private List<mypage.goodsOrderBean> goodsOrderList = new ArrayList<mypage.goodsOrderBean>();
	private List<goods.goodsVO> goodsList = new ArrayList<goods.goodsVO>();*/
	
	private int currentPage = 1; 
	private int totalCount;		 
	private int blockCount = 10; 
	private int blockPage = 5;   
	private String pagingHtml;   
	private int num = 0;
	
	// goodsOrder
	private int order_no;
	private int order_goods_no;
	private int order_member_no;
	private int order_status;
	
	// Goods
	private int goods_no;
	
	//member
	private int member_no;
	
	
	
	private String searchKeyword1;
	private String searchKeyword2;
	
	public mypageOrderlistAction() throws Exception{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); //sqlMapConfig.xml 
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);  //sqlMapConfig.xml
		reader.close();
	}
	
	// 주문배송현환 목록 불러옴
	//리스트 출력
	public String execute() throws Exception{
		
		ActionContext context = ActionContext.getContext();
		session = context.getSession();
		
		if(session.get("session_member_id") == null){
			return LOGIN;
		}
				
		orderList=sqlMapper.queryForList("mypageOrderDeliverCondition.selectAll-notRefund", (int) session.get("session_member_no"));
		System.out.println(orderList.size());
		
		return SUCCESS;
	}

	// 기간조회
	/*public String search() throws Exception{
		paramClass4 = new goodsOrderBean();
		paramClass5= new goodsOrderBean();
			
		resultClass4 = new goodsOrderBean();
		resultClass5= new goodsOrderBean();
			
		paramClass4 = (goodsOrderBean) sqlMapper.queryForList(getSearchKeyword1());
		paramClass5 = (goodsOrderBean) sqlMapper.queryForList(getSearchKeyword2());
			
		return SUCCESS;
	}*/
	public static Reader getReader() {
		return reader;
	}

	
	public static void setReader(Reader reader) {
		mypageOrderlistAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		mypageOrderlistAction.sqlMapper = sqlMapper;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public orderVO getParamClass1() {
		return paramClass1;
	}

	public void setParamClass1(orderVO paramClass1) {
		this.paramClass1 = paramClass1;
	}

	public orderVO getResultClass1() {
		return resultClass1;
	}

	public void setResultClass1(orderVO resultClass1) {
		this.resultClass1 = resultClass1;
	}

	public orderVO getParamClass2() {
		return paramClass2;
	}

	public void setParamClass2(orderVO paramClass2) {
		this.paramClass2 = paramClass2;
	}

	public orderVO getResultClass2() {
		return resultClass2;
	}

	public void setResultClass2(orderVO resultClass2) {
		this.resultClass2 = resultClass2;
	}

	public goodsVO getParamClass3() {
		return paramClass3;
	}

	public void setParamClass3(goodsVO paramClass3) {
		this.paramClass3 = paramClass3;
	}

	public goodsVO getResultClass3() {
		return resultClass3;
	}

	public void setResultClass3(goodsVO resultClass3) {
		this.resultClass3 = resultClass3;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getBlockCount() {
		return blockCount;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public String getPagingHtml() {
		return pagingHtml;
	}

	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public int getOrder_goods_no() {
		return order_goods_no;
	}

	public void setOrder_goods_no(int order_goods_no) {
		this.order_goods_no = order_goods_no;
	}

	public int getOrder_member_no() {
		return order_member_no;
	}

	public void setOrder_member_no(int order_member_no) {
		this.order_member_no = order_member_no;
	}

	public int getOrder_status() {
		return order_status;
	}

	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}

	public int getGoods_no() {
		return goods_no;
	}

	public void setGoods_no(int goods_no) {
		this.goods_no = goods_no;
	}

	public String getSearchKeyword1() {
		return searchKeyword1;
	}

	public void setSearchKeyword1(String searchKeyword1) {
		this.searchKeyword1 = searchKeyword1;
	}

	public String getSearchKeyword2() {
		return searchKeyword2;
	}

	public void setSearchKeyword2(String searchKeyword2) {
		this.searchKeyword2 = searchKeyword2;
	}

	public List<orderVO> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<orderVO> orderList) {
		this.orderList = orderList;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	
}
