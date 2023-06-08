package com.example.java_demo_test.repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.vo.PersonInfoBankVo;

@Repository
public interface PersonInfoDao extends JpaRepository<PersonInfo, String> {

	// 預期find回傳會有多筆，用list作回傳銜接
	// findBy+Entity的屬性名稱會抓JpaRepository<PersonInfo,String>的Entity
	// 這邊只會定義方法
	List<PersonInfo> findByAge(int age);

	List<PersonInfo> findByAgeGreaterThan(int age);

	List<PersonInfo> findByAgeLessThanEqual(int age);

	List<PersonInfo> findByCityAndAgeGreaterThan(String city, int age);

	List<PersonInfo> findByCityContaining(String city);

	

	// 用模糊搜尋去改TOP
	List<PersonInfo> findTop2ByCityContaining(String city);

	List<PersonInfo> findFirst2ByCityContaining(String city);

	// 用模糊搜尋去改OrderBy
	List<PersonInfo> findByCityContainingOrderByAge(String city);

	List<PersonInfo> findByCityContainingOrderByAgeAsc(String city);

	List<PersonInfo> findByCityContainingOrderByAgeDesc(String city);

	// 作業
	// 包含15~30
	List<PersonInfo> findByAgeBetween(int fromdata, int todata);

	// >30 and <20 不成立。為[]
	List<PersonInfo> findByAgeGreaterThanAndAgeLessThan(int fromdata, int todata);

	// >30 or <20
	List<PersonInfo> findByAgeGreaterThanOrAgeLessThan(int fromdata, int todata);

	// >30 or <20 or city IS Tainan;
	List<PersonInfo> findByAgeGreaterThanOrAgeLessThanOrCity(int fromdata, int todata, String city);

