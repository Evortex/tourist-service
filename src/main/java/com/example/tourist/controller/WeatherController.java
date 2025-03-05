package com.example.tourist.controller;

import com.example.tourist.dto.WeatherDataDto;
import com.example.tourist.service.WeatherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер для получения данных о погоде.
 * Предоставляет API для получения данных о погоде по координатам.
 */
@RestController
@RequestMapping("api/weather")
@RequiredArgsConstructor
@Tag(name = "Погода", description = "API для получения данных о погоде")
public class WeatherController {

    private final WeatherService weatherService;

    /**
     * Получает данные о погоде для указанных координат.
     * @param q1 Широта места.
     * @param q2 Долгота места.
     * @return Объект {@link WeatherDataDto}, содержащий данные о погоде для указанных координат.
     */
    @Operation(summary = "Получить данные о погоде", description = "Возвращает текущую погоду по заданным координатам (широта и долгота)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение данных о погоде"),
            @ApiResponse(responseCode = "400", description = "Некорректные параметры запроса"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @GetMapping(produces = "application/json")
    public WeatherDataDto getWeatherDataDto(@RequestParam String q1, @RequestParam String q2) {
        String coordinates = q1 + "," + q2;
        return weatherService.getWeather(coordinates);
    }
}
