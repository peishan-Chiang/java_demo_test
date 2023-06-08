package com.example.java_demo_test.service.ifs;

import java.util.List;
import java.util.Map;

import com.example.java_demo_test.entity.Menu;
import com.example.java_demo_test.vo.MenuRequest;
import com.example.java_demo_test.vo.MenuResponse;
import com.example.java_demo_test.vo.OrderRequest;

public interface OrderService {
//	public void totoal();
//	public void order1(Map<String, Integer> menumap,Map<String, Integer> ordermap);
//	public void order(Menu menu,Map<String, Integer> ordermap);
//	public void OrderALL(Map<String, Integer> menumap);
//	public Menu addOrder(Map<String, Integer> menumap);
//	public void OrderMenu(Map<String, Integer> menumap, String string, int amount);
	
	public MenuResponse addMenu(MenuRequest menuRequest);
	
	public List<Menu> getAllMenu();
	
	public MenuResponse order(OrderRequest orderreq);
	
	public MenuResponse seekMenu(MenuRequest menuRequest);
	
}
