package com.example.java_demo_test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java_demo_test.entity.Users;



@Repository
public interface UserDao extends JpaRepository<Users,Integer> {
	public Users findByUserName(String userName);

}
