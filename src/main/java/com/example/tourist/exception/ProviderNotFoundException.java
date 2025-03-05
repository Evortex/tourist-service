package com.example.tourist.exception;

/**
 * Исключение, выбрасываемое, когда не удается найти поставщика услуг.
 * Это исключение наследуется от {@link RuntimeException} и используется
 * для обработки ошибок, связанных с отсутствием поставщика услуг в системе.
 */
public class ProviderNotFoundException extends RuntimeException {

    /**
     * Конструктор по умолчанию, создающий исключение без сообщения.
     */
    public ProviderNotFoundException() {
    }

    /**
     * Конструктор, создающий исключение с заданным сообщением.
     *
     * @param message Сообщение, которое будет связано с исключением.
     */
    public ProviderNotFoundException(String message) {
        super(message);
    }
}
