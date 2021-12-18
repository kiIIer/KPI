package Commands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "graph", description = "This program allows you to work with graphs and binary trees, which represent arithmetic calculations.")
public class AppCommand implements IAppCommand
{
    @Override
    public Integer call() throws Exception
    {
        System.out.println("Hello, have a good day. Run command help!");
        return CommandLine.ExitCode.OK;
    }
}
