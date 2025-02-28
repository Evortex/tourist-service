package com.example.tourist.service;

import com.example.tourist.model.Address;
import com.example.tourist.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(UUID id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
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