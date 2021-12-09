package Commands;

import Main.Tools.MyClasses.IValidator;
import Main.Tools.Yaml.IYamlReader;
import Main.Tools.MyClasses.InvalidDataStructureException;
import Main.Tools.Printers.IExceptionPrinter;
import Main.Tools.Printers.IInstitutePrinter;
import Main.Tools.Yaml.IYamlWriter;
import MyClasses.Abstract.IInstitute;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

@CommandLine.Command(name = "institute", description = "Shows the string representation of selected institute.")
public class ShowInstituteCommand extends BaseCommand implements IShowInstituteCommand
{
    @Inject
    public ShowInstituteCommand(
            IYamlReader yamlReader,
            IValidator validator,
            IYamlWriter yamlWriter
    )
    {
        super(yamlReader, validator, yamlWriter);
    }

    @Override
    public Integer call() throws CommandLine.ParameterException
    {
        IInstitute institute = super.readInstitute();

        try
        {
            yamlWriter.write(System.out, institute);
        } catch (IOException e)
        {
            throw new CommandLine.ParameterException(spec.commandLine(), e.getMessage());
        }

        return CommandLine.ExitCode.OK;
    }
}
