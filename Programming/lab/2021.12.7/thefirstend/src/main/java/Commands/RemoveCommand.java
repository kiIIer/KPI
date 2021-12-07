package Commands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "remove", description = "Group command for removing.")
public class RemoveCommand implements IRemoveCommand
{

    @Override
    public Integer call() throws Exception
    {
        System.out.println("Never existed...");
        return 0;
    }
}
