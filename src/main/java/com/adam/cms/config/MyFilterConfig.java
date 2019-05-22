package com.adam.cms.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.adam.cms.filter.MyNewFilter;

@Configuration
public class MyFilterConfig {

	@Bean
	public FilterRegistrationBean<MyNewFilter> registrationBean(){
		FilterRegistrationBean<MyNewFilter> registrationBean = new FilterRegistrationBean<MyNewFilter>();
		 registrationBean.setFilter(new MyNewFilter());
		 registrationBean.addUrlPatterns("/customers/*");
		 return registrationBean;
				
	}
	
}
