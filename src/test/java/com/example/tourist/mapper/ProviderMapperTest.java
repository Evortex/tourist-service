package com.example.tourist.mapper;

import com.example.tourist.dto.ProviderDto;
import com.example.tourist.model.Provider;
import com.example.tourist.model.ProviderType;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Тестовый класс для {@link ProviderMapper}.
 * Проверяет корректность преобразования между {@link Provider} и {@link ProviderDto}.
 */
class ProviderMapperTest {

    /**
     * Проверяет корректность преобразования сущности {@link Provider} в DTO {@link ProviderDto}.
     */
    @Test
    void testToDto() {
        Provider provider = new Provider();
        UUID providerId = UUID.randomUUID();

        provider.setId(providerId);
        provider.setName("Tourist Guide Inc.");
        provider.setDescription("Provides guided tours");
        provider.setType(ProviderType.valueOf("Tour Operator"));

        ProviderDto dto = ProviderMapper.toDto(provider);

        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(providerId);
        assertThat(dto.getName()).isEqualTo("Tourist Guide Inc.");
        assertThat(dto.getDescription()).isEqualTo("Provides guided tours");
        assertThat(dto.getType()).isEqualTo("Tour Operator");
    }

    /**
     * Проверяет корректность преобразования DTO {@link ProviderDto} в сущность {@link Provider}.
     */
    @Test
    void testToEntity() {
        ProviderDto dto = new ProviderDto();
        UUID providerId = UUID.randomUUID();

        dto.setId(providerId);
        dto.setName("Adventure Tours");
        dto.setDescription("Specialized in adventure tourism");
        dto.setType(ProviderType.valueOf("Adventure"));

        Provider provider = ProviderMapper.toEntity(dto);

        assertThat(provider).isNotNull();
        assertThat(provider.getId()).isEqualTo(providerId);
        assertThat(provider.getName()).isEqualTo("Adventure Tours");
        assertThat(provider.getDescription()).isEqualTo("Specialized in adventure tourism");
        assertThat(provider.getType()).isEqualTo("Adventure");
    }
}
