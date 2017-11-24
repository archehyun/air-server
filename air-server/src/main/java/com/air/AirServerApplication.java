package com.air;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirServerApplication {

	public static void main(String[] args) {
		
		System.out.println("test");
		SpringApplication.run(AirServerApplication.class, args);
		
	}
}
