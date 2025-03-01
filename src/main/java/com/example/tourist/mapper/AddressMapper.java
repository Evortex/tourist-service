package com.example.tourist.mapper;

import com.example.tourist.dto.AddressDto;
import com.example.tourist.model.Address;
import org.springframework.stereotype.Component;

/**
 * Класс для преобразования между объектами {@link Address} и {@link AddressDto}.
 * Используется для преобразования данных между слоями модели и DTO.
 */
@Component
public class AddressMapper {

    /**
     * Преобразует объект {@link Address} в объект {@link AddressDto}.
     *
     * @param address объект модели, который необходимо преобразовать.
     * @return объект типа {@link AddressDto}, содержащий данные из объекта {@link Address}.
     */
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

    /**
     * Преобразует объект {@link AddressDto} в объект {@link Address}.
     *
     * @param dto объект типа {@link AddressDto}, который необходимо преобразовать.
     * @return объект модели {@link Address}, содержащий данные из объекта {@link AddressDto}.
     */
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
