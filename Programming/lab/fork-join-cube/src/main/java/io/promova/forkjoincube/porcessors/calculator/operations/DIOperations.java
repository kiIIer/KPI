package io.promova.forkjoincube.porcessors.calculator.operations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIOperations
{
    @Bean
    public IOperationsMap operationsMap()
    {
        IOperationsMap map = new OperationsMap();

        map.put(Addition.symbol, new Addition());

        return map;
    }
}
