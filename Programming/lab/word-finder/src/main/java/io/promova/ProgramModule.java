package io.promova;

import com.google.inject.AbstractModule;

public class ProgramModule extends AbstractModule
{
    @Override
    public void configure()
    {
        bind(IProgram.class).to(Program.class);
        bind(IFordFinder.class).to(FordFinder.class);
    }
}
