package com.example.java_demo_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.service.ifs.BankService;
import com.example.java_demo_test.service.ifs.PersonInfoService;
import com.example.java_demo_test.vo.BankRequest;
import com.example.java_demo_test.vo.BankResponse;
import com.example.java_demo_test.vo.PersonInfoRequest;
import com.example.java_demo_test.vo.PersonInfoRequestAA;
import com.example.java_demo_test.vo.PersonInfoResponse;
import com.example.java_demo_test.vo.PersonInfoResponseA;

@RestController
public class PersonInfoController {

	@Autowired
	private PersonInfoService personInfoService;

	@PostMapping("/add_PersonInfo_nw")
	public PersonInfoResponse addPersonInfo(@RequestBody PersonInfoRequest personInfoRequest) {
		return personInfoService.addPersonInfo(personInfoRequest);
	}

	@PostMapping("/add_PersonInfoA")
	public PersonInfoResponseA addPersonInfo(@RequestBody PersonInfoRequestAA personInfoRequest) {
		return personInfoService.addPersonInfo(personInfoRequest);
	}

//	@PostMapping("/getPersonInfo")
//	public List <PersonInfo> getPersonInfo
//	(@RequestBody PersonInfoRequest personInfoRequest) {
//		  return personInfoService.getPersonInfo();
//	}

	@PostMapping("/getPersonInfo")
	public PersonInfoResponse getPersonInfo(@RequestBody PersonInfoRequest personInfoRequest) {
		return personInfoService.getPersonInfo();
	}

	@PostMapping("/getPersonByID")
	public PersonInfoResponseA getPersonByID(@RequestBody PersonInfoRequestAA personInfoRequest) {
		return personInfoService.getPersonByID(personInfoRequest);
	}

	@PostMapping("/get_Person_info_by_age")
	public List<PersonInfo> getPersonInfoByAge(@RequestBody PersonInfoRequest request) {
		return personInfoService.getPersonInfoByAge(request.getAge());
	}

	@PostMapping("/get_Person_info_by_age_greater_than")
	public List<PersonInfo> getPersonInfoByAgeGreaterThan(@RequestBody PersonInfoRequest request) {
		return personInfoService.getPersonInfoByAgeGreaterThan(request.getAge());
	}

	@PostMapping("/get_Person_info_by_age_less_than_equal")
	public List<PersonInfo> findByAgeLessThanEqual(@RequestBody PersonInfoRequest request) {
		return personInfoService.findByAgeLessThanEqual(request.getAge());
	}

	@PostMapping("/get_Person_info_by_city_and_age_greater")
	public List<PersonInfo> getPersonInfoByCityAndAgeGreaterThan(@RequestBody PersonInfoRequest request) {
		return personInfoService.getPersonInfoByCityAndAgeGreaterThan(request.getCity(), request.getAge());
	}

	@PostMapping("/get_Person_info_by_city_containing")
	public List<PersonInfo> findByCityContaining(@RequestBody PersonInfoRequest request) {
		return personInfoService.findByCityContaining(request.getCity());
	}

	@PostMapping("/get_Person_info_by_age_between")
	public List<PersonInfo> findByAgeBetween(@RequestBody PersonInfoRequest request) {
		return personInfoService.findByAgeBetween(request.getFromdata(), request.getTodata());
	}
	
	
	@PostMapping("/get_Person_info_by_age_greater_and_less")
	public List<PersonInfo> findByAgeGreaterThanAndAgeLessThan(@RequestBody PersonInfoRequest request) {
		return personInfoService.findByAgeGreaterThanAndAgeLessThan(request.getFromdata(), request.getTodata());
	}
	
	
	@PostMapping("/get_Person_info_by_age_greater_or_less")
	public List<PersonInfo> findByAgeGreaterThanOrAgeLessThan(@RequestBody PersonInfoRequest request) {
		return personInfoService.findByAgeGreaterThanOrAgeLessThan(request.getFromdata(), request.getTodata());
	}
	
	@PostMapping("/get_Person_info_by_age_greater_or_less_or_city")
	public List<PersonInfo> findByAgeGreaterThanOrAgeLessThanOrCity(@RequestBody PersonInfoRequest request) {
		return personInfoService.findByAgeGreaterThanOrAgeLessThanOrCity(request.getFromdata(), request.getTodata(),request.getCity());
	}
	
	@PostMapping("/get_Person_info_by_First_city_cotain")
	public List<PersonInfo> findFirst2ByCityContaining(@RequestBody PersonInfoRequest request) {
		return personInfoService.findFirst2ByCityContaining(request.getCity());
	}
	
	@PostMapping("/get_Person_info_by_city_cotain_order_age")
	public List<PersonInfo>  findByCityContainingOrderByAge(@RequestBody PersonInfoRequest request) {
		return personInfoService. findByCityContainingOrderByAge(request.getCity());
	}
	
	@PostMapping("/get_Person_info_by_city_cotain_order_age_asc")
	public List<PersonInfo>  findByCityContainingOrderByAgeAsc(@RequestBody PersonInfoRequest request) {
		return personInfoService. findByCityContainingOrderByAgeAsc(request.getCity());
	}
	
	@PostMapping("/get_Person_info_by_city_cotain_order_age_desc")
	public List<PersonInfo>  findByCityContainingOrderByAgeDesc(@RequestBody PersonInfoRequest request) {
		return personInfoService. findByCityContainingOrderByAgeDesc(request.getCity());
	}
	
	

}
