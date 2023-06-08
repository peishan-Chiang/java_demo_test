package com.example.java_demo_test.service.ifs;

import com.example.java_demo_test.vo.RegisterRequest;
import com.example.java_demo_test.vo.RegisterResponse;

public interface RegisterService {
	public RegisterResponse register(RegisterRequest req);
	public RegisterResponse active(RegisterRequest req);
	public RegisterResponse login(RegisterRequest req);
	public RegisterResponse getRegTime(String account,String pwd);

}
