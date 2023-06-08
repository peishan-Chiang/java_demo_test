package com.example.java_demo_test.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests() //定義那些url需要被保護http.authorizeHttpRequests()  
		.antMatchers("/resources/**").permitAll()   //resource資料夾可匿名存取 :http.authorizeHttpRequests().antMatchers("/resourced/**").permitAll()     
//		.antMatchers("/api/login").hasRole("admin")//定義controller下的方法路經下，什麼角色才能進入        
		.anyRequest().authenticated()   //上述其他的請求(url)，都需要身分認證
		.and().formLogin() //
		.and().httpBasic() //
		.and().csrf().disable();//and().csrf().disable() 讓401錯誤可以消失
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	
      
}
