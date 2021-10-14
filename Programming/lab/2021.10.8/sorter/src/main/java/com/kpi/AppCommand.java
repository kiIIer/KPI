package com.kpi;

import java.util.concurrent.Callable;

import com.google.inject.Inject;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Spec;

@Command(name = "sorter", version = "sorter 1", description = "Sorts provided array of doubles using chosen algorithm. Currently supported algorithms: quick, bubble, insertion, selection.")
public class AppCommand implements Callable<Integer>, IAppCommand {

    @Spec
    private CommandSpec spec;

    public final IGenerator generator;
    public final IWriter writer;
    public final ISorterCommand command;

    public int length = 10;

    @Inject
    public AppCommand(ISorterCommand command, IGenerator generator, IWriter writer) {
        this.generator = generator;
        this.writer = writer;
        this.command = command;
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
        return 0;
    }

}
