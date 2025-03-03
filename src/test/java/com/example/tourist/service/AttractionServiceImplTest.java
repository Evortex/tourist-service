package com.example.tourist.service;

import com.example.tourist.model.Attraction;
import com.example.tourist.model.Address;
import com.example.tourist.repository.AttractionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Тесты для {@link AttractionService}.
 * Этот класс тестирует методы сервиса {@link AttractionService}, включая сохранение, получение и удаление аттракционов.
 */
@ExtendWith(MockitoExtension.class)
class AttractionServiceImplTest {

    @Mock
    private AttractionRepository attractionRepository;

    @InjectMocks
    private AttractionService attractionService;

    private Attraction attraction;
    private UUID id;

    /**
     * Метод, выполняемый перед каждым тестом для настройки тестовых данных.
     * Создается объект аттракциона и присваивается ему уникальный идентификатор и адрес.
     */
    @BeforeEach
    void setUp() {
        id = UUID.randomUUID();
        attraction = new Attraction();
        attraction.setId(id);
        attraction.setName("Эйфелева башня");
        Address address = new Address();
        address.setCity("Париж");
        attraction.setAddress(address);
    }

    /**
     * Тестирует метод {@link AttractionService#getAllAttractions()}.
     * Проверяется, что метод возвращает список аттракционов.
     */
    @Test
    void getAllAttractions_ShouldReturnList() {
        when(attractionRepository.findAll()).thenReturn(List.of(attraction));

        List<Attraction> result = attractionService.getAllAttractions();

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals("Эйфелева башня", result.getFirst().getName());
        verify(attractionRepository, times(1)).findAll();
    }

    /**
     * Тестирует метод {@link AttractionService#getAttractionById(UUID)}.
     * Проверяется, что метод возвращает аттракцион по ID.
     */
    @Test
    void getAttractionById_ShouldReturnAttraction() {
        when(attractionRepository.findById(id)).thenReturn(Optional.of(attraction));

        Attraction result = attractionService.getAttractionById(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Париж", result.getAddress().getCity());
    }

    /**
     * Тестирует метод {@link AttractionService#getAttractionById(UUID)} в случае, когда аттракцион не найден.
     * Ожидается выброс исключения {@link RuntimeException} с сообщением "Attraction not found".
     */
    @Test
    void getAttractionById_NotFound_ShouldThrowException() {
        when(attractionRepository.findById(id)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            attractionService.getAttractionById(id);
        });

        assertEquals("Attraction not found", exception.getMessage());
    }

    /**
     * Тестирует метод {@link AttractionService#saveAttraction(Attraction)}.
     * Проверяется, что метод сохраняет аттракцион и возвращает его.
     */
    @Test
    void saveAttraction_ShouldSaveAndReturnAttraction() {
        when(attractionRepository.save(any())).thenReturn(attraction);

        Attraction result = attractionService.saveAttraction(attraction);

        assertNotNull(result);
        assertEquals("Эйфелева башня", result.getName());
        assertEquals("Париж", result.getAddress().getCity()); // Проверяем адрес
        verify(attractionRepository, times(1)).save(attraction);
    }

    /**
     * Тестирует метод {@link AttractionService#deleteAttraction(UUID)}.
     * Проверяется, что метод вызывает {@link AttractionRepository#"deleteById"(UUID)}.
     */
    @Test
    void deleteAttraction_ShouldCallDeleteById() {
        doNothing().when(attractionRepository).deleteById(id);

        attractionService.deleteAttraction(id);

        verify(attractionRepository, times(1)).deleteById(id);
    }
}