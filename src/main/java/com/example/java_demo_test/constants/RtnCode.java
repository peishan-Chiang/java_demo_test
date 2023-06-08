package com.example.java_demo_test.constants;

import java.time.LocalDateTime;

public enum RtnCode {
	
	SUCCESSFUL("200","successful"), //	1. SUCCESSFUL()->private String code; String 紅蚯蚓會消失 2.("200","successful") 3.constructor 生成 4.之間","最後";"
	
	CANNOT_EMPTY("400","cannot empty!"),
	NOT_FOUND("404","not found!!"),
	ACCOUNT_EXISTED("400","account existed"),
	FAILED("400","create failed"),
	ACCOUNT_ACTIVED("400","accounted actived!!"),
	ACCOUNT_NOT_ACTIVED("400","accounted not actived!!"),
	PLEASE_LOGIN("400","please login");
	;
	
	
	
	
	private String code; //	private String code; String 或int
	private String  message;
	private LocalDateTime regTime;
	
	
	
	
	
	private RtnCode(String code, String message, LocalDateTime regTime) {
		this.code = code;
		this.message = message;
		this.regTime = regTime;
	}
	private RtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}
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
	public LocalDateTime getRegTime() {
		return regTime;
	}
	public void setRegTime(LocalDateTime regTime) {
		this.regTime = regTime;
	}
	
	

}
