package com.example.tourist.dto;

import com.example.tourist.model.AttractionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.UUID;
import java.util.Set;

/**
 * Класс для представления информации о достопримечательности.
 * Используется для передачи данных о достопримечательности между слоями приложения.
 */
@Data
@AllArgsConstructor
public class AttractionDto {

    /**
     * Уникальный идентификатор достопримечательности.
     */
    private UUID id;

    /**
     * Название достопримечательности.
     */
    private String name;

    /**
     * Описание достопримечательности.
     */
    private String description;

    /**
     * Тип достопримечательности.
     * Ссылка на {@link AttractionType}, который представляет тип достопримечательности.
     */
    private AttractionType type;

    /**
     * Идентификатор адреса, связанного с данной достопримечательностью.
     * Ссылка на уникальный идентификатор адреса.
     */
    private UUID addressId;

    /**
     * Идентификатор информации о билетах, связанной с данной достопримечательностью.
     * Ссылка на уникальный идентификатор информации о билетах.
     */
    private UUID ticketInfoId;

    /**
     * Множество идентификаторов поставщиков, предоставляющих услуги для данной достопримечательности.
     * Ссылка на множество уникальных идентификаторов поставщиков.
     */
    private Set<UUID> providerIds;

    /**
     * Пустой конструктор для создания объекта AttractionDto.
     */
    public AttractionDto() {
    }

    /**
     * Получает уникальный идентификатор достопримечательности.
     *
     * @return UUID идентификатор достопримечательности.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Устанавливает уникальный идентификатор достопримечательности.
     *
     * @param id UUID уникальный идентификатор достопримечательности.
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Получает название достопримечательности.
     *
     * @return Название достопримечательности.
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает название достопримечательности.
     *
     * @param name Название достопримечательности.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получает описание достопримечательности.
     *
     * @return Описание достопримечательности.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Устанавливает описание достопримечательности.
     *
     * @param description Описание достопримечательности.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Получает тип достопримечательности.
     *
     * @return Тип достопримечательности.
     */
    public AttractionType getType() {
        return type;
    }

    /**
     * Устанавливает тип достопримечательности.
     *
     * @param type Тип достопримечательности.
     */
    public void setType(AttractionType type) {
        this.type = type;
    }

    /**
     * Получает идентификатор адреса, связанного с достопримечательностью.
     *
     * @return Идентификатор адреса.
     */
    public UUID getAddressId() {
        return addressId;
    }

    /**
     * Устанавливает идентификатор адреса, связанного с достопримечательностью.
     *
     * @param addressId Идентификатор адреса.
     */
    public void setAddressId(UUID addressId) {
        this.addressId = addressId;
    }

    /**
     * Получает идентификатор информации о билетах для достопримечательности.
     *
     * @return Идентификатор информации о билетах.
     */
    public UUID getTicketInfoId() {
        return ticketInfoId;
    }

    /**
     * Устанавливает идентификатор информации о билетах для достопримечательности.
     *
     * @param ticketInfoId Идентификатор информации о билетах.
     */
    public void setTicketInfoId(UUID ticketInfoId) {
        this.ticketInfoId = ticketInfoId;
    }

    /**
     * Получает множество идентификаторов поставщиков, связанных с достопримечательностью.
     *
     * @return Множество идентификаторов поставщиков.
     */
    public Set<UUID> getProviderIds() {
        return providerIds;
    }

    /**
     * Устанавливает множество идентификаторов поставщиков, связанных с достопримечательностью.
     *
     * @param providerIds Множество идентификаторов поставщиков.
     */
    public void setProviderIds(Set<UUID> providerIds) {
        this.providerIds = providerIds;
    }

}
