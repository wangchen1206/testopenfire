package com.hp.roam.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageInterceptor;

/**
 * PageHelper的Page拦截器PageInterceptor，如果不进行配置，那么分页功能将没有效果
 * @author wachen
 *
 */
@Configuration
public class PageHelperConfig {

	@Value("${pagehelper.helperDialect}")
	private String helperDialect;
	
	@Bean
	public PageInterceptor pageInterceptor(){
		PageInterceptor pageInterceptor = new PageInterceptor();
		Properties properties = new Properties();
		properties.setProperty("helperDialect", helperDialect);
		pageInterceptor.setProperties(properties);
		return pageInterceptor;
	}
}
