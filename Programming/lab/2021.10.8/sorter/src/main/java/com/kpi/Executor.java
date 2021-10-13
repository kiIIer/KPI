package com.kpi;

import java.util.concurrent.Callable;

import com.google.inject.Inject;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Spec;

@Command(name = "sorter", version = "sorter 1", description = "Sorts provided array of doubles using chosen algorithm. Currently supported algorithms: quick, bubble, insertion, selection.")
public class Executor implements Callable<Integer>, IExecutor {

    @Spec
    private CommandSpec spec;

    private IGenerator generator;
    private IWriter writer;
    private IAlgorithmProvider provider;

    private String algorithm;
    private int length = 10;

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

    @Option(names = { "--length", "-l" }, description = "Length of the randomly generated array. Default is 10")
    public void setLength(int value) {
        if (value <= 0) {
            throw new ParameterException(spec.commandLine(),
                    String.format("Length must be greater than 0. You entered: %s", value));
        }
        this.length = value;
    }

    @Option(names = { "--help", "-h" }, usageHelp = true, description = "Displays help")
    boolean help;

    @Override
    public Integer call() throws Exception {
        double[] array = generator.genetateArray(length);

        writer.write(array);

        ISorter sorter = provider.getAlgorithm(algorithm);

        sorter.sort(array);

        writer.write(array);

        return 0;
    }

}
