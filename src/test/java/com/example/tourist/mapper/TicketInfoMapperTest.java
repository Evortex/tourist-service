package com.example.tourist.mapper;

import com.example.tourist.dto.TicketInfoDto;
import com.example.tourist.model.TicketInfo;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Тестовый класс для {@link TicketInfoMapper}.
 * Проверяет корректность маппинга между {@link TicketInfo} и {@link TicketInfoDto}.
 */
class TicketInfoMapperTest {

    /**
     * Проверяет, что метод toDto() корректно преобразует сущность {@link TicketInfo} в {@link TicketInfoDto}.
     */
    @Test
    void testToDto() {
        TicketInfo ticketInfo = new TicketInfo();
        UUID ticketId = UUID.randomUUID();

        ticketInfo.setId(ticketId);
        ticketInfo.setPrice(new BigDecimal("49.99"));
        ticketInfo.setCurrency("USD");
        ticketInfo.setAvailability(true);

        TicketInfoDto dto = TicketInfoMapper.toDto(ticketInfo);

        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(ticketId);
        assertThat(dto.getPrice()).isEqualTo(new BigDecimal("49.99"));
        assertThat(dto.getCurrency()).isEqualTo("USD");
        assertThat(dto.getAvailability()).isTrue();
    }

    /**
     * Проверяет, что метод toEntity() корректно преобразует {@link TicketInfoDto} в {@link TicketInfo}.
     */
    @Test
    void testToEntity() {
        TicketInfoDto dto = new TicketInfoDto();
        UUID ticketId = UUID.randomUUID();

        dto.setId(ticketId);
        dto.setPrice(new BigDecimal("59.99"));
        dto.setCurrency("EUR");
        dto.setAvailability(false);

        TicketInfo ticketInfo = TicketInfoMapper.toEntity(dto);

        assertThat(ticketInfo).isNotNull();
        assertThat(ticketInfo.getId()).isEqualTo(ticketId);
        assertThat(ticketInfo.getPrice()).isEqualTo(new BigDecimal("59.99"));
        assertThat(ticketInfo.getCurrency()).isEqualTo("EUR");
        assertThat(ticketInfo.getAvailability()).isFalse();
    }
}