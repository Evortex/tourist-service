package com.example.tourist.exception;

/**
 * Исключение, выбрасываемое, когда не удается найти достопримечательность.
 * Это исключение наследуется от {@link RuntimeException} и используется
 * для обработки ошибок, связанных с отсутствием достопримечательности в системе.
 */
public class AttractionNotFoundException extends RuntimeException {

    /**
     * Конструктор по умолчанию, создающий исключение без сообщения.
     */
    public AttractionNotFoundException() {
    }

    /**
     * Конструктор, создающий исключение с заданным сообщением.
     *
     * @param message Сообщение, которое будет связано с исключением.
     */
    public AttractionNotFoundException(String message) {
        super(message);
    }
}
