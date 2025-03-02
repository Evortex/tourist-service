package com.example.tourist.dto;

import com.example.tourist.model.ProviderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.UUID;

/**
 * Класс для представления информации о поставщике услуг.
 * Используется для передачи данных о поставщике услуг между слоями приложения.
 */
@Data
@AllArgsConstructor
public class ProviderDto {

    /**
     * Уникальный идентификатор поставщика услуг.
     */
    private UUID id;

    /**
     * Название поставщика услуг.
     */
    private String name;

    /**
     * Описание поставщика услуг.
     */
    private String description;

    /**
     * Тип поставщика услуг.
     * Ссылка на {@link ProviderType}, который представляет тип поставщика.
     */
    private ProviderType type;

    /**
     * Пустой конструктор для создания объекта ProviderDto.
     */
    public ProviderDto() {
    }

    /**
     * Получает уникальный идентификатор поставщика.
     *
     * @return UUID уникальный идентификатор поставщика.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Устанавливает уникальный идентификатор поставщика.
     *
     * @param id UUID уникальный идентификатор поставщика.
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Получает название поставщика услуг.
     *
     * @return Название поставщика услуг.
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает название поставщика услуг.
     *
     * @param name Название поставщика услуг.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получает описание поставщика услуг.
     *
     * @return Описание поставщика услуг.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Устанавливает описание поставщика услуг.
     *
     * @param description Описание поставщика услуг.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Получает тип поставщика услуг.
     *
     * @return Тип поставщика услуг.
     */
    public ProviderType getType() {
        return type;
    }

    /**
     * Устанавливает тип поставщика услуг.
     *
     * @param type Тип поставщика услуг.
     */
    public void setType(ProviderType type) {
        this.type = type;
    }
}
