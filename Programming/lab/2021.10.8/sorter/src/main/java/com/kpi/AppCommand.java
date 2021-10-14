package com.kpi;

import java.util.concurrent.Callable;

import com.google.inject.Inject;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Spec;

@Command(name = "sorter", version = "sorter 1", description = "Sorts provided array of doubles using chosen algorithm.")
public class AppCommand implements Callable<Integer>, IAppCommand {

    public final IGenerator generator;
    public final IWriter writer;
    public final ISorterCommand command;

    @Spec
    public CommandSpec spec;

    public int length;

    @Option(names = { "--length",
            "-l" }, description = "Length of the randomly generated array. Default is 10", defaultValue = "10")
    public void setLength(int value) {
        if (value <= 0) {
            throw new ParameterException(spec.commandLine(),
                    String.format("Length must be greater than 0. You entered: %s", value));
        }
        this.length = value;
    }

    @Option(names = {
            "-min" }, description = "The minimum randomly generated array can contain. Default is 0", defaultValue = "0")
    public int min;

    @Option(names = {
            "-max" }, description = "The maximum value randomly generated array can contain. Default is 9", defaultValue = "9")
    public int max;

    @Option(names = { "-i", "--input" }, description = "Prints the input array. Default is true", defaultValue = "true")
    public boolean show;

    @Option(names = { "-d",
            "--descend" }, description = "Descending sort order. Default is false", defaultValue = "false")
    public boolean descending;

    @Option(names = { "--file",
            "-f" }, description = "A name of CSV file containing input array", defaultValue = "/dev/stdin")
    public String filename;
    @Option(names = { "-a",
            "--array" }, split = ",", description = "You can manually provide an array using this flag. Enter array separating values with ',' like this 3,2,1 ")
    public double[] array;

    @Option(names = { "-r",
            "--random" }, description = "Generates random input array. Default is false", defaultValue = "false")
    public boolean isRandom;

    @Option(names = { "-t", "--time" }, description = "Prints time of execution", defaultValue = "false")
    public boolean isTime;

    @Inject
    public AppCommand(ISorterCommand command, IGenerator generator, IWriter writer) {
        this.generator = generator;
        this.writer = writer;
        this.command = command;
    }

    @Option(names = { "--help", "-h" }, usageHelp = true, description = "Displays help")
    boolean help;

    @Override
    public Integer call() throws Exception {
        System.out.println("If you are reading this, plz use option -h");
        return 0;
    }

}
