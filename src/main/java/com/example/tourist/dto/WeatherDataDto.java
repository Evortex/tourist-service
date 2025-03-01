package com.example.tourist.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Класс для представления данных о погоде.
 * Используется для получения информации о текущей погоде, включая параметры
 * такие как температура, влажность, давление и т.д.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class WeatherDataDto {

    /**
     * Местоположение (город, регион, страна, координаты).
     */
    @JsonProperty("location")
    private Location location;

    /**
     * Текущие погодные условия (температура, влажность, скорость ветра и т.д.).
     */
    @JsonProperty("current")
    private Current current;

    /**
     * Вложенный класс, представляющий местоположение для погодных данных.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class Location {
        /**
         * Название местоположения (например, город).
         */
        private String name;

        /**
         * Регион, в котором находится местоположение.
         */
        private String region;

        /**
         * Страна, в которой находится местоположение.
         */
        private String country;

        /**
         * Широта местоположения.
         */
        private Double lat;

        /**
         * Долгота местоположения.
         */
        private Double lon;

        /**
         * Идентификатор часового пояса.
         */
        @JsonProperty("tz_id")
        private String tzId;

        /**
         * Время в формате Unix (секунды с 1970 года).
         */
        @JsonProperty("localtime_epoch")
        private Integer localtimeEpoch;

        /**
         * Локальное время в формате строки.
         */
        private String localtime;
    }

    /**
     * Вложенный класс, представляющий текущие погодные условия.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class Current {
        /**
         * Время последнего обновления погодных данных в формате Unix.
         */
        @JsonProperty("last_updated_epoch")
        private Integer lastUpdatedEpoch;

        /**
         * Время последнего обновления погодных данных.
         */
        @JsonProperty("last_updated")
        private String lastUpdated;

        /**
         * Температура в градусах Цельсия.
         */
        @JsonProperty("temp_c")
        private Double tempC;

        /**
         * Температура в градусах Фаренгейта.
         */
        @JsonProperty("temp_f")
        private Double tempF;

        /**
         * Показатель дня (1 — день, 0 — ночь).
         */
        @JsonProperty("is_day")
        private Integer isDay;

        /**
         * Условия погоды (например, ясно, дождливо).
         */
        private Condition condition;

        /**
         * Скорость ветра в милях в час.
         */
        @JsonProperty("wind_mph")
        private Double windMph;

        /**
         * Скорость ветра в километрах в час.
         */
        @JsonProperty("wind_kph")
        private Double windKph;

        /**
         * Направление ветра в градусах.
         */
        @JsonProperty("wind_degree")
        private Integer windDegree;

        /**
         * Направление ветра (например, север, юг).
         */
        @JsonProperty("wind_dir")
        private String windDir;

        /**
         * Давление в миллибарах.
         */
        @JsonProperty("pressure_mb")
        private Double pressureMb;

        /**
         * Давление в дюймах ртутного столба.
         */
        @JsonProperty("pressure_in")
        private Double pressureIn;

        /**
         * Количество осадков в миллиметрах.
         */
        @JsonProperty("precip_mm")
        private Double precipMm;

        /**
         * Количество осадков в дюймах.
         */
        @JsonProperty("precip_in")
        private Double precipIn;

        /**
         * Влажность в процентах.
         */
        private Integer humidity;

        /**
         * Облачность в процентах.
         */
        private Integer cloud;

        /**
         * Температура, как ощущается человеком, в градусах Цельсия.
         */
        @JsonProperty("feelslike_c")
        private Double feelslikeC;

        /**
         * Температура, как ощущается человеком, в градусах Фаренгейта.
         */
        @JsonProperty("feelslike_f")
        private Double feelslikeF;

        /**
         * Видимость в километрах.
         */
        @JsonProperty("vis_km")
        private Double visKm;

        /**
         * Видимость в милях.
         */
        @JsonProperty("vis_miles")
        private Double visMiles;

        /**
         * Ультрафиолетовый индекс.
         */
        private Double uv;

        /**
         * Скорость порывов ветра в милях в час.
         */
        @JsonProperty("gust_mph")
        private Double gustMph;

        /**
         * Скорость порывов ветра в километрах в час.
         */
        @JsonProperty("gust_kph")
        private Double gustKph;
    }

    /**
     * Вложенный класс, представляющий описание погодных условий (например, "ясно", "дождливо").
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class Condition {
        /**
         * Описание погодных условий (например, "ясно", "дождливо").
         */
        private String text;

        /**
         * Иконка, соответствующая погодным условиям.
         */
        private String icon;

        /**
         * Код погодных условий.
         */
        private Integer code;
    }
}
