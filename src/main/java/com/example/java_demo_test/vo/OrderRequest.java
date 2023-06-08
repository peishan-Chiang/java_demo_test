package com.example.java_demo_test.vo;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderRequest {
	
	@JsonProperty("menu_order")
	private Map<String,Integer> oredrMap;//餐店名稱+數量

	public Map<String, Integer> getOredrMap() {
		return oredrMap;
	}

	public void setOredrMap(Map<String, Integer> oredrMap) {
		this.oredrMap = oredrMap;
	}

}
