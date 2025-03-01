package com.example.tourist.controller;

import com.example.tourist.model.Provider;
import com.example.tourist.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Контроллер для работы с услугами.
 * Предоставляет API для получения, создания, удаления услуг.
 */
@RestController
@RequestMapping("/api/providers")
@RequiredArgsConstructor
public class ProviderController {

    private final ProviderService providerService;

    /**
     * Получает список всех услуг.
     *
     * @return Список объектов {@link Provider}, представляющих все услуги.
     */
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
    @GetMapping("/{id}")
    public Provider getProviderById(@PathVariable UUID id) {
        return providerService.getProviderById(id);
    }

    /**
     * Создает новую услугу.
     *
     * @param provider Объект {@link Provider}, содержащий данные для создания услуги.
     * @return Объект {@link Provider}, представляющий созданную услугу.
     */
    @PostMapping
    public Provider createProvider(@RequestBody Provider provider) {
        return providerService.saveProvider(provider);
    }

    /**
     * Удаляет услугу по уникальному идентификатору.
     *
     * @param id UUID уникальный идентификатор услуги, которую нужно удалить.
     */
    @DeleteMapping("/{id}")
    public void deleteProvider(@PathVariable UUID id) {
        providerService.deleteProvider(id);
    }
}