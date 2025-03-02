package com.example.tourist.exception;

/**
 * Исключение, выбрасываемое при попытке создать дубликат записи.
 */
public class DuplicateEntryException extends RuntimeException {

    /**
     * Конструктор без параметров.
     */
    public DuplicateEntryException() {
        super();
    }

    /**
     * Конструктор с сообщением об ошибке.
     *
     * @param message описание ошибки.
     */
    public DuplicateEntryException(String message) {
        super(message);
    }

    /**
     * Конструктор с сообщением об ошибке и причиной исключения.
     *
     * @param message описание ошибки.
     * @param cause причина ошибки.
     */
    public DuplicateEntryException(String message, Throwable cause) {
        super(message, cause);
    }
}
