package com.howtodoinjava.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	//http://localhost:8083/employees
	//http://localhost:8083/employees/2
		
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
