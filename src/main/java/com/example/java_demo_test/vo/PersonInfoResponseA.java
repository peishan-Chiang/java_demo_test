package com.example.java_demo_test.vo;

import com.example.java_demo_test.constants.RtnCode;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)


//這邊是原始的版本
public class PersonInfoResponseA  {
	
	
	private String id;
	private String name;
	private Integer age;
	
	
	

	private String code; //	private String code; String 或int
	private String message;
	
	
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public PersonInfoResponseA(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public PersonInfoResponseA(String id, String name, Integer age, String message) {
		super();
		this.id = id;
		this.name = name;
		this.message = message;
		this.age = age;
	}
	public PersonInfoResponseA(String id, String name, String message) {
		super();
		this.id = id;
		this.name = name;
		this.message = message;
	}
//	public PersonInfoResponseA(String id, String message) {
//		super();
//		this.id = id;
//		this.message = message;
//	}
	public PersonInfoResponseA() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
