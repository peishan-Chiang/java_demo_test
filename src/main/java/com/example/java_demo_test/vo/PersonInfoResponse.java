package com.example.java_demo_test.vo;

import java.util.List;

import com.example.java_demo_test.entity.PersonInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)


//這邊是老師的版本
public class PersonInfoResponse  {
	
	
	@JsonProperty("person_info")
	private PersonInfo personInfo;
	
	@JsonProperty("person_info_list")
	private List<PersonInfo> personInfoList;
	
	
	//for RtnCode_rnum 1.屬性從enum 過來 2.生成屬性的建購方法
	private String code; //	private String code; String 或int
	private String message;
	
	
	
	public PersonInfoResponse(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}


	public PersonInfoResponse(List<PersonInfo> personInfoList, String message) {
		super();
		this.personInfoList = personInfoList;
		this.message = message;
	}


	public PersonInfoResponse(PersonInfo personInfo, String message) {
		super();
		this.personInfo = personInfo;
		this.message = message;
	}


	public PersonInfoResponse(PersonInfo personInfo) {
		super();
		this.personInfo = personInfo;
	}


	public PersonInfoResponse(String message) {
		super();
		this.message = message;
	}


	public PersonInfoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PersonInfo getPersonInfo() {
		return personInfo;
	}


	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public List<PersonInfo> getPersonInfoList() {
		return personInfoList;
	}


	public void setPersonInfoList(List<PersonInfo> personInfoList) {
		this.personInfoList = personInfoList;
	}


	


	
	
	
	
	
	
}
