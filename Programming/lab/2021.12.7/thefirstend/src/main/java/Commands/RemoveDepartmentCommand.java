package Commands;

import Main.Tools.*;
import Main.Tools.Printers.IExceptionPrinter;
import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.File;
import java.io.StringWriter;

@CommandLine.Command(name = "department", description = "Removes specified department from the institute.")
public class RemoveDepartmentCommand extends BaseCommand implements IRemoveDepartmentCommand
{
    private final IValidator validator;
    private final IExceptionPrinter exceptionPrinter;
    private final IDepartmentCreator departmentCreator;
    private final IYamlWriter yamlWriter;
    @CommandLine.Option(names = {"--name"}, required = true, description = "Name of a department to be removed.")
    String departmentName;

    @Inject
    public RemoveDepartmentCommand(
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

        institute.removeDepartment(department);

        File file = new File(filename);
        yamlWriter.write(file, institute);

        return 0;
    }
}
