package support;

import java.util.Date;

public class inquiryVO {
	private int inquiry_no;
	private int member_no;
	private int inquiry_category;
	private String inquiry_subject;
	private String inquiry_content;
	private Date inquiry_regdate;
	private String inquiry_email;
	private String inquiry_addfile;
	private int inquiry_ref;
	private int inquiry_re_step;
	private int inquiry_re_level;

	public int getInquiry_ref() {
		return inquiry_ref;
	}

	public void setInquiry_ref(int inquiry_ref) {
		this.inquiry_ref = inquiry_ref;
	}

	public int getInquiry_re_step() {
		return inquiry_re_step;
	}

	public void setInquiry_re_step(int inquiry_re_step) {
		this.inquiry_re_step = inquiry_re_step;
	}

	public int getInquiry_re_level() {
		return inquiry_re_level;
	}

	public void setInquiry_re_level(int inquiry_re_level) {
		this.inquiry_re_level = inquiry_re_level;
	}

	public int getInquiry_no() {
		return inquiry_no;
	}

	public void setInquiry_no(int inquiry_no) {
		this.inquiry_no = inquiry_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public int getInquiry_category() {
		return inquiry_category;
	}

	public void setInquiry_category(int inquiry_category) {
		this.inquiry_category = inquiry_category;
	}

	public String getInquiry_subject() {
		return inquiry_subject;
	}

	public void setInquiry_subject(String inquiry_subject) {
		this.inquiry_subject = inquiry_subject;
	}

	public String getInquiry_content() {
		return inquiry_content;
	}

	public void setInquiry_content(String inquiry_content) {
		this.inquiry_content = inquiry_content;
	}

	public Date getInquiry_regdate() {
		return inquiry_regdate;
	}

	public void setInquiry_regdate(Date inquiry_regdate) {
		this.inquiry_regdate = inquiry_regdate;
	}

	public String getInquiry_email() {
		return inquiry_email;
	}

	public void setInquiry_email(String inquiry_email) {
		this.inquiry_email = inquiry_email;
	}

	public String getInquiry_addfile() {
		return inquiry_addfile;
	}

	public void setInquiry_addfile(String inquiry_addfile) {
		this.inquiry_addfile = inquiry_addfile;
	}

}
