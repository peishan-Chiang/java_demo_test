package com.example.java_demo_test.service.ifs;

import java.util.List;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.vo.PersonInfoRequestAA;
import com.example.java_demo_test.vo.PersonInfoRequest;
import com.example.java_demo_test.vo.PersonInfoResponse;
import com.example.java_demo_test.vo.PersonInfoResponseA;

public interface PersonInfoService {
	
	public List<PersonInfo> getPersonInfoByCityAndAgeGreaterThan(String city,int age);
	
	
	public PersonInfoResponseA addPersonInfo(PersonInfoRequestAA personInfoRequest);//這是舊的版本responseA 跟request出來的。
	
	public PersonInfoResponse addPersonInfo(PersonInfoRequest request);//這是老師新的版本
	
	
	public PersonInfoResponse  getPersonInfo();//這是因為我listALL要呈現response提供的list格式所以回傳PersonInfoResponse
	
	
	public PersonInfoResponseA getPersonByID(PersonInfoRequestAA personInfoRequest);

	public List<PersonInfo> getPersonInfoByAgeGreaterThan(int age);
	
	public List<PersonInfo> getPersonInfoByAge(int age);
	
	public List<PersonInfo> findByAgeLessThanEqual(int age);
	
	public List<PersonInfo> findByCityContaining(String city);
	//between 15~30
	public List<PersonInfo> findByAgeBetween(int fromdata, int todata);
	//>30 and <20
	public List<PersonInfo> findByAgeGreaterThanAndAgeLessThan(int fromdata, int todata);
	//>30 or <20
	public List<PersonInfo> findByAgeGreaterThanOrAgeLessThan(int fromdata, int todata);
	
	//>30 or <20 or city tainan
	public List<PersonInfo> findByAgeGreaterThanOrAgeLessThanOrCity(int fromdata, int todata,String city);
	 
	
	public List<PersonInfo> findTop2ByCityContaining(String city);
	public List<PersonInfo> findFirst2ByCityContaining(String city);
	
	public List<PersonInfo> findByCityContainingOrderByAge(String city);
	public  List<PersonInfo> findByCityContainingOrderByAgeAsc(String city);
	public List<PersonInfo> findByCityContainingOrderByAgeDesc(String city);
	
	
}
