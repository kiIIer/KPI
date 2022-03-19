package io.promova.newsservice.endpoints;

import io.promova.newsservice.endpoints.tools.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EndpointConfig
{
    @Bean
    public ISingleNewsModelAssembler singleNewsModelAssembler()
    {
        return new SingleNewsModelAssembler();
    }

    @Bean
    public IResponseAllNewsEntityModelAssembler responseAllNewsEntityModelAssembler(ISingleNewsModelAssembler modelAssembler)
    {
        return new ResponseAllNewsEntityModelAssembler(modelAssembler);
    }

    @Bean
    public ISingleTitleEntityModelAssembler singleTitleEntityModelAssembler()
    {
        return new SingleTitleEntityModelAssembler();
    }

    @Bean
    public IResponseAllTitlesEntityModelAssembler responseAllTitlesEntityModelAssembler(ISingleTitleEntityModelAssembler modelAssembler)
    {
        return new ResponseAllTitlesEntityModelAssembler(modelAssembler);
    }
}
