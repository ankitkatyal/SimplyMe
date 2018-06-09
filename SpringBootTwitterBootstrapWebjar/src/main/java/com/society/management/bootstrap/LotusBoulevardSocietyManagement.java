package com.society.management.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.society.management") 
public class LotusBoulevardSocietyManagement {

	public static void main(String[] args) {
		SpringApplication.run(LotusBoulevardSocietyManagement.class, args);
	}
}

