package com.example.java_demo_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.service.ifs.BankService;
import com.example.java_demo_test.vo.BankRequest;
import com.example.java_demo_test.vo.BankResponse;
import com.example.java_demo_test.vo.BankUpdateRequest;

@RestController
public class BankController {
	@Autowired
	private BankService bankService;

//	@RequestMapping(value="/get_amount",method=RequestMethod.POST)
	@PostMapping("/get_amount")
	public BankResponse getAmount(@RequestBody BankRequest bankRequest) {
//		BankResponse response=bankService.getAmount(bankRequest);
//		return response;
		return bankService.getAmount(bankRequest);
	}

	@PostMapping("/deposit")
	public BankResponse deposit(@RequestBody BankRequest bankRequest) {
		return bankService.deposit(bankRequest);

	}
	
	@PostMapping("/withdraw")
	public BankResponse withdraw(@RequestBody BankRequest bankRequest) {
		return bankService.withdraw(bankRequest);

	}
	
	@PostMapping("/depositBoolean")
	public BankResponse depositBoolean(@RequestBody BankRequest bankRequest) {
		return bankService.depositBoolean(bankRequest);

	}
	
	@PostMapping("/addAccount")
	public BankResponse addAccount(@RequestBody BankRequest bankRequest) {
		return bankService.addAccount(bankRequest);

	}
	
	@PostMapping("/updatePassword")
	public BankResponse updatePassword(@RequestBody BankUpdateRequest bankUpdateRequest) {
		return bankService.updatePassword(bankUpdateRequest);

	}
	
	
}
