package mypage;

import java.util.Date;

public class inquiryVO {
	private int inquiry_no;
	private int MEMBER_NO;
	private int inquiry_category;
	private String inquiry_subject;
	private String inquiry_content;
	private Date inquiry_regdate;
	private String inquiry_addfile;
	private int inquiry_ref;
	private int inquiry_re_step;
	private int inquiry_level;
	private String member_name;
  
	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	
	public int getInquiry_no() {
		return inquiry_no;
	}

	public void setInquiry_no(int inquiry_no) {
		this.inquiry_no = inquiry_no;
	}

	public int getMEMBER_NO() {
		return MEMBER_NO;
	}

	public void setMEMBER_NO(int mEMBER_NO) {
		MEMBER_NO = mEMBER_NO;
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

	public String getInquiry_addfile() {
		return inquiry_addfile;
	}

	public void setInquiry_addfile(String inquiry_addfile) {
		this.inquiry_addfile = inquiry_addfile;
	}

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

	public int getInquiry_level() {
		return inquiry_level;
	}

	public void setInquiry_level(int inquiry_level) {
		this.inquiry_level = inquiry_level;
	}
	
}
