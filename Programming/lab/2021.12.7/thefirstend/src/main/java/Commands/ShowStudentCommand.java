package Commands;

import Main.Tools.*;
import Main.Tools.Printers.IExceptionPrinter;
import Main.Tools.Printers.IStudentPrinter;
import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

@CommandLine.Command(name = "student", description = "Shows the string representation of selected student.")
public class ShowStudentCommand extends BaseCommand implements IShowStudentCommand
{
    private final IValidator validator;
    private final IExceptionPrinter exceptionPrinter;
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
            IValidator validator,
            IExceptionPrinter exceptionPrinter,
            IDepartmentFinder departmentFinder,
            IStudentFinder studentFinder,
            IStudentPrinter studentPrinter
    )
    {
        super(yamlReader);
        this.validator = validator;
        this.exceptionPrinter = exceptionPrinter;
        this.departmentFinder = departmentFinder;
        this.studentFinder = studentFinder;
        this.studentPrinter = studentPrinter;
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