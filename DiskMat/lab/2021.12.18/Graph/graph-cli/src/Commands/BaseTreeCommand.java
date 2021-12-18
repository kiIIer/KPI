package Commands;

import Tree.IBranch;
import Tree.ITreeFromString;
import Yaml.IYamlReader;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;

public class BaseTreeCommand
{
    protected static String filename;
    protected static String equation;

    private IYamlReader yamlReader;
    private ITreeFromString treeFromString;

    @CommandLine.ArgGroup(exclusive = true, multiplicity = "1")
    public Group group;

    static class Group
    {
        @CommandLine.Option(names = {"-f", "--file"}, description = "A yaml file containing tree of arithmetic operations.", required = true)
        public void setFilename(String filenamep)
        {
            filename = filenamep;
        }

        @CommandLine.Option(names = {"-e", "--equasion"}, description = "Mathematical equasion which will be used. Please give us A LOT of ()", required = true)
        public void setEquation(String equasion)
        {
            equation = equasion;
        }

    }


    @CommandLine.Spec
    protected CommandLine.Model.CommandSpec spec;

    public BaseTreeCommand(
            IYamlReader yamlReader,
            ITreeFromString treeFromString
    )
    {
        this.yamlReader = yamlReader;
        this.treeFromString = treeFromString;
    }

    protected IBranch read() throws CommandLine.ParameterException
    {
        try
        {
            if (filename != null)
            {
                return yamlReader.read(new File(filename));
            }
            return treeFromString.translate(equation);
        } catch (IOException e)
        {
            throw new CommandLine.ParameterException(spec.commandLine(), e.getMessage());
        } catch (Exception e)
        {
            throw new CommandLine.ParameterException(spec.commandLine(), "Some additional spaces, unequal (). Plz check. " + e.getMessage());
        }
    }
}
