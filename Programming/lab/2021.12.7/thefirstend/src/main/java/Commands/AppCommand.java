package Commands;

import picocli.CommandLine;

@CommandLine.Command(name = "ender", description = "This program allows you to perform different actions on Institute structure provided as yaml file. Or just have fun with files")
public class AppCommand implements IAppCommand
{

    @Override
    public Integer call()
    {
        System.out.println("Hello whoever you are. Have a nice day!");
        return CommandLine.ExitCode.OK;
    }
}
