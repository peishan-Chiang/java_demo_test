package com.example.java_demo_test.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java_demo_test.entity.Book;
import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.vo.BookResponse;

@ Repository
public interface BookDao extends JpaRepository<Book,String> {
	


	void save(List<String> classlist);
	
	List <Book> findByClassifyContaining(String classify);
	
	List <Book> findByNameContainingOrIsbnContainingOrAuthorContaining(String name, String isbn,String author);
	
	List<Book> findTop5ByOrderBySaleAmountDesc();
	
}
