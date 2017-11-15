package cmc;

import java.util.Date;

public class faqVO {
	private int faq_no;
	private String faq_subject;
	private String faq_content;
	private Date faq_regdate;
	private int faq_category;

	public int getFaq_category() {
		return faq_category;
	}

	public void setFaq_category(int faq_category) {
		this.faq_category = faq_category;
	}

	public int getFaq_no() {
		return faq_no;
	}

	public void setFaq_no(int faq_no) {
		this.faq_no = faq_no;
	}

	public String getFaq_subject() {
		return faq_subject;
	}

	public void setFaq_subject(String faq_subject) {
		this.faq_subject = faq_subject;
	}

	public String getFaq_content() {
		return faq_content;
	}

	public void setFaq_content(String faq_content) {
		this.faq_content = faq_content;
	}

	public Date getFaq_regdate() {
		return faq_regdate;
	}

	public void setFaq_regdate(Date faq_regdate) {
		this.faq_regdate = faq_regdate;
	}

}
