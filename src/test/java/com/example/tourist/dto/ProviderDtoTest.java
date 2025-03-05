package com.example.tourist.dto;

import com.example.tourist.model.ProviderType;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Тестовый класс для {@link ProviderDto}.
 * Проверяет корректность работы конструкторов, геттеров и сеттеров.
 */
class ProviderDtoTest {

    /**
     * Проверяет работу конструктора без аргументов.
     */
    @Test
    void testNoArgsConstructor() {
        ProviderDto providerDto = new ProviderDto();

        assertThat(providerDto).isNotNull();
        assertThat(providerDto.getId()).isNull();
        assertThat(providerDto.getName()).isNull();
        assertThat(providerDto.getDescription()).isNull();
        assertThat(providerDto.getType()).isNull();
    }

    /**
     * Проверяет работу конструктора со всеми аргументами.
     */
    @Test
    void testAllArgsConstructor() {
        UUID id = UUID.randomUUID();

        ProviderDto providerDto = new ProviderDto(id, "Best Tours", "Top travel agency", ProviderType.TRAVEL_AGENCY);

        assertThat(providerDto.getId()).isEqualTo(id);
        assertThat(providerDto.getName()).isEqualTo("Best Tours");
        assertThat(providerDto.getDescription()).isEqualTo("Top travel agency");
        assertThat(providerDto.getType()).isEqualTo(ProviderType.TRAVEL_AGENCY);
    }

    /**
     * Проверяет корректность работы сеттеров и геттеров.
     */
    @Test
    void testSettersAndGetters() {
        ProviderDto providerDto = new ProviderDto();
        UUID id = UUID.randomUUID();

        providerDto.setId(id);
        providerDto.setName("Luxury Travel");
        providerDto.setDescription("Exclusive vacations");
        providerDto.setType(ProviderType.LUXURY);

        assertThat(providerDto.getId()).isEqualTo(id);
        assertThat(providerDto.getName()).isEqualTo("Luxury Travel");
        assertThat(providerDto.getDescription()).isEqualTo("Exclusive vacations");
        assertThat(providerDto.getType()).isEqualTo(ProviderType.LUXURY);
    }
}
