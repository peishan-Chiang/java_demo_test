package com.example.java_demo_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.entity.Bird;
import com.example.java_demo_test.entity.Book;
import com.example.java_demo_test.entity.Menu;
import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.repository.BookDao;
import com.example.java_demo_test.service.ifs.Activity;
import com.example.java_demo_test.service.ifs.BankService;
import com.example.java_demo_test.service.ifs.BookService;
import com.example.java_demo_test.service.ifs.OrderService;
import com.example.java_demo_test.service.impl.ActivityImpl;

import com.example.java_demo_test.vo.BookRequest;
import com.example.java_demo_test.vo.BookResponse;

@SpringBootTest(classes=JavaDemoTestApplication.class)
class JavaDemoTestApplicationTests {
	@Autowired
	private com.example.java_demo_test.service.ifs.RegisterService registerService;
	
	
	@Test
    void contextLoads() {
		
	};
	
	
}
//
//	@Autowired
//	private Activity activity;
//	@Autowired
//	private BankService bankService;
//	
//	@Autowired
//	private OrderService orderService;
//	@Autowired
//	private BookService  bookService;
//	@Autowired
//	private BookDao bookdao;
//
//////	@Test
//////	void contextLoads() {
//////		
//////		Bird bird =new Bird ("CCC",5);
//////		activity.fly(bird.getName(), bird.getAge());}
////
////		@Test
////		void bankserviceTest() {
////		Scanner scanner = new Scanner(System.in);
////		
////		Bank bank = new Bank(0,"233");
////		bankService.getAmount(bank);
////		System.out.println("==========");
////		System.out.println("請問要存入多少");
////		int behavior=scanner.nextInt();
////		
//////		while(behavior<=0) {
//////		System.out.println("請重新下提款");
//////		behavior=scanner.nextInt();}
////		bankService.deposit(bank, behavior);
////		
////		
////		System.out.println("==========");
////		System.out.println("請問要提領多少");
////		int output=scanner.nextInt();
////		bankService.withdraw(bank, output);
////		System.out.println("==========");
////		bankService.deposit(bank, 200);
////		}		
////		
////	
//
////   @Test
////    void muticlassify() {
////	
////	 Book data=new Book("898989","name","author","精神科學"); 
////	 List<String> classlist=new ArrayList<>();
////	 classlist=Arrays.asList("人文關懷","社會科學"); 
////	 
////	
//////	!StringUtils.hasText(req.getName()) ||
////	
////	 
////	  
////		
////	String string =" ";
////	for (String classifyitem : classlist) {
////		String str = classifyitem.toString();
////		string=str+";"+string;
////	}
////	
////	
////	
////	
////
//////	
////	System.out.println(string+"Update the classifyinfo");
////}
//   @Test
//   void classifyContain() {
//	List <Book> result = new ArrayList<>();
//	Book data1=new Book("898989","name","author",100,2,3,"神學");
//	Book data2=new Book("898980","name","author2",100,2,3,"神學"); 
//	result= Arrays.asList(data1,data2);
//	bookdao.saveAll(result);
//    
//	
//	bookdao.findByClassifyContaining("神學");
//	Assert.isTrue(result.size()==2, "test error");
//	
//	List <Book> booklist = new ArrayList<>();	
//	for (Book item : result) {
//		
//		item.setSaleAmount(0);
//		item.setClassify(null);
//		booklist.add(item);
//	}
//	
//	System.out.println(booklist); 
//   
//   
//}
//}
////	@Test
////	void MenuTest() {
////			
////		Scanner scanner = new Scanner(System.in);
////		Map<String,Integer> newMenuMap =new HashMap<>();
////		newMenuMap.put("pork",200);
////		newMenuMap.put("beef",300);
////		newMenuMap.put("lamb",350);
////		Menu newMenu=orderService.addOrder(newMenuMap);
////		//Menu newMenu是要宣告一個記憶體空間給他。
////	
////		orderService.OrderALL(newMenuMap);
////		
////		
////		System.out.println("===========");
////		
////		String thing;
////		int piece=0;
////		int total=0;
////		int sum=0;
//		
////		System.out.println("請點餐");
////		for(;;) {
////			
////			 thing=scanner.next();
////			 
////			 if(thing.equals("0")) {orderService.totoal();break;}
////			 if(!newMenuMap.containsKey(thing)) { System.out.println("請一致名稱");continue;}//防呆菜單一致
////			 System.out.println(thing+"好，幾份");
////			 piece=scanner.nextInt();
////			 if(piece<=0) {System.out.println("數量有誤，請重下餐點名稱及數量");continue;}
////			 orderService.OrderMenu(newMenuMap, thing, piece);
////			 System.out.println("還有嗎?");
////			}
////		
////		
////		System.out.println("===========");
////		Map<String, Integer> orderMap =new HashMap<>();
////		Scanner scannerth = new Scanner(System.in);
////		System.out.println("請點餐:1 繼續點餐，0為結束點餐");
////		int count;
////		count=scanner.nextInt();		
////		while(count==1) {
////			System.out.println("請輸入品項");
////			String name =scannerth.next();
//////			if(!newMenuMap.containsKey(name)) {continue;}
////			System.out.println("請輸入數量: ");
////			int num=scannerth.nextInt();
//////			while (num<=0) {
//////				System.out.println("請輸入數量: ");
//////				num=scannerth.nextInt();
//////				};			
////			orderMap.put(name, num);
////			System.out.println("請點餐:1 繼續點餐，0為結束點餐");
////			count=scanner.nextInt();	
////			}
////			orderService.order1(newMenuMap, orderMap);
////			}
////		}

