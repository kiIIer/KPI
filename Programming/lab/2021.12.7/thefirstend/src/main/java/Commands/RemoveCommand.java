package Commands;

import picocli.CommandLine;

@CommandLine.Command(name = "remove", description = "Group command for removing.")
public class RemoveCommand implements IRemoveCommand
{
    @Override
    public Integer call()
    {
        System.out.println("Never existed...");
        return CommandLine.ExitCode.OK;
    }
}
