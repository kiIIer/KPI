package Commands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "calculator", version = "calculator 0.0", description = "Executes chosen commands on provided Sets")
public class AppCommand implements Callable<Integer>, IAppCommand
{
    @Override
    public Integer call() throws Exception
    {
        System.out.println("Hi, please use 'help' command to see help.");
        return 0;
    }
}
