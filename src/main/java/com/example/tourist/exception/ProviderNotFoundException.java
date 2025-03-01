package com.example.tourist.exception;


public class ProviderNotFoundException extends RuntimeException{
    public ProviderNotFoundException() {
    }

    public ProviderNotFoundException(String message) {
        super(message);
    }
}
