package com.example.tourist.service;

import com.example.tourist.dto.WeatherDataDto;

/**
 * Сервис для получения данных о погоде.
 * Этот интерфейс определяет метод для получения погодных данных по заданным координатам.
 * Сервис взаимодействует с внешними API для получения актуальной информации о погоде.
 */
public interface WeatherService {

    WeatherDataDto getWeather(String coordinates);
}
