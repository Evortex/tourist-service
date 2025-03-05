package com.example.tourist.mapper;

import com.example.tourist.dto.ProviderDto;
import com.example.tourist.model.Provider;
import org.springframework.stereotype.Component;

/**
 * Класс для преобразования между объектами {@link Provider} и {@link ProviderDto}.
 * Используется для преобразования данных между слоями модели и DTO.
 */
@Component
public class ProviderMapper {

    /**
     * Преобразует объект {@link Provider} в объект {@link ProviderDto}.
     *
     * @param provider объект модели, который необходимо преобразовать.
     * @return объект типа {@link ProviderDto}, содержащий данные из объекта {@link Provider}.
     */
    public static ProviderDto toDto(Provider provider) {
        ProviderDto dto = new ProviderDto();
        dto.setId(provider.getId());
        dto.setName(provider.getName());
        dto.setDescription(provider.getDescription());
        dto.setType(provider.getType());
        return dto;
    }

    /**
     * Преобразует объект {@link ProviderDto} в объект {@link Provider}.
     *
     * @param dto объект типа {@link ProviderDto}, который необходимо преобразовать.
     * @return объект модели {@link Provider}, содержащий данные из объекта {@link ProviderDto}.
     */
    public static Provider toEntity(ProviderDto dto) {
        Provider provider = new Provider();
        provider.setId(dto.getId());
        provider.setName(dto.getName());
        provider.setDescription(dto.getDescription());
        provider.setType(dto.getType());
        return provider;
    }
}
