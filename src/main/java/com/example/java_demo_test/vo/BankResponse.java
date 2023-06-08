package com.example.java_demo_test.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankResponse {
	private String account;
	private Integer balance;//餘額
	private String message;
	private Integer amount;//存款金額
    
   	public BankResponse(String account, String message) {
		super();
		this.account = account;
		this.message = message;
	}

	

	public BankResponse(String account, Integer amount, Integer balance, String message) {
		super();
		this.account = account;
		this.balance = balance;
		this.amount = amount;
		this.message = message;
	}

	public BankResponse(String account, Integer amount, String message) {
		super();
		this.account = account;
		this.amount = amount;
		this.message = message;
	}

	public BankResponse(String account, Integer amount) {
		super();
		this.account = account;
		this.amount = amount;
	}

	public BankResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

}
