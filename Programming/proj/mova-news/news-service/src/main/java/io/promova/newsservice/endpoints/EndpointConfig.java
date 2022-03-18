package io.promova.newsservice.endpoints;

import io.promova.newsservice.endpoints.tools.ResponseAllHeadersEntityModelAssembler;
import io.promova.newsservice.endpoints.tools.ResponseAllNewsEntityModelAssembler;
import io.promova.newsservice.endpoints.tools.SingleHeaderEntityModelAssembler;
import io.promova.newsservice.endpoints.tools.SingleNewsModelAssembler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EndpointConfig
{
    @Bean
    public SingleNewsModelAssembler singleNewsModelAssembler()
    {
        return new SingleNewsModelAssembler();
    }

    @Bean
    public ResponseAllNewsEntityModelAssembler responseAllNewsEntityModelAssembler(SingleNewsModelAssembler modelAssembler)
    {
        return new ResponseAllNewsEntityModelAssembler(modelAssembler);
    }

    @Bean
    public SingleHeaderEntityModelAssembler singleHeaderEntityModelAssembler()
    {
        return new SingleHeaderEntityModelAssembler();
    }

    @Bean
    public ResponseAllHeadersEntityModelAssembler responseAllHeadersEntityModelAssembler(SingleHeaderEntityModelAssembler modelAssembler)
    {
        return new ResponseAllHeadersEntityModelAssembler(modelAssembler);
    }
}
