package com.example.tourist.repository;

import com.example.tourist.model.TicketInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Репозиторий для работы с сущностью {@link TicketInfo}.
 * Этот интерфейс расширяет {@link JpaRepository} и предоставляет методы для взаимодействия с базой данных
 * для операций с объектами {@link TicketInfo}.
 * В данный момент репозиторий не содержит дополнительных методов, кроме тех, что предоставляются {@link JpaRepository}.
 * {@link JpaRepository} уже включает основные операции, такие как сохранение, удаление, обновление и поиск по ID.
 */
@Repository
public interface TicketInfoRepository extends JpaRepository<TicketInfo, UUID> {
}
