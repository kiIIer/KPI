package io.promova.forkjoincube.porcessors.polish;

import io.promova.forkjoincube.porcessors.calculator.operations.IOperationsMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIPolish
{
    @Bean
    public ITranslator translator(IOperationsMap operationsMap)
    {
        return new Translator(operationsMap);
    }
}
