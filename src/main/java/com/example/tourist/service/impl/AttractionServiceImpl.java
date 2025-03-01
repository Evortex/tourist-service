package com.example.tourist.service.impl;

import com.example.tourist.exception.AttractionNotFoundException;
import com.example.tourist.model.Attraction;
import com.example.tourist.repository.AttractionRepository;
import com.example.tourist.service.AttractionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.example.tourist.util.AttractionMessages.ATTRACTION_NOT_FOUND_MESSAGE;

/**
 * Реализация сервиса для управления данными о достопримечательностях.
 * Этот сервис предоставляет методы для получения, сохранения, удаления и поиска достопримечательностей по городу.
 */
@Service
public class AttractionServiceImpl implements AttractionService {

    private final AttractionRepository attractionRepository;

    /**
     * Конструктор для инициализации {@link AttractionRepository}.
     *
     * @param attractionRepository репозиторий для работы с данными о достопримечательностях
     */
    public AttractionServiceImpl(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    /**
     * Получить все достопримечательности.
     *
     * @return список всех достопримечательностей {@link Attraction}
     */
    @Override
    public List<Attraction> getAllAttractions() {
        return attractionRepository.findAll();
    }

    /**
     * Получить достопримечательность по её уникальному идентификатору.
     *
     * @param id уникальный идентификатор достопримечательности
     * @return объект {@link Attraction} с данными достопримечательности
     * @throws AttractionNotFoundException если достопримечательность с заданным идентификатором не найдена
     */
    @Override
    public Attraction getAttractionById(UUID id) {
        return attractionRepository.findById(id)
                .orElseThrow(() -> new AttractionNotFoundException(ATTRACTION_NOT_FOUND_MESSAGE));
    }

    /**
     * Сохранить данные о достопримечательности в базе данных.
     *
     * @param attraction объект {@link Attraction} с данными для сохранения
     * @return сохранённый объект {@link Attraction}
     */
    @Override
    public Attraction saveAttraction(Attraction attraction) {
        return attractionRepository.save(attraction);
    }

    /**
     * Удалить достопримечательность по её уникальному идентификатору.
     *
     * @param id уникальный идентификатор достопримечательности
     */
    @Override
    public void deleteAttraction(UUID id) {
        attractionRepository.deleteById(id);
    }

    /**
     * Найти все достопримечательности, расположенные в указанном городе.
     *
     * @param city название города
     * @return список достопримечательностей, расположенных в указанном городе
     */
    @Override
    public List<Attraction> searchByCity(String city) {
        return attractionRepository.findByAddress_CityContainingIgnoreCase(city);
    }
}
