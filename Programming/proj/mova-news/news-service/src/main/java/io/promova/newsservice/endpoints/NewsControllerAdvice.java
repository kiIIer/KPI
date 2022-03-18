package io.promova.newsservice.endpoints;

import io.promova.newsservice.endpoints.error.ApiError;
import io.promova.newsservice.endpoints.error.exceptions.NewsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class NewsControllerAdvice
{
    @ResponseBody
    @ExceptionHandler(NewsNotFoundException.class)
    ResponseEntity<ApiError> formulaNotFoundHandler(NewsNotFoundException ex)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(HttpStatus.NOT_FOUND, "Not found", ex));
    }
}
