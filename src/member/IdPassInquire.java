package member;

import com.opensymphony.xwork2.ActionSupport;

import member.memberbean;


public class IdPassInquire extends ActionSupport {

	memberbean resultClass;
	
	private static final long serialVersionUID = 1L;

	public String execute() {
		return SUCCESS;
	}
	
	public String inquireForm() {
		return SUCCESS;
	}
}
