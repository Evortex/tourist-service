package com.example.tourist.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Конфигурационный класс для настройки OpenAPI/Swagger в приложении.
 * Определяет описание API, контактную информацию, лицензирование и список доступных серверов.
 */
@Configuration
public class OpenApiConfig {

    /**
     * URL локального сервера, загружается из application.properties.
     */
    @Value("${openapi.server.local}")
    private String localServerUrl;

    /**
     * URL продакшен-сервера, загружается из application.properties.
     */
    @Value("${openapi.server.production}")
    private String productionServerUrl;

    /**
     * Определяет конфигурацию OpenAPI.
     * @return Объект OpenAPI с метаинформацией о сервисе.
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Tourist Service API")
                        .version("1.0")
                        .description("API для управления туристическими объектами")
                        .contact(new Contact()
                                .name("Tourist API Support")
                                .email("support@tourist-api.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")))
                .servers(List.of(
                        new Server().url(localServerUrl).description("Локальный сервер"),
                        new Server().url(productionServerUrl).description("Продакшен сервер")
                ));
    }
}
