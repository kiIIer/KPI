package io.promova.newsservice.singlenew;

import io.promova.newsservice.singlenew.tools.SingleNewsModelAssembler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SingleNewsConfig
{
    @Bean
    SingleNewsModelAssembler singleNewsModelAssembler()
    {
        return new SingleNewsModelAssembler();
    }
}
