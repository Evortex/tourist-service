package com.example.tourist.dto;

import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Тестовый класс для проверки работы {@link AddressDto}.
 * Проверяет конструкторы, геттеры и сеттеры.
 */
class AddressDtoTest {

    /**
     * Проверяет, что конструктор без аргументов создает объект с null-полями.
     */
    @Test
    void testNoArgsConstructor() {
        AddressDto addressDto = new AddressDto();

        assertThat(addressDto).isNotNull();
        assertThat(addressDto.getId()).isNull();
        assertThat(addressDto.getCity()).isNull();
    }

    /**
     * Проверяет, что конструктор со всеми аргументами правильно инициализирует объект.
     */
    @Test
    void testAllArgsConstructor() {
        UUID id = UUID.randomUUID();
        AddressDto addressDto = new AddressDto(id, 10, "Main Street", "New York", "NY", -74.006, 40.7128);

        assertThat(addressDto.getId()).isEqualTo(id);
        assertThat(addressDto.getBuilding()).isEqualTo(10);
        assertThat(addressDto.getStreet()).isEqualTo("Main Street");
        assertThat(addressDto.getCity()).isEqualTo("New York");
        assertThat(addressDto.getRegion()).isEqualTo("NY");
        assertThat(addressDto.getLongitude()).isEqualTo(-74.006);
        assertThat(addressDto.getLatitude()).isEqualTo(40.7128);
    }

    /**
     * Проверяет корректность работы сеттеров и геттеров.
     */
    @Test
    void testSettersAndGetters() {
        AddressDto addressDto = new AddressDto();
        UUID id = UUID.randomUUID();

        addressDto.setId(id);
        addressDto.setBuilding(20);
        addressDto.setStreet("Broadway");
        addressDto.setCity("Los Angeles");
        addressDto.setRegion("CA");
        addressDto.setLongitude(-118.2437);
        addressDto.setLatitude(34.0522);

        assertThat(addressDto.getId()).isEqualTo(id);
        assertThat(addressDto.getBuilding()).isEqualTo(20);
        assertThat(addressDto.getStreet()).isEqualTo("Broadway");
        assertThat(addressDto.getCity()).isEqualTo("Los Angeles");
        assertThat(addressDto.getRegion()).isEqualTo("CA");
        assertThat(addressDto.getLongitude()).isEqualTo(-118.2437);
        assertThat(addressDto.getLatitude()).isEqualTo(34.0522);
    }
}
