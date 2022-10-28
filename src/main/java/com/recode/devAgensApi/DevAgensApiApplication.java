package com.recode.devAgensApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DevAgensApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevAgensApiApplication.class, args);
		System.out.println("Encode " + new BCryptPasswordEncoder().encode("123"));
	}
	 
}
