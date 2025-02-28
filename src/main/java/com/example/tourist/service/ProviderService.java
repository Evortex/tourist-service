package com.example.tourist.service;

import com.example.tourist.model.Provider;
import com.example.tourist.repository.AttractionRepository;
import com.example.tourist.repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProviderService {
    private final ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    public Provider getProviderById(UUID id) {
        return providerRepository.findById(id).orElseThrow(() -> new RuntimeException("Provider not found"));
    }

    public Provider saveProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    public void deleteProvider(UUID id) {
        providerRepository.deleteById(id);
    }
}

