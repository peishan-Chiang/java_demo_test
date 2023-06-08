package com.example.java_demo_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.example.java_demo_test.entity.Bird;
import com.example.java_demo_test.service.ifs.Activity;
import com.example.java_demo_test.service.impl.ActivityImpl;

@SpringBootApplication(exclude= {SecurityAutoConfiguration.class})
public class JavaDemoTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaDemoTestApplication.class, args);

	}

}
