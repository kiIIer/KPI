package Commands;

import Main.Tools.MyClasses.IDepartmentCreator;
import Main.Tools.MyClasses.IValidator;
import Main.Tools.Yaml.IYamlReader;
import Main.Tools.Yaml.IYamlWriter;
import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@CommandLine.Command(name = "department", description = "Adds provided department to the institute")
public class AddDepartmentCommand extends BaseCommand implements IAddDepartmentCommand
{
    private final IDepartmentCreator departmentCreator;

    @CommandLine.Option(names = {"--name"}, required = true, description = "Name of department to be added")
    String departmentName;

    @CommandLine.Option(names = {"-c", "--console"}, description = "Outputs resulting institute in console, rewriting file is omitted.", defaultValue = "false")
    boolean console;

    @Inject
    public AddDepartmentCommand(
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

        institute.addDepartment(department);

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
