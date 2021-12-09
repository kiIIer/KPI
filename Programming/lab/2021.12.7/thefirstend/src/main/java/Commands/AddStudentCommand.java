package Commands;

import Main.Tools.MyClasses.IDepartmentFinder;
import Main.Tools.MyClasses.IStudentCreator;
import Main.Tools.MyClasses.IValidator;
import Main.Tools.Printers.IExceptionPrinter;
import Main.Tools.Yaml.IYamlReader;
import Main.Tools.Yaml.IYamlWriter;
import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.*;

@CommandLine.Command(name = "student", description = "Adds provided student to the institute.")
public class AddStudentCommand extends BaseCommand implements IAddStudentCommand
{
    private final IDepartmentFinder departmentFinder;
    private final IStudentCreator studentCreator;

    @CommandLine.Option(names = {"--name"}, required = true, description = "Name of student to be added.")
    String studentName;

    @CommandLine.Option(names = {"--surname"}, required = true, description = "Surname of student to be added.")
    String studentSurname;

    @CommandLine.Option(names = {"--gradeBookId"}, required = true, description = "GradeBookId of student to be added.")
    String studentGradeBookId;

    @CommandLine.Option(names = {"--grade"}, required = true, description = "Grade of student to be added.")
    int studentGrade;

    @CommandLine.Option(names = {"-d", "--department"}, required = true, description = "Department name of department to which student will be added.")
    String departmentName;

    @CommandLine.Option(names = {"-c", "--console"}, description = "Outputs resulting institute in console, rewriting file is omitted.", defaultValue = "false")
    boolean console;

    @Inject
    public AddStudentCommand(
            IYamlReader yamlReader,
            IValidator validator,
            IDepartmentFinder departmentFinder,
            IStudentCreator studentCreator,
            IYamlWriter yamlWriter
    )
    {
        super(yamlReader, validator, yamlWriter);
        this.departmentFinder = departmentFinder;
        this.studentCreator = studentCreator;
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

        IStudent student = studentCreator.create(studentName, studentSurname, studentGradeBookId, studentGrade, collectionType);

        department.addStudent(student);
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
