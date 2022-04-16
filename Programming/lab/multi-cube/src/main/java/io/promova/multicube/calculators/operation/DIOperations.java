package io.promova.multicube.calculators.operation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    IAdd add()
    {
        return new Add();
    }
}
