package com.example.tourist.repository;

import com.example.tourist.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Репозиторий для работы с сущностью {@link Provider}.
 * Этот интерфейс расширяет {@link JpaRepository} и предоставляет стандартные методы для взаимодействия с базой данных
 * для объектов {@link Provider}.
 * Репозиторий автоматически предоставляет основные CRUD операции (создание, чтение, обновление и удаление),
 * а также дополнительные функции поиска по идентификатору {@link UUID}.
 */
@Repository
public interface ProviderRepository extends JpaRepository<Provider, UUID> {
}
