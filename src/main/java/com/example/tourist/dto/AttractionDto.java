package com.example.tourist.dto;

import com.example.tourist.model.AttractionType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

/**
 * Класс для представления информации о достопримечательности.
 * Используется для передачи данных о достопримечательности между слоями приложения.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO для передачи информации о достопримечательности")
public class AttractionDto {

    @Schema(description = "Уникальный идентификатор достопримечательности", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID id;

    @Schema(description = "Название достопримечательности", example = "Эйфелева башня")
    private String name;

    @Schema(description = "Описание достопримечательности", example = "Одна из самых известных достопримечательностей Парижа")
    private String description;

    @Schema(description = "Тип достопримечательности (культурная, историческая и т. д.)")
    private AttractionType type;

    @Schema(description = "Идентификатор адреса, связанного с достопримечательностью", example = "660e8400-e29b-41d4-a716-446655441234")
    private UUID addressId;

    @Schema(description = "Идентификатор информации о билетах", example = "770e8400-e29b-41d4-a716-446655442345")
    private UUID ticketInfoId;

    @Schema(description = "Множество идентификаторов поставщиков услуг", example = "[\"880e8400-e29b-41d4-a716-446655443456\", \"990e8400-e29b-41d4-a716-446655444567\"]")
    private Set<UUID> providerIds;
}
