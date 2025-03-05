package com.example.tourist.service;

import com.example.tourist.model.Address;

import java.util.List;
import java.util.UUID;

/**
 * Сервис для работы с адресами.
 * Этот интерфейс определяет методы для получения, создания, обновления и удаления данных о адресах.
 * Адреса могут быть связаны с различными достопримечательностями, поставщиками и другой информацией.
 */
public interface AddressService {

     List<Address> getAllAddresses();

     Address getAddressById(UUID id);

     Address saveAddress(Address address);

     void deleteAddress(UUID id);

     List<Address> searchByCity(String city);

     List<Address> searchByRegion(String region);
}
