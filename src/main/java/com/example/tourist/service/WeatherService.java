package com.example.tourist.service;

import com.example.tourist.dto.WeatherDataDto;

public interface WeatherService {

    WeatherDataDto getWeather(String coordinates);
}

