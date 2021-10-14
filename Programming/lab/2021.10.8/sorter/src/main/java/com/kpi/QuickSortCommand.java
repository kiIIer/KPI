package com.kpi;

import java.util.concurrent.Callable;

import com.google.inject.Inject;

import picocli.CommandLine.Command;
import picocli.CommandLine.ParentCommand;

@Command(name = "quick", description = "Sorts using QuickSort")
public class QuickSortCommand implements Callable<Integer> {

    @ParentCommand
    private AppCommand parent;
    private ISorter sorter;

    @Inject
    public QuickSortCommand(IQuickSorter sorter) {
        this.sorter = sorter;
    }

    public Integer call() throws Exception {
        return parent.command.call(sorter, parent.length);
    }

}