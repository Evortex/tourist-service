package com.example.tourist.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Класс для представления информации об адресе.
 * Используется для передачи данных об адресе между слоями приложения.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO для передачи информации об адресе")
public class AddressDto {

    @Schema(description = "Уникальный идентификатор адреса", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID id;

    @Schema(description = "Номер здания", example = "10")
    private Integer building;

    @Schema(description = "Название улицы", example = "Main Street")
    private String street;

    @Schema(description = "Название города", example = "New York")
    private String city;

    @Schema(description = "Название региона", example = "NY")
    private String region;

    @Schema(description = "Долгота", example = "-74.006")
    private Double longitude;

    @Schema(description = "Широта", example = "40.7128")
    private Double latitude;
}
