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

        map.put(Addition.SYMBOL, new Addition());
        map.put(Subtraction.SYMBOL, new Subtraction());
        map.put(Multiplication.SYMBOL, new Multiplication());
        map.put(Division.SYMBOL, new Division());
        map.put(Sine.SYMBOL, new Sine());
        map.put(Cosine.SYMBOL, new Cosine());
        map.put(Exponentiation.SYMBOL, new Exponentiation());

        return map;
    }
}
