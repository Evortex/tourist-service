package com.example.tourist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Класс для представления информации о билетах.
 * Используется для передачи данных о стоимости и доступности билетов для аттракционов.
 */
@Data
@AllArgsConstructor
public class TicketInfoDto {

    /**
     * Уникальный идентификатор записи о билете.
     */
    private UUID id;

    /**
     * Цена билета.
     */
    private BigDecimal price;

    /**
     * Валюта, в которой указана цена билета.
     */
    private String currency;

    /**
     * Доступность билета (доступен ли билет для покупки).
     */
    private Boolean availability;

    /**
     * Идентификатор аттракциона, для которого доступен билет.
     */
    private UUID attractionId;

    /**
     * Пустой конструктор для создания объекта TicketInfoDto.
     */
    public TicketInfoDto() {
    }

    /**
     * Получает уникальный идентификатор билета.
     *
     * @return UUID уникальный идентификатор билета.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Устанавливает уникальный идентификатор билета.
     *
     * @param id UUID уникальный идентификатор билета.
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Получает цену билета.
     *
     * @return Цена билета.
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Устанавливает цену билета.
     *
     * @param price Цена билета.
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Получает валюту, в которой указана цена билета.
     *
     * @return Валюта цены билета.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Устанавливает валюту, в которой указана цена билета.
     *
     * @param currency Валюта для цены билета.
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Получает доступность билета.
     *
     * @return Доступность билета (true, если доступен).
     */
    public Boolean getAvailability() {
        return availability;
    }

    /**
     * Устанавливает доступность билета.
     *
     * @param availability Доступность билета (true, если доступен).
     */
    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    /**
     * Получает идентификатор аттракциона, для которого доступен билет.
     *
     * @return Идентификатор аттракциона.
     */
    public UUID getAttractionId() {
        return attractionId;
    }

    /**
     * Устанавливает идентификатор аттракциона, для которого доступен билет.
     *
     * @param attractionId Идентификатор аттракциона.
     */
    public void setAttractionId(UUID attractionId) {
        this.attractionId = attractionId;
    }
}