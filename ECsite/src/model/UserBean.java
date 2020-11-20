package model;

import java.io.Serializable;

public class UserBean implements Serializable {



	private String logincode;
	private String loginpassword;
	private String loginid;


	public String getLogincode() {
		return logincode;
	}
	public void setLogincode(String logincode) {
		this.logincode = logincode;
	}
	public String getLoginpassword() {
		return loginpassword;
	}
	public void setLoginpassword(String loginpassword) {
		this.loginpassword = loginpassword;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}


//	 !!!!!!  the reason we create this is because this BEAN can be used at DAO. !!!!!!!





}
