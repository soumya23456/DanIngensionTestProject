package com.dan_ui.dan_ingestion_project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.dan_ui.dan_ingestion_project.fileservice.StorageProperties;
import com.dan_ui.dan_ingestion_project.fileservice.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class DanIngensionProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DanIngensionProjectApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(StorageService service) {
		return (args) -> {
			service.init();
		};
	}

}
