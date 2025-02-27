package com.example.tourist.mapper;

import com.example.tourist.dto.ProviderDto;
import com.example.tourist.model.Provider;
import org.springframework.stereotype.Component;

@Component
public class ProviderMapper {
    public static ProviderDto toDto(Provider provider) {
        ProviderDto dto = new ProviderDto();
        dto.setId(provider.getId());
        dto.setName(provider.getName());
        dto.setDescription(provider.getDescription());
        dto.setType(provider.getType());
        return dto;
    }

    public static Provider toEntity(ProviderDto dto) {
        Provider provider = new Provider();
        provider.setId(dto.getId());
        provider.setName(dto.getName());
        provider.setDescription(dto.getDescription());
        provider.setType(dto.getType());
        return provider;
    }
}

