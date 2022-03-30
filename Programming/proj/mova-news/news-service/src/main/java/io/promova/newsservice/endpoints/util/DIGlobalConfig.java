package io.promova.newsservice.endpoints.util;

import io.promova.newsservice.endpoints.titles.validators.IIsIntegerValidator;
import io.promova.newsservice.endpoints.titles.validators.IsIntegerValidator;
import io.promova.newsservice.endpoints.util.tools.AcceptHeaderProcessor;
import io.promova.newsservice.endpoints.util.tools.IAcceptHeaderProcessor;
import io.promova.newsservice.endpoints.util.validators.IIdValidator;
import io.promova.newsservice.endpoints.util.validators.INotNullValidator;
import io.promova.newsservice.endpoints.util.validators.IdValidator;
import io.promova.newsservice.endpoints.util.validators.NotNullValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIGlobalConfig
{
    @Bean
    public IAcceptHeaderProcessor acceptHeaderProcessor()
    {
        return new AcceptHeaderProcessor();
    }

    @Bean
    public IIsIntegerValidator isIntegerValidator()
    {
        return new IsIntegerValidator();
    }

    @Bean
    public IIdValidator idValidator()
    {
        return new IdValidator();
    }

    @Bean
    public INotNullValidator notNullValidator()
    {
        return new NotNullValidator();
    }

}
