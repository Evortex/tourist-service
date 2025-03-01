package com.example.tourist.service.impl;

import com.example.tourist.dto.WeatherDataDto;
import com.example.tourist.feign.WeatherDataFeign;
import com.example.tourist.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService{

    private final WeatherDataFeign weatherDataFeign;

    @Value("${apiKey}")
    private String apiKey;
    @Value("${aqi}")
    private String aqi;

    public WeatherDataDto getWeather(String coordinates) {
        return weatherDataFeign.getWeather(
                apiKey,
                coordinates,
                aqi
        );
    }
}