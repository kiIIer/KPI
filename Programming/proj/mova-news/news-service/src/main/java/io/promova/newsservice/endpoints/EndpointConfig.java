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
    public ISingleTitleEntityModelAssembler singleTitleEntityModelAssembler()
    {
        return new SingleTitleEntityModelAssembler();
    }

    @Bean
    public IResponseAllTitlesEntityModelAssembler responseAllTitlesEntityModelAssembler(ISingleTitleEntityModelAssembler modelAssembler)
    {
        return new ResponseAllTitlesEntityModelAssembler(modelAssembler);
    }

    @Bean
    public IAcceptHeaderParser acceptHeaderParser()
    {
        return new AcceptHeaderParser();
    }
}
