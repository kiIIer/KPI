package Commands;

import Tree.IBranch;
import Tree.Tablers.IPreTable;
import Yaml.IYamlReader;
import picocli.CommandLine;

import javax.inject.Inject;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "pre-table", description = "Generates table of calculations using prefix.")
public class PrefixTableCommand extends BaseTreeCommand implements IPrefixTableCommand
{
    private IPreTable preTable;

    @Inject
    public PrefixTableCommand(
            IYamlReader yamlReader,
            IPreTable preTable
    )
    {
        super(yamlReader);
        this.preTable = preTable;
    }

    @Override
    public Integer call() throws CommandLine.ParameterException
    {
        IBranch root = super.read();

        StringBuilder stringBuilder = new StringBuilder();

        preTable.generate(root, stringBuilder);

        System.out.println(stringBuilder);

        return CommandLine.ExitCode.OK;
    }
}
