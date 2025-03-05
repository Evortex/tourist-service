package com.example.tourist.repository;

import com.example.tourist.model.Attraction;
import com.example.tourist.model.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для {@link AttractionRepository}.
 * Этот класс тестирует операции сохранения и поиска объектов {@link Attraction}.
 *
 * @see AttractionRepository
 */
@DataJpaTest
@ActiveProfiles("test")
class AttractionRepositoryTest {

    @Autowired
    private AttractionRepository attractionRepository;

    /**
     * Тестирует сохранение и поиск объекта {@link Attraction} по городу.
     * В этом тесте создается объект {@link Attraction} с адресом в Париже,
     * сохраняется в базе данных, а затем проверяется, что можно найти аттракцион по городу.
     */
    @Test
    void testSaveAndFindAttraction() {
        Address address = new Address();
        address.setCity("Париж");
        Attraction attraction = new Attraction();
        attraction.setId(UUID.randomUUID());
        attraction.setName("Эйфелева башня");
        attraction.setAddress(address);
        attractionRepository.save(attraction);
        List<Attraction> attractions = attractionRepository.findByAddress_CityContainingIgnoreCase("париж");
        assertFalse(attractions.isEmpty());
        assertEquals("Эйфелева башня", attractions.get(0).getName());
    }
}
