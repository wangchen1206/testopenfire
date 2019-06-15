package com.hp.roam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hp.roam.security.CustomerUserService;

/**
 * @author ck
 * @date 2019年2月27日 下午4:43:28
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	/*
	 * 注册CustomerUserService
	 */
	@Bean
	UserDetailsService customerUserService(){
		return new CustomerUserService();
	}
	
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	/*
	 *添加我们自定义的user detail service 认证 
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(customerUserService()).passwordEncoder(bCryptPasswordEncoder());
	}
	
	/* 
	 * 定义请求规则
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//			.antMatchers("/css/**").permitAll()
//			.antMatchers("/start").permitAll()
//			.anyRequest().authenticated()//所有请求需认证即登陆后才能访问
//			.and()
//			.formLogin()
//				.loginPage("/login")
//				.failureUrl("/login?error")//定义登陆失败的页面
//				.permitAll()//定义登录行为，登录页面可任意访问
//			.and()
//			.logout().permitAll();//定义注销请求，注销请求可任意访问
	}
}
