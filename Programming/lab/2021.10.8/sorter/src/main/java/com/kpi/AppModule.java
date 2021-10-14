package com.kpi;

import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IWriter.class).to(Writer.class);
        bind(IGenerator.class).to(ArrayGenerator.class);
        bind(IAppCommand.class).to(AppCommand.class);
        bind(ISorterCommand.class).to(SorterCommand.class);
        bind(ICLIInitializer.class).to(CLIInitializer.class);
        bind(IQuickSorter.class).to(QuickSorter.class);
        bind(IBubbleSorter.class).to(BubbleSorter.class);
        bind(ISelectionSorter.class).to(SelectionSorter.class);
        bind(IInsertionSorter.class).to(InsertionSorter.class);
    }
}