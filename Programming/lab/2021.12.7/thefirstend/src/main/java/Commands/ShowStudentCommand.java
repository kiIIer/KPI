package Commands;

import Main.Tools.MyClasses.IDepartmentFinder;
import Main.Tools.MyClasses.IStudentFinder;
import Main.Tools.MyClasses.IValidator;
import Main.Tools.MyClasses.InvalidDataStructureException;
import Main.Tools.Printers.IExceptionPrinter;
import Main.Tools.Printers.IStudentPrinter;
import Main.Tools.Yaml.IYamlReader;
import Main.Tools.Yaml.IYamlWriter;
import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

@CommandLine.Command(name = "student", description = "Shows the string representation of selected student.")
public class ShowStudentCommand extends BaseCommand implements IShowStudentCommand
{
    private final IDepartmentFinder departmentFinder;
    private final IStudentFinder studentFinder;

    @CommandLine.Option(names = {"-i", "--id"}, required = true, description = "Grade book ID for sought student.")
    String gradeBookID;

    @CommandLine.Option(names = {"-d", "--department"}, required = true, description = "Department name to look in.")
    String departmentName;

    @Inject
    public ShowStudentCommand(
            IYamlReader yamlReader,
            IValidator validator,
            IYamlWriter yamlWriter,
            IDepartmentFinder departmentFinder,
            IStudentFinder studentFinder
    )
    {
        super(yamlReader, validator, yamlWriter);
        this.departmentFinder = departmentFinder;
        this.studentFinder = studentFinder;
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

        IStudent student = studentFinder.find(gradeBookID, department.getStudents());

        if (student == null)
        {
            throw new CommandLine.ParameterException(spec.commandLine(), "There is no such student!");
        }

        try
        {
            yamlWriter.write(System.out, student);
        } catch (IOException e)
        {
            throw new CommandLine.ParameterException(spec.commandLine(), e.getMessage());
        }

        return CommandLine.ExitCode.OK;
    }
}