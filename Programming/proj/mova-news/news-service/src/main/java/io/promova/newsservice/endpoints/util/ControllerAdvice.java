package io.promova.newsservice.endpoints.util;

import io.promova.newsservice.endpoints.titles.exceptions.InvalidRequestException;
import io.promova.newsservice.endpoints.titles.exceptions.TitleEntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice
{
    @ExceptionHandler(TitleEntityNotFoundException.class)
    public ResponseEntity<APIError> titleEntityNotFound(TitleEntityNotFoundException exception)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIError(HttpStatus.NOT_FOUND, "Not found", exception));
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<APIError> invalidRequest(InvalidRequestException exception)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new APIError(
                        HttpStatus.BAD_REQUEST,
                        "Request contains errors",
                        exception,
                        exception.getErrors())
        );
    }
}
