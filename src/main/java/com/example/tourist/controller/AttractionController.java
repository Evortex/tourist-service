package com.example.tourist.controller;

import com.example.tourist.dto.AttractionDto;
import com.example.tourist.mapper.AttractionMapper;
import com.example.tourist.model.Attraction;
import com.example.tourist.service.AttractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Контроллер для работы с достопримечательностями.
 * Предоставляет API для получения, создания, удаления и поиска достопримечательностей.
 */
@RestController
@RequestMapping("/api/attractions")
@RequiredArgsConstructor
public class AttractionController {

    private final AttractionService attractionService;

    /**
     * Получает список всех достопримечательностей.
     *
     * @return Список объектов {@link AttractionDto}, представляющих все достопримечательности.
     */
    @GetMapping
    public List<AttractionDto> getAllAttractions() {
        return attractionService.getAllAttractions().stream()
                .map(AttractionMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Получает достопримечательность по уникальному идентификатору.
     *
     * @param id UUID уникальный идентификатор достопримечательности.
     * @return Объект {@link AttractionDto}, представляющий найденную достопримечательность.
     */
    @GetMapping("/{id}")
    public AttractionDto getAttractionById(@PathVariable UUID id) {
        return AttractionMapper.toDto(attractionService.getAttractionById(id));
    }

    /**
     * Создает новую достопримечательность.
     *
     * @param attractionDto Объект {@link AttractionDto}, содержащий данные для создания достопримечательности.
     * @return Объект {@link AttractionDto}, представляющий созданную достопримечательность.
     */
    @PostMapping
    public AttractionDto createAttraction(@RequestBody AttractionDto attractionDto) {
        Attraction attraction = AttractionMapper.toEntity(attractionDto);
        return AttractionMapper.toDto(attractionService.saveAttraction(attraction));
    }

    /**
     * Удаляет достопримечательность по уникальному идентификатору.
     *
     * @param id UUID уникальный идентификатор достопримечательности, которую необходимо удалить.
     */
    @DeleteMapping("/{id}")
    public void deleteAttraction(@PathVariable UUID id) {
        attractionService.deleteAttraction(id);
    }

    /**
     * Ищет достопримечательности по названию города.
     *
     * @param city Название города для поиска достопримечательностей.
     * @return Список объектов {@link AttractionDto}, представляющих достопримечательности, найденные по городу.
     */
    @GetMapping("/search/city")
    public List<AttractionDto> searchByCity(@RequestParam String city) {
        return attractionService.searchByCity(city).stream()
                .map(AttractionMapper::toDto)
                .collect(Collectors.toList());
    }
}