package com.kpi;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "helloworld", version = "hello 1.0", description = "Prints options you selected and sometimes says hello")
public class HwWithCLI {

    @Parameters(index = "0", description = "False by default but you may change it!")
    boolean a = false;

    @Option(names = { "b", "boofo" }, description = "Calls the boofo if true")
    boolean b = false;

    @Option(names = { "h", "hello" }, description = "Says hello if true")
    boolean isHello = false;

    public int execute() {
        System.out.println("a is " + a);

        if (b) {
            System.out.println("The grean boofo was summoned. RUUUUN");
        }

        if (isHello) {
            System.out.println("Hello to you too");
        }
        return 0;
    }
}
