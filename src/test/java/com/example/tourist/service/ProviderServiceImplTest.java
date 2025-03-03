package com.example.tourist.service;

import com.example.tourist.exception.ProviderNotFoundException;
import com.example.tourist.model.Provider;
import com.example.tourist.model.ProviderType;
import com.example.tourist.repository.ProviderRepository;
import com.example.tourist.service.impl.ProviderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

/**
 * Тестовый класс для {@link ProviderServiceImpl}.
 * Проверяет основные методы сервиса работы с поставщиками.
 */
@ExtendWith(MockitoExtension.class)
class ProviderServiceImplTest {

    @Mock
    private ProviderRepository providerRepository;

    @InjectMocks
    private ProviderServiceImpl providerService;

    private Provider provider;
    private UUID providerId;

    /**
     * Инициализация тестовых данных перед каждым тестом.
     */
    @BeforeEach
    void setUp() {
        providerId = UUID.randomUUID();
        provider = new Provider();
        provider.setId(providerId);
        provider.setName("Test Provider");
        provider.setDescription("Test Description");
        provider.setType(ProviderType.valueOf("Test Type"));
    }

    /**
     * Проверяет, что метод getAllProviders() возвращает список поставщиков.
     */
    @Test
    void testGetAllProviders() {
        when(providerRepository.findAll()).thenReturn(List.of(provider));

        List<Provider> providers = providerService.getAllProviders();

        assertThat(providers).isNotEmpty().hasSize(1);
        assertThat(providers.get(0)).isEqualTo(provider);
        verify(providerRepository, times(1)).findAll();
    }

    /**
     * Проверяет, что метод getProviderById() возвращает поставщика, если он найден.
     */
    @Test
    void testGetProviderById_WhenFound() {
        when(providerRepository.findById(providerId)).thenReturn(Optional.of(provider));

        Provider foundProvider = providerService.getProviderById(providerId);

        assertThat(foundProvider).isNotNull();
        assertThat(foundProvider.getId()).isEqualTo(providerId);
        assertThat(foundProvider.getName()).isEqualTo("Test Provider");
        verify(providerRepository, times(1)).findById(providerId);
    }

    /**
     * Проверяет, что метод getProviderById() выбрасывает исключение, если поставщик не найден.
     */
    @Test
    void testGetProviderById_WhenNotFound() {
        when(providerRepository.findById(providerId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> providerService.getProviderById(providerId))
                .isInstanceOf(ProviderNotFoundException.class);

        verify(providerRepository, times(1)).findById(providerId);
    }

    /**
     * Проверяет, что метод saveProvider() корректно сохраняет поставщика.
     */
    @Test
    void testSaveProvider() {
        when(providerRepository.save(provider)).thenReturn(provider);

        Provider savedProvider = providerService.saveProvider(provider);

        assertThat(savedProvider).isNotNull();
        assertThat(savedProvider.getId()).isEqualTo(providerId);
        verify(providerRepository, times(1)).save(provider);
    }

    /**
     * Проверяет, что метод deleteProvider() удаляет поставщика по ID.
     */
    @Test
    void testDeleteProvider() {
        doNothing().when(providerRepository).deleteById(providerId);

        providerService.deleteProvider(providerId);

        verify(providerRepository, times(1)).deleteById(providerId);
    }
}