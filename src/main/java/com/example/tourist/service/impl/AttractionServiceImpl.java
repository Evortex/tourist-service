package com.example.tourist.service.impl;

import com.example.tourist.exception.AttractionNotFoundException;
import com.example.tourist.model.Attraction;
import com.example.tourist.repository.AttractionRepository;
import com.example.tourist.service.AttractionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.example.tourist.util.AttractionMessages.ATTRACTION_NOT_FOUND_MESSAGE;

/**
 * Реализация сервиса для управления данными о достопримечательностях.
 * Этот сервис предоставляет методы для получения, сохранения, удаления и поиска достопримечательностей по городу.
 */
@Service
public class AttractionServiceImpl implements AttractionService {

    private final AttractionRepository attractionRepository;

    public AttractionServiceImpl(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    @Override
    public List<Attraction> getAllAttractions() {
        return attractionRepository.findAll();
    }

    @Override
    public Attraction getAttractionById(UUID id) {
        return attractionRepository.findById(id)
                .orElseThrow(() -> new AttractionNotFoundException(ATTRACTION_NOT_FOUND_MESSAGE));
    }

    @Override
    public Attraction saveAttraction(Attraction attraction) {
        return attractionRepository.save(attraction);
    }

    @Override
    public void deleteAttraction(UUID id) {
        attractionRepository.deleteById(id);
    }

    @Override
    public List<Attraction> searchByCity(String city) {
        return attractionRepository.findByAddress_CityContainingIgnoreCase(city);
    }
}
