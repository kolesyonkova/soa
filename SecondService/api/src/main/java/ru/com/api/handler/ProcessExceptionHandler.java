package ru.com.api.handler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.com.api.controllers.LabWorkController;
import ru.com.api.dto.ErrorMessage;
import ru.com.api.exception.EntityNotFoundException;
import ru.com.api.exception.IncreaseNotAvailableException;
import ru.com.api.exception.NotValidParamsException;

import java.time.format.DateTimeParseException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice(assignableTypes = {LabWorkController.class})
public class ProcessExceptionHandler {
    private final ErrorMessage errorMessage = new ErrorMessage();

    @ExceptionHandler({Exception.class})
    public ResponseEntity<?> handleException(Exception e) {
        return ResponseEntity.status(400)
                .body(errorMessage.setMessage("Произошла ошибка: " + e));
    }

    @ExceptionHandler({InvalidFormatException.class})
    public ResponseEntity<?> handleInvalidFormatException(InvalidFormatException e) {
        return ResponseEntity.status(400)
                .body(errorMessage.setMessage("Произошла ошибка: " + e.getMessage()));
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException e) {
        return ResponseEntity.status(404)
                .body(errorMessage.setMessage("Произошла ошибка: " + e.getMessage()));
    }

    @ExceptionHandler({IncreaseNotAvailableException.class})
    public ResponseEntity<?> handleIncreaseNotAvailableException(IncreaseNotAvailableException e) {
        return ResponseEntity.status(422)
                .body(errorMessage.setMessage("Произошла ошибка: " + e.getMessage()));
    }

    @ExceptionHandler({NotValidParamsException.class})
    public ResponseEntity<?> handleNotValidParamsException(NotValidParamsException e) {
        return ResponseEntity.status(422)
                .body(errorMessage.setMessage("Произошла ошибка: " + e.getMessage()));
    }

    @ExceptionHandler({DateTimeParseException.class})
    public ResponseEntity<?> handleDateTimeParseException(DateTimeParseException e) {
        return ResponseEntity.status(422)
                .body(errorMessage.setMessage("Произошла ошибка: " + e.getMessage()));
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return ResponseEntity.status(422)
                .body(errorMessage.setMessage("Невалидные формат json"));
    }
}
