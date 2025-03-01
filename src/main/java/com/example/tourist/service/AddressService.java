package com.example.tourist.service;

import com.example.tourist.model.Address;

import java.util.List;
import java.util.UUID;

public interface AddressService {

     List<Address> getAllAddresses();

     Address getAddressById(UUID id);

     Address saveAddress(Address address);

     void deleteAddress(UUID id);

     List<Address> searchByCity(String city);

     List<Address> searchByRegion(String region);
}