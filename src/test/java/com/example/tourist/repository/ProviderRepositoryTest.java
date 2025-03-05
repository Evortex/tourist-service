package com.example.tourist.repository;

import com.example.tourist.model.Provider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Тестовый класс для {@link ProviderRepository}.
 * Проверяет операции сохранения, поиска и удаления поставщиков.
 */
@DataJpaTest
class ProviderRepositoryTest {

    @Autowired
    private ProviderRepository providerRepository;

    /**
     * Проверяет, что поставщик корректно сохраняется и находится по ID.
     */
    @Test
    void testSaveAndFindById() {
        Provider provider = new Provider();
        provider.setId(UUID.randomUUID());
        provider.setName("Test Provider");

        Provider savedProvider = providerRepository.save(provider);

        Optional<Provider> foundProvider = providerRepository.findById(savedProvider.getId());
        assertThat(foundProvider).isPresent();
        assertThat(foundProvider.get().getName()).isEqualTo("Test Provider");
    }

    /**
     * Проверяет, что поставщик корректно удаляется из репозитория.
     */
    @Test
    void testDelete() {
        Provider provider = new Provider();
        provider.setId(UUID.randomUUID());
        provider.setName("To be deleted");

        Provider savedProvider = providerRepository.save(provider);
        providerRepository.deleteById(savedProvider.getId());

        Optional<Provider> foundProvider = providerRepository.findById(savedProvider.getId());
        assertThat(foundProvider).isEmpty();
    }
}
