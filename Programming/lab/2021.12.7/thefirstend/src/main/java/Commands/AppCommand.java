package Commands;

import picocli.CommandLine;

@CommandLine.Command(name = "", description = "This program allows you to perform different actions on Institute structure provided as yaml file. Or just have fun with files")
public class AppCommand implements IAppCommand
{

    @Override
    public Integer call() throws Exception
    {
        System.out.println("Hello whoever you are. Have a nice day!");
        return 0;
    }
}
