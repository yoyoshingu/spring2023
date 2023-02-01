package com.leo.spring1.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Spring1WebMVCConfiguration implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(
				// "post/**" 추가됨 p159
				new AuthenticateInterceptor()).addPathPatterns("/", "post/**");
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
