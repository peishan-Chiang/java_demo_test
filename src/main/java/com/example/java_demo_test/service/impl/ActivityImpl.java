package com.example.java_demo_test.service.impl;

import org.springframework.stereotype.Service;

import com.example.java_demo_test.service.ifs.Activity;

@Service
public class ActivityImpl implements Activity   {
	
	
	
	@Override
	public void fly(String name,int age) {
		
//		System.out.println("name:"+name +"  age:"+age+"  正在飛");
		System.out.printf("%2s",name);
		System.out.printf("%2d",age);
		
	}


	
}
