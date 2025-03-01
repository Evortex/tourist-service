package com.example.tourist.service.impl;

import com.example.tourist.exception.AddressNotFoundException;
import com.example.tourist.model.Address;
import com.example.tourist.repository.AddressRepository;
import com.example.tourist.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.example.tourist.util.AddressMessages.ADDRESS_NOT_FOUND_MESSAGE;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(UUID id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException(ADDRESS_NOT_FOUND_MESSAGE));
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public void deleteAddress(UUID id) {
        addressRepository.deleteById(id);
    }

    public List<Address> searchByCity(String city) {
        return addressRepository.findByCity(city);
    }

    public List<Address> searchByRegion(String region) {
        return addressRepository.findByRegion(region);
    }
}