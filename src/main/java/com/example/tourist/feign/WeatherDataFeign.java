package com.example.tourist.feign;

import com.example.tourist.dto.WeatherDataDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Интерфейс для взаимодействия с внешним API погоды с использованием Feign.
 * Этот клиент делает запросы к API погоды (WeatherAPI) для получения данных о текущей погоде.
 */
@FeignClient(name = "weatherClient", url = "http://api.weatherapi.com/v1/current.json")
public interface WeatherDataFeign {

    /**
     * Метод для получения данных о текущей погоде.
     *
     * @param apiKey API ключ для аутентификации на сервере WeatherAPI.
     * @param coordinates Координаты (широта и долгота), по которым нужно получить данные о погоде.
     * @param aqi Параметр для получения данных о качестве воздуха (например, "yes" или "no").
     * @return Объект {@link WeatherDataDto}, содержащий данные о текущей погоде.
     */
    @GetMapping(produces = "application/json")
    WeatherDataDto getWeather(
            @RequestParam("key") String apiKey,
            @RequestParam("q") String coordinates,
            @RequestParam("aqi") String aqi
    );
}
