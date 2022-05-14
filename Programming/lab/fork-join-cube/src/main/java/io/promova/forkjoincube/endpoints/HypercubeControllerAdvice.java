package io.promova.forkjoincube.endpoints;

import io.promova.forkjoincube.util.APIError;
import io.promova.forkjoincube.util.InvalidRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class HypercubeControllerAdvice
{
    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<APIError> titleEntityNotFound(InvalidRequestException exception)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new APIError(HttpStatus.BAD_REQUEST, "Bad request", exception, exception.getErrors()));
    }

}
