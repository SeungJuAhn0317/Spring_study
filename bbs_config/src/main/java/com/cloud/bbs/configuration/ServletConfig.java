package com.cloud.bbs.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.cloud.bbs"})
public class ServletConfig implements WebMvcConfigurer {
//	@Override
//	public void addInterceptors(InterceptorRegistry registry){
//		registry.addInterceptor(new SignInInterceptor())
//		.addPathPatterns("/write.bbs");	
//	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
		registry.addResourceHandler("/image/**").addResourceLocations("classpath:/static/image/");
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
	}
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	
	@Bean
	public MultipartResolver multipartResolver() {
		MultipartResolver mr = new StandardServletMultipartResolver();
		return mr;
	}
} 