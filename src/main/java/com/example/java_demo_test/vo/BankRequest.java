package com.example.java_demo_test.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BankRequest {
	private String account;
	
	
	@JsonProperty("depositAmount")
	@JsonAlias("withdrawAmount")
	private int moneyRange;//存入金額及提款金額
	
	
	@JsonProperty("password")
	private String pwd;
	
	
	public int getMoneyRange() {
		return moneyRange;
	}
	public void setMoneyRange(int moneyRange) {
		this.moneyRange = moneyRange;
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
