package com.advertisementportal.config.mvc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.advertisementportal.config.security.AdvertisementAppSecurityConfig;

public class AdvertisementAppServletInitialiizer extends AbstractAnnotationConfigDispatcherServletInitializer{

	public AdvertisementAppServletInitialiizer() {
		System.out.println("Web Dispacther Servlet Initialiization");
	}
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {AdvertisementAppSecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {AdvertisementWebMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
