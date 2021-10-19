package com.kip;

import picocli.CommandLine;

public class App {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new HwWithCLI()).execute(args);
        System.exit(exitCode);
    }
}
