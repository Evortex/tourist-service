package com.example.tourist.controller;

import com.example.tourist.dto.WeatherDataDto;
import com.example.tourist.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping(produces = "application/json")
    public WeatherDataDto getWeatherDataDto(@RequestParam String q1, @RequestParam String q2) {
        StringBuilder coordinates = new StringBuilder();
        coordinates.append(q1).append(",").append(q2);
        return weatherService.getWeather(coordinates.toString());
    }
}
