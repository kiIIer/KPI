package io.promova.newsservice.singlenew;

import io.promova.newsservice.singlenew.exceptions.SingleNewsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class SingleNewsControllerAdvice
{
    @ResponseBody
    @ExceptionHandler(SingleNewsNotFoundException.class)
    ResponseEntity<String> formulaNotFoundHandler(SingleNewsNotFoundException ex)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
