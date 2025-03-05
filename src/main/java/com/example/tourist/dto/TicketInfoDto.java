package com.example.tourist.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Класс для представления информации о билетах.
 * Используется для передачи данных о стоимости и доступности билетов для аттракционов.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO для представления информации о билетах на аттракционы.")
public class TicketInfoDto {

    @Schema(description = "Уникальный идентификатор билета", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID id;

    @Schema(description = "Стоимость билета", example = "19.99")
    private BigDecimal price;

    @Schema(description = "Валюта стоимости билета", example = "USD")
    private String currency;

    @Schema(description = "Доступность билета (true - доступен, false - недоступен)", example = "true")
    private Boolean availability;

    @Schema(description = "Идентификатор аттракциона, к которому относится билет", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID attractionId;
}
