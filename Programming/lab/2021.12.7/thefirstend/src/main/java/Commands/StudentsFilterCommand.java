package Commands;

import Main.StudentFilter.IFilterLauncher;
import Main.StudentFilter.IFilterStrategy;
import Main.Tools.FilterSettings;
import Main.Tools.IYamlReader;
import Main.Tools.Printers.IStudentPrinter;
import Main.Tools.SearchType;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@CommandLine.Command(name = "filter", description = "Filters students as instructed.")
public class StudentsFilterCommand extends BaseCommand implements IStudentsFilterCommand
{
    private final IYamlReader yamlReader;
    private final IFilterStrategy filterStrategy;
    private final IStudentPrinter studentPrinter;
    @CommandLine.Option(names = {"-g", "--grade"}, required = true, description = "Grade to compare to.")
    int grade;

    @CommandLine.ArgGroup(exclusive = true, multiplicity = "1")
    ChosenSort chosenSort;

    private static SearchType searchType;

    static class ChosenSort
    {
        @CommandLine.Option(names = "-eq", required = true, description = "Equal to grade entered.")
        public void equal(boolean b)
        {
            searchType = (b) ? SearchType.EQUAL : searchType;
        }

        @CommandLine.Option(names = "-gr", required = true, description = "Greater than grade entered.")
        public void greater(boolean b)
        {
            searchType = (b) ? SearchType.GREATER : searchType;
        }

        @CommandLine.Option(names = "-ge", required = true, description = "Greater or equal to grade entered.")
        public void greaterEqual(boolean b)
        {
            searchType = (b) ? SearchType.GREATEREQUAL : searchType;
        }

        @CommandLine.Option(names = "-ls", required = true, description = "Less than grade entered.")
        public void less(boolean b)
        {
            searchType = (b) ? SearchType.LESS : searchType;
        }

        @CommandLine.Option(names = "-le", required = true, description = "Less or equal to grade entered.")
        public void lessEqual(boolean b)
        {
            searchType = (b) ? SearchType.LESSEQUAL : searchType;
        }
    }

    @Inject
    public StudentsFilterCommand(
            IYamlReader yamlReader,
            IFilterStrategy filterStrategy,
            IStudentPrinter studentPrinter
    )
    {
        this.yamlReader = yamlReader;
        this.filterStrategy = filterStrategy;
        this.studentPrinter = studentPrinter;
    }

    @Override
    public Integer call() throws Exception
    {
        IInstitute institute;
        try
        {
            institute = yamlReader.read(new File(filename), dataType);
        } catch (IOException e)
        {
            throw new CommandLine.ParameterException(spec.commandLine(), e.getMessage());
        }

        FilterSettings settings = new FilterSettings(searchType, grade);

        Collection<IStudent> students = filterStrategy.get(institute, settings, dataType);

        PrintWriter writer = new PrintWriter(System.out);

        studentPrinter.print(students, writer);
        writer.write("\n");
        writer.flush();
        writer.close();

        return 0;
    }
}
