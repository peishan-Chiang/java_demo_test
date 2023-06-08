package com.example.java_demo_test.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


//@Component  //變成springBoot讓他託管
//@Aspect    //切入點
public class ExecuteTimeLogAspect {
	
	private Logger logger=LoggerFactory.getLogger(getClass());//slf4j
//	execution ()要空格，用雙引號 【.*.*】表示repository下所有DAO方法(..) 任意兩個點
	//跟springBoot說我想在這個專案底下，repository都做一個橫切 
	//切可以頭可以尾，所以要做【通知】
	@Pointcut("execution (public * com.example.java_demo_test.repository.*.*(..))")
	public void pointcut() {
		//這個宣告很重要，後面才會有before，after，around
	}
	
	
//	@Before("pointcut()")  //上述@Pointcut 的方法要被帶入參數 //身分驗證
	public void before() {
		System.out.println("===before advice==");
	}

	
//	@After("pointcut()")  //上述@Pointcut 的方法要被帶入參數
	public void after() {
		System.out.println("===after advice==");
	}
	
//	@Around("pointcut()")  //上述@Pointcut 的方法要被帶入參數
	//使用情境需要再程式之前或是之後做什麼事情
	//ProceedingJoinPoint 要讓原本程式執行
	//log前後要做什麼
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("===round before advice==");
		
		 Signature signature=pjp.getSignature();
		System.out.println("signature_name:"+signature.getName());
		MethodSignature methodSignature=(MethodSignature)pjp.getSignature();
		System.out.println("method_signature_name:"+methodSignature.getName());
		long startTime=System.currentTimeMillis();
		//呼叫 proceed() 才會開始執行原方法
		Object result = pjp.proceed();//回寫回DAO原本程式，不寫原本動作會爆掉
		long endTime=System.currentTimeMillis();
		long spendTime=endTime-startTime; //計算程式花費多少時機
		System.out.println("===round after advice==");
		return result;
	}
	
//	@AfterReturning("pointcut()")
	public void afterReturning() {
		//執行成功才會印出這一行
		System.out.println("===after returning advice==");
	}
	
	@AfterThrowing(pointcut="pointcut()",throwing="throwable") 
	//throwable就是Throwable throwable這個變數
	public void  afterThrowing(Throwable throwable){
		//取得錯誤訊息
		System.out.println("錯誤訊息:" +throwable.getMessage());
		System.out.println("=====after throwing advice====");
		
	}
}
