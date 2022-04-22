package io.promova.multicube.calculators;

import io.promova.multicube.calculators.operation.IOperation;
import io.promova.multicube.calculators.operation.IOperationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class DICalculators
{
    @Bean
    public IFormulaCrawler formulaCrawler()
    {
        return new FormulaCrawler();
    }

    @Bean
    public ITranslator translator(
            IOperationProvider operationProvider,
            Map<String, IOperation> operations
    )
    {
        return new Translator(operations);
    }
}
