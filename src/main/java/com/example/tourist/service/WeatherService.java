package com.example.tourist.service;

import com.example.tourist.dto.WeatherDataDto;

/**
 * Сервис для получения данных о погоде.
 * Этот интерфейс определяет метод для получения погодных данных по заданным координатам.
 * <p>
 * Сервис взаимодействует с внешними API для получения актуальной информации о погоде.
 */
public interface WeatherService {

    /**
     * Получить данные о погоде для указанных координат.
     *
     * @param coordinates строка, представляющая координаты в формате "широта, долгота"
     * @return объект {@link WeatherDataDto}, содержащий данные о текущей погоде
     */
    WeatherDataDto getWeather(String coordinates);
}
