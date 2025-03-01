package com.example.tourist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Главный класс для запуска Spring Boot приложения {@code TouristServiceApplication}.
 * Этот класс является точкой входа в приложение и запускает его с использованием {@link SpringApplication}.
 * Аннотация {@link @SpringBootApplication} включает в себя все необходимые настройки для создания Spring Boot приложения:
 * - {@link @EnableAutoConfiguration} для автоматической конфигурации компонентов Spring;
 * - {@link @ComponentScan} для поиска и регистрации бинов в контексте приложения;
 * - {@link @Configuration} для указания, что данный класс является конфигурационным.
 * Аннотация {@link @EnableFeignClients} активирует поддержку OpenFeign для клиентских запросов, что позволяет использовать
 * интерфейсы, аннотированные с {@link @FeignClient}, для взаимодействия с внешними сервисами через HTTP.
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.tourist.feign")
public class TouristServiceApplication {

	/**
	 * Точка входа в приложение. Этот метод запускает Spring Boot приложение.
	 *
	 * @param args аргументы командной строки
	 */
	public static void main(String[] args) {
		SpringApplication.run(TouristServiceApplication.class, args);
	}
}
