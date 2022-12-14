package com.recode.devAgensApi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	private static final String DESTINO_PATH = "destino";
	private static final String PACOTE_PATH = "pacote";
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}

	
	@Bean 
    public ClassLoaderTemplateResolver destinoTemplateResolver() {
	 
		  return createTemplateResolver(DESTINO_PATH);
	  
	}
	
	@Bean 
    public ClassLoaderTemplateResolver pacoteTemplateResolver() {
	 
		  return createTemplateResolver(PACOTE_PATH);
	  
	}
	  
    public ClassLoaderTemplateResolver createTemplateResolver(String folder) {
    	
    	  ClassLoaderTemplateResolver secondaryTemplateResolver = new
		  ClassLoaderTemplateResolver();
	  		  
		  secondaryTemplateResolver.setPrefix(String.format("templates/%s/", folder));
		  secondaryTemplateResolver.setSuffix(".html");
		  secondaryTemplateResolver.setTemplateMode(TemplateMode.HTML);
		  secondaryTemplateResolver.setCharacterEncoding("UTF-8");
		  secondaryTemplateResolver.setOrder(1);
		  secondaryTemplateResolver.setCheckExistence(true);
		  return secondaryTemplateResolver;
	}
	 
}
