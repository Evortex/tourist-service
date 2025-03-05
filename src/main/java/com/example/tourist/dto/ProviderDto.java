package com.example.tourist.dto;

import com.example.tourist.model.ProviderType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Класс для представления информации о поставщике услуг.
 * Используется для передачи данных о поставщике услуг между слоями приложения.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO для передачи информации о поставщике услуг")
public class ProviderDto {

    @Schema(description = "Уникальный идентификатор поставщика услуг", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID id;

    @Schema(description = "Название поставщика услуг", example = "Best Tours")
    private String name;

    @Schema(description = "Описание поставщика услуг", example = "Туристическое агентство, предоставляющее экскурсионные туры")
    private String description;

    @Schema(description = "Тип поставщика услуг", example = "TRAVEL_AGENCY")
    private ProviderType type;
}
