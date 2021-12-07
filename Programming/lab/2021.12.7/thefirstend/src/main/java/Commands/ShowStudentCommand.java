package Commands;

import Main.Tools.DataType;
import Main.Tools.IDepartmentFinder;
import Main.Tools.IStudentFinder;
import Main.Tools.IYamlReader;
import Main.Tools.Printers.IStudentPrinter;
import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@CommandLine.Command(name = "student", description = "Shows the string representation of selected student.")
public class ShowStudentCommand extends BaseCommand implements IShowStudentCommand
{
    private final IYamlReader yamlReader;
    private final IDepartmentFinder departmentFinder;
    private final IStudentFinder studentFinder;
    private final IStudentPrinter studentPrinter;
    @CommandLine.Option(names = {"-i", "--id"}, required = true, description = "Grade book ID for sought student.")
    String gradeBookID;

    @CommandLine.Option(names = {"-d", "--department"}, required = true, description = "Department name to look in.")
    String departmentName;

    @Inject
    public ShowStudentCommand(
            IYamlReader yamlReader,
            IDepartmentFinder departmentFinder,
            IStudentFinder studentFinder,
            IStudentPrinter studentPrinter
    )
    {
        this.yamlReader = yamlReader;
        this.departmentFinder = departmentFinder;
        this.studentFinder = studentFinder;
        this.studentPrinter = studentPrinter;
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

        IStudent student = studentFinder.find(gradeBookID, department.getStudents());

        if (student == null)
        {
            throw new CommandLine.ParameterException(spec.commandLine(), "There is no such student!");
        }

        PrintWriter writer = new PrintWriter(System.out);
        studentPrinter.print(student, writer);
        writer.write("\n");
        writer.flush();
        writer.close();

        return 0;
    }
}