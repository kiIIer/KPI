package io.promova.forkjoincube.porcessors.calculator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DICalculator
{
    @Bean
    public IFormulaCrawler formulaCrawler()
    {
        return new FormulaCrawler();
    }
}
