package com.example.tourist;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * Базовый класс для тестирования с использованием Testcontainers.
 */
@Testcontainers
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DataJpaTest
public abstract class AbstractTestContainer {

    private static final PostgreSQLContainer<?> POSTGRESQL_CONTAINER =
            new PostgreSQLContainer<>("postgres:15")
                    .withDatabaseName("testdb")
                    .withUsername("testuser")
                    .withPassword("testpassword");

    @BeforeAll
    public void startContainer() {
        POSTGRESQL_CONTAINER.start();
        System.setProperty("spring.datasource.url", POSTGRESQL_CONTAINER.getJdbcUrl());
        System.setProperty("spring.datasource.username", POSTGRESQL_CONTAINER.getUsername());
        System.setProperty("spring.datasource.password", POSTGRESQL_CONTAINER.getPassword());
    }
}
