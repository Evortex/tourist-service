package com.example.tourist.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Класс для представления данных о погоде.
 * Используется для получения информации о текущей погоде, включая параметры
 * такие как температура, влажность, давление и т.д.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@Schema(description = "DTO для представления данных о погоде.")
public class WeatherDataDto {

    @Schema(description = "Информация о местоположении")
    @JsonProperty("location")
    private Location location;

    @Schema(description = "Информация о текущих погодных условиях")
    @JsonProperty("current")
    private Current current;

    /**
     * Вложенный класс, представляющий местоположение для погодных данных.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    @Schema(description = "Информация о местоположении для погодных данных.")
    public static class Location {

        @Schema(description = "Название города", example = "Москва")
        private String name;

        @Schema(description = "Регион", example = "Московская область")
        private String region;

        @Schema(description = "Страна", example = "Россия")
        private String country;

        @Schema(description = "Широта", example = "55.7558")
        private Double lat;

        @Schema(description = "Долгота", example = "37.6173")
        private Double lon;

        @Schema(description = "Идентификатор часового пояса", example = "Europe/Moscow")
        @JsonProperty("tz_id")
        private String tzId;

        @Schema(description = "Временная метка локального времени (epoch)", example = "1617187200")
        @JsonProperty("localtime_epoch")
        private Integer localtimeEpoch;

        @Schema(description = "Локальное время", example = "2025-03-05 14:00")
        private String localtime;
    }

    /**
     * Вложенный класс, представляющий текущие погодные условия.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    @Schema(description = "Информация о текущих погодных условиях.")
    public static class Current {

        @Schema(description = "Последнее обновление (epoch)", example = "1617187200")
        @JsonProperty("last_updated_epoch")
        private Integer lastUpdatedEpoch;

        @Schema(description = "Последнее обновление", example = "2025-03-05 14:00")
        @JsonProperty("last_updated")
        private String lastUpdated;

        @Schema(description = "Температура в градусах Цельсия", example = "15.5")
        @JsonProperty("temp_c")
        private Double tempC;

        @Schema(description = "Температура в градусах Фаренгейта", example = "59.9")
        @JsonProperty("temp_f")
        private Double tempF;

        @Schema(description = "Является ли сейчас день (1 - да, 0 - нет)", example = "1")
        @JsonProperty("is_day")
        private Integer isDay;

        @Schema(description = "Описание погодных условий")
        private Condition condition;

        @Schema(description = "Скорость ветра в миль/ч", example = "12.5")
        @JsonProperty("wind_mph")
        private Double windMph;

        @Schema(description = "Скорость ветра в км/ч", example = "20.1")
        @JsonProperty("wind_kph")
        private Double windKph;

        @Schema(description = "Направление ветра в градусах", example = "240")
        @JsonProperty("wind_degree")
        private Integer windDegree;

        @Schema(description = "Направление ветра (строковое значение)", example = "WSW")
        @JsonProperty("wind_dir")
        private String windDir;

        @Schema(description = "Давление в миллибарах", example = "1012.3")
        @JsonProperty("pressure_mb")
        private Double pressureMb;

        @Schema(description = "Давление в дюймах рт. ст.", example = "29.88")
        @JsonProperty("pressure_in")
        private Double pressureIn;

        @Schema(description = "Осадки в мм", example = "0.2")
        @JsonProperty("precip_mm")
        private Double precipMm;

        @Schema(description = "Осадки в дюймах", example = "0.01")
        @JsonProperty("precip_in")
        private Double precipIn;

        @Schema(description = "Влажность в %", example = "80")
        private Integer humidity;

        @Schema(description = "Облачность в %", example = "75")
        private Integer cloud;

        @Schema(description = "Ощущаемая температура в градусах Цельсия", example = "14.0")
        @JsonProperty("feelslike_c")
        private Double feelslikeC;

        @Schema(description = "Ощущаемая температура в градусах Фаренгейта", example = "57.2")
        @JsonProperty("feelslike_f")
        private Double feelslikeF;

        @Schema(description = "Видимость в км", example = "10.0")
        @JsonProperty("vis_km")
        private Double visKm;

        @Schema(description = "Видимость в милях", example = "6.2")
        @JsonProperty("vis_miles")
        private Double visMiles;

        @Schema(description = "Индекс ультрафиолетового излучения", example = "5.0")
        private Double uv;

        @Schema(description = "Порывы ветра в миль/ч", example = "25.0")
        @JsonProperty("gust_mph")
        private Double gustMph;

        @Schema(description = "Порывы ветра в км/ч", example = "40.2")
        @JsonProperty("gust_kph")
        private Double gustKph;
    }

    /**
     * Вложенный класс, представляющий описание погодных условий (например, "ясно", "дождливо").
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    @Schema(description = "Описание погодных условий.")
    public static class Condition {

        @Schema(description = "Текстовое описание погоды", example = "Ясно")
        private String text;

        @Schema(description = "URL иконки погодных условий", example = "//cdn.weatherapi.com/weather/64x64/day/113.png")
        private String icon;

        @Schema(description = "Код состояния погоды", example = "1000")
        private Integer code;
    }
}
