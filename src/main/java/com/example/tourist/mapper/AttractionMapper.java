package com.example.tourist.mapper;

import com.example.tourist.dto.AttractionDto;
import com.example.tourist.model.Attraction;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * Класс для преобразования между объектами {@link Attraction} и {@link AttractionDto}.
 * Используется для преобразования данных между слоями модели и DTO.
 */
@Component
public class AttractionMapper {

    /**
     * Преобразует объект {@link Attraction} в объект {@link AttractionDto}.
     *
     * @param attraction объект модели, который необходимо преобразовать.
     * @return объект типа {@link AttractionDto}, содержащий данные из объекта {@link Attraction}.
     */
    public static AttractionDto toDto(Attraction attraction) {
        AttractionDto dto = new AttractionDto();
        dto.setId(attraction.getId());
        dto.setName(attraction.getName());
        dto.setDescription(attraction.getDescription());
        dto.setType(attraction.getType());
        dto.setAddressId(attraction.getAddress().getId());
        dto.setTicketInfoId(attraction.getTicketInfo() != null ? attraction.getTicketInfo().getId() : null);
        dto.setProviderIds(attraction.getProviders().stream().map(provider -> provider.getId()).collect(Collectors.toSet()));
        return dto;
    }

    /**
     * Преобразует объект {@link AttractionDto} в объект {@link Attraction}.
     *
     * @param dto объект типа {@link AttractionDto}, который необходимо преобразовать.
     * @return объект модели {@link Attraction}, содержащий данные из объекта {@link AttractionDto}.
     */
    public static Attraction toEntity(AttractionDto dto) {
        Attraction attraction = new Attraction();
        attraction.setId(dto.getId());
        attraction.setName(dto.getName());
        attraction.setDescription(dto.getDescription());
        attraction.setType(dto.getType());
        return attraction;
    }
}
