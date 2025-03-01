package com.example.tourist.dto;

import lombok.Data;
import java.util.UUID;

/**
 * Класс для представления информации об адресе.
 * Используется для передачи данных об адресе между слоями приложения.
 */
@Data
public class AddressDto {

    /**
     * Уникальный идентификатор адреса.
     */
    private UUID id;

    /**
     * Номер здания.
     */
    private Integer building;

    /**
     * Название улицы.
     */
    private String street;

    /**
     * Название города.
     */
    private String city;

    /**
     * Название региона.
     */
    private String region;

    /**
     * Долгота адреса.
     */
    private Double longitude;

    /**
     * Широта адреса.
     */
    private Double latitude;

    /**
     * Получает уникальный идентификатор адреса.
     *
     * @return UUID идентификатор адреса.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Устанавливает уникальный идентификатор адреса.
     *
     * @param id UUID уникальный идентификатор адреса.
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Получает номер здания.
     *
     * @return Номер здания.
     */
    public Integer getBuilding() {
        return building;
    }

    /**
     * Устанавливает номер здания.
     *
     * @param building Номер здания.
     */
    public void setBuilding(Integer building) {
        this.building = building;
    }

    /**
     * Получает название улицы.
     *
     * @return Название улицы.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Устанавливает название улицы.
     *
     * @param street Название улицы.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Получает название города.
     *
     * @return Название города.
     */
    public String getCity() {
        return city;
    }

    /**
     * Устанавливает название города.
     *
     * @param city Название города.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Получает название региона.
     *
     * @return Название региона.
     */
    public String getRegion() {
        return region;
    }

    /**
     * Устанавливает название региона.
     *
     * @param region Название региона.
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Получает долготу адреса.
     *
     * @return Долгота адреса.
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * Устанавливает долготу адреса.
     *
     * @param longitude Долгота адреса.
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * Получает широту адреса.
     *
     * @return Широта адреса.
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Устанавливает широту адреса.
     *
     * @param latitude Широта адреса.
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}