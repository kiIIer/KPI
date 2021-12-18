package Commands;

import Tree.IBranch;
import Tree.ITreeFromString;
import Yaml.IYamlReader;
import picocli.CommandLine;

import javax.inject.Inject;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "show", description = "Shows beautiful tree in console.")
public class ShowTreeCommand extends BaseTreeCommand implements IShowTreeCommand
{
    @Inject
    public ShowTreeCommand(
            IYamlReader yamlReader,
            ITreeFromString treeFromString
    )
    {
        super(yamlReader, treeFromString);
    }

    @Override
    public Integer call() throws CommandLine.ParameterException
    {
        IBranch root = super.read();

        System.out.println(root.toString());

        return CommandLine.ExitCode.OK;
    }
}
