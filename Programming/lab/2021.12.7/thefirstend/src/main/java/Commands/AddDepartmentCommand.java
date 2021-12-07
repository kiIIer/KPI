package Commands;

import Main.Tools.*;
import Main.Tools.Printers.IExceptionPrinter;
import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.File;
import java.io.StringWriter;

@CommandLine.Command(name = "department", description = "Adds provided department to the institute")
public class AddDepartmentCommand extends BaseCommand implements IAddDepartmentCommand
{
    private final IValidator validator;
    private final IExceptionPrinter exceptionPrinter;
    private final IDepartmentCreator departmentCreator;
    private final IYamlWriter yamlWriter;

    @CommandLine.Option(names = {"--name"}, required = true, description = "Name of department to be added")
    String departmentName;

    @Inject
    public AddDepartmentCommand(
            IYamlReader yamlReader,
            IValidator validator,
            IExceptionPrinter exceptionPrinter,
            IDepartmentCreator departmentCreator,
            IYamlWriter yamlWriter
    )
    {
        super(yamlReader);
        this.validator = validator;
        this.exceptionPrinter = exceptionPrinter;
        this.departmentCreator = departmentCreator;
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

        IDepartment department = departmentCreator.create(departmentName, dataType);

        institute.addDepartment(department);

        File file = new File(filename);
        yamlWriter.write(file, institute);

        return 0;
    }
}
