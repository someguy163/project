package com.example.fitstproject;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@Configuration
public class FitstprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitstprojectApplication.class, args);
	}

}
