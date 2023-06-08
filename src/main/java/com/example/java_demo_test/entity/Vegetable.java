package com.example.java_demo_test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "vegetable_item")
public class Vegetable {

	

	
		
		@Id
		@Column(name="vg_Item_Id")
		private String id;
		
		@Column(name="vg_Item_Name")
		private String name;
		
		@Column(name="vg_Item_Price")
		private int price;
		
		@Column(name="vg_Item_Num")
		private int number;
		
		@Column(name="vg_Item_Explain")
		private String explain;
			
		@Column(name="vg_Item_Type")
		private String type;
		
		@Column(name="vg_Item_place")
		private String place;
		
		@Column(name="vg_Item_Date")
		private String date;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
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

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public String getExplain() {
			return explain;
		}

		public void setExplain(String explain) {
			this.explain = explain;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getPlace() {
			return place;
		}

		public void setPlace(String place) {
			this.place = place;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}
		
		
	
}
