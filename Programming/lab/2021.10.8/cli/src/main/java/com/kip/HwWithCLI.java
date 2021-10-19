package com.kip;

import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "helloworld", version = "hello 1.0", description = "Prints options you selected and sometimes says hello")
public class HwWithCLI implements Callable<Integer>{

    @Parameters(index = "0", description = "False by default but you may change it!")
    int a = 0;

    @Option(names = { "b", "boofo" }, description = "Calls the boofo if true")
    boolean b = false;

    @Option(names = { "h", "hello" }, description = "Says hello if true")
    boolean isHello = false;

    public void execute() {
        System.out.println("a is " + a);

        if (b) {
            System.out.println("The grean boofo was summoned. RUUUUN");
        }

        if (isHello) {
            System.out.println("Hello to you too");
        }
    }

    @Override
    public Integer call() throws Exception {
        execute();
        return 0;
    }
}
