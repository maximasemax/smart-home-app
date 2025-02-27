package com.smart.house.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.smart.house.app"})

public class SmartHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartHomeApplication.class, args);
	}

}
