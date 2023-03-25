package com.example.springjpaweb5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.springjpaweb5.config.JwtFilter;

@SpringBootApplication
public class SpringjwtWeb5Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringjwtWeb5Application.class, args);
	}

	
	 @Bean
	    public FilterRegistrationBean<JwtFilter> jwtFilter()
	    {
	        FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
	        registrationBean.setFilter( new JwtFilter() );
	        registrationBean.addUrlPatterns( "/api/*" );
	        return registrationBean;
	    }
}
