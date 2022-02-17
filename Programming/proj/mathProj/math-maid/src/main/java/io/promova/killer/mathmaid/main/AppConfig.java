package io.promova.killer.mathmaid.main;

import io.promova.killer.mathmaid.calculator.ITranslator;
import io.promova.killer.mathmaid.calculator.Translator;
import io.promova.killer.mathmaid.calculator.operations.*;
import io.promova.killer.mathmaid.util.FormulaConverter;
import io.promova.killer.mathmaid.util.IFormulaConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig
{
    private final OperationProvider operationProvider;

    AppConfig(OperationProvider operationProvider)
    {
        this.operationProvider = operationProvider;
    }

    @Bean
    public ITranslator translator()
    {
        return new Translator(operationProvider);
    }

    @Bean
    public IFormulaConverter formulaConverter()
    {
        return new FormulaConverter();
    }
}