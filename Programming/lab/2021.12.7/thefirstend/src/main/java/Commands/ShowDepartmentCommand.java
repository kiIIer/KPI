package Commands;

import Main.Tools.*;
import Main.Tools.Printers.IDepartmentPrinter;
import Main.Tools.Printers.IExceptionPrinter;
import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.PrintWriter;
import java.io.StringWriter;

@CommandLine.Command(name = "department", description = "Shows the string representation of selected student.")
public class ShowDepartmentCommand extends BaseCommand implements IShowDepartmentCommand
{
    private final IValidator validator;
    private final IExceptionPrinter exceptionPrinter;
    private final IDepartmentFinder departmentFinder;
    private final IDepartmentPrinter departmentPrinter;

    @CommandLine.Option(names = {"-d", "--department"}, required = true, description = "Department name of sought department.")
    String departmentName;

    @Inject
    public ShowDepartmentCommand(
            IYamlReader yamlReader,
            IValidator validator,
            IExceptionPrinter exceptionPrinter,
            IDepartmentFinder departmentFinder,
            IDepartmentPrinter departmentPrinter
    )
    {
        super(yamlReader);
        this.validator = validator;
        this.exceptionPrinter = exceptionPrinter;
        this.departmentFinder = departmentFinder;
        this.departmentPrinter = departmentPrinter;
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
