package mypage;

import java.util.Date;

public class goods_qaBean {
	private int qa_no;
	private int goods_no;
	private int member_no;
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

	public int getQa_no() {
		return qa_no;
	}
	public void setQa_no(int qa_no) {
		this.qa_no = qa_no;
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
