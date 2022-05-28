package io.promova.multicube.calculators.operation;

import io.promova.multicube.calculators.OperationsMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DIOperations
{
    @Bean
    OperationsMap operationMap(
            IAdd add,
            ISubtract subtract
    )
    {
        OperationsMap map = new OperationsMap();
        map.put(add.getSymbol(), add);
        map.put(subtract.getSymbol(), subtract);

        return map;
    }

    @Bean
    IAdd add()
    {
        return new Add();
    }

    @Bean
    ISubtract subtract()
    {
        return new Subtract();
    }
}
