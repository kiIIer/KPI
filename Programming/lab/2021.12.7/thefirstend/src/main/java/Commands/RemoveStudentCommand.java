package Commands;

import Main.Tools.*;
import Main.Tools.Printers.IExceptionPrinter;
import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.File;
import java.io.StringWriter;

@CommandLine.Command(name = "student", description = "Removes specified student from institute")
public class RemoveStudentCommand extends BaseCommand implements IRemoveStudentCommand
{
    private final IValidator validator;
    private final IExceptionPrinter exceptionPrinter;
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
            IValidator validator,
            IExceptionPrinter exceptionPrinter,
            IDepartmentFinder departmentFinder,
            IStudentCreator studentCreator,
            IYamlWriter yamlWriter
    )
    {
        super(yamlReader);
        this.validator = validator;
        this.exceptionPrinter = exceptionPrinter;
        this.departmentFinder = departmentFinder;
        this.studentCreator = studentCreator;
        this.yamlWriter = yamlWriter;
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

        IStudent student = studentCreator.create(null, null, studentGradeBookId, 0, dataType);

        department.removeStudent(student);

        File file = new File(filename);
        yamlWriter.write(file, institute);

        return 0;
    }
}
