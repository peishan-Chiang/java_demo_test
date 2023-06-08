package com.example.java_demo_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_demo_test.entity.Menu;
import com.example.java_demo_test.service.ifs.OrderService;
import com.example.java_demo_test.vo.MenuRequest;
import com.example.java_demo_test.vo.MenuResponse;
import com.example.java_demo_test.vo.OrderRequest;

@RestController
public class MenuController {
	
	@Autowired
	private OrderService orderservice;
	
	@PostMapping("/addMenu")
	public MenuResponse addMenu(@RequestBody MenuRequest menuRequest) {
		return orderservice.addMenu(menuRequest);
	}
	
	@PostMapping("/getallMenu")
	public List<Menu> getAllMenu() {
		return orderservice.getAllMenu();
	}
	
	@PostMapping("/order")
	public MenuResponse order(@RequestBody OrderRequest orderreq) {
		return orderservice.order(orderreq);
	}
	
	
	@PostMapping("/seekMenu")
	public MenuResponse seekMenu(@RequestBody MenuRequest menuRequest) {
		return orderservice.seekMenu(menuRequest);
	}
	


}
