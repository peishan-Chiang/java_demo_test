package com.example.java_demo_test.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_demo_test.entity.Register;
import com.example.java_demo_test.service.ifs.RegisterService;
import com.example.java_demo_test.vo.RegisterRequest;
import com.example.java_demo_test.vo.RegisterResponse;

@EnableScheduling
@RestController
public class RegisterController {
	
	@Autowired
	private RegisterService registerservice;
	
	@Scheduled(cron="0/5 * 12 * * *")
	public void schedule() {
		System.out.println(LocalDateTime.now());
	}
	@PostMapping("register")
	public RegisterResponse register(@RequestBody RegisterRequest req) {
	return  registerservice.register(req);
	}
	
	@PostMapping("active")
	public RegisterResponse active(@RequestBody RegisterRequest req) {
	return  registerservice.active(req);
	}
	
	
	@PostMapping("/api/login")
	public RegisterResponse login(@RequestBody RegisterRequest req, HttpSession session) {
	RegisterResponse res=  registerservice.login(req);
	if(res.getCode().equals("200")) {
		
		session.setAttribute("account", req.getAccount());
		session.setAttribute("pwd", req.getPwd());
		session.setMaxInactiveInterval(30); //秒_時間
		
	}
	return res;

}
	
	
//	=========================================================================
//	@PostMapping("logout") //不會進入Service端
//	public RegisterResponse logout(HttpSession session) {//要求login 後的帳號值
//		
//	session.removeAttribute("account");
//	session.removeAttribute("pwd");
////	return  new RegisterResponse( )
//	}	
//	
	
//==========================================================================
	@PostMapping("getRegTime")
	public RegisterResponse getRegTime(HttpSession session) {//要求login 後的帳號值
		
	String account=(String)session.getAttribute("account"); 
	String pwd=(String)session.getAttribute("pwd");
	return  registerservice.getRegTime(account,pwd);
	}	

}

