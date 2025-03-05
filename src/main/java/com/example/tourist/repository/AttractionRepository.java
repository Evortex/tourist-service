package com.example.tourist.repository;

import com.example.tourist.model.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Репозиторий для работы с сущностью {@link Attraction}.
 * Этот интерфейс расширяет {@link JpaRepository} и предоставляет стандартные методы для взаимодействия с базой данных
 * для объектов {@link Attraction}.
 * Репозиторий автоматически предоставляет основные CRUD операции (создание, чтение, обновление и удаление),
 * а также дополнительные методы для поиска объектов {@link Attraction} по разным критериям.
 * Например, метод {@link #findByAddress_CityContainingIgnoreCase(String city)} выполняет поиск аттракционов по городу
 * в поле адреса, игнорируя регистр.
 */
@Repository
public interface AttractionRepository extends JpaRepository<Attraction, UUID> {
    /**
     * Ищет аттракционы по городу в поле адреса. Поиск выполняется с учетом части города (поддержка поиска по подстроке)
     * и без учета регистра символов.
     * @param city название города, которое будет использовано для поиска аттракционов
     * @return список аттракционов, расположенных в указанном городе
     */
    List<Attraction> findByAddress_CityContainingIgnoreCase(String city);
}
