package com.example.java_demo_test.service.ifs;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.vo.BankRequest;
import com.example.java_demo_test.vo.BankResponse;
import com.example.java_demo_test.vo.BankUpdateRequest;

public interface BankService {
	
	//修改密碼
	public BankResponse updatePassword(BankUpdateRequest bankUpdateRequest);
	
	
	//新增帳號
	public BankResponse addAccount(BankRequest bankRequest);
	
	//獲取額度
		public void getAmount(Bank bank);
         public BankResponse getAmount(BankRequest bankRequest);
     //存款
         public void deposit(Bank bank,int depositAmount);
         public BankResponse deposit(BankRequest bankRequest);
     //提款
         public void withdraw(Bank bank,int withdrawAmount);
         public BankResponse withdraw(BankRequest bankRequest);
         
         public BankResponse depositBoolean(BankRequest bankRequest);
         
}
