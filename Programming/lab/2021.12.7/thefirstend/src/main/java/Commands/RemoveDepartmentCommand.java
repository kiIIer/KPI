package Commands;

import Main.Tools.MyClasses.IDepartmentCreator;
import Main.Tools.MyClasses.IValidator;
import Main.Tools.MyClasses.InvalidDataStructureException;
import Main.Tools.Printers.IExceptionPrinter;
import Main.Tools.Yaml.IYamlReader;
import Main.Tools.Yaml.IYamlWriter;
import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.*;

@CommandLine.Command(name = "department", description = "Removes specified department from the institute.")
public class RemoveDepartmentCommand extends BaseCommand implements IRemoveDepartmentCommand
{
    private final IDepartmentCreator departmentCreator;

    @CommandLine.Option(names = {"--name"}, required = true, description = "Name of a department to be removed.")
    String departmentName;

    @CommandLine.Option(names = {"-c", "--console"}, description = "Outputs resulting institute in console, rewriting file is omitted.", defaultValue = "false")
    boolean console;

    @Inject
    public RemoveDepartmentCommand(
            IYamlReader yamlReader,
            IValidator validator,
            IDepartmentCreator departmentCreator,
            IYamlWriter yamlWriter
    )
    {
        super(yamlReader, validator, yamlWriter);
        this.departmentCreator = departmentCreator;
    }

    @Override
    public Integer call() throws CommandLine.ParameterException
    {
        IInstitute institute = super.readInstitute();

        IDepartment department = departmentCreator.create(departmentName, collectionType);

        institute.removeDepartment(department);

        OutputStream stream;

        try
        {
            if (console)
            {
                stream = System.out;
            } else
            {
                stream = new FileOutputStream(filename);
            }

            yamlWriter.write(stream, institute);

            stream.close();
        } catch (IOException e)
        {
            throw new CommandLine.ParameterException(spec.commandLine(), e.getMessage());
        }

        return CommandLine.ExitCode.OK;
    }
}
