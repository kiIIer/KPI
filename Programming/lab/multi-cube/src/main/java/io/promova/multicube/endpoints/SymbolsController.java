package io.promova.multicube.endpoints;

import io.promova.multicube.calculators.operation.Operations;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SymbolsController
{
    @GetMapping("/symbols")
    public ResponseEntity<Map<Operations, String>> all()
    {
        Map<Operations, String> map = new HashMap<>();
        Arrays.stream(Operations.values()).forEach(operation ->
                map.put(operation, operation.getSymbol())
        );
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
