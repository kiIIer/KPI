package Commands;

import Main.Tools.IValidator;
import Main.Tools.IYamlReader;
import Main.Tools.InvalidDataStructureException;
import Main.Tools.Printers.IExceptionPrinter;
import Main.Tools.Printers.IInstitutePrinter;
import Main.Tools.Validator;
import MyClasses.Abstract.IInstitute;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.PrintWriter;
import java.io.StringWriter;

@CommandLine.Command(name = "institute", description = "Shows the string representation of selected institute.")
public class ShowInstituteCommand extends BaseCommand implements IShowInstituteCommand
{
    private final IValidator validator;
    private final IExceptionPrinter exceptionPrinter;
    private final IInstitutePrinter institutePrinter;

    @Inject
    public ShowInstituteCommand(
            IYamlReader yamlReader,
            IValidator validator,
            IExceptionPrinter exceptionPrinter,
            IInstitutePrinter institutePrinter
    )
    {
        super(yamlReader);
        this.validator = validator;
        this.exceptionPrinter = exceptionPrinter;
        this.institutePrinter = institutePrinter;
    }

    @Override
    public Integer call() throws Exception
    {
        IInstitute institute = super.readInstitute();

        try
        {
            validator.validate(institute);
        } catch (InvalidDataStructureException e)
        {
            StringWriter stringWriter = new StringWriter();
            exceptionPrinter.print(e, stringWriter);
            throw new CommandLine.ParameterException(spec.commandLine(), stringWriter.toString());
        }

        PrintWriter writer = new PrintWriter(System.out);
        institutePrinter.print(institute, writer);
        writer.flush();
        writer.close();

        return 0;
    }
}
