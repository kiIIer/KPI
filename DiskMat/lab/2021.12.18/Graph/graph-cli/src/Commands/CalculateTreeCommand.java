package Commands;

import Tree.Calculator.IBranchCalculator;
import Tree.IBranch;
import Tree.ITreeFromString;
import Yaml.IYamlReader;
import picocli.CommandLine;

import javax.inject.Inject;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "calculate", description = "A simple command used to calculate math in a yaml file.")
public class CalculateTreeCommand extends BaseTreeCommand implements ICalculateTreeCommand
{
    private final IBranchCalculator branchCalculator;

    @Inject
    public CalculateTreeCommand(
            IYamlReader yamlReader,
            ITreeFromString treeFromString,
            IBranchCalculator branchCalculator
    )
    {
        super(yamlReader, treeFromString);
        this.branchCalculator = branchCalculator;
    }

    @Override
    public Integer call() throws CommandLine.ParameterException
    {
        IBranch root = super.read();
        System.out.println(branchCalculator.calculate(root));

        return CommandLine.ExitCode.OK;
    }
}
