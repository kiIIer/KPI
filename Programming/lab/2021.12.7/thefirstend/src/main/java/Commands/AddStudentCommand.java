package Commands;

import Main.Tools.IDepartmentFinder;
import Main.Tools.IStudentCreator;
import Main.Tools.IYamlReader;
import Main.Tools.IYamlWriter;
import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;

@CommandLine.Command(name = "student", description = "Adds provided student to the institute.")
public class AddStudentCommand extends BaseCommand implements IAddStudentCommand
{
    private final IYamlReader yamlReader;
    private final IDepartmentFinder departmentFinder;
    private final IStudentCreator studentCreator;
    private final IYamlWriter yamlWriter;
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

    @Inject
    public AddStudentCommand(
            IYamlReader yamlReader,
            IDepartmentFinder departmentFinder,
            IStudentCreator studentCreator,
            IYamlWriter yamlWriter
    )
    {
        this.yamlReader = yamlReader;
        this.departmentFinder = departmentFinder;
        this.studentCreator = studentCreator;
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

        IDepartment department = departmentFinder.find(departmentName, institute.getDepartments());

        if (department == null)
        {
            throw new CommandLine.ParameterException(spec.commandLine(), "There is no such department!");
        }

        IStudent student = studentCreator.create(studentName, studentSurname, studentGradeBookId, studentGrade, dataType);

        department.addStudent(student);

        yamlWriter.write(file, institute);

        return 0;
    }
}
