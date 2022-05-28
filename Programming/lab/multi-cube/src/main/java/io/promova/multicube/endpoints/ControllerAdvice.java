package io.promova.multicube.endpoints;

import io.promova.multicube.tools.util.APIError;
import io.promova.multicube.tools.util.InvalidRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice
{
    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<APIError> titleEntityNotFound(InvalidRequestException exception)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new APIError(HttpStatus.BAD_REQUEST, "Bad request", exception, exception.getErrors()));
    }
}
