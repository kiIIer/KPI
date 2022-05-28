package io.promova.multicube.tools;

import io.promova.multicube.calculators.IFormulaCrawler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DITools
{
    @Bean
    public IDimensionBuilderFactory dimensionBuilderFactory(
            IFormulaCrawler formulaCrawler
    )
    {
        return new DimensionBuilderFactory(formulaCrawler);
    }
}
