package Commands;

import Main.Tools.IDepartmentCreator;
import Main.Tools.IYamlReader;
import Main.Tools.IYamlWriter;
import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;

@CommandLine.Command(name = "department", description = "Adds provided department to the institute")
public class AddDepartmentCommand extends BaseCommand implements IAddDepartmentCommand
{

    private final IYamlReader yamlReader;
    private final IDepartmentCreator departmentCreator;
    private final IYamlWriter yamlWriter;

    @CommandLine.Option(names = {"--name"}, required = true, description = "Name of department to be added")
    String departmentName;

    @Inject
    public AddDepartmentCommand(
            IYamlReader yamlReader,
            IDepartmentCreator departmentCreator,
            IYamlWriter yamlWriter
    )
    {
        this.yamlReader = yamlReader;
        this.departmentCreator = departmentCreator;
        this.yamlWriter = yamlWriter;
    }

    @Override
    public Integer call() throws Exception
    {
        IInstitute institute;
        File file = new File(filename);
        try
        {
            institute = yamlReader.read(file, dataType);
        } catch (IOException e)
        {
            throw new CommandLine.ParameterException(spec.commandLine(), e.getMessage());
        }
        IDepartment department = departmentCreator.create(departmentName, dataType);

        institute.addDepartment(department);

        yamlWriter.write(file, institute);

        return 0;
    }
}
