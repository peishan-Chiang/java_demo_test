package com.example.java_demo_test.vo;

import com.example.java_demo_test.entity.PersonInfo;
import com.fasterxml.jackson.annotation.JsonProperty;


//這邊是原始的版本
public class PersonInfoRequestAA {
	
	
	private PersonInfo personInfo;//因為與Entity 重疊，所以直接類別帶入
	
	
	private String id;
	private String name;
	private int age;
	
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
