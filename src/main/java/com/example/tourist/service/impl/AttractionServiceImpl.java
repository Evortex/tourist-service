package com.example.tourist.service.impl;

import com.example.tourist.exception.AttractionNotFoundException;
import com.example.tourist.model.Attraction;
import com.example.tourist.repository.AttractionRepository;
import com.example.tourist.service.AttractionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.example.tourist.util.AttractionMessages.ATTRACTION_NOT_FOUND_MESSAGE;

@Service
public class AttractionServiceImpl implements AttractionService {
    private final AttractionRepository attractionRepository;

    public AttractionServiceImpl(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    public List<Attraction> getAllAttractions() {
        return attractionRepository.findAll();
    }

    public Attraction getAttractionById(UUID id) {
        return attractionRepository.findById(id)
                .orElseThrow(() -> new AttractionNotFoundException(ATTRACTION_NOT_FOUND_MESSAGE));
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