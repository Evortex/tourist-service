package com.example.tourist.mapper;

import com.example.tourist.dto.AddressDto;
import com.example.tourist.model.Address;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Тестовый класс для {@link AddressMapper}.
 * Проверяет корректность преобразования между {@link Address} и {@link AddressDto}.
 */
class AddressMapperTest {

    /**
     * Проверяет преобразование сущности {@link Address} в DTO {@link AddressDto}.
     */
    @Test
    void testToDto() {
        Address address = new Address();
        UUID id = UUID.randomUUID();
        address.setId(id);
        address.setBuilding(34233);
        address.setStreet("Main Street");
        address.setCity("Springfield");
        address.setRegion("Some Region");
        address.setLongitude(12.345);
        address.setLatitude(54.321);

        AddressDto dto = AddressMapper.toDto(address);

        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(id);
        assertThat(dto.getBuilding()).isEqualTo(34233);
        assertThat(dto.getStreet()).isEqualTo("Main Street");
        assertThat(dto.getCity()).isEqualTo("Springfield");
        assertThat(dto.getRegion()).isEqualTo("Some Region");
        assertThat(dto.getLongitude()).isEqualTo(12.345);
        assertThat(dto.getLatitude()).isEqualTo(54.321);
    }

    /**
     * Проверяет преобразование DTO {@link AddressDto} в сущность {@link Address}.
     */
    @Test
    void testToEntity() {
        AddressDto dto = new AddressDto();
        UUID id = UUID.randomUUID();
        dto.setId(id);
        dto.setBuilding(534534);
        dto.setStreet("Broadway");
        dto.setCity("New York");
        dto.setRegion("NY Region");
        dto.setLongitude(-74.006);
        dto.setLatitude(40.7128);

        Address address = AddressMapper.toEntity(dto);

        assertThat(address).isNotNull();
        assertThat(address.getId()).isEqualTo(id);
        assertThat(address.getBuilding()).isEqualTo(534534);
        assertThat(address.getStreet()).isEqualTo("Broadway");
        assertThat(address.getCity()).isEqualTo("New York");
        assertThat(address.getRegion()).isEqualTo("NY Region");
        assertThat(address.getLongitude()).isEqualTo(-74.006);
        assertThat(address.getLatitude()).isEqualTo(40.7128);
    }
}