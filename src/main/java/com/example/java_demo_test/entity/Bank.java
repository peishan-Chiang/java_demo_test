package com.example.java_demo_test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank")

public class Bank {
	
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="password")
	private String password;
	@Id
	@Column(name="account")
	private String account;
	
	public Bank( String account,String password) {
		super();
		this.password = password;
		this.account = account;
	}

	public Bank(String account,String password,  int amount) {
		super();
		this.password = password;
		this.amount = amount;
		this.account = account;
	}
	
	public  Bank() {}
	
	public Bank(int amount, String account) {
		super();
		this.amount = amount;
		this.account = account;
	}

	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
