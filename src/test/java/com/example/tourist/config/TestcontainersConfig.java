package com.example.tourist.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

/**
 * Конфигурация для использования контейнера PostgreSQL при тестировании.
 * Этот класс используется для создания контейнера PostgreSQL, который будет запускаться в тестах.
 */
@TestConfiguration
public class TestcontainersConfig {

    /**
     * Бин для контейнера PostgreSQL. Этот контейнер будет использоваться для тестирования.
     *
     * @return контейнер PostgreSQL
     */
    @Bean
    public PostgreSQLContainer<?> postgreSQLContainer() {
        PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:15")
                .withDatabaseName("testdb")
                .withUsername("test")
                .withPassword("test");
        container.start();
        return container;
    }
}