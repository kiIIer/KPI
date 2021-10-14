package com.kpi;

import java.util.concurrent.Callable;

import com.google.inject.Inject;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Spec;

@Command(name = "sorter", version = "sorter 1", description = "Sorts provided array of doubles using chosen algorithm. Hand input > file input > random input")
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
            "-min" }, description = "Minimum randomly generated array can contain. Default is 0", defaultValue = "0")
    public int min;

    @Option(names = {
            "-max" }, description = "Maximum value randomly generated array can contain. Default is 100", defaultValue = "100")
    public int max;

    @Option(names = { "--file", "-f" }, description = "CSV file, from which array will be sorted")
    public String filename;

    @Option(names = { "-s", "--show" }, description = "Shows the input array.", defaultValue = "true")
    public boolean show;

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
