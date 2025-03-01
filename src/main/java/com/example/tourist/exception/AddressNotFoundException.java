package com.example.tourist.exception;

/**
 * Исключение, выбрасываемое, когда не удается найти адрес.
 * Это исключение наследуется от {@link RuntimeException} и используется
 * для обработки ошибок, связанных с отсутствием адреса в системе.
 */
public class AddressNotFoundException extends RuntimeException {

    /**
     * Конструктор по умолчанию, создающий исключение без сообщения.
     */
    public AddressNotFoundException() {
    }

    /**
     * Конструктор, создающий исключение с заданным сообщением.
     *
     * @param message Сообщение, которое будет связано с исключением.
     */
    public AddressNotFoundException(String message) {
        super(message);
    }
}
