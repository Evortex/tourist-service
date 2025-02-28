package com.example.tourist.controller;

import com.example.tourist.dto.AttractionDto;
import com.example.tourist.mapper.AttractionMapper;
import com.example.tourist.model.Attraction;
import com.example.tourist.service.AddressService;
import com.example.tourist.service.AttractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/attractions")
public class AttractionController {
    private final AttractionService attractionService;

    @Autowired
    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    @GetMapping
    public List<AttractionDto> getAllAttractions() {
        return attractionService.getAllAttractions().stream()
                .map(AttractionMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AttractionDto getAttractionById(@PathVariable UUID id) {
        return AttractionMapper.toDto(attractionService.getAttractionById(id));
    }

    @PostMapping
    public AttractionDto createAttraction(@RequestBody AttractionDto attractionDto) {
        Attraction attraction = AttractionMapper.toEntity(attractionDto);
        return AttractionMapper.toDto(attractionService.saveAttraction(attraction));
    }

    @DeleteMapping("/{id}")
    public void deleteAttraction(@PathVariable UUID id) {
        attractionService.deleteAttraction(id);
    }

    @GetMapping("/search/city")
    public List<AttractionDto> searchByCity(@RequestParam String city) {
        return attractionService.searchByCity(city).stream()
                .map(AttractionMapper::toDto)
                .collect(Collectors.toList());
    }
}