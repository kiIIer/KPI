package Commands;

import Main.Finder.IFinder;
import Main.Finder.IFinderHash;
import Main.Finder.IFinderList;
import Main.Finder.IFinderSet;
import Main.Tools.*;
import Main.Tools.Printers.IDepartmentPrinter;
import Main.Tools.Printers.IExceptionPrinter;
import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@CommandLine.Command(name = "find-largest-department", description = "Finds and prints representation of largest department if provided institute")
public class FindCommand extends BaseCommand implements IFindCommand
{

    private final IValidator validator;
    private final IExceptionPrinter exceptionPrinter;
    private final IDepartmentPrinter departmentPrinter;
    private final Map<DataType, IFinder> finders;

    @Inject
    public FindCommand(
            IYamlReader yamlReader,
            IValidator validator,
            IExceptionPrinter exceptionPrinter,
            IFinderList finderList,
            IFinderSet finderSet,
            IFinderHash finderHash,
            IDepartmentPrinter departmentPrinter
    )
    {
        super(yamlReader);
        this.validator = validator;
        this.exceptionPrinter = exceptionPrinter;
        this.departmentPrinter = departmentPrinter;

        finders = new HashMap<>();

        finders.put(DataType.LIST, finderList);
        finders.put(DataType.TREESET, finderSet);
        finders.put(DataType.HASHSET, finderHash);
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

        IFinder finder = finders.get(dataType);

        IDepartment department = finder.findMaxStudentDepartment(institute);

        PrintWriter writer = new PrintWriter(System.out);

        departmentPrinter.print(department, writer);
        writer.write("\n");
        writer.flush();
        writer.close();

        return 0;
    }
}
