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
 * Класс для работы с адресами
 */
@RestController
@RequestMapping("/api/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public List<AddressDto> getAllAddresses() {
        return addressService.getAllAddresses().stream()
                .map(AddressMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable UUID id) {
        return ResponseEntity.ok(AddressMapper.toDto(addressService.getAddressById(id)));
    }

    @PostMapping
    public AddressDto createAddress(@RequestBody AddressDto addressDto) {
        Address address = AddressMapper.toEntity(addressDto);
        return AddressMapper.toDto(addressService.saveAddress(address));
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable UUID id) {
        addressService.deleteAddress(id);
    }

    @GetMapping("/search/city")
    public List<AddressDto> searchByCity(@RequestParam String city) {
        return addressService.searchByCity(city).stream()
                .map(AddressMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/search/region")
    public List<AddressDto> searchByRegion(@RequestParam String region) {
        return addressService.searchByRegion(region).stream()
                .map(AddressMapper::toDto)
                .collect(Collectors.toList());
    }
}
