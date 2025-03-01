package com.example.tourist.service.impl;

import com.example.tourist.exception.ProviderNotFoundException;
import com.example.tourist.model.Provider;
import com.example.tourist.repository.ProviderRepository;
import com.example.tourist.service.ProviderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.example.tourist.util.ProviderMessages.PROVIDER_NOT_FOUND_MESSAGE;

/**
 * Реализация сервиса для управления данными поставщиков.
 * Этот сервис предоставляет методы для получения, сохранения и удаления данных о поставщиках.
 */
@Service
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;

    /**
     * Конструктор для инициализации {@link ProviderRepository}.
     *
     * @param providerRepository репозиторий для работы с данными о поставщиках
     */
    public ProviderServiceImpl(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    /**
     * Получить все данные о поставщиках.
     *
     * @return список всех поставщиков {@link Provider}
     */
    @Override
    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    /**
     * Получить данные о поставщике по его идентификатору.
     *
     * @param id уникальный идентификатор поставщика
     * @return объект {@link Provider} с данными поставщика
     * @throws ProviderNotFoundException если поставщик с заданным идентификатором не найден
     */
    @Override
    public Provider getProviderById(UUID id) {
        return providerRepository.findById(id).orElseThrow(() -> new ProviderNotFoundException(PROVIDER_NOT_FOUND_MESSAGE));
    }

    /**
     * Сохранить данные о поставщике в базе данных.
     *
     * @param provider объект {@link Provider} с данными для сохранения
     * @return сохранённый объект {@link Provider}
     */
    @Override
    public Provider saveProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    /**
     * Удалить поставщика по его идентификатору.
     *
     * @param id уникальный идентификатор поставщика
     */
    @Override
    public void deleteProvider(UUID id) {
        providerRepository.deleteById(id);
    }
}
