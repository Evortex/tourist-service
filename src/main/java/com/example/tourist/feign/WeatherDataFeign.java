package com.example.tourist.feign;

import com.example.tourist.dto.WeatherDataDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weatherClient", url = "http://api.weatherapi.com/v1/current.json")
public interface WeatherDataFeign {

    @GetMapping(produces = "application/json")
    WeatherDataDto getWeather(
            @RequestParam("key") String apiKey,
            @RequestParam("q") String coordinates,
            @RequestParam("aqi") String aqi
    );
}
