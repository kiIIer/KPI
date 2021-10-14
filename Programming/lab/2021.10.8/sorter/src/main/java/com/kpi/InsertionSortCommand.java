package com.kpi;

import java.util.concurrent.Callable;

import com.google.inject.Inject;

import picocli.CommandLine.Command;
import picocli.CommandLine.ParentCommand;

@Command(name = "quick", description = "Sorts using InsertionSort")
public class InsertionSortCommand implements Callable<Integer> {

    @ParentCommand
    private AppCommand parent;
    private ISorter sorter;

    @Inject
    public InsertionSortCommand(IInsertionSorter sorter) {
        this.sorter = sorter;
    }

    public Integer call() throws Exception {
        return parent.command.call(sorter, parent.length);
    }

}