package ru.com.api.exception;

public class NotValidParamsException extends RuntimeException {
    public NotValidParamsException(String message) {
        super(message);
    }
}
