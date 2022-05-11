package io.promova.forkjoincube;

import io.promova.forkjoincube.models.logic.Formula;
import io.promova.forkjoincube.porcessors.polish.ITranslator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ForkJoinCubeApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ForkJoinCubeApplication.class, args);
    }

}
