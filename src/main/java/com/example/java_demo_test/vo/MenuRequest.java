package com.example.java_demo_test.vo;

import java.util.List;
import java.util.Map;

import com.example.java_demo_test.entity.Menu;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuRequest {
	
	
	
	@JsonProperty("menu_order")
	private Menu menu;
	
	@JsonProperty("menu_order_list")
	private List <Menu> MenuList;
	
	private String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public List<Menu> getMenuList() {
		return MenuList;
	}
	public void setMenuList(List<Menu> menuList) {
		MenuList = menuList;
	}
	
}
