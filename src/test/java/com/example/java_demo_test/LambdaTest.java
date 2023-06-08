package com.example.java_demo_test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.example.java_demo_test.entity.Register;

public class LambdaTest {

	@Test
	public void listForEachTest() {

		List<String> strList = new ArrayList<>(Arrays.asList("a", "b", "c"));
		// Lambda
		strList.forEach((item) -> {
			System.out.println(item);
		});
		// 參數列表只有一個參數的時候，小括號可以省略
		strList.forEach(item -> {
			System.out.println(item);
		});
		// 表達式主體只有一行的時候，大括號跟結尾的分號可以省略
		strList.forEach(item -> System.out.println(item));

	}

	@Test
	public void mapForEachTest() {
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 1);
		map.put("B", 1);
		map.put("C", 1);
		for (Entry<String, Integer> item : map.entrySet()) {
			System.out.println(item.getKey());
			System.out.println(item.getValue());
		}

		// Lambda
		map.forEach((Key, Value) -> {
			System.out.println(Key);
			System.out.println(Value);
		});
		Map<String, Integer> map1 = new HashMap<>();
		map1.put("AA", 1);
		map1.put("BB", 1);
		map1.put("CC", 1);

		List<Map<String, Integer>> mapList = new ArrayList<>(Arrays.asList(map, map1));
		mapList.forEach(mapA -> {
			mapA.forEach((k, v) -> {
				System.out.println(k);
				System.out.println(v);
			});
		});

