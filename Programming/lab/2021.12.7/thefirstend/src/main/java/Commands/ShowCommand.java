package Commands;

import picocli.CommandLine;

@CommandLine.Command(name = "show", description = "Commands from this little group show string representation of selected")
public class ShowCommand implements IShowCommand
{
    @Override
    public Integer call()
    {
        System.out.println("Plz get some help, I'm just a group command ^^'");
        return CommandLine.ExitCode.OK;
    }
}
