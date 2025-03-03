package com.example.tourist.mapper;

import com.example.tourist.dto.AttractionDto;
import com.example.tourist.model.*;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Тестовый класс для {@link AttractionMapper}.
 * Проверяет корректность преобразования между {@link Attraction} и {@link AttractionDto}.
 */
class AttractionMapperTest {

    /**
     * Проверяет преобразование сущности {@link Attraction} в DTO {@link AttractionDto}.
     */
    @Test
    void testToDto() {
        Attraction attraction = new Attraction();
        UUID attractionId = UUID.randomUUID();
        UUID addressId = UUID.randomUUID();
        UUID ticketInfoId = UUID.randomUUID();
        UUID provider1Id = UUID.randomUUID();
        UUID provider2Id = UUID.randomUUID();

        attraction.setId(attractionId);
        attraction.setName("Eiffel Tower");
        attraction.setDescription("Famous landmark in Paris");
        attraction.setType(AttractionType.valueOf("Historical"));

        Address address = new Address();
        address.setId(addressId);
        attraction.setAddress(address);

        TicketInfo ticketInfo = new TicketInfo();
        ticketInfo.setId(ticketInfoId);
        attraction.setTicketInfo(ticketInfo);

        Provider provider1 = new Provider();
        provider1.setId(provider1Id);
        Provider provider2 = new Provider();
        provider2.setId(provider2Id);
        attraction.setProviders(Set.of(provider1, provider2));

        AttractionDto dto = AttractionMapper.toDto(attraction);

        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(attractionId);
        assertThat(dto.getName()).isEqualTo("Eiffel Tower");
        assertThat(dto.getDescription()).isEqualTo("Famous landmark in Paris");
        assertThat(dto.getType()).isEqualTo("Historical");
        assertThat(dto.getAddressId()).isEqualTo(addressId);
        assertThat(dto.getTicketInfoId()).isEqualTo(ticketInfoId);
        assertThat(dto.getProviderIds()).containsExactlyInAnyOrder(provider1Id, provider2Id);
    }

    /**
     * Проверяет преобразование DTO {@link AttractionDto} в сущность {@link Attraction}.
     */
    @Test
    void testToEntity() {
        AttractionDto dto = new AttractionDto();
        UUID attractionId = UUID.randomUUID();

        dto.setId(attractionId);
        dto.setName("Colosseum");
        dto.setDescription("Ancient Roman amphitheater");
        dto.setType(AttractionType.valueOf("Historical"));

        Attraction attraction = AttractionMapper.toEntity(dto);

        assertThat(attraction).isNotNull();
        assertThat(attraction.getId()).isEqualTo(attractionId);
        assertThat(attraction.getName()).isEqualTo("Colosseum");
        assertThat(attraction.getDescription()).isEqualTo("Ancient Roman amphitheater");
        assertThat(attraction.getType()).isEqualTo("Historical");

        assertThat(attraction.getAddress()).isNull();
        assertThat(attraction.getTicketInfo()).isNull();
        assertThat(attraction.getProviders()).isEmpty();
    }
}