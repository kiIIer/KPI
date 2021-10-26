package com.kpi;

import com.google.inject.Guice;
import com.google.inject.Injector;

import picocli.CommandLine;

public class App {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AppModule());

        ICLIInitializer initializer = injector.getInstance(ICLIInitializer.class);

        CommandLine commandLine = initializer.initialize();

        int exitCode = commandLine.execute(args);
        System.exit(exitCode);
    }
}