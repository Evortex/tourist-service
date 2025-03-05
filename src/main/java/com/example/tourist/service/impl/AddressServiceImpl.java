package com.example.tourist.service.impl;

import com.example.tourist.exception.AddressNotFoundException;
import com.example.tourist.model.Address;
import com.example.tourist.repository.AddressRepository;
import com.example.tourist.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.example.tourist.util.AddressMessages.ADDRESS_NOT_FOUND_MESSAGE;

/**
 * Реализация сервиса для управления данными об адресах.
 * Этот сервис предоставляет методы для получения, сохранения, удаления и поиска адресов.
 */
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(UUID id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException(ADDRESS_NOT_FOUND_MESSAGE));
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(UUID id) {
        if (!addressRepository.existsById(id)) {
            throw new AddressNotFoundException(ADDRESS_NOT_FOUND_MESSAGE);
        }
        addressRepository.deleteById(id);
    }

    @Override
    public List<Address> searchByCity(String city) {
        return addressRepository.findByCity(city);
    }

    @Override
    public List<Address> searchByRegion(String region) {
        return addressRepository.findByRegion(region);
    }
}
