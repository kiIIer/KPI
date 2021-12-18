package Commands;

import Tree.IBranch;
import Tree.ITreeFromString;
import Yaml.IYamlReader;
import picocli.CommandLine;
import Tree.Tablers.IPostTable;

import javax.inject.Inject;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "post-table", description = "Generates table of calculations using postfix.")
public class PostfixTableCommand extends BaseTreeCommand implements IPostfixTableCommand
{

    private IPostTable postTable;

    @Inject
    public PostfixTableCommand(
            IYamlReader yamlReader,
            ITreeFromString treeFromString,
            IPostTable postTable
    )
    {
        super(yamlReader, treeFromString);
        this.postTable = postTable;
    }

    @Override
    public Integer call() throws CommandLine.ParameterException
    {
        IBranch root = super.read();

        StringBuilder stringBuilder = new StringBuilder();

        postTable.generate(root, stringBuilder);

        System.out.println(stringBuilder);

        return CommandLine.ExitCode.OK;
    }
}
