package com.danny.springsecurity.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.danny.springsecurity.demo")
public class DemoAppConfig {
	
  //define a bean for ViewResolver
	
	public ViewResolver viewResolver() {
		
		
		InternalResourceViewResolver viewResoLver= new InternalResourceViewResolver();
		
		viewResoLver.setPrefix("/WEB-INF/view/");
		viewResoLver.setSuffix(".jsp");
		
		return viewResoLver;
		
	}

}
