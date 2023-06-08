package com.example.java_demo_test.vo;

import java.util.List;
import java.util.Map;

import com.example.java_demo_test.entity.Menu;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuResponse {

	
	@JsonProperty("order_menu")
	private Map<String,Integer>ordermap;
	
	@JsonProperty("original_total_Price")
	private Integer originaltotalPrice;
	
	@JsonProperty("total_Price")
	private Integer totalPrice;
	
	
	@JsonProperty("menu_order_list")
	private List<Menu> MenuList;

	private String message;
	@JsonProperty("menu_order")
	private Menu menu;

	

	public MenuResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MenuResponse(Map<String, Integer> ordermap, Integer originaltotalPrice) {
		super();
		this.ordermap = ordermap;
		this.originaltotalPrice = originaltotalPrice;
	}


	public MenuResponse(Map<String, Integer> ordermap, Integer originaltotalPrice, Integer totalPrice) {
		super();
		this.ordermap = ordermap;
		this.originaltotalPrice = originaltotalPrice;
		this.totalPrice = totalPrice;
	}


	public MenuResponse(Menu menu, String message) {
		super();
		this.menu = menu;
		this.message = message;
	}

	public MenuResponse(String message) {
		super();
		this.message = message;
	}

	public MenuResponse(List<Menu> menuList) {
		super();
		MenuList = menuList;

	}

	public MenuResponse(List<Menu> menuList, String message) {
		super();
		MenuList = menuList;
		this.message = message;
	}

	public MenuResponse(Menu menu) {
		super();
		this.menu = menu;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public Map<String, Integer> getOrdermap() {
		return ordermap;
	}


	public void setOrdermap(Map<String, Integer> ordermap) {
		this.ordermap = ordermap;
	}


	public Integer getOriginaltotalPrice() {
		return originaltotalPrice;
	}


	public void setOriginaltotalPrice(Integer originaltotalPrice) {
		this.originaltotalPrice = originaltotalPrice;
	}


	public Integer getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}


	public List<Menu> getMenuList() {
		return MenuList;
	}


	public void setMenuList(List<Menu> menuList) {
		MenuList = menuList;
	}


	public Menu getMenu() {
		return menu;
	}


	public void setMenu(Menu menu) {
		this.menu = menu;
	}


}
