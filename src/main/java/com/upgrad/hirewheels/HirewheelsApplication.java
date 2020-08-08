package com.upgrad.hirewheels;

import com.upgrad.hirewheels.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HirewheelsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HirewheelsApplication.class, args);
	}
	@Autowired
	InitService initService;
	@Override
	public void run(String... args) throws Exception {
		initService.start();
	}
}
