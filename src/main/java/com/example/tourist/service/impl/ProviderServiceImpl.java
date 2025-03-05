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

    public ProviderServiceImpl(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    @Override
    public Provider getProviderById(UUID id) {
        return providerRepository.findById(id).orElseThrow(() -> new ProviderNotFoundException(PROVIDER_NOT_FOUND_MESSAGE));
    }

    @Override
    public Provider saveProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    @Override
    public void deleteProvider(UUID id) {
        providerRepository.deleteById(id);
    }
}
