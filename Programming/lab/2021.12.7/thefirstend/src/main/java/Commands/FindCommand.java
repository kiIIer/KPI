package Commands;

import Main.Finder.IFinder;
import Main.Finder.IFinderHash;
import Main.Finder.IFinderList;
import Main.Finder.IFinderSet;
import Main.Tools.*;
import Main.Tools.MyClasses.IValidator;
import Main.Tools.MyClasses.InvalidDataStructureException;
import Main.Tools.Printers.IDepartmentPrinter;
import Main.Tools.Printers.IExceptionPrinter;
import Main.Tools.Yaml.IYamlReader;
import Main.Tools.Yaml.IYamlWriter;
import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@CommandLine.Command(name = "find-largest-department", description = "Finds and prints representation of largest department if provided institute")
public class FindCommand extends BaseCommand implements IFindCommand
{

    private final IDepartmentPrinter departmentPrinter;
    private final Map<CollectionType, IFinder> finders;

    @Inject
    public FindCommand(
            IYamlReader yamlReader,
            IValidator validator,
            IYamlWriter yamlWriter,
            IFinderList finderList,
            IFinderSet finderSet,
            IFinderHash finderHash,
            IDepartmentPrinter departmentPrinter
    )
    {
        super(yamlReader, validator, yamlWriter);
        this.departmentPrinter = departmentPrinter;

        finders = new HashMap<>();

        finders.put(CollectionType.LIST, finderList);
        finders.put(CollectionType.TREESET, finderSet);
        finders.put(CollectionType.HASHSET, finderHash);
    }

    @Override
    public Integer call() throws CommandLine.ParameterException
    {
        IInstitute institute = super.readInstitute();

        IFinder finder = finders.get(collectionType);

        IDepartment department = finder.findMaxStudentDepartment(institute);

        try (PrintWriter writer = new PrintWriter(System.out))
        {
            departmentPrinter.print(department, writer);
            writer.write(System.lineSeparator());
            writer.flush();
        } catch (IOException e)
        {
            throw new CommandLine.ParameterException(spec.commandLine(), e.getMessage());
        }
        return CommandLine.ExitCode.OK;
    }
}
