package com.advertisementportal.config.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class AdvertisementAppSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
public AdvertisementAppSecurityInitializer() {
	System.out.println("Security  Initialized");
}

}
