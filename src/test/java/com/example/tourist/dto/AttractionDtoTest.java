package com.example.tourist.dto;

import com.example.tourist.model.AttractionType;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Тестовый класс для {@link AttractionDto}.
 * Проверяет корректность работы конструкторов, геттеров и сеттеров.
 */
class AttractionDtoTest {

    /**
     * Проверяет работу конструктора без аргументов.
     */
    @Test
    void testNoArgsConstructor() {
        AttractionDto attractionDto = new AttractionDto();

        assertThat(attractionDto).isNotNull();
        assertThat(attractionDto.getId()).isNull();
        assertThat(attractionDto.getName()).isNull();
        assertThat(attractionDto.getDescription()).isNull();
        assertThat(attractionDto.getType()).isNull();
        assertThat(attractionDto.getAddressId()).isNull();
        assertThat(attractionDto.getTicketInfoId()).isNull();
        assertThat(attractionDto.getProviderIds()).isNull();
    }

    /**
     * Проверяет работу конструктора со всеми аргументами.
     */
    @Test
    void testAllArgsConstructor() {
        UUID id = UUID.randomUUID();
        UUID addressId = UUID.randomUUID();
        UUID ticketInfoId = UUID.randomUUID();
        Set<UUID> providerIds = Set.of(UUID.randomUUID(), UUID.randomUUID());

        AttractionDto attractionDto = new AttractionDto(id, "Eiffel Tower", "Famous landmark",
                AttractionType.HISTORICAL, addressId,
                ticketInfoId, providerIds);

        assertThat(attractionDto.getId()).isEqualTo(id);
        assertThat(attractionDto.getName()).isEqualTo("Eiffel Tower");
        assertThat(attractionDto.getDescription()).isEqualTo("Famous landmark");
        assertThat(attractionDto.getType()).isEqualTo(AttractionType.HISTORICAL);
        assertThat(attractionDto.getAddressId()).isEqualTo(addressId);
        assertThat(attractionDto.getTicketInfoId()).isEqualTo(ticketInfoId);
        assertThat(attractionDto.getProviderIds()).containsAll(providerIds);
    }

    /**
     * Проверяет корректность работы сеттеров и геттеров.
     */
    @Test
    void testSettersAndGetters() {
        AttractionDto attractionDto = new AttractionDto();
        UUID id = UUID.randomUUID();
        UUID addressId = UUID.randomUUID();
        UUID ticketInfoId = UUID.randomUUID();
        Set<UUID> providerIds = Set.of(UUID.randomUUID());

        attractionDto.setId(id);
        attractionDto.setName("Colosseum");
        attractionDto.setDescription("Ancient amphitheater");
        attractionDto.setType(AttractionType.CULTURAL);
        attractionDto.setAddressId(addressId);
        attractionDto.setTicketInfoId(ticketInfoId);
        attractionDto.setProviderIds(providerIds);

        assertThat(attractionDto.getId()).isEqualTo(id);
        assertThat(attractionDto.getName()).isEqualTo("Colosseum");
        assertThat(attractionDto.getDescription()).isEqualTo("Ancient amphitheater");
        assertThat(attractionDto.getType()).isEqualTo(AttractionType.CULTURAL);
        assertThat(attractionDto.getAddressId()).isEqualTo(addressId);
        assertThat(attractionDto.getTicketInfoId()).isEqualTo(ticketInfoId);
        assertThat(attractionDto.getProviderIds()).containsAll(providerIds);
    }
}