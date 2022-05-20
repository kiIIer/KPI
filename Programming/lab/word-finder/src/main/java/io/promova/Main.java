package io.promova;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Injector injector = Guice.createInjector(new ProgramModule());
        IProgram program = injector.getInstance(IProgram.class);
        program.execute(args);
    }
}