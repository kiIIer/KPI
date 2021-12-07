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

@CommandLine.Command(name = "student", description = "Removes specified student from institute")
public class RemoveStudentCommand extends BaseCommand implements IRemoveStudentCommand
{

    private final IYamlReader yamlReader;
    private final IDepartmentFinder departmentFinder;
    private final IStudentCreator studentCreator;
    private final IYamlWriter yamlWriter;

    @CommandLine.Option(names = {"-d", "--department"}, required = true, description = "Department name of department from which student will be removed.")
    String departmentName;

    @CommandLine.Option(names = {"--gradeBookId"}, required = true, description = "GradeBookId of student to be removed")
    String studentGradeBookId;

    @Inject
    public RemoveStudentCommand(
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

        IStudent student = studentCreator.create(null, null, studentGradeBookId, 0, dataType);

        department.removeStudent(student);

        yamlWriter.write(file, institute);

        return 0;
    }
}
