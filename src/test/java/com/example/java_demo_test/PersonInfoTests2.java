package com.example.java_demo_test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.Assert;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.repository.PersonInfoDao;
import com.example.java_demo_test.vo.PersonInfoBankVo;

@SpringBootTest(classes = JavaDemoTestApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PersonInfoTests2 {

//	  List<PersonInfo>list=new ArrayList<>();
	@Autowired
	private PersonInfoDao pesonInfoDao;

//	@Test
//	public void insertInfo() {
//		int res = pesonInfoDao.insertInfo("AAA", "小將", 12, "台南");
//		System.out.println(res);
//	}
//
//	@Test
//	public void insertInfo2() {
//		int res = pesonInfoDao.insertInfo2("AAA902", "小將3", 12, "台南");
//		System.out.println(res);
//	}
//
//	@Test
//	public void insertInfo3() {
//		int res = pesonInfoDao.insertInfo3("AAA903", "小將4", 12, "台南");
//		System.out.println(res);
//	}
//
//	@Test
//	public void insertInfo4() {
//		int res = pesonInfoDao.insertInfo4();
//		System.out.println(res);
//	}
//
//	@Test
//	public void insertInfo5() {
//		int id = 1004;
//
//		int res = pesonInfoDao.insertInfo5(id, String.valueOf(id));
//		System.out.println(res);
//	}
//
//	@Test
//	public void updateInfo1() {
//
//		int res = pesonInfoDao.updateNameById("王曉明", "3");
//		System.out.println(res);
//	}
//
//	@Test
//	public void findByIdAndName0() {
//
//		PersonInfo res = pesonInfoDao.findByIdAndName0("王曉明", "3");
//		System.out.println(res.getId());
//		System.out.println(res.getAge());
//		System.out.println(res.getCity());
//		System.out.println(res.getName());
//	}
//
//	@Test
//	public void findByIdAndName1() {
//
//		PersonInfo res = pesonInfoDao.findByIdAndName1("王曉明", "3");
//		System.out.println(res.getId());
//		System.out.println(res.getAge());
//		System.out.println(res.getCity());
//		System.out.println(res.getName());
//	}
//
//	@Test
//	public void findByIdAndName4() {
//
//		List<Map<String, Object>> res = pesonInfoDao.findByIdAndName4("王曉明", "3");
//		for (Map<String, Object> item : res) {
//			for (Entry<String, Object> map : item.entrySet()) {
//				System.out.println(map.getKey());
//				System.out.println(map.getValue());
//
//			}
//		}
//	}
//
//	@Test
//	public void selectLimitTest() {
//
//		List<PersonInfo> res = pesonInfoDao.findByAgeGreaterThanLimit3(18, 2, 3);
//		System.out.println(res.size());
//		for (PersonInfo item : res) {
//			System.out.println(item.getAge());
//		}
//
//	}
//
//	@Test
//	public void selectRegexpTest() {
//		List<String> list = new ArrayList<>(Arrays.asList("北", "中", "南"));
////		Set<String>set=new HashSet<>(list); //set去重複
//		String regexp = String.join("|", list); // 可以取代串接
//		List<PersonInfo> res = pesonInfoDao.findByCityRegexp(regexp);
//		System.out.println(res.size());
////		for (int i=0;i<list.size();i++) {
////			int listLengh= list.size()-1;
////			if(i==listLengh) {
////				 regexp=regexp+list.get(i);
////				break;
////			} else {
////			    regexp=regexp+list.get(i)+"|";}
////			
////			
////			}System.out.println( regexp);
//
//		for (PersonInfo item : res) {
//			System.out.println(item.getAge());
//			System.out.println(item.getCity());
//			System.out.println(item.getName());
//		}
//	}
//
////		
//
//	@Test
//	public void selectRegexpTest1() {
//		List<String> citylist = new ArrayList<>(Arrays.asList("北", "中", "南"));
//		List<String> namelist = new ArrayList<>(Arrays.asList("m"));
////	Set<String>set=new HashSet<>(list); //set去重複
//		String regexpCity = String.join("|", citylist); // 可以取代串接
//		String regexpName = String.join("|", namelist); // 可以取代串接
//		List<PersonInfo> res = pesonInfoDao.findByCityOrNameRegexp(regexpCity, regexpName);
//		System.out.println(res.size());
////	for (int i=0;i<list.size();i++) {
////		int listLengh= list.size()-1;
////		if(i==listLengh) {
////			 regexp=regexp+list.get(i);
////			break;
////		} else {
////		    regexp=regexp+list.get(i)+"|";}
////		
////		
////		}System.out.println( regexp);
//
//		for (PersonInfo item : res) {
//			System.out.println(item.getAge());
//			System.out.println(item.getCity());
//			System.out.println(item.getName());
//		}
//	}
//
////	
//	@Test
//	public void joinTwoTableTest() {
//		List<Map<String, Object>> res = pesonInfoDao.jointwotable();
//
//		for (Map<String, Object> item : res) {
//			for (Entry<String, Object> mapItem : item.entrySet()) {
//				System.out.println(mapItem.getKey());
//				System.out.println(mapItem.getValue());
//			}
//		}
//
//	}
//
//	@Test
//	public void joinTwoTableTest1() {
//		PersonInfoBankVo res = pesonInfoDao.jointwotable3("A01");
//		System.out.println(res.getId());
//		System.out.println(res.getAmount());
//		System.out.println(res.getName());
//
//	}

	@Test
	public void findAllTest() { //pageable
		Page<PersonInfo> res = pesonInfoDao.findAll(PageRequest.of(3, 3));
		
		for(PersonInfo item:res) {
			System.out.println(item.getId());
			System.out.println(item.getName());
		}
	}}
	
//	@Test
//	public void  findByRegexpPaging() {
//		Page<PersonInfo> res = pesonInfoDao.findByRegexpPaging("北|中|南",PageRequest.of(0, 3));   
//		
//		for(PersonInfo item:res) {
//			System.out.println(item.getId());
//			System.out.println(item.getName());
//		}
//	}
//
//}

//	   
//	   
//	   @Test
//	   public void findByAgeDaoTest() {
//		   //新增一筆假資料。
////		   PersonInfo personInfo= new PersonInfo("testA","testB",66,"桃園");
////		   pesonInfoDao.save(personInfo);//因為要測試所以不用回傳
//		   //測試
//		   List<PersonInfo>result= pesonInfoDao.findByAge(66);
//		   Assert.isTrue(result.size()==1, "test error");//前面結果對V，不對拋字串。result.size()表示筆數。
//		   //Assert.斷言>>istrue(result.size()==1)，錯誤"test error"
//		   //刪除新增假資料
////		   pesonInfoDao.delete(personInfo);
//		   
//	   }
//		   @Test
//		   public void findByAgeGreaterThanDaoTest() {
//			   
////			   新增假資料在beforEach
////			   PersonInfo personInfo1= new PersonInfo("testA","testName",42,"屏東");
////			   PersonInfo personInfo2= new PersonInfo("testB","testName",45,"屏東");
////			   PersonInfo personInfo3= new PersonInfo("testC","testName",48,"屏東");
////			   list= Arrays.asList(personInfo1,personInfo2,personInfo3);
////			   pesonInfoDao.saveAll(list);
//			   
//			   
//			   List<PersonInfo>result= pesonInfoDao.findByAgeGreaterThan(40);
//			   Assert.isTrue(result.size()==3, "test error");
////			   pesonInfoDao.deleteAll(list); 刪除放到afterEach
//		   }
//		   
//		   @BeforeEach//通常用在新增假資料
//		   public void beforeEachTest() {
//			   PersonInfo personInfo1= new PersonInfo("testA","testName",42,"屏東");
//			   PersonInfo personInfo2= new PersonInfo("testB","testName",45,"屏東");
//			   PersonInfo personInfo3= new PersonInfo("testC","testName",66,"屏東");
//			   list= Arrays.asList(personInfo1,personInfo2,personInfo3);
//			   pesonInfoDao.saveAll(list);
//		   }
//		   
//		   
//		   
//		   
//		   @AfterEach//通常用於刪除在@BeforeEach 新增的測試資料
//		   public void afterEachTest() {
//			   pesonInfoDao.deleteAll(list);
//		   }
//		   
//		   @BeforeAll//通常用在新增假資料
//		   public void beforeAllTest() {
//			   PersonInfo personInfo1= new PersonInfo("testA","testName",42,"屏東");
//			   PersonInfo personInfo2= new PersonInfo("testB","testName",45,"屏東");
//			   PersonInfo personInfo3= new PersonInfo("testC","testName",66,"屏東");
//			   list= Arrays.asList(personInfo1,personInfo2,personInfo3);
//			   pesonInfoDao.saveAll(list);
//		   }
//		   
//		   @AfterAll//通常用於刪除在@BeforeEach 新增的測試資料
//		   public void afterAllTest() {
//			   pesonInfoDao.deleteAll(list);
//		   }
