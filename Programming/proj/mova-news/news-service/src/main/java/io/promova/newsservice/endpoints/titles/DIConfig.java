package io.promova.newsservice.endpoints.titles;

import io.promova.newsservice.config.EnvConfig;
import io.promova.newsservice.endpoints.titles.tools.*;
import io.promova.newsservice.endpoints.titles.tools.util.TitlesAllGetRequest;
import io.promova.newsservice.endpoints.titles.validators.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIConfig
{
    @Bean
    public IAcceptHeaderProcessor acceptHeaderProcessor()
    {
        return new AcceptHeaderProcessor();
    }

    @Bean
    public ITitleModelAssembler titleModelAssembler()
    {
        return new TitleModelAssembler();
    }

    @Bean
    public IPagedTitlesModelAssembler pagedTitlesModelAssembler(ITitleModelAssembler modelAssembler)
    {
        return new PagedTitlesModelAssembler(modelAssembler);
    }

    @Bean
    public IPageSizeValidator pageSizeValidator(EnvConfig envConfig, IIsIntegerValidator isIntegerValidator)
    {
        return new PageSizeValidator(envConfig, isIntegerValidator);
    }

    @Bean
    public IPageValidator pageValidator(IIsIntegerValidator isIntegerValidator)
    {
        return new PageValidator(isIntegerValidator);
    }

    @Bean
    public IValidator<TitlesAllGetRequest> titlesAllGetRequestValidator(IPageValidator pageValidator, IPageSizeValidator pageSizeValidator)
    {
        return new TitlesAllGetRequestValidator(pageSizeValidator, pageValidator);
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
}