	// insert有相同資料會報錯，成功會回傳1，失敗會回傳0
	// insert into PersonInfo() 1.PersonInfo是entity 所以括號裡面是java的屬性，不是SQL_colume
	// values() 括號資料是從request來 從外部請求來的變數名稱要+【:】
	// @Param("inputId") inputId為 請求對應變數
	// build.gradle->id 'org.springframework.boot' version
	// '2.7.10'，insert只支援2.7.10以上
	// ==== +value 及+,nativeQuery=true======
	// insert into + SQL table 的名稱-> person_info
	// insert into ( ) 請確認括號內為SQLcolume名稱
//
//	@Transactional
//	@Modifying
//	@Query(value = "insert into person_info(id,name,age,city) values(:inputId, :inputName,:inputAge,:inputCity)", nativeQuery = true)
//	public int insertInfo(@Param("inputId") String id, @Param("inputName") String name, @Param("inputAge") int age,
//			@Param("inputCity") String City);
//
//	// ?1 代表第一個參數要填入
//
//	@Transactional
//	@Modifying
//	@Query(value = "insert into person_info(id,name,age,city) values(?1, ?2,?3, ?4)", nativeQuery = true)
//	public int insertInfo2(String id, String name, int age, String City);
//	
//	
//	
//	//判斷唯一性 where not exists
//	//"where not exists(select 1 from person_info where id= :inputId)"，如果請求在資料庫有值會有1，但1不能存在，如有有1 我就不做建立資料
//	//select 1 作為有值的回傳，如果有值， 會有一個colume 1 及 row內容為1
//	//id= :inputId  inputId為外部資料 要【:】
//	//value 改select 因為是SQL語法所以不用()
//	//cause 錯誤如果是問你where 通常是斷行問題 先將字串鏈結+space+enter，重斷行
//	
//	@Transactional
//	@Modifying
//	@Query(value = "insert into person_info(id,name,age,city) "
//			+ "select :inputId, :inputName,:inputAge,:inputCity "
//			+ "where not exists(select 1 from person_info where id= :inputId)"  
//			, nativeQuery = true)
//	public int insertInfo3(@Param("inputId") String id, @Param("inputName") String name, @Param("inputAge") int age,@Param("inputCity") String City);
//
//
//	
//	@Transactional
//	@Modifying
//	@Query(value = "insert into person_info(id ,name,age,city) "
//			+ "select id ,name,age,city from customers "
//		
//			+ "where id=10 "
////			+ "and exists (select 1 from customers c where c.id=10)"  
//			, nativeQuery = true)
//	public int insertInfo4(
//
//			);
//	
//	
//	@Transactional
//	@Modifying
//	@Query(value = "insert into person_info(id ,name,age,city) "
//			+ "select id ,name,age,city from customers where id=:customerId " 
//			+ "and exists (select 1 from customers c where c.id=:personId)" //判斷key的資料是否存在 customers.id=person_info.id?
//			, nativeQuery = true)
//	public int insertInfo5(
//			@Param("customerId") int customerId,
//			@Param("personId") String personId
//			);
//	       //因為 customers 為ai所以型態為int
//	       // person_info為 varchar型態為String
//	
////===============================================================================================================================================
//
//	@Transactional
//	@Modifying
//	@Query("update PersonInfo set name=:InputName where id=:InputId")
//	public int updateNameById(
//			@Param("InputName") String name,
//			@Param("InputId") String id
//			);
//	//上面:一般方法 下面native方法
//	@Transactional
//	@Modifying
//	@Query(value="update person_info set name=:InputName where id=:InputId " ,nativeQuery = true)
//	public int nativeUpdateNameById(
//			@Param("InputName") String name,
//			@Param("InputId") String id
//			);
//	
////===============================================================================================================================================
//	//select all columns:等於JPA findByIdAndName
//	@Query("select p from PersonInfo p where name=:InputName and id=:InputId")
//	public PersonInfo findByIdAndName (
//			@Param("InputName") String name,
//			@Param("InputId") String id
//			
//			);
//	
//	
//	//select all columns:等於JPA findByIdAndName replace by ?
//	@Query("select p from PersonInfo p where name=?1 and id=?2")
//	public PersonInfo findByIdAndName0 (
//			String name,
//			String id
//			
//			);
//	
//	//select id, name, age
//	@Query("select new PersonInfo(p.id, p.name, p.age)  from PersonInfo p where name=:InputName and id=:InputId")
//	public PersonInfo findByIdAndName1 (
//			@Param("InputName") String name,
//			@Param("InputId") String id
//			
//			);
//	
//	//native 版本
//	//select all columns
//	@Transactional
//	@Modifying
//	@Query(value="select id, name, age  from person_info  where name=:InputName and id=:InputId" ,nativeQuery = true)
//	public PersonInfo findByIdAndName2 (
//			@Param("InputName") String name,
//			@Param("InputId") String id
//			
//			);
//	
//	//select all columns_use *
//	@Transactional
//	@Modifying
//	@Query(value="select *  from person_info  where name=:InputName and id=:InputId" ,nativeQuery = true)
//	public PersonInfo findByIdAndName3 (
//			@Param("InputName") String name,
//			@Param("InputId") String id
//			
//			);
//	
//	//select id, name, age:不實用
//	@Query(value="select id, name,age  from person_info  where name=:InputName and id=:InputId" ,nativeQuery = true)
//	public List<Map<String, Object>> findByIdAndName4 (
//			@Param("InputName") String name,
//			@Param("InputId") String id
//			
//			);
//	
//	//select limit(native only)
//	@Query(value="select * from person_info   where age> :InputAge  limit :num" ,nativeQuery = true)
//	public List<PersonInfo> findByAgeGreaterThanLimit (//
//			@Param("InputAge") int age,//
//			@Param("num") int limitNum//
//			
//			);
//	
//	
//	//select limit(native only) with start_position
//		@Query(value="select * from person_info   where age> :InputAge  limit :startPostion, :num" ,nativeQuery = true)
//		public List<PersonInfo> findByAgeGreaterThanLimit2 (//
//				@Param("InputAge") int age,//
//				@Param("startPostion") int startPostion ,//
//				@Param("num") int limitNum//
//				
//				);
//		
//		
//		//select limit(native only) with start_position use ? instead of @Param+:input
//				@Query(value="select * from person_info   where age> ?1  limit ?2, ?3" ,nativeQuery = true)
//				public List<PersonInfo> findByAgeGreaterThanLimit3 (//
//						 int age,//
//						 int startPostion ,//
//						int limitNum//
//						
//						);
//				
//				//select Regular expression(native only)
//				@Query(value="select * from person_info   where city regexp :input" ,//
//						nativeQuery = true)
//				public List<PersonInfo> findByCityRegexp (@Param("input") String input
//						);//
//				
//				
//				//select Regular expression(native only)
//				@Query(value="select * from person_info   where city regexp :inputCity or name regexp :inputName" ,//
//						nativeQuery = true)
//				public List<PersonInfo> findByCityOrNameRegexp (//
//						@Param("inputCity") String inputCity,//
//				        @Param("inputName") String inputName
//				        );//
//				
//				//select Regular expression(native only) replace by?
//				@Query(value="select * from person_info   where city regexp ?1 or name regexp ?2" //
//						,nativeQuery = true)
//				public List<PersonInfo> findByCityOrNameRegexp1 (//
//					 String inputCity,//
//				     String inputName
//				        );//
//				
//				//JPA:city containing 北 ，中， 南
//				List<PersonInfo> findByCityContainingOrCityContainingOrCityContaining(String city1,String city2,String city3);
////====================================== join ======================================================================
//				@Query(value="select p.id, p.name, b.amount from person_info p "
//						+ " join bank b on p.id=b.account where p.id='A01'",nativeQuery = true)
//				//因為回傳 會是陣列 ->所以是list
//				//而他只會提供內容，不知道對應欄位所以要Map
//				public List<Map<String, Object>>  jointwotable();
//				
//				
//				@Query(value="select p.id, p.name, b.amount from person_info p "
//						+ " join bank b on p.id=b.account where p.id= ?1",nativeQuery = true)
//				//因為回傳 會是陣列 ->所以是list
//				//而他只會提供內容，不知道對應欄位所以要Map
//				public List<Map<String, Object>>  jointwotable2(
//						String id);
//				
//				
//				
//				
//				//如果要用java Entity 來做join串表，不是native
//				//建立Vo一個類別->PersonInfoBankVo 將共要回傳的屬性建立
//				//建立 select + 新見類別_共通屬性_建構方法 from A_Entity join B_Entity 
//				
//				@Query("select new com.example.java_demo_test.vo.PersonInfoBankVo(p.id, p.name, b.amount) from PersonInfo p "
//						+ " join Bank b on p.id=b.account where p.id= ?1")
//				
//				public PersonInfoBankVo  jointwotable3(
//						String id);
//				
//				
////===============================================分頁======================================				
//				
				public Page<PersonInfo> findAll(Pageable pageable);
				
				@Query(value="select * from person_info  "
						+ " where city regexp :input",nativeQuery = true)
				public Page<PersonInfo> findByRegexpPaging(
					@Param("input")	String input,Pageable pageable);
			
	
}


