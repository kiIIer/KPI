package io.promova.forkjoincube.porcessors.job;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIJob
{
    @Bean
    public IJobCreator jobCreator()
    {
        return new JobCreator();
    }
}
