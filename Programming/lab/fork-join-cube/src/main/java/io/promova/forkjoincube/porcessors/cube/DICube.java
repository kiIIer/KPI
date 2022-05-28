package io.promova.forkjoincube.porcessors.cube;

import io.promova.forkjoincube.porcessors.calculator.IFormulaCrawler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DICube
{
    @Bean
    public IRecursiveFormerFactory recursiveFormerFactory(IFormulaCrawler formulaCrawler){
        return new RecursiveFormerFactory(formulaCrawler);
    }
}
