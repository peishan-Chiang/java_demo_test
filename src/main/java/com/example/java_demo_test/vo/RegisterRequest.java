package com.example.java_demo_test.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterRequest {

	@JsonProperty("account")
	private String account;
	@JsonProperty("pwd")
	private String pwd;
	
	
	
	
	public RegisterRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegisterRequest(String account, String pwd) {
		super();
		this.account = account;
		this.pwd = pwd;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
