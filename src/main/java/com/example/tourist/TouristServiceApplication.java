package com.example.tourist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.tourist.feign")
public class TouristServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(TouristServiceApplication.class, args);
	}
}