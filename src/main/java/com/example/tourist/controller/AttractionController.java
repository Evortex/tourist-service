package com.example.tourist.controller;

import com.example.tourist.dto.AttractionDto;
import com.example.tourist.mapper.AttractionMapper;
import com.example.tourist.model.Attraction;
import com.example.tourist.service.AttractionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
@Tag(name = "Достопримечательности", description = "API для управления достопримечательностями")
public class AttractionController {

    private final AttractionService attractionService;

    /**
     * Получает список всех достопримечательностей.
     *
     * @return Список объектов {@link AttractionDto}, представляющих все достопримечательности.
     */
    @Operation(summary = "Получить все достопримечательности", description = "Возвращает список всех доступных достопримечательностей")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно получен список достопримечательностей")
    })
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
    @Operation(summary = "Получить достопримечательность по ID", description = "Возвращает достопримечательность по ее уникальному идентификатору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Достопримечательность найдена"),
            @ApiResponse(responseCode = "404", description = "Достопримечательность не найдена")
    })
    @GetMapping("/{id}")
    public ResponseEntity<AttractionDto> getAttractionById(@PathVariable UUID id) {
        return ResponseEntity.ok(AttractionMapper.toDto(attractionService.getAttractionById(id)));
    }

    /**
     * Создает новую достопримечательность.
     *
     * @param attractionDto Объект {@link AttractionDto}, содержащий данные для создания достопримечательности.
     * @return Объект {@link AttractionDto}, представляющий созданную достопримечательность.
     */
    @Operation(summary = "Создать новую достопримечательность", description = "Добавляет новую достопримечательность в систему")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Достопримечательность успешно создана"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные")
    })
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
    @Operation(summary = "Удалить достопримечательность", description = "Удаляет достопримечательность по ее ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Достопримечательность успешно удалена"),
            @ApiResponse(responseCode = "404", description = "Достопримечательность не найдена")
    })
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
    @Operation(summary = "Поиск достопримечательностей по городу", description = "Находит все достопримечательности в указанном городе")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список достопримечательностей найден"),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос")
    })
    @GetMapping("/search/city")
    public List<AttractionDto> searchByCity(@RequestParam String city) {
        return attractionService.searchByCity(city).stream()
                .map(AttractionMapper::toDto)
                .collect(Collectors.toList());
    }
}
