package com.example.java_demo_test.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="menu_order")
public class Menu {
	
	 
//	private Map<String, Integer> map = new HashMap() ;
//	
//    public Map<String, Integer> getMap() {
//		return map;
//	}
//	public void setMap(Map<String, Integer> map) {
//		this.map = map;
//		
//	}
	
	@Id
	@Column(name="name")
	private String name;
	
	@Column(name="price") 
	private int price;
	
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Menu(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	
	
	
	
	

	
	
	

}
