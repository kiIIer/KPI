package com.kpi;

import java.util.concurrent.Callable;

import com.google.inject.Inject;

import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Spec;

@Command(name = "sorter", version = "sorter 0.1", description = "Sorts provided array of doubles using chosen algorithm")
public class Executor implements Callable<Integer>, IExecutor {

    @Spec
    private CommandSpec spec;

    private IGenerator generator;
    private IWriter writer;
    private IAlgorithmProvider provider;

    private String algorithm;

    @Inject
    public Executor(IGenerator generator, IWriter writer, IAlgorithmProvider provider) {
        this.generator = generator;
        this.writer = writer;
        this.provider = provider;
    }

    @Parameters(index = "0", description = "Algorithm to be used while sorting")
    public void setAlgorithm(String value) {
        boolean found = provider.getSupportedAlgorithms().contains(value);

        if (!found) {
            throw new ParameterException(spec.commandLine(), String.format("Unsupported algorithm '%s'", value));
        }

        this.algorithm = value;
    }

    @Override
    public Integer call() throws Exception {
        double[] array = generator.genetateArray(10);

        writer.write(array);

        ISorter sorter = provider.getAlgorithm(algorithm);

        sorter.sort(array);

        writer.write(array);
        return 0;
    }

}
