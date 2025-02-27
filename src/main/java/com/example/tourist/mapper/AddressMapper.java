package com.example.tourist.mapper;

import com.example.tourist.dto.AddressDto;
import com.example.tourist.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public static AddressDto toDto(Address address) {
        AddressDto dto = new AddressDto();
        dto.setId(address.getId());
        dto.setBuilding(address.getBuilding());
        dto.setStreet(address.getStreet());
        dto.setCity(address.getCity());
        dto.setRegion(address.getRegion());
        dto.setLongitude(address.getLongitude());
        dto.setLatitude(address.getLatitude());
        return dto;
    }

    public static Address toEntity(AddressDto dto) {
        Address address = new Address();
        address.setId(dto.getId());
        address.setBuilding(dto.getBuilding());
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setRegion(dto.getRegion());
        address.setLongitude(dto.getLongitude());
        address.setLatitude(dto.getLatitude());
        return address;
    }
}

