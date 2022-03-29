package io.promova.newsservice.endpoints.titles;

import io.promova.newsservice.endpoints.titles.tools.IAcceptHeaderProcessor;
import io.promova.newsservice.endpoints.titles.tools.AcceptHeaderProcessor;
import io.promova.newsservice.endpoints.titles.tools.PagedTitlesModelAssembler;
import io.promova.newsservice.endpoints.titles.tools.TitleModelAssembler;
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
    public TitleModelAssembler titleModelAssembler()
    {
        return new TitleModelAssembler();
    }

    @Bean
    public PagedTitlesModelAssembler pagedTitlesModelAssembler(TitleModelAssembler modelAssembler)
    {
        return new PagedTitlesModelAssembler(modelAssembler);
    }
}
