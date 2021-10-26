package com.kpi;

import java.util.concurrent.Callable;

import com.google.inject.Inject;
import picocli.CommandLine.ParameterException;

import picocli.CommandLine.Command;
import picocli.CommandLine.ParentCommand;
import picocli.CommandLine.Spec;
import picocli.CommandLine.Model.CommandSpec;

@Command(name = "quick", description = "Sorts using SelectionSort")
public class SelectionSortCommand implements Callable<Integer> {

    @ParentCommand
    private AppCommand parent;

    @Spec
    private CommandSpec spec;

    private ISorter sorter;

    @Inject
    public SelectionSortCommand(ISelectionSorter sorter) {
        this.sorter = sorter;
    }

    public Integer call() throws Exception {
        try {
            return parent.command.call(sorter, parent);
        } catch (NumberFormatException e) {
            throw new ParameterException(spec.commandLine(),
                    String.format("Provided file has something exept doubles"));
        } catch (Exception e) {
            throw new ParameterException(spec.commandLine(), e.getMessage());
        }
    }

}