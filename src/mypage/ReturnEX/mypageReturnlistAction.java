package mypage.ReturnEX;

import java.io.Reader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import goods.goodsVO;
import member.memberbean;
import order.orderVO;

public class mypageReturnlistAction extends ActionSupport implements SessionAware{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private Map session;
	Map param = new HashMap();
	
	private orderVO paramClass;
	private orderVO resultClass;
	
	private orderVO paramClass1;
	private orderVO resultClass1;

	private orderVO paramClass2;
	private orderVO resultClass2;
	
	private goodsVO paramClass3;
	private goodsVO resultClass3;
	
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
	/*private int order_goods_amount;
	private String order_goods_size;
	private String order_goods_color;
	private String order_receive_name;
	private String order_receive_zipcode;
	private String order_receive_addr1;
	private String order_receive_addr2;
	private String order_receive_phone;
	private String order_memo;
	private int order_total_price;
	private Date order_date;
	private Date order_trade_date;
	private int order_list_amount;
	private String order_goods_image;
	private int order_pay_type;
	private String order_pay_name;
	private int order_total_pay;
	private String invoice_no;*/
	
	// Goods
	private int goods_no;
	/*private String goods_name;
	private int goods_category;
	private String goods_size;
	private String goods_color;
	private String goods_content;
	private int goods_amount;
	private int goods_price;
	private String goods_image;
	private Date goods_regdate;*/
	
	//member
	private int member_no;
	
	private String searchKeyword1;
	private String searchKeyword2;
	
	public mypageReturnlistAction() throws Exception{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); //sqlMapConfig.xml 
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);  //sqlMapConfig.xml
		reader.close();
	}
	//교환 반품으로 상태 변환
	public String changeCondition() throws Exception{	
		
		sqlMapper.update("mypageReturnEX.updateORDER_STATUS",getOrder_no());
		
		return SUCCESS;
	}
	
	//교환 반품 구분하기
	public String classify() throws Exception{
		paramClass1 = new orderVO();
		resultClass1 = new orderVO();
		
		paramClass1.setOrder_no(getOrder_no());
		paramClass1.setOrder_status(getOrder_status());
		
		resultClass1=(orderVO) sqlMapper.queryForList("mypageReturnEX.selectOneGoodsOrderReturnEX",paramClass1);
		
		return SUCCESS;
	}
	
	public String execute() throws Exception{
		//모든 글을 가져와 list에 넣는다.	
		paramClass2 = new orderVO();
		resultClass2 = new orderVO();
				
		paramClass3 = new goodsVO();
		paramClass3 = new goodsVO();
				
		order_member_no = (int)session.get("session_member_no");
		paramClass2.setOrder_member_no(getOrder_member_no());
		paramClass2.setOrder_no(getOrder_no());
				
		resultClass2=(orderVO)sqlMapper.queryForObject("mypageReturnEX.selectOneGoodsOrderReturnEX",paramClass2);
				
		goods_no = getOrder_goods_no();
		paramClass3.setGoods_no(goods_no);
				
		resultClass3=(goodsVO)sqlMapper.queryForObject("mypageReturnEX.selectOneGoodsReturnEX",paramClass3);
				
		return SUCCESS;
	}
	
	public static Reader getReader() {
		return reader;
	}
	public static void setReader(Reader reader) {
		mypageReturnlistAction.reader = reader;
	}
	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}
	public static void setSqlMapper(SqlMapClient sqlMapper) {
		mypageReturnlistAction.sqlMapper = sqlMapper;
	}
	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}
	public Map getParam() {
		return param;
	}
	public void setParam(Map param) {
		this.param = param;
	}
	public orderVO getParamClass() {
		return paramClass;
	}
	public void setParamClass(orderVO paramClass) {
		this.paramClass = paramClass;
	}
	public orderVO getResultClass() {
		return resultClass;
	}
	public void setResultClass(orderVO resultClass) {
		this.resultClass = resultClass;
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
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
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
	
	
}
