package Commands;

import Main.Tools.MyClasses.IDepartmentFinder;
import Main.Tools.MyClasses.IValidator;
import Main.Tools.MyClasses.InvalidDataStructureException;
import Main.Tools.Printers.IDepartmentPrinter;
import Main.Tools.Printers.IExceptionPrinter;
import Main.Tools.Yaml.IYamlReader;
import Main.Tools.Yaml.IYamlWriter;
import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

@CommandLine.Command(name = "department", description = "Shows the string representation of selected student.")
public class ShowDepartmentCommand extends BaseCommand implements IShowDepartmentCommand
{
    private final IDepartmentFinder departmentFinder;

    @CommandLine.Option(names = {"-d", "--department"}, required = true, description = "Department name of sought department.")
    String departmentName;

    @Inject
    public ShowDepartmentCommand(
            IYamlReader yamlReader,
            IValidator validator,
            IYamlWriter yamlWriter,
            IDepartmentFinder departmentFinder
    )
    {
        super(yamlReader, validator, yamlWriter);
        this.departmentFinder = departmentFinder;
    }

    @Override
    public Integer call() throws CommandLine.ParameterException
    {
        IInstitute institute = super.readInstitute();

        IDepartment department = departmentFinder.find(departmentName, institute.getDepartments());

        if (department == null)
        {
            throw new CommandLine.ParameterException(spec.commandLine(), "There is no such department!");
        }

        try
        {
            yamlWriter.write(System.out, department);
        } catch (IOException e)
        {
            throw new CommandLine.ParameterException(spec.commandLine(), e.getMessage());
        }

        return CommandLine.ExitCode.OK;
    }
}
