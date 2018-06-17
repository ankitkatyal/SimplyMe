package com.society.management.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.society.management.repository") 
@ComponentScan("com.society.management") 
@EntityScan("com.society.management.entity") 
public class LotusBoulevardSocietyManagement {

	public static void main(String[] args) {
		SpringApplication.run(LotusBoulevardSocietyManagement.class, args);
	}
}

