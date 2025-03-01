package com.example.tourist.service;

import com.example.tourist.model.Attraction;

import java.util.List;
import java.util.UUID;

/**
 * Сервис для работы с достопримечательностями.
 * Этот интерфейс определяет методы для получения, создания, обновления и удаления данных о достопримечательностях.
 * Достопримечательности могут быть связаны с различными адресами, билетами и поставщиками услуг.
 */
public interface AttractionService {

    /**
     * Получить список всех достопримечательностей.
     *
     * @return список всех {@link Attraction}
     */
    List<Attraction> getAllAttractions();

    /**
     * Получить информацию о достопримечательности по ее уникальному идентификатору.
     *
     * @param id уникальный идентификатор достопримечательности
     * @return объект {@link Attraction}, содержащий данные о достопримечательности
     */
    Attraction getAttractionById(UUID id);

    /**
     * Сохранить новую или обновить существующую достопримечательность.
     *
     * @param attraction объект {@link Attraction}, содержащий информацию о достопримечательности
     * @return объект {@link Attraction}, сохраненный в базе данных
     */
    Attraction saveAttraction(Attraction attraction);

    /**
     * Удалить достопримечательность по ее уникальному идентификатору.
     *
     * @param id уникальный идентификатор достопримечательности
     */
    void deleteAttraction(UUID id);

    /**
     * Найти достопримечательности по названию города.
     *
     * @param city название города
     * @return список {@link Attraction} в указанном городе
     */
    List<Attraction> searchByCity(String city);
}
