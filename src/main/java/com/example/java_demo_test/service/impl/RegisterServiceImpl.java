package com.example.java_demo_test.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.constants.RtnCode;
import com.example.java_demo_test.entity.Register;
import com.example.java_demo_test.repository.RegisterDao;
import com.example.java_demo_test.service.ifs.RegisterService;
import com.example.java_demo_test.vo.RegisterRequest;
import com.example.java_demo_test.vo.RegisterResponse;

@Service
public class RegisterServiceImpl implements RegisterService {

	private Logger logger=LoggerFactory.getLogger(getClass());//slf4j
	
	@Autowired
	private RegisterDao registerDao;

	@Override
	public RegisterResponse register(RegisterRequest req) {
		logger.info("register service");
//		String account=req.getAccount();
//        String pwd=req.getPwd();
       
        
		if (!StringUtils.hasText(req.getAccount()) || !StringUtils.hasText(req.getPwd())) {
			
			logger.error("cannot empty");
			return new RegisterResponse(RtnCode.CANNOT_EMPTY.getCode(), RtnCode.CANNOT_EMPTY.getMessage());

		}
		if (registerDao.existsById(req.getAccount())) {
			return new RegisterResponse(RtnCode.ACCOUNT_EXISTED.getCode(), RtnCode.ACCOUNT_EXISTED.getMessage());
		}
		try {
			registerDao.save(new Register(req.getAccount(),req.getPwd()));
		} catch (Exception e) {
			return new RegisterResponse(RtnCode.FAILED.getCode(),RtnCode.FAILED.getMessage());
		}
		
		return new RegisterResponse(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public RegisterResponse active(RegisterRequest req) { //啟動過後就不讓她啟動  //類似信箱開通->確認不要返氾濫
		String account=req.getAccount();
        String pwd=req.getPwd();
		
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new RegisterResponse(RtnCode.CANNOT_EMPTY.getCode(), RtnCode.CANNOT_EMPTY.getMessage());

		}
		Register res=registerDao.findByAccountAndPwd(account, pwd);
		if(res==null) {
			return new RegisterResponse(RtnCode.NOT_FOUND.getCode(), RtnCode.NOT_FOUND.getMessage());
		}
		if(res.isActive()) {
			return new RegisterResponse(RtnCode.ACCOUNT_ACTIVED.getCode(), RtnCode.ACCOUNT_ACTIVED.getMessage());
		}
		res.setActive(true);//如果沒有啟動動
		
		try {
			registerDao.save(res);//狀態存回去
		} catch (Exception e) {
			return new RegisterResponse(RtnCode.FAILED.getCode(),RtnCode.FAILED.getMessage());
		}
		
		return new RegisterResponse(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public RegisterResponse login(RegisterRequest req) {
		String account=req.getAccount();
        String pwd=req.getPwd();
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new RegisterResponse(RtnCode.CANNOT_EMPTY.getCode(), RtnCode.CANNOT_EMPTY.getMessage());

		}
		Register res=registerDao.findByAccountAndPwd(account, pwd);
		if(res==null) {
			return new RegisterResponse(RtnCode.NOT_FOUND.getCode(), RtnCode.NOT_FOUND.getMessage());
		}
		if(!res.isActive()) {
			return new RegisterResponse(RtnCode.ACCOUNT_NOT_ACTIVED.getCode(), RtnCode.ACCOUNT_NOT_ACTIVED.getMessage());
		}
		return new RegisterResponse(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public RegisterResponse getRegTime(String account, String pwd) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new RegisterResponse(RtnCode.PLEASE_LOGIN.getCode(), RtnCode.PLEASE_LOGIN.getMessage());

		}
		Register res=registerDao.findByAccountAndPwd(account, pwd);
		if(res==null) {
			return new RegisterResponse(RtnCode.NOT_FOUND.getCode(), RtnCode.NOT_FOUND.getMessage());
		}if(!res.isActive()) {
			return new RegisterResponse(RtnCode.ACCOUNT_NOT_ACTIVED.getCode(), RtnCode.ACCOUNT_NOT_ACTIVED.getMessage(),RtnCode.ACCOUNT_NOT_ACTIVED.getRegTime());
		}
		return new RegisterResponse(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage());
	}

}
