package io.promova;

import javax.inject.Inject;
import java.io.File;

public class Program implements IProgram
{
    private final IFordFinder fordFinder;

    @Inject
    public Program(IFordFinder fordFinder)
    {
        this.fordFinder = fordFinder;
    }

    @Override
    public void execute(String[] args) throws Exception
    {
        if (args.length != 1)
        {
            System.out.println("Nonono, you need to gimme file");
            return;
        }
        String filename = args[0];

        File file = new File(filename);

        System.out.println(fordFinder.find(file));
    }
}
