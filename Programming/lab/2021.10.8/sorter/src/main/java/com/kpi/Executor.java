package com.kpi;

import java.util.Map;
import java.util.concurrent.Callable;

import com.google.inject.Inject;

import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Spec;

@Command(name = "sorter", version = "sorter 0.1", description = "Sorts provided array of doubles using chosen algorithm: "
        + SupportedAlgorithms.list)
public class Executor implements Callable<Integer>, IExecutor {

    @Spec
    private CommandSpec spec;

    @Inject
    private IGenerator generator;

    @Inject
    private IWriter writer;

    @Inject
    private IAlgorithmProvider provider;

    private String algorithm;

    @Parameters(index = "0", description = "Algorithm to be used while sorting")
    public void setAlgorithm(String value) {
        String[] supported = SupportedAlgorithms.algorithms;
        boolean found = false;

        for (String x : supported) {
            if (x.equals(value)) {
                found = true;
            }
        }

        if (!found) {
            throw new ParameterException(spec.commandLine(), String.format("Unsupported algorithm '%s'", value));
        }
        this.algorithm = value;
    }

    @Override
    public Integer call() throws Exception {
        double[] array = generator.genetateArray(10);

        writer.write(array);

        Map<String, ISorter> algorithms = provider.getAlgorithms();

        ISorter sorter = algorithms.get(algorithm);

        sorter.sort(array);

        writer.write(array);
        return 0;
    }

}
