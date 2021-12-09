package Commands;

import Main.StudentFilter.IFilterStrategy;
import Main.Tools.*;
import Main.Tools.MyClasses.IValidator;
import Main.Tools.Yaml.IYamlReader;
import Main.Tools.Yaml.IYamlWriter;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.IOException;
import java.util.Collection;

@CommandLine.Command(name = "filter", description = "Filters students as instructed.")
public class StudentsFilterCommand extends BaseCommand implements IStudentsFilterCommand
{
    private final IFilterStrategy filterStrategy;

    @CommandLine.Option(names = {"-g", "--grade"}, required = true, description = "Grade to compare to.")
    int grade;

    @CommandLine.ArgGroup(exclusive = true, multiplicity = "1")
    ChosenSort chosenSort;

    private static ComparisonType comparisonType;

    static class ChosenSort
    {
        @CommandLine.Option(names = "-eq", required = true, description = "Equal to grade entered.")
        public void equal(boolean b)
        {
            comparisonType = (b) ? ComparisonType.EQUAL : comparisonType;
        }

        @CommandLine.Option(names = "-gt", required = true, description = "Greater than grade entered.")
        public void greater(boolean b)
        {
            comparisonType = (b) ? ComparisonType.GREATER : comparisonType;
        }

        @CommandLine.Option(names = "-ge", required = true, description = "Greater or equal to grade entered.")
        public void greaterEqual(boolean b)
        {
            comparisonType = (b) ? ComparisonType.GREATEREQUAL : comparisonType;
        }

        @CommandLine.Option(names = "-lt", required = true, description = "Less than grade entered.")
        public void less(boolean b)
        {
            comparisonType = (b) ? ComparisonType.LESS : comparisonType;
        }

        @CommandLine.Option(names = "-le", required = true, description = "Less or equal to grade entered.")
        public void lessEqual(boolean b)
        {
            comparisonType = (b) ? ComparisonType.LESSEQUAL : comparisonType;
        }
    }

    @Inject
    public StudentsFilterCommand(
            IYamlReader yamlReader,
            IValidator validator,
            IYamlWriter yamlWriter,
            IFilterStrategy filterStrategy
    )
    {
        super(yamlReader, validator, yamlWriter);
        this.filterStrategy = filterStrategy;
    }

    @Override
    public Integer call() throws CommandLine.ParameterException
    {
        IInstitute institute = super.readInstitute();

        FilterSettings settings = new FilterSettings(comparisonType, grade);

        Collection<IStudent> students = filterStrategy.get(institute, settings, collectionType);

        try
        {
            yamlWriter.write(System.out, students);
        } catch (IOException e)
        {
            throw new CommandLine.ParameterException(spec.commandLine(), e.getMessage());
        }

        return CommandLine.ExitCode.OK;
    }
}
