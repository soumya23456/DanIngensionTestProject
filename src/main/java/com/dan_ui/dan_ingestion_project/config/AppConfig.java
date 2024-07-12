package com.dan_ui.dan_ingestion_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	  @Bean 
	  public RestTemplate restTemplate() { 
		  return new RestTemplate(); 
	  }
	  
	  @Primary
	  @Bean
	  public FreeMarkerConfigurationFactoryBean factoryBean() {
		  FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
		  bean.setTemplateLoaderPath("classpath:/templates");
		  return bean;
	  }
	  
}
