package Commands;

import picocli.CommandLine;

@CommandLine.Command(name = "add", description = "Group command for adding.")
public class AddCommand implements IAddCommand
{
    @Override
    public Integer call() throws Exception
    {
        System.out.println("I'm just a group command.");
        return 0;
    }
}
