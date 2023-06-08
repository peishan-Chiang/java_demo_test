package com.example.java_demo_test.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.entity.Menu;
import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.repository.MenuDao;
import com.example.java_demo_test.service.ifs.OrderService;
import com.example.java_demo_test.vo.MenuRequest;
import com.example.java_demo_test.vo.MenuResponse;
import com.example.java_demo_test.vo.OrderRequest;
import com.example.java_demo_test.vo.PersonInfoResponseA;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private MenuDao menudao;

	@Override
	public MenuResponse addMenu(MenuRequest menuRequest) {

		List<Menu> errorlist = new ArrayList<>();
		List<Menu> menulist = menuRequest.getMenuList();

		if (CollectionUtils.isEmpty(menulist)) {
			return new MenuResponse("404 non request section");
		}

		for (Menu item : menulist) {
			if (!StringUtils.hasText(item.getName())) {
				return new MenuResponse("unfilled");
			}

			if (menudao.existsById(item.getName())) {
				errorlist.add(item);

			}
		}

		if (!errorlist.isEmpty()) {
			return new MenuResponse(errorlist, "primary key existed");
		}
//		else {
		menudao.saveAll(menulist);
		return new MenuResponse(menulist, "successed");
	}

	@Override
	public List<Menu> getAllMenu() {

		return menudao.findAll();
	}

	@Override
	public MenuResponse seekMenu(MenuRequest menuRequest) {
		String reqname = menuRequest.getName();
		if (!StringUtils.hasText(reqname)) {
			return new MenuResponse("unfilled");
		}
//		接收不確定的東西(可能是null或是有東西)
		Optional<Menu> op = menudao.findById(reqname);
		if (!op.isPresent()) {
			return new MenuResponse("404 non found,be null");
		}

		Menu list = op.get();

		return new MenuResponse(list, "infro provided");

	}

	@Override
	public MenuResponse order(OrderRequest orderreq) {

		// Map格式接收req的Map資料
		Map<String, Integer> orderMenu = orderreq.getOredrMap();

		int originaltotalPrice = 0;
		// Map的for遍歷作資料確認
		for (Entry<String, Integer> item : orderMenu.entrySet()) {

			String menuItem = item.getKey();// 抓Key值

			// 因為要get是否存在的資訊，需要使用Optional，而非 menudao.existsById()【為單純判斷式】
			Optional<Menu> op = menudao.findById(menuItem);
			if (!op.isPresent()) {
				return new MenuResponse("404 non found,be null");
			}

			Menu menu = op.get();

			// 作餐點運算
			int price = menu.getPrice();
			int itemTotalPrice = price * item.getValue();
			originaltotalPrice += itemTotalPrice;

		}
		int totalPrice = 0;
		return originaltotalPrice >= 500
				? new MenuResponse(orderMenu, originaltotalPrice, 
						(int) (originaltotalPrice * 0.9))
				: new MenuResponse(orderMenu, originaltotalPrice);
		
//		if (originaltotalPrice >= 500) {
//			totalPrice = (int) (originaltotalPrice * 0.9);
//			return new MenuResponse(orderMenu, originaltotalPrice, totalPrice);
//		}else{
//
//		return new MenuResponse(orderMenu, originaltotalPrice);}
	}
}

//	double total = 0;
//	int sum = 0;
//
//	@Override
//	public void totoal() {
//		System.out.println("總共" + sum + "請結帳");
//	}
//
//	@Override
//	public void OrderALL(Map<String, Integer> menumap) {
//
//		for (Entry<String, Integer> entry : menumap.entrySet()) {
//			System.out.println(entry.getKey() + " ：" + entry.getValue());
//		}
//	}
//
//	@Override
//	public Menu addOrder(Map<String, Integer> menumap) {
//		Menu menu = new Menu();
//		menu.setMap(menumap);
//		return menu;
//	}
//
//	@Override
//	public void OrderMenu(Map<String, Integer> menumap, String string, int amount) {
//
//		if (menumap.containsKey(string)) {
//			int price = menumap.get(string);
//
////				for (Entry<String, Integer> entry : menumap.entrySet()) {
////			if (menumap.equals(string)) {
//			if (price * amount >= 500) {
//				System.out.println(string + "份數" + amount + "總共: " + (price * amount * 0.9));
//				total = price * amount * 0.9;
//				sum += total;
//			}
//			if (price * amount < 500) {
//				System.out.println(string + "份數" + amount + "總共: " + (price * amount * 1));
//				;
//				total = price * amount * 1;
//				sum += total;
//			}
//		}
//	}
//
//// 老師提供點餐的方法
//	@Override
//	public void order(Menu menu, Map<String, Integer> ordermap) {
//		int totalPrice = 0;
//		Map<String, Integer> menuMap = new HashMap<>();
//		for (Entry<String, Integer> item : ordermap.entrySet()) {
//			String key = item.getKey();
//			int value = item.getValue();
//			System.out.println(item.getKey() + "數量" + item.getValue());
//			// 防呆:防餐點不再menu中，及數量大於0
////			if(!menuMap.containsKey(key)||value<=0) {
////				continue;
////			}else {
//
//			int itemTotalPrice = menuMap.get(key) * value;
//
//			// 印出單一品項、數量及單項總價格
//			System.out.println(item.getKey() + "數量" + item.getValue() + "價格:" + itemTotalPrice);
//
//			if (totalPrice > 500) {
//				int newTotalPrice = (int) (totalPrice * 0.9);
//				System.out.println("餐點總價格:" + totalPrice + "折扣後總價格:" + newTotalPrice);
//
//			}
//			System.out.println("餐點總價格:" + totalPrice);
//
//		}
//
//	}
//
//	//本人協助修正版
//	
//	@Override
//	public void order1(Map<String, Integer> menumap, Map<String, Integer> ordermap) {
//		int totalPrice = 0;
//		for (Entry<String, Integer> item : ordermap.entrySet()) {
//			String key = item.getKey();
//			int value = item.getValue();
////			System.out.println(item.getKey() + "數量" +item.getValue()+"單價"+menumap.get(key));
//			// 防呆:防餐點不再menu中，及數量大於0
//			if (!menumap.containsKey(key) || value <= 0) {
//				continue;}
////			}else {
//
//				int itemTotalPrice = menumap.get(key) * value;
//				totalPrice += itemTotalPrice;
//				// 印出單一品項、數量及單項總價格
//				System.out.println(item.getKey() + "數量" + item.getValue() + "價格:" + itemTotalPrice);
//
//				
//
//			}if (totalPrice > 500) {
//				int newTotalPrice = (int) (totalPrice * 0.9);
//				System.out.println("餐點總價格:" + totalPrice + "折扣後總價格:" + newTotalPrice);
//
//			} else {
//				System.out.println("餐點總價格:" + totalPrice);
//			}
//
//		}
