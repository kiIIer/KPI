package Commands;

import Tree.IBranch;
import Yaml.IYamlReader;
import Yaml.YamlReader;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;

public class BaseTreeCommand
{
    @CommandLine.Option(names = {"-f", "--file"}, description = "A yaml file containing tree of arithmetic operations.", required = true)
    String filename;
    private IYamlReader yamlReader;

    @CommandLine.Spec
    protected CommandLine.Model.CommandSpec spec;

    public BaseTreeCommand(
            IYamlReader yamlReader
    )
    {
        this.yamlReader = yamlReader;
    }

    protected IBranch read() throws CommandLine.ParameterException
    {
        try
        {
            return yamlReader.read(new File(filename));
        } catch (IOException e)
        {
            throw new CommandLine.ParameterException(spec.commandLine(), e.getMessage());
        }
    }
}
