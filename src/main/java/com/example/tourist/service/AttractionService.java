package com.example.tourist.service;

import com.example.tourist.repository.AttractionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttractionService {
    private final AttractionRepository attractionRepository;

    public List<AttractionDto> getAll() {
        return attractionRepository.findAll()
                .stream()
                .map(AttractionMapper::toDto)
                .collect(Collectors.toList());
    }
}

