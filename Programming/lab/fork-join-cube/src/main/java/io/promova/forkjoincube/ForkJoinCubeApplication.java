package io.promova.forkjoincube;

import io.promova.forkjoincube.models.logic.CalculateJob;
import io.promova.forkjoincube.models.logic.Parameter;
import io.promova.forkjoincube.porcessors.job.JobCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ForkJoinCubeApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(ForkJoinCubeApplication.class, args);
    }

}
