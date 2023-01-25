package com.example.apiblogapplication;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@SpringBootApplication
public class Application implements CommandLineRunner {
   @Autowired
	private PasswordEncoder PasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
	@Bean
	public ModelMapper modelmap() {
		return new ModelMapper();
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println(PasswordEncoder.encode("bh$Ss"));
		
	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
		
		
		
	}
	
