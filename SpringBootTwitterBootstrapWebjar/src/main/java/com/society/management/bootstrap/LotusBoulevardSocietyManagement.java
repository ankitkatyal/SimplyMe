package com.society.management.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.society.management") 
public class SpringBootTwitterBootstrapWebjarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTwitterBootstrapWebjarApplication.class, args);
	}
}

