package goods;

import java.util.Date;

public class goodsCmtVO {
	
	private int goods_cmt_no;            //글번호
	private String goods_cmt_pw;         //글비번
	private String goods_cmt_subject;    //글제목
	private int goods_cmt_memberno;   //작성자 가입 번호
	private String goods_cmt_id;       //작성자 ID
	private String goods_cmt_image;  //원래 파일 이름
	private int goods_cmt_score;      //평점
	private String goods_cmt_content;    //내용
	private Date goods_cmt_date;         //작성일
	
	private int ref;
	private int re_step;
	private int re_level;
	
	public int getGoods_cmt_no() { return goods_cmt_no; }
	public void setGoods_cmt_no(int goods_cmt_no) { this.goods_cmt_no = goods_cmt_no; }
	
	public String getGoods_cmt_pw() { return goods_cmt_pw; }
	public void setGoods_cmt_pw(String goods_cmt_pw) { this.goods_cmt_pw = goods_cmt_pw; }
	
	public int getGoods_cmt_memberno() { return goods_cmt_memberno; }
	public void setGoods_cmt_memberno(int goods_cmt_memberno) { this.goods_cmt_memberno = goods_cmt_memberno; }
	
	public String getGoods_cmt_image() { return goods_cmt_image; }
	public void setGoods_cmt_image(String goods_cmt_image) { this.goods_cmt_image = goods_cmt_image; }
	
	public int getGoods_cmt_score() { return goods_cmt_score; }
	public void setGoods_cmt_score(int goods_cmt_score) { this.goods_cmt_score = goods_cmt_score; }
	
	public String getGoods_cmt_subject() { return goods_cmt_subject; }
	public void setGoods_cmt_subject(String goods_cmt_subject) { this.goods_cmt_subject = goods_cmt_subject; }
	
	public String getGoods_cmt_id() { return goods_cmt_id; }
	public void setGoods_cmt_id(String goods_cmt_id) { this.goods_cmt_id = goods_cmt_id; }
	
	public Date getGoods_cmt_date() { return goods_cmt_date; }
	public void setGoods_cmt_date(Date goods_cmt_date) { this.goods_cmt_date = goods_cmt_date; }
	
	public String getGoods_cmt_content() { return goods_cmt_content; }
	public void setGoods_cmt_content(String goods_cmt_content) { this.goods_cmt_content = goods_cmt_content; }
	
	public int getRef() { return ref; }
	public void setRef(int ref) { this.ref = ref; }
	
	public int getRe_step() { return re_step; }
	public void setRe_step(int re_step) { this.re_step = re_step; }
	
	public int getRe_level() { return re_level; }
	public void setRe_level(int re_level) { this.re_level = re_level; }
	
}