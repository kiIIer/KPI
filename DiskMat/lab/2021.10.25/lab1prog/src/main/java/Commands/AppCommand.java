package Commands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "calculator", version = "calculator 0.0", description = "Executes chosen commands on provided Sets")
public class AppCommand implements Callable<Integer>, IAppCommand
{

    @CommandLine.Option(names = {"-1", "--first"}, split = ",", description = "First set which will be used in commands. Enter like this 3,2,1.")
    int[] set1;

    @CommandLine.Option(names = {"-2", "--second"}, split = ",", description = "Second set which will be used in commands. Enter like this: 3,2,1.")
    int[] set2;

    @Override
    public Integer call() throws Exception
    {
        System.out.println("Hi, please use 'help' command to see help.");
        return 0;
    }
}
