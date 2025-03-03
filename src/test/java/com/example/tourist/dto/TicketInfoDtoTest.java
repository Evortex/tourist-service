package com.example.tourist.dto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Тестовый класс для {@link TicketInfoDto}.
 * Проверяет корректность работы конструкторов, геттеров и сеттеров.
 */
public class TicketInfoDtoTest {

    /**
     * Проверяет работу конструктора с полными аргументами.
     */
    @Test
    public void testAllArgsConstructor() {
        UUID id = UUID.randomUUID();
        BigDecimal price = new BigDecimal("99.99");
        String currency = "USD";
        Boolean availability = true;
        UUID attractionId = UUID.randomUUID();

        TicketInfoDto ticketInfoDto = new TicketInfoDto(id, price, currency, availability, attractionId);

        assertThat(ticketInfoDto).isNotNull();
        assertThat(ticketInfoDto.getId()).isEqualTo(id);
        assertThat(ticketInfoDto.getPrice()).isEqualTo(price);
        assertThat(ticketInfoDto.getCurrency()).isEqualTo(currency);
        assertThat(ticketInfoDto.getAvailability()).isEqualTo(availability);
        assertThat(ticketInfoDto.getAttractionId()).isEqualTo(attractionId);
    }

    /**
     * Проверяет работу конструктора без аргументов.
     */
    @Test
    public void testNoArgsConstructor() {
        TicketInfoDto ticketInfoDto = new TicketInfoDto();

        assertThat(ticketInfoDto).isNotNull();
        assertThat(ticketInfoDto.getId()).isNull();
        assertThat(ticketInfoDto.getPrice()).isNull();
        assertThat(ticketInfoDto.getCurrency()).isNull();
        assertThat(ticketInfoDto.getAvailability()).isNull();
        assertThat(ticketInfoDto.getAttractionId()).isNull();
    }

    /**
     * Проверяет корректность работы сеттеров и геттеров.
     */
    @Test
    public void testSettersAndGetters() {
        TicketInfoDto ticketInfoDto = new TicketInfoDto();

        UUID id = UUID.randomUUID();
        BigDecimal price = new BigDecimal("49.99");
        String currency = "EUR";
        Boolean availability = false;
        UUID attractionId = UUID.randomUUID();

        ticketInfoDto.setId(id);
        ticketInfoDto.setPrice(price);
        ticketInfoDto.setCurrency(currency);
        ticketInfoDto.setAvailability(availability);
        ticketInfoDto.setAttractionId(attractionId);

        assertThat(ticketInfoDto.getId()).isEqualTo(id);
        assertThat(ticketInfoDto.getPrice()).isEqualTo(price);
        assertThat(ticketInfoDto.getCurrency()).isEqualTo(currency);
        assertThat(ticketInfoDto.getAvailability()).isEqualTo(availability);
        assertThat(ticketInfoDto.getAttractionId()).isEqualTo(attractionId);
    }
}