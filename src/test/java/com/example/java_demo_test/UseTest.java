package com.example.java_demo_test;

import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.java_demo_test.entity.Users;
import com.example.java_demo_test.repository.UserDao;

@SpringBootTest(classes=JavaDemoTestApplication.class)
public class UseTest {
	@Autowired
	private UserDao userDao;
	
	@Test
    void test() {
		
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		Users u1=new Users("AAA",encoder.encode("AA123"),"admin",true);
		Users u2=new Users("bbb",encoder.encode("bb123"),"user",true);
		Users u3=new Users("ccc",encoder.encode("cc123"),"user",true);
		Users u4=new Users("ddd",encoder.encode("dd123"),"user",false);
		List<Users> list=Arrays.asList(u1,u2,u3,u4);
		userDao.saveAll(list);
	};
	
	
	
}
