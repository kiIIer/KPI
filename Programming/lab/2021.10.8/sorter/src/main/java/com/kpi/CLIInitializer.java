package com.kpi;

import com.google.inject.Inject;

import picocli.CommandLine;

public class CLIInitializer implements ICLIInitializer {

    private final IAppCommand appCommand;
    private QuickSortCommand quickSortCommand;
    private BubbleSortCommand bubbleSortCommand;
    private SelectionSortCommand selectionSortCommand;
    private InsertionSortCommand insertionSortCommand;

    @Inject
    public CLIInitializer(IAppCommand appCommand, QuickSortCommand quickSortCommand,
            BubbleSortCommand bubbleSortCommand, SelectionSortCommand selectionSortCommand,
            InsertionSortCommand insertionSortCommand) {
        this.appCommand = appCommand;
        this.quickSortCommand = quickSortCommand;
        this.bubbleSortCommand = bubbleSortCommand;
        this.selectionSortCommand = selectionSortCommand;
        this.insertionSortCommand = insertionSortCommand;
    }

    public CommandLine initialize() {
        CommandLine commandLine = new CommandLine(appCommand);

        commandLine.addSubcommand("quick", quickSortCommand);
        commandLine.addSubcommand("bubble", bubbleSortCommand);
        commandLine.addSubcommand("selection", selectionSortCommand);
        commandLine.addSubcommand("insertion", insertionSortCommand);

        return commandLine;
    }
}
