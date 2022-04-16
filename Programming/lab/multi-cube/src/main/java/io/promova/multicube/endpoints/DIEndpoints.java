package io.promova.multicube.endpoints;

import io.promova.multicube.calculators.ITranslator;
import io.promova.multicube.calculators.Translator;
import io.promova.multicube.calculators.operation.IOperationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIEndpoints
{
    @Bean
    public ITranslator translator(IOperationProvider operationProvider)
    {
        return new Translator(operationProvider);
    }

}
