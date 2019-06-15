package com.hp.roam.config;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.github.pagehelper.PageInterceptor;

import tk.mybatis.spring.annotation.MapperScan;


/**
 * 数据源配置
 * @author wangchen
 *
 */
@Configuration
@MapperScan("com.hp.roam.dao")
@EnableTransactionManagement
public class DataSourceConfig {
	
	private static Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private PageInterceptor pageInterceptor;
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		//该配置非常的重要，如果不将PageInterceptor设置到SqlSessionFactoryBean中，导致分页失效
		sessionFactoryBean.setPlugins(new Interceptor[]{pageInterceptor});
		sessionFactoryBean.setTypeAliasesPackage(environment.getProperty("mybatis.type-aliases-package"));
		sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(environment.getProperty("mybatis.mapper-locations")));
		return sessionFactoryBean.getObject();
	}
	
	
}
