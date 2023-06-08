package com.example.java_demo_test.vo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterResponse {
	private String code;
	private String message;
	
	@JsonProperty("reg_time")
	private LocalDateTime regTime;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	public RegisterResponse(String code, String message, LocalDateTime regTime) {
		super();
		this.code = code;
		this.message = message;
		this.regTime = regTime;
	}
	public RegisterResponse(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public RegisterResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LocalDateTime getRegTime() {
		return regTime;
	}
	public void setRegTime(LocalDateTime regTime) {
		this.regTime = regTime;
	}

	
	
}
