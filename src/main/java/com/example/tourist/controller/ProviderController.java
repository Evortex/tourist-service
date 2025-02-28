package com.example.tourist.controller;

import com.example.tourist.model.Provider;
import com.example.tourist.service.AttractionService;
import com.example.tourist.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/providers")
public class ProviderController {
    private final ProviderService providerService;

    @Autowired
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping
    public List<Provider> getAllProviders() {
        return providerService.getAllProviders();
    }

    @GetMapping("/{id}")
    public Provider getProviderById(@PathVariable UUID id) {
        return providerService.getProviderById(id);
    }

    @PostMapping
    public Provider createProvider(@RequestBody Provider provider) {
        return providerService.saveProvider(provider);
    }

    @DeleteMapping("/{id}")
    public void deleteProvider(@PathVariable UUID id) {
        providerService.deleteProvider(id);
    }
}
