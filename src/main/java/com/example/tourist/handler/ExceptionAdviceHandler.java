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

@RestControllerAdvice
public class ExceptionAdviceHandler {

    Logger log = LoggerFactory.getLogger(ExceptionAdviceHandler.class);

    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<ErrorMessageDto> handleAddressNotFound(AddressNotFoundException e) {

        String message = e.getMessage();
        log.error(message);
        return new ResponseEntity<>(new ErrorMessageDto(message), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AttractionNotFoundException.class)
    public ResponseEntity<ErrorMessageDto> handleAttractionNotFound(AttractionNotFoundException e) {

        String message = e.getMessage();
        log.error(message);
        return new ResponseEntity<>(new ErrorMessageDto(message), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProviderNotFoundException.class)
    public ResponseEntity<ErrorMessageDto> handleProviderNotFound(ProviderNotFoundException e) {

        String message = e.getMessage();
        log.error(message);
        return new ResponseEntity<>(new ErrorMessageDto(message), HttpStatus.NOT_FOUND);
    }
}
