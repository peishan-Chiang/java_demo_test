package com.example.java_demo_test.vo;

import java.util.List;

import com.example.java_demo_test.entity.PersonInfo;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;


//這邊是老師的版本
public class PersonInfoRequest {
	
	@JsonProperty("person_info")
	private PersonInfo personInfo;//因為與Entity 重疊，所以直接類別帶入

	@JsonProperty("person_info_list")
	private List<PersonInfo> personInfoList;
	
	private String city;
	
	
	private int fromdata;
	
	
	private int todata;
	
	
	
	private int age;

	
	public int getFromdata() {
		return fromdata;
	}

	public void setFromdata(int fromdata) {
		this.fromdata = fromdata;
	}

	public int getTodata() {
		return todata;
	}

	public void setTodata(int todata) {
		this.todata = todata;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
	

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	public List<PersonInfo> getPersonInfoList() {
		return personInfoList;
	}

	public void setPersonInfoList(List<PersonInfo> personInfoList) {
		this.personInfoList = personInfoList;
	}

	

	
	
	
	
}
