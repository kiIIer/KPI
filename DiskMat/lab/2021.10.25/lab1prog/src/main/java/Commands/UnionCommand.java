package Commands;

import Commands.AppCommand;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "union", description = "Calculates the union of sets.")
public class UnionCommand implements Callable<Integer>
{
    @CommandLine.ParentCommand
    private AppCommand parent;

    @Override
    public Integer call() throws Exception
    {
        System.out.println("FOR THE UNION");
        return 0;
    }
}
