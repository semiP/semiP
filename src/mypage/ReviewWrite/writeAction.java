package mypage.ReviewWrite;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import mypage.goodsBean;
import mypage.goods_qaBean;
import mypage.memberBean;

public class writeAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private memberBean paramClass1;
	private memberBean resultClass1;
	
	private goodsBean paramClass2;
	private goodsBean resultClass2;
	
	private goods_qaBean paramClass3;
	private goods_qaBean resultClass3;
	
	private int member_no;
	private String member_name;
	private String member_id;
	private String member_pw;
	private String member_zipcode;
	private String member_address1;
	private String member_address2;
	private String member_phone;
	private String member_email;
	private Date member_regdate;
	private int member_level;
	
	private int goods_no;
	private String goods_name;
	private int goods_category;
	private String goods_size;
	private String goods_color;
	private String goods_content;
	private int goods_amount;
	private int goods_price;
	private String goods_image;
	private Date goods_regdate;
	
	private int qa_no;
	//private int goods_no;
	//private int member_no;
	private String qa_subject;
	private String qa_content;
	private String qa_pw;
	private int secret_flag;
	private Date regdate;
	private String qa_addfile;
	private int qare_flag;
	private int qa_ref;
	private int aq_re_step;
	private int re_level;
	private String start;
	
	//생성자
	public writeAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String Reviewform() throws Exception{
		return SUCCESS;
	}
	
	public String execute() throws Exception{
		paramClass1 = new memberBean();
		resultClass1 = new memberBean();
		
		paramClass2 = new goodsBean();
		resultClass2 = new goodsBean();
		
		paramClass3 = new goods_qaBean();
		resultClass3 = new goods_qaBean();
		
		paramClass1.setMember_name(getMember_name());
		paramClass2.setGoods_no(getGoods_no());
		paramClass2.setGoods_color(getGoods_color());
		paramClass2.setGoods_size(getGoods_size());
		
		resultClass1 = (memberBean)sqlMapper.queryForObject("Member_no",paramClass1);
		resultClass2 = (goodsBean)sqlMapper.queryForObject("goods_no",paramClass2);
		
		return SUCCESS;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		writeAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		writeAction.sqlMapper = sqlMapper;
	}

	public memberBean getParamClass1() {
		return paramClass1;
	}

	public void setParamClass1(memberBean paramClass1) {
		this.paramClass1 = paramClass1;
	}

	public memberBean getResultClass1() {
		return resultClass1;
	}

	public void setResultClass1(memberBean resultClass1) {
		this.resultClass1 = resultClass1;
	}

	public goodsBean getParamClass2() {
		return paramClass2;
	}

	public void setParamClass2(goodsBean paramClass2) {
		this.paramClass2 = paramClass2;
	}

	public goodsBean getResultClass2() {
		return resultClass2;
	}

	public void setResultClass2(goodsBean resultClass2) {
		this.resultClass2 = resultClass2;
	}

	public goods_qaBean getParamClass3() {
		return paramClass3;
	}

	public void setParamClass3(goods_qaBean paramClass3) {
		this.paramClass3 = paramClass3;
	}

	public goods_qaBean getResultClass3() {
		return resultClass3;
	}

	public void setResultClass3(goods_qaBean resultClass3) {
		this.resultClass3 = resultClass3;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_zipcode() {
		return member_zipcode;
	}

	public void setMember_zipcode(String member_zipcode) {
		this.member_zipcode = member_zipcode;
	}

	public String getMember_address1() {
		return member_address1;
	}

	public void setMember_address1(String member_address1) {
		this.member_address1 = member_address1;
	}

	public String getMember_address2() {
		return member_address2;
	}

	public void setMember_address2(String member_address2) {
		this.member_address2 = member_address2;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public Date getMember_regdate() {
		return member_regdate;
	}

	public void setMember_regdate(Date member_regdate) {
		this.member_regdate = member_regdate;
	}

	public int getMember_level() {
		return member_level;
	}

	public void setMember_level(int member_level) {
		this.member_level = member_level;
	}

	public int getGoods_no() {
		return goods_no;
	}

	public void setGoods_no(int goods_no) {
		this.goods_no = goods_no;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public int getGoods_category() {
		return goods_category;
	}

	public void setGoods_category(int goods_category) {
		this.goods_category = goods_category;
	}

	public String getGoods_size() {
		return goods_size;
	}

	public void setGoods_size(String goods_size) {
		this.goods_size = goods_size;
	}

	public String getGoods_color() {
		return goods_color;
	}

	public void setGoods_color(String goods_color) {
		this.goods_color = goods_color;
	}

	public String getGoods_content() {
		return goods_content;
	}

	public void setGoods_content(String goods_content) {
		this.goods_content = goods_content;
	}

	public int getGoods_amount() {
		return goods_amount;
	}

	public void setGoods_amount(int goods_amount) {
		this.goods_amount = goods_amount;
	}

	public int getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
	}

	public String getGoods_image() {
		return goods_image;
	}

	public void setGoods_image(String goods_image) {
		this.goods_image = goods_image;
	}

	public Date getGoods_regdate() {
		return goods_regdate;
	}

	public void setGoods_regdate(Date goods_regdate) {
		this.goods_regdate = goods_regdate;
	}

	public int getQa_no() {
		return qa_no;
	}

	public void setQa_no(int qa_no) {
		this.qa_no = qa_no;
	}

	public String getQa_subject() {
		return qa_subject;
	}

	public void setQa_subject(String qa_subject) {
		this.qa_subject = qa_subject;
	}

	public String getQa_content() {
		return qa_content;
	}

	public void setQa_content(String qa_content) {
		this.qa_content = qa_content;
	}

	public String getQa_pw() {
		return qa_pw;
	}

	public void setQa_pw(String qa_pw) {
		this.qa_pw = qa_pw;
	}

	public int getSecret_flag() {
		return secret_flag;
	}

	public void setSecret_flag(int secret_flag) {
		this.secret_flag = secret_flag;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getQa_addfile() {
		return qa_addfile;
	}

	public void setQa_addfile(String qa_addfile) {
		this.qa_addfile = qa_addfile;
	}

	public int getQare_flag() {
		return qare_flag;
	}

	public void setQare_flag(int qare_flag) {
		this.qare_flag = qare_flag;
	}

	public int getQa_ref() {
		return qa_ref;
	}

	public void setQa_ref(int qa_ref) {
		this.qa_ref = qa_ref;
	}

	public int getAq_re_step() {
		return aq_re_step;
	}

	public void setAq_re_step(int aq_re_step) {
		this.aq_re_step = aq_re_step;
	}

	public int getRe_level() {
		return re_level;
	}

	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	
}
