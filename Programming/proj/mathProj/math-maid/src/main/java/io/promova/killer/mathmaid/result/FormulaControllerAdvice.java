package io.promova.killer.mathmaid.result;

import io.promova.killer.mathmaid.result.exceptions.FormulaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class FormulaControllerAdvice
{
    @ResponseBody
    @ExceptionHandler(FormulaNotFoundException.class)
    ResponseEntity<String> formulaNotFoundHandler(FormulaNotFoundException ex)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
