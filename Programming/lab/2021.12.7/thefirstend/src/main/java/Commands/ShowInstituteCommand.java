package Commands;

import Main.Tools.IYamlReader;
import Main.Tools.Printers.IInstitutePrinter;
import MyClasses.Abstract.IInstitute;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "institute", description = "Shows the string representation of selected institute.")
public class ShowInstituteCommand extends BaseCommand implements IShowInstituteCommand
{

    private final IYamlReader yamlReader;
    private final IInstitutePrinter institutePrinter;

    @Inject
    public ShowInstituteCommand(
            IYamlReader yamlReader,
            IInstitutePrinter institutePrinter
    )
    {
        this.yamlReader = yamlReader;
        this.institutePrinter = institutePrinter;
    }

    @Override
    public Integer call() throws Exception
    {
        IInstitute institute;
        try
        {
            institute = yamlReader.read(new File(filename), dataType);
        } catch (IOException e)
        {
            throw new CommandLine.ParameterException(spec.commandLine(), e.getMessage());
        }

        PrintWriter writer = new PrintWriter(System.out);
        institutePrinter.print(institute, writer);
        writer.flush();
        writer.close();

        return 0;
    }
}
