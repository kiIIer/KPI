package com.kpi;

import com.google.inject.Guice;
import com.google.inject.Injector;

import picocli.CommandLine;

public class App {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AppModule());
        int exitCode = new CommandLine(injector.getInstance(IExecutor.class)).execute(args);
        System.exit(exitCode);
    }
}