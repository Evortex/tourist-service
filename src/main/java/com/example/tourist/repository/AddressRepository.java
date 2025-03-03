package com.example.tourist.repository;

import com.example.tourist.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Репозиторий для работы с сущностью {@link Address}.
 * Этот интерфейс расширяет {@link JpaRepository} и предоставляет методы для взаимодействия с базой данных
 * для операций с объектами {@link Address}.
 * Основные методы:
 * {@link #findByCity(String)} - ищет адреса по названию города.
 * {@link #findByRegion(String)} - ищет адреса по названию региона.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {

    /**
     * Находит список адресов по названию города.
     *
     * @param city Название города, по которому будет произведен поиск.
     * @return Список адресов, соответствующих данному городу.
     */
    List<Address> findByCity(String city);

    /**
     * Находит список адресов по названию региона.
     *
     * @param region Название региона, по которому будет произведен поиск.
     * @return Список адресов, соответствующих данному региону.
     */
    List<Address> findByRegion(String region);
}
