package io.promova.newsservice.endpoints.titles;

import io.promova.newsservice.config.EnviromentalConfig;
import io.promova.newsservice.endpoints.titles.tools.*;
import io.promova.newsservice.endpoints.titles.tools.util.TitlesAllGetRequest;
import io.promova.newsservice.endpoints.titles.validators.*;
import io.promova.newsservice.endpoints.util.validators.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DITitlesConfig
{

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
    public ITitleEntityCreator titleEntityCreator()
    {
        return new TitleEntityCreator();
    }

    @Bean
    public IPageSizeValidator pageSizeValidator(EnviromentalConfig enviromentalConfig, IIsIntegerValidator isIntegerValidator)
    {
        return new PageSizeValidator(enviromentalConfig, isIntegerValidator);
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
    public IOneTitleRequestTitleValidator postOneTitleRequestTitleValidator(INotNullValidator notNullValidator)
    {
        return new OneTitleRequestTitleValidator(notNullValidator);
    }

    @Bean
    public IOneTitleRequestValidator postOneTitleRequestValidator(INotNullValidator notNullValidator, IOneTitleRequestTitleValidator postOneTitleRequestTitleValidator)
    {
        return new OneTitleRequestValidator(notNullValidator, postOneTitleRequestTitleValidator);
    }
}
