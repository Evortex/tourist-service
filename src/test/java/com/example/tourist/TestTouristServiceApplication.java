package com.example.tourist;

import org.springframework.boot.SpringApplication;

public class TestTouristServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(TouristServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
