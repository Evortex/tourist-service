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

    List<Attraction> getAllAttractions();

    Attraction getAttractionById(UUID id);

    Attraction saveAttraction(Attraction attraction);

    void deleteAttraction(UUID id);

    List<Attraction> searchByCity(String city);
}
