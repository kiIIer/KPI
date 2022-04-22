package io.promova.multicube.calculators.operation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DIOperations
{
    @Bean
    IOperationProvider operationProvider(
            IAdd add
    )
    {
        return new OperationProvider(
                add
        );
    }

    @Bean
    Map<String, IOperation> operationMap(
            IAdd add
    )
    {
        Map<String, IOperation> map = new HashMap<>();
        map.put(add.getSymbol(), add);

        return map;
    }

    @Bean
    IAdd add()
    {
        return new Add();
    }
}
