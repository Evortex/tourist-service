package com.example.tourist.service;

import com.example.tourist.model.Attraction;

import java.util.List;
import java.util.UUID;


public interface AttractionService {

    List<Attraction> getAllAttractions();

    Attraction getAttractionById(UUID id);

    Attraction saveAttraction(Attraction attraction);

    void deleteAttraction(UUID id);

    List<Attraction> searchByCity(String city);
}