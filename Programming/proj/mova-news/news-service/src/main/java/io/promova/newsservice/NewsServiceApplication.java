package io.promova.newsservice;

import io.promova.newsservice.config.EnviromentalConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(EnviromentalConfig.class)
public class NewsServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(NewsServiceApplication.class, args);
    }

}
