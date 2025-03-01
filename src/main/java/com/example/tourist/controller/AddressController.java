package com.example.tourist.controller;

import com.example.tourist.dto.AddressDto;
import com.example.tourist.mapper.AddressMapper;
import com.example.tourist.model.Address;
import com.example.tourist.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Контроллер для работы с адресами.
 * Предоставляет API для получения, создания, удаления и поиска адресов.
 */
@RestController
@RequestMapping("/api/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    /**
     * Получает список всех адресов.
     *
     * @return Список объектов {@link AddressDto}, представляющих все адреса.
     */
    @GetMapping
    public List<AddressDto> getAllAddresses() {
        return addressService.getAllAddresses().stream()
                .map(AddressMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Получает адрес по уникальному идентификатору.
     *
     * @param id UUID уникальный идентификатор адреса.
     * @return Ответ с объектом {@link AddressDto}, представляющим адрес.
     */
    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable UUID id) {
        return ResponseEntity.ok(AddressMapper.toDto(addressService.getAddressById(id)));
    }

    /**
     * Создает новый адрес.
     *
     * @param addressDto Объект {@link AddressDto}, содержащий данные для создания адреса.
     * @return Объект {@link AddressDto}, представляющий созданный адрес.
     */
    @PostMapping
    public AddressDto createAddress(@RequestBody AddressDto addressDto) {
        Address address = AddressMapper.toEntity(addressDto);
        return AddressMapper.toDto(addressService.saveAddress(address));
    }

    /**
     * Удаляет адрес по уникальному идентификатору.
     *
     * @param id UUID уникальный идентификатор адреса, который нужно удалить.
     */
    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable UUID id) {
        addressService.deleteAddress(id);
    }

    /**
     * Ищет адреса по названию города.
     *
     * @param city Название города для поиска.
     * @return Список объектов {@link AddressDto}, представляющих адреса, найденные по городу.
     */
    @GetMapping("/search/city")
    public List<AddressDto> searchByCity(@RequestParam String city) {
        return addressService.searchByCity(city).stream()
                .map(AddressMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Ищет адреса по названию региона.
     *
     * @param region Название региона для поиска.
     * @return Список объектов {@link AddressDto}, представляющих адреса, найденные по региону.
     */
    @GetMapping("/search/region")
    public List<AddressDto> searchByRegion(@RequestParam String region) {
        return addressService.searchByRegion(region).stream()
                .map(AddressMapper::toDto)
                .collect(Collectors.toList());
    }
}