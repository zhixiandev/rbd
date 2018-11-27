package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.aop.AdminInterceptor;

@Configuration
public class InterceptConfig implements WebMvcConfigurer, WebMvcRegistrations{
	
	@Autowired
	private AdminInterceptor adminInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		//WebMvcConfigurer.super.addInterceptors(registry);
		registry.addInterceptor(adminInterceptor).addPathPatterns("/admin").addPathPatterns("/admin/**")
		.addPathPatterns("/qnareply").excludePathPatterns(""); //pattern 매핑, pattern 제외
	}
}
