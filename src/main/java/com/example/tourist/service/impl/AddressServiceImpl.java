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

    /**
     * Конструктор для инициализации {@link AddressRepository}.
     *
     * @param addressRepository репозиторий для работы с данными об адресах
     */
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    /**
     * Получить все адреса.
     *
     * @return список всех адресов {@link Address}
     */
    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    /**
     * Получить адрес по его уникальному идентификатору.
     *
     * @param id уникальный идентификатор адреса
     * @return объект {@link Address} с данными адреса
     * @throws AddressNotFoundException если адрес с заданным идентификатором не найден
     */
    @Override
    public Address getAddressById(UUID id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException(ADDRESS_NOT_FOUND_MESSAGE));
    }

    /**
     * Сохранить данные об адресе в базе данных.
     *
     * @param address объект {@link Address} с данными для сохранения
     * @return сохранённый объект {@link Address}
     */
    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    /**
     * Удалить адрес по его уникальному идентификатору.
     *
     * @param id уникальный идентификатор адреса
     */
    @Override
    public void deleteAddress(UUID id) {
        addressRepository.deleteById(id);
    }

    /**
     * Найти все адреса, расположенные в указанном городе.
     *
     * @param city название города
     * @return список адресов, расположенных в указанном городе
     */
    @Override
    public List<Address> searchByCity(String city) {
        return addressRepository.findByCity(city);
    }

    /**
     * Найти все адреса, расположенные в указанном регионе.
     *
     * @param region название региона
     * @return список адресов, расположенных в указанном регионе
     */
    @Override
    public List<Address> searchByRegion(String region) {
        return addressRepository.findByRegion(region);
    }
}