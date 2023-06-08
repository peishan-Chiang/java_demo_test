package com.example.java_demo_test.vo;

import java.util.List;
import java.util.Map;

import com.example.java_demo_test.entity.Book;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookRequestWithoutClass {
	
	private Book book;
	@JsonProperty("book_list")
	private List<Book> booklist;
	
	List<String> classlist;
	
	@JsonProperty("buy_list")
	private Map<String,Integer> buymap;
	
	
	private String message;
	private String isbn;
	
	
	private String name;
	private String author;
    private Integer price;
    private Integer saleAmount;
	private Integer stock;
	private Integer num;
	public BookRequestWithoutClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public List<Book> getBooklist() {
		return booklist;
	}
	public void setBooklist(List<Book> booklist) {
		this.booklist = booklist;
	}
	public List<String> getClasslist() {
		return classlist;
	}
	public void setClasslist(List<String> classlist) {
		this.classlist = classlist;
	}
	public Map<String, Integer> getBuymap() {
		return buymap;
	}
	public void setBuymap(Map<String, Integer> buymap) {
		this.buymap = buymap;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getSaleAmount() {
		return saleAmount;
	}
	public void setSaleAmount(Integer saleAmount) {
		this.saleAmount = saleAmount;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}

}
