package com.example.tourist.handler;

import com.example.tourist.dto.ErrorMessageDto;
import com.example.tourist.exception.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Тестовый класс для {@link ExceptionAdviceHandler}.
 * Проверяет корректность обработки различных исключений.
 */
class ExceptionAdviceHandlerTest {

    private ExceptionAdviceHandler exceptionHandler;

    /**
     * Инициализация обработчика исключений перед каждым тестом.
     */
    @BeforeEach
    void setUp() {
        exceptionHandler = new ExceptionAdviceHandler();
    }

    /**
     * Проверяет обработку {@link AddressNotFoundException}.
     */
    @Test
    void handleAddressNotFound() {
        AddressNotFoundException exception = new AddressNotFoundException("Адрес не найден");
        ResponseEntity<ErrorMessageDto> response = exceptionHandler.handleAddressNotFound(exception);

        assertThat(response.getStatusCode().value()).isEqualTo(404);
        assertThat(response.getBody().message()).isEqualTo("Адрес не найден");
    }

    /**
     * Проверяет обработку {@link AttractionNotFoundException}.
     */
    @Test
    void handleAttractionNotFound() {
        AttractionNotFoundException exception = new AttractionNotFoundException("Достопримечательность не найдена");
        ResponseEntity<ErrorMessageDto> response = exceptionHandler.handleAttractionNotFound(exception);

        assertThat(response.getStatusCode().value()).isEqualTo(404);
        assertThat(response.getBody().message()).isEqualTo("Достопримечательность не найдена");
    }

    /**
     * Проверяет обработку {@link ProviderNotFoundException}.
     */
    @Test
    void handleProviderNotFound() {
        ProviderNotFoundException exception = new ProviderNotFoundException("Поставщик не найден");
        ResponseEntity<ErrorMessageDto> response = exceptionHandler.handleProviderNotFound(exception);

        assertThat(response.getStatusCode().value()).isEqualTo(404);
        assertThat(response.getBody().message()).isEqualTo("Поставщик не найден");
    }

    /**
     * Проверяет обработку {@link DuplicateEntryException}.
     */
    @Test
    void handleDuplicateEntry() {
        DuplicateEntryException exception = new DuplicateEntryException("Дубликат записи");
        ResponseEntity<ErrorMessageDto> response = exceptionHandler.handleDuplicateEntry(exception);

        assertThat(response.getStatusCode().value()).isEqualTo(409);
        assertThat(response.getBody().message()).isEqualTo("Дубликат записи");
    }

    /**
     * Проверяет обработку {@link DataIntegrityViolationException}.
     */
    @Test
    void handleDataIntegrityViolation() {
        DataIntegrityViolationException exception = new DataIntegrityViolationException("Нарушение целостности данных");
        ResponseEntity<ErrorMessageDto> response = exceptionHandler.handleDataIntegrityViolation(exception);

        assertThat(response.getStatusCode().value()).isEqualTo(400);
        assertThat(response.getBody().message()).isEqualTo("Ошибка базы данных: операция невозможна");
    }

    /**
     * Проверяет обработку глобальных исключений.
     */
    @Test
    void handleGlobalException() {
        Exception exception = new Exception("Неизвестная ошибка");
        ResponseEntity<ErrorMessageDto> response = exceptionHandler.handleGlobalException(exception);

        assertThat(response.getStatusCode().value()).isEqualTo(500);
        assertThat(response.getBody().message()).isEqualTo("Внутренняя ошибка сервера");
    }
}