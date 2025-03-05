package com.example.tourist;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

/**
 * Конфигурация для использования контейнера PostgreSQL с помощью Testcontainers.
 * Этот класс используется для настройки контейнера PostgreSQL, который будет использоваться
 * для тестирования с базой данных в изолированном контейнере.
 *
 * @see org.testcontainers.containers.PostgreSQLContainer
 * @see org.springframework.boot.testcontainers.service.connection.ServiceConnection
 */
@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {

	/**
	 * Создает и возвращает контейнер PostgreSQL для использования в тестах.
	 * Аннотация {@link ServiceConnection} указывает, что данный контейнер должен
	 * быть использован как сервис для тестирования в Spring.
	 *
	 * @return {@link PostgreSQLContainer} экземпляр контейнера PostgreSQL.
	 *
	 * @see PostgreSQLContainer
	 */
	@Bean
	@ServiceConnection
	PostgreSQLContainer<?> postgresContainer() {
		return new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"));
	}
}