		mapList.forEach(mapA -> mapA.forEach((k, v) -> {
			System.out.println(k);
			System.out.println(v);

		}));

	}

	@Test
	public void listToMap() { // map 沒有重複的key

		Register register1 = new Register("A01", "AA123");
		Register register2 = new Register("A02", "BB123");
		Map<String, String> map = new HashMap<>();
		List<Register> mapList = new ArrayList<>(Arrays.asList(register1, register2));
		for (Register item : mapList) {
			map.put(item.getAccount(), item.getPwd());
		}

		// Lambda_foreach
		mapList.forEach(item -> {
			map.put(item.getAccount(), item.getPwd());
		});

		Map<String, String> mapStream = mapList.stream()
				.collect(Collectors.toMap(Register::getAccount, Register::getPwd));
		map.forEach((k, v) -> {
			System.out.println(k);
			System.out.println(v);
		});

		mapStream.forEach((k, v) -> {
			System.out.println(k);
			System.out.println(v);
		});

	}

	@Test
	public void listToMap2() {// map 有重複的key -> 會報錯 ->Register::getPwd//,(k1,k2)->k1 【表示當遇到重複，我要保留k1(比較舊的資料)】

//		建構資料
		Register register1 = new Register("A02", "AA123");
		Register register2 = new Register("A02", "BB123");
		Register register3 = new Register("A03", "BB123");

		Map<String, String> map = new HashMap<>();
		List<Register> mapList = new ArrayList<>(Arrays.asList(register1, register2, register3));
		for (Register item : mapList) {
			map.put(item.getAccount(), item.getPwd());
		}

		// Lambda_foreach
		System.out.println("Lambda_foreach");
		mapList.forEach(item -> {
			map.put(item.getAccount(), item.getPwd());
		});

		// Lambda_stream
		System.out.println("Lambda_stream");
		Map<String, String> mapStream = mapList.stream().collect(Collectors.toMap(//
				Register::getAccount, Register::getPwd//
				, (k1, k2) -> k1));

		mapStream.forEach((k, v) -> {
			System.out.println(k);
			System.out.println(v);
		});

		System.out.println("map");
		map.forEach((k, v) -> {
			System.out.println(k);
			System.out.println(v);
		});

	}

	@Test
	public void compareTest() { // 用stream本來的List結構不會變
		List<Integer> list = new ArrayList<>(Arrays.asList(7, 1, 10, 6, 3));
		list.sort((o1, o2) -> o1.compareTo(o2));
		list.forEach(item -> {
			System.out.println(item);
		});
		// Lambda_stream
		List<Integer> list1 = new ArrayList<>(Arrays.asList(7, 1, 10, 6, 3));
		System.out.println("Lambda_stream_ASC");
		List<Integer> ASCList = list1.stream().sorted().collect(Collectors.toList()); // ASC
		ASCList.forEach(item -> {
			System.out.println(item);
		});

		System.out.println("Lambda_stream_DESC");
		List<Integer> list2 = new ArrayList<>(Arrays.asList(7, 1, 10, 6, 3));
		List<Integer> DESCList = list2.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()); // DESC
		DESCList.forEach(item -> {
			System.out.println(item);
		});

	}

	public void filterTest() { // filter
		List<Integer> list = new ArrayList<>(Arrays.asList(7, 1, 10, 6, 3));
		List<Integer> listNew = new ArrayList<>();
		for (Integer item : list) {
			if (item % 2 == 1) {
				listNew.add(item);
			}
		}

		List<Integer> listNew2 = list.stream().filter(item -> item % 2 == 1).collect(Collectors.toList());
		listNew2.forEach(item -> {
			System.out.println(item);
		});

	}

	@Test
	public void mapTest() {// map->List
		List<Integer> list = new ArrayList<>(Arrays.asList(7, 1, 10, 6, 3));
		List<Integer> newList = list.stream().map(item -> {
			Integer i = Integer.valueOf(item);
			i += 2;
			return i;
		}).collect(Collectors.toList());

		list.forEach(item -> {
			System.out.println(item);
		});
		System.out.println("===================");
		newList.forEach(item -> {
			System.out.println(item);
		});

	}
	@Test
	public void reduceTest() { //疊加(加減乘除)
		List<Integer> list = new ArrayList<>(Arrays.asList(7, 1, 10, 6, 3));
		Optional<Integer> res = list.stream().reduce((i, j) -> i + j);
		System.out.println(res.get());
		
		Integer res1 = list.stream().reduce(100,(i, j) -> i + j);
		System.out.println(res1);
	}
	
	@Test
	public void consumerTest() {
		Consumer<String> c =x ->{
			System.out.println(x.toLowerCase());
		};
		System.out.println("================");
		c.accept("ABC");
	}
	
	@Test
	public void functionTest() {
		Function<Integer,String>f=x->{  //Function<參數(input型態),回傳(return型態)>所以x為Integer f=String.valueOf(y)
			int y=x*10;
			return String.valueOf(y);
		};
		System.out.println(f.apply(5));
	} 
	
	@Test
	public void functionTest2() {
		Function<String,String>f=str->{  //Function<參數(input型態),回傳(return型態)>所以x為Integer f=String.valueOf(y)
			
			return "Hi"+str;
		};
		System.out.println(f.apply("java"));
	} 
	
	@Test
	public void biConsumerTest() {
		BiConsumer<String,String>c=(x,y)->{ //Binary
			System.out.println(x+" "+y);
		};
		c.accept("hello","java");
	} 
	
	@Test
	public void biFunctionTest1() { //允許多個
		BiFunction<Integer,Integer,String> f=(x,y)->{
			int z=x+y;
			return String.valueOf(z);
		};
		System.out.println(f.apply(2, 3));
	} 
	
	@Test
	public void predicateTest() { //斷言->判斷句
		Predicate<String> p= x->{
			return x.length() > 3;
		};
		System.out.println(p.test("java"));
		
	} 
	
	@Test
	public void predicateTest1() { //斷言->判斷句
		
		Predicate<String> p= x->{  //只能針對一向判斷
			return x.length()>4;
		};
		List<String> list = new ArrayList<>(Arrays.asList("C++","Java","Python","Kotlin"));	
		list.forEach(item->{
			System.out.println(p.test(item));//呼叫判斷
		});
		
		
	} 
	
	@Test
	public void andpredicateTest1() { //斷言->判斷句
		
		Predicate<String> p1= x->{  //只能針對一向判斷
			return x.length()>3;
		};
		Predicate<String> p2= x->{  //只能針對一向判斷
			return x.startsWith("C");
		};
		
		List<String> list = new ArrayList<>(Arrays.asList("C++","Java","Python","Kotlin"));	
		list.forEach(item->{
//			boolean res=p1.and(p2).test(item);//有P1跟P2的條件去驗證item
			boolean res=p1.or(p2).test(item);//有P1跟P2的條件去驗證item
			System.out.println(res);
		});
		
		
	} 
	
	@Test
	public void  supplierTest() { //斷言->判斷句
		
		Supplier<String> s= ()->{  //只能針對一向判斷
			return "Hello Java";
		};
		System.out.println(s.get()); //用get
		
		
		
	} 
	
	
	@Test
	public void intSupllierTest() {
		IntSupplier s=()->{ //IntSupplier不用回傳型態
			
			return 123;
			
		};
		System.out.println(s.getAsInt());
	}
	@Test
	public void doubleSupllierTest() {
		DoubleSupplier s=()->{ //不用回傳型態
			
			return 123;
			
		};
		System.out.println(s.getAsDouble());
	}
	
	
}
