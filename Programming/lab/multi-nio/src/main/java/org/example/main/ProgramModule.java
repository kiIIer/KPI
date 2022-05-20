package org.example.main;

import com.google.inject.AbstractModule;
import org.example.fileworker.IJobCreator;
import org.example.fileworker.JobCreator;

public class ProgramModule extends AbstractModule
{
    @Override
    public void configure()
    {
        bind(IJobCreator.class).to(JobCreator.class);
        bind(IProgram.class).to(Program.class);
    }
}
