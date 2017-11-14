package member;

import java.util.Date;

public class memberbean {

	private int member_no;
	private String member_name;
	private String member_id;
	private String member_pw;
	private String member_zipcode;
	private String member_address1;
	private String member_address2;
	private String member_phone;
	private String member_email;
	Date member_regdate;
	private int member_level;
	
	public int getmember_no() {
		return member_no;
	}
	public void setmember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getmember_name() {
		return member_name;
	}
	public void setmember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getmember_id() {
		return member_id;
	}
	public void setmember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getmember_pw() {
		return member_pw;
	}
	public void setmember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getmember_zipcode() {
		return member_zipcode;
	}
	public void setmember_zipcode(String member_zipcode) {
		this.member_zipcode = member_zipcode;
	}
	public String getmember_address1() {
		return member_address1;
	}
	public void setmember_address1(String member_address1) {
		this.member_address1 = member_address1;
	}
	public String getmember_address2() {
		return member_address2;
	}
	public void setmember_address2(String member_address2) {
		this.member_address2 = member_address2;
	}
	public String getmember_phone() {
		return member_phone;
	}
	public void setmember_phone(String member_phone) {
		this.member_phone = member_phone;
	}
	public String getmember_email() {
		return member_email;
	}
	public void setmember_email(String member_email) {
		this.member_email = member_email;
	}
	public Date getmember_regdate() {
		return member_regdate;
	}
	public void setmember_regdate(Date member_regdate) {
		this.member_regdate = member_regdate;
	}
	public int getmember_level() {
		return member_level;
	}
	public void setmember_level(int member_level) {
		this.member_level = member_level;
	}
}
