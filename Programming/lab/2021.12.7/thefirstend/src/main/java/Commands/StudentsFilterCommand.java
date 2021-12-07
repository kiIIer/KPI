package Commands;

import Main.StudentFilter.IFilterStrategy;
import Main.Tools.*;
import Main.Tools.Printers.IExceptionPrinter;
import Main.Tools.Printers.IStudentPrinter;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;

@CommandLine.Command(name = "filter", description = "Filters students as instructed.")
public class StudentsFilterCommand extends BaseCommand implements IStudentsFilterCommand
{
    private final IValidator validator;
    private final IExceptionPrinter exceptionPrinter;
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
            IValidator validator,
            IExceptionPrinter exceptionPrinter,
            IFilterStrategy filterStrategy,
            IStudentPrinter studentPrinter
    )
    {
        super(yamlReader);
        this.validator = validator;
        this.exceptionPrinter = exceptionPrinter;
        this.filterStrategy = filterStrategy;
        this.studentPrinter = studentPrinter;
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
