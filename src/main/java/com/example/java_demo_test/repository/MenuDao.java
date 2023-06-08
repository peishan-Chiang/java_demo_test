package com.example.java_demo_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java_demo_test.entity.Menu;

@Repository
public interface MenuDao extends JpaRepository<Menu,String> {

}
