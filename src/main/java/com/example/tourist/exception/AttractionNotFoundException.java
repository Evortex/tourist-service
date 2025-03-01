package com.example.tourist.exception;


public class AttractionNotFoundException extends RuntimeException{
    public AttractionNotFoundException() {
    }

    public AttractionNotFoundException(String message) {
        super(message);
    }
}
