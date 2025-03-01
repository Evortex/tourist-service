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

     /**
      * Получить список всех адресов.
      *
      * @return список всех {@link Address}
      */
     List<Address> getAllAddresses();

     /**
      * Получить информацию об адресе по его уникальному идентификатору.
      *
      * @param id уникальный идентификатор адреса
      * @return объект {@link Address}, содержащий данные о адресе
      */
     Address getAddressById(UUID id);

     /**
      * Сохранить новый или обновить существующий адрес.
      *
      * @param address объект {@link Address}, содержащий информацию об адресе
      * @return объект {@link Address}, сохраненный в базе данных
      */
     Address saveAddress(Address address);

     /**
      * Удалить адрес по его уникальному идентификатору.
      *
      * @param id уникальный идентификатор адреса
      */
     void deleteAddress(UUID id);

     /**
      * Найти адреса по названию города.
      *
      * @param city название города
      * @return список {@link Address} в указанном городе
      */
     List<Address> searchByCity(String city);

     /**
      * Найти адреса по названию региона.
      *
      * @param region название региона
      * @return список {@link Address} в указанном регионе
      */
     List<Address> searchByRegion(String region);
}