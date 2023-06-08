package com.example.java_demo_test.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.constants.RtnCode;
import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.repository.PersonInfoDao;
import com.example.java_demo_test.service.ifs.PersonInfoService;
import com.example.java_demo_test.vo.BankResponse;
import com.example.java_demo_test.vo.PersonInfoRequest;
import com.example.java_demo_test.vo.PersonInfoRequestAA;
import com.example.java_demo_test.vo.PersonInfoResponse;
import com.example.java_demo_test.vo.PersonInfoResponseA;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {

	
	private Logger logger=LoggerFactory.getLogger(getClass());//slf4j
	
	@Autowired
	private PersonInfoDao personInfoDao;

	// 這是新的方法(response.request 屬性都使用Entity)
	@Transactional
	@Override
	public PersonInfoResponse addPersonInfo(PersonInfoRequest request) {
//		
//		//從request中取出單筆 PersonInfo
//		PersonInfo reqInfo=request.getPersonInfo();
//		//檢查單筆 PersonInfo
//		if (!StringUtils.hasText(reqInfo.getId()) || !StringUtils.hasText(reqInfo.getName())) {
//			return new PersonInfoResponse("ID或姓名不得為空");
//		}
//		if (personInfoDao.existsById(reqInfo.getId())) {
//		return new PersonInfoResponse("ID已存在");
//		}	
//		personInfoDao.save(reqInfo);//新增單筆 PersonInfo
		// ===================================================

		// new 一個List來接所有ID重複的personInfo
		List<PersonInfo> errorInfoList = new ArrayList<>();
		// 從request中取出多筆 PersonInfo
		List<PersonInfo> infoList = request.getPersonInfoList();
		// 檢查多筆 PersonInfo；foreach逐筆;
		for (PersonInfo item : infoList) {
			// reqInfo=item，用item檢查單筆PersonInfo
			if (!StringUtils.hasText(item.getId()) || !StringUtils.hasText(item.getName())) {
				return new PersonInfoResponse("ID或姓名不得為空");
			}
			if (personInfoDao.existsById(item.getId())) {
				// 把id有重複的person加到 errorInfoList
				errorInfoList.add(item);
//			return new PersonInfoResponse(item,"ID已存在");//因為大量多筆資料，先抓出某幾筆可能有重複
			}
		}
		// 檢查erroInfoList 是否為空，不是空的話，執行:
		if (!errorInfoList.isEmpty()) {
			return new PersonInfoResponse(errorInfoList, "ID已存在");

			// infoList 有幾筆資料，就會save 多少次；程式語言對DB的存取比較耗cost
			// 新增單筆 PersonInfo(item)
//		personInfoDao.save(item);
		}
		//// 新增多筆 PersonInfo(infoList)
		personInfoDao.saveAll(infoList);
		return new PersonInfoResponse(infoList, "基本資料建置成功");
	}

	// 這是過去的方法(屬性都展開 Request，Response)
	@Override
	public PersonInfoResponseA addPersonInfo(PersonInfoRequestAA personInfoRequest) {
		String reqId = personInfoRequest.getId();
		String reqName = personInfoRequest.getName();
		int reqAge = personInfoRequest.getAge();
	
		if (!StringUtils.hasText(reqId) || !StringUtils.hasText(reqName)) {
			return new PersonInfoResponseA(RtnCode.CANNOT_EMPTY.getCode(),RtnCode.CANNOT_EMPTY.getMessage());
//			return new PersonInfoResponseA(reqId, "ID或姓名不得為空");
		}

		if (personInfoDao.existsById(reqId)) {
			return new PersonInfoResponseA(RtnCode.CANNOT_EMPTY.getCode(),RtnCode.CANNOT_EMPTY.getMessage());

		}

		if (reqAge <= 0) {
			return new PersonInfoResponseA(RtnCode.CANNOT_EMPTY.getCode(),RtnCode.CANNOT_EMPTY.getMessage());

		}

		PersonInfo personinfo = new PersonInfo(reqId, reqName, reqAge);
		PersonInfo result = personInfoDao.save(personinfo);

		if (StringUtils.hasText(result.getId())) {
			return new PersonInfoResponseA(RtnCode.CANNOT_EMPTY.getCode(),RtnCode.CANNOT_EMPTY.getMessage());
		}
		return new PersonInfoResponseA(RtnCode.CANNOT_EMPTY.getCode(),RtnCode.CANNOT_EMPTY.getMessage());
	}

	@Override
	public PersonInfoResponseA getPersonByID(PersonInfoRequestAA personInfoRequest) {
		String reqId = personInfoRequest.getId();
		String reqName = personInfoRequest.getName();
		int reqAge = personInfoRequest.getAge();

		if (!StringUtils.hasText(reqId)) {
			return new PersonInfoResponseA(reqId, "ID不得為空");
		}

		Optional<PersonInfo> op = personInfoDao.findById(reqId);
		if (!op.isPresent()) {// 判斷optional中的Bank物件是否存在(包含判斷是否為null)
			return new PersonInfoResponseA(reqId, "帳號不存在");
		}

		PersonInfo personInfo = op.get();

		return new PersonInfoResponseA(reqId, personInfo.getName(), personInfo.getAge(), "基本資訊提供!");

	}
	
	
	
	
	//=============================================================
//	enum
	public PersonInfoResponseA getPersonByID_enum(PersonInfoRequestAA personInfoRequest) {
		String reqId = personInfoRequest.getId();
		String reqName = personInfoRequest.getName();
		int reqAge = personInfoRequest.getAge();

		if (!StringUtils.hasText(reqId)) {
			
			return new PersonInfoResponseA(RtnCode.CANNOT_EMPTY.getCode(),RtnCode.CANNOT_EMPTY.getMessage());//(reqId, "ID不得為空")
		}

		Optional<PersonInfo> op = personInfoDao.findById(reqId);
		if (!op.isPresent()) {// 判斷optional中的Bank物件是否存在(包含判斷是否為null)
			return new PersonInfoResponseA(reqId, "帳號不存在");
		}

		PersonInfo personInfo = op.get();

		return new PersonInfoResponseA(reqId, personInfo.getName(), personInfo.getAge(), "基本資訊提供!");

	}
	
	
	
	
	
	
	
	

	// 全部資料呈現
//	@Override
//	public List<PersonInfo> getPersonInfo() {
//		return personInfoDao.findAll();
//	}

	// 全部資料呈現_回傳PersonInfoResponse
	@Override
	public PersonInfoResponse getPersonInfo() {
		List<PersonInfo> InfoList = personInfoDao.findAll();
		return new PersonInfoResponse(InfoList, "all");
	}

	@Override
	public List<PersonInfo> getPersonInfoByAgeGreaterThan(int age) {
		return personInfoDao.findByAgeGreaterThan(age);
	}

	@Override
	public List<PersonInfo> getPersonInfoByAge(int age) {
		return personInfoDao.findByAge(age);
	}

	@Override
	public List<PersonInfo> findByAgeLessThanEqual(int age) {
		return personInfoDao.findByAgeLessThanEqual(age);
	}

	@Override
	public List<PersonInfo> getPersonInfoByCityAndAgeGreaterThan(String city, int age) {
		return personInfoDao.findByCityAndAgeGreaterThan(city, age);
	}

	@Override
	public List<PersonInfo> findByCityContaining(String city) {
		return personInfoDao.findByCityContaining(city);
	}

	@Override
	public List<PersonInfo> findByAgeBetween(int fromdata, int todata) {
		return personInfoDao.findByAgeBetween(fromdata, todata);
	}

	@Override
	public List<PersonInfo> findByAgeGreaterThanAndAgeLessThan(int fromdata, int todata) {

		return personInfoDao.findByAgeGreaterThanAndAgeLessThan(fromdata, todata);
	}

	@Override
	public List<PersonInfo> findByAgeGreaterThanOrAgeLessThan(int fromdata, int todata) {

		return personInfoDao.findByAgeGreaterThanOrAgeLessThan(fromdata, todata);
	}

	@Override
	public List<PersonInfo> findByAgeGreaterThanOrAgeLessThanOrCity(int fromdata, int todata, String city) {

		return personInfoDao.findByAgeGreaterThanOrAgeLessThanOrCity(fromdata, todata, city);
	}

	@Override
	public List<PersonInfo> findTop2ByCityContaining(String city) {

		return personInfoDao.findTop2ByCityContaining(city);
	}

	@Override
	public List<PersonInfo> findFirst2ByCityContaining(String city) {

		return personInfoDao.findFirst2ByCityContaining(city);
	}

	@Override
	public List<PersonInfo> findByCityContainingOrderByAge(String city) {

		return personInfoDao.findByCityContainingOrderByAge(city);
	}

	@Override
	public List<PersonInfo> findByCityContainingOrderByAgeAsc(String city) {

		return personInfoDao.findByCityContainingOrderByAgeAsc(city);
	}

	@Override
	public List<PersonInfo> findByCityContainingOrderByAgeDesc(String city) {

		return personInfoDao.findByCityContainingOrderByAgeDesc(city);
	}
}
