package Commands;

import Main.Tools.IDepartmentFinder;
import Main.Tools.IYamlReader;
import Main.Tools.Printers.IDepartmentPrinter;
import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "department", description = "Shows the string representation of selected student.")
public class ShowDepartmentCommand extends BaseCommand implements IShowDepartmentCommand
{

    private final IYamlReader yamlReader;
    private final IDepartmentFinder departmentFinder;
    private final IDepartmentPrinter departmentPrinter;

    @CommandLine.Option(names = {"-d", "--department"}, required = true, description = "Department name of sought department.")
    String departmentName;

    @Inject
    public ShowDepartmentCommand(
            IYamlReader yamlReader,
            IDepartmentFinder departmentFinder,
            IDepartmentPrinter departmentPrinter
    )
    {
        this.yamlReader = yamlReader;
        this.departmentFinder = departmentFinder;
        this.departmentPrinter = departmentPrinter;
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
        IDepartment department = departmentFinder.find(departmentName, institute.getDepartments());

        if (department == null)
        {
            throw new CommandLine.ParameterException(spec.commandLine(), "There is no such department!");
        }

        PrintWriter writer = new PrintWriter(System.out);
        departmentPrinter.print(department, writer);
        writer.write("\n");
        writer.flush();
        writer.close();

        return 0;
    }
}
