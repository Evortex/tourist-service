package com.example.tourist.controller;

import com.example.tourist.model.Provider;
import com.example.tourist.service.ProviderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Контроллер для работы с услугами.
 * Предоставляет API для получения, создания и удаления услуг.
 */
@RestController
@RequestMapping("/api/providers")
@RequiredArgsConstructor
@Tag(name = "Услуги", description = "API для управления поставщиками услуг")
public class ProviderController {

    private final ProviderService providerService;

    /**
     * Получает список всех услуг.
     *
     * @return Список объектов {@link Provider}, представляющих все услуги.
     */
    @Operation(summary = "Получить все услуги", description = "Возвращает список всех доступных услуг")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно получен список услуг")
    })
    @GetMapping
    public List<Provider> getAllProviders() {
        return providerService.getAllProviders();
    }

    /**
     * Получает услугу по уникальному идентификатору.
     *
     * @param id UUID уникальный идентификатор услуги.
     * @return Объект {@link Provider}, представляющий найденную услугу.
     */
    @Operation(summary = "Получить услугу по ID", description = "Возвращает услугу по ее уникальному идентификатору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Услуга найдена"),
            @ApiResponse(responseCode = "404", description = "Услуга не найдена")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Provider> getProviderById(@PathVariable UUID id) {
        return ResponseEntity.ok(providerService.getProviderById(id));
    }

    /**
     * Создает новую услугу.
     *
     * @param provider Объект {@link Provider}, содержащий данные для создания услуги.
     * @return Объект {@link Provider}, представляющий созданную услугу.
     */
    @Operation(summary = "Создать новую услугу", description = "Добавляет новую услугу в систему")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Услуга успешно создана"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные")
    })
    @PostMapping
    public Provider createProvider(@RequestBody Provider provider) {
        return providerService.saveProvider(provider);
    }

    /**
     * Удаляет услугу по уникальному идентификатору.
     *
     * @param id UUID уникальный идентификатор услуги, которую нужно удалить.
     */
    @Operation(summary = "Удалить услугу", description = "Удаляет услугу по ее ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Услуга успешно удалена"),
            @ApiResponse(responseCode = "404", description = "Услуга не найдена")
    })
    @DeleteMapping("/{id}")
    public void deleteProvider(@PathVariable UUID id) {
        providerService.deleteProvider(id);
    }
}
