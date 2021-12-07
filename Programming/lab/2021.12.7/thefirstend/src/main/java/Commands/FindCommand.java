package Commands;

import Main.Finder.IFinder;
import Main.Finder.IFinderHash;
import Main.Finder.IFinderList;
import Main.Finder.IFinderSet;
import Main.Tools.DataType;
import Main.Tools.IYamlReader;
import Main.Tools.Printers.IDepartmentPrinter;
import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@CommandLine.Command(name = "find-largest-department", description = "Finds and prints representation of largest department if provided institute")
public class FindCommand extends BaseCommand implements IFindCommand
{

    private final IYamlReader yamlReader;
    private final IDepartmentPrinter departmentPrinter;
    private final Map<DataType, IFinder> finders;

    @Inject
    public FindCommand(
            IYamlReader yamlReader,
            IFinderList finderList,
            IFinderSet finderSet,
            IFinderHash finderHash,
            IDepartmentPrinter departmentPrinter
    )
    {
        this.yamlReader = yamlReader;
        this.departmentPrinter = departmentPrinter;

        finders = new HashMap<>();

        finders.put(DataType.LIST, finderList);
        finders.put(DataType.TREESET, finderSet);
        finders.put(DataType.HASHSET, finderHash);
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
