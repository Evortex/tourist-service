package com.example.tourist.handler;

import com.example.tourist.dto.ErrorMessageDto;
import com.example.tourist.exception.AddressNotFoundException;
import com.example.tourist.exception.AttractionNotFoundException;
import com.example.tourist.exception.ProviderNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Обработчик исключений, который перехватывает специфические исключения,
 * связанные с отсутствием адресов, достопримечательностей или поставщиков услуг.
 * Обработчик возвращает соответствующие сообщения об ошибках в формате JSON.
 */
@RestControllerAdvice
public class ExceptionAdviceHandler {

    Logger log = LoggerFactory.getLogger(ExceptionAdviceHandler.class);

    /**
     * Обрабатывает исключение {@link AddressNotFoundException} и возвращает
     * сообщение об ошибке с HTTP статусом 404 Not Found.
     *
     * @param e Исключение, которое произошло, если адрес не найден.
     * @return Ответ с сообщением об ошибке.
     */
    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<ErrorMessageDto> handleAddressNotFound(AddressNotFoundException e) {

        String message = e.getMessage();
        log.error(message);
        return new ResponseEntity<>(new ErrorMessageDto(message), HttpStatus.NOT_FOUND);
    }

    /**
     * Обрабатывает исключение {@link AttractionNotFoundException} и возвращает
     * сообщение об ошибке с HTTP статусом 404 Not Found.
     *
     * @param e Исключение, которое произошло, если достопримечательность не найдена.
     * @return Ответ с сообщением об ошибке.
     */
    @ExceptionHandler(AttractionNotFoundException.class)
    public ResponseEntity<ErrorMessageDto> handleAttractionNotFound(AttractionNotFoundException e) {

        String message = e.getMessage();
        log.error(message);
        return new ResponseEntity<>(new ErrorMessageDto(message), HttpStatus.NOT_FOUND);
    }

    /**
     * Обрабатывает исключение {@link ProviderNotFoundException} и возвращает
     * сообщение об ошибке с HTTP статусом 404 Not Found.
     *
     * @param e Исключение, которое произошло, если поставщик услуг не найден.
     * @return Ответ с сообщением об ошибке.
     */
    @ExceptionHandler(ProviderNotFoundException.class)
    public ResponseEntity<ErrorMessageDto> handleProviderNotFound(ProviderNotFoundException e) {

        String message = e.getMessage();
        log.error(message);
        return new ResponseEntity<>(new ErrorMessageDto(message), HttpStatus.NOT_FOUND);
    }
}
