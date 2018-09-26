package com.advertisementportal.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class AdvertisementAppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder noop;

	@Bean
	public PasswordEncoder noOpPasswordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication().withUser("admin").password(noop.encode("admin")).roles("ADMIN");
		auth
			.inMemoryAuthentication().withUser("saurabh").password(noop.encode("password")).roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests().antMatchers("/").permitAll();
		http
			.authorizeRequests().antMatchers("/createNewAd").hasAnyRole("USER","ADMIN");
		http
			.formLogin().permitAll();
	}
}
