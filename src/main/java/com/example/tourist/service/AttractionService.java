package com.example.tourist.service;

import com.example.tourist.model.Attraction;
import com.example.tourist.repository.AddressRepository;
import com.example.tourist.repository.AttractionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AttractionService {
    private final AttractionRepository attractionRepository;

    public AttractionService(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    public List<Attraction> getAllAttractions() {
        return attractionRepository.findAll();
    }

    public Attraction getAttractionById(UUID id) {
        return attractionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attraction not found"));
    }

    public Attraction saveAttraction(Attraction attraction) {
        return attractionRepository.save(attraction);
    }

    public void deleteAttraction(UUID id) {
        attractionRepository.deleteById(id);
    }

    public List<Attraction> searchByCity(String city) {
        return attractionRepository.findByAddress_CityContainingIgnoreCase(city);
    }
}