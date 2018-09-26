package com.advertisementportal.config.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.advertisementportal.controller")
public class AdvertisementWebMvcConfig implements WebMvcConfigurer {

public AdvertisementWebMvcConfig() {
	System.out.println("Web MVC Configuration");
}	

@Override
public void configureViewResolvers(ViewResolverRegistry registry) {
	InternalResourceViewResolver view = new InternalResourceViewResolver();
	view.setPrefix("/WEB-INF/jsps/");
	view.setSuffix(".jsp");
	view.setExposeContextBeansAsAttributes(true);
	registry.viewResolver(view);
	
}
public void addResourceHandlers(ResourceHandlerRegistry registry) {
	
	WebMvcConfigurer.super.addResourceHandlers(registry);
	registry.addResourceHandler("/static/**")
	.addResourceLocations("/static/");
}

}
