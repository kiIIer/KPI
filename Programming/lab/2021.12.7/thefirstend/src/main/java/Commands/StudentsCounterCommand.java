package Commands;

import Main.StudentsCounter.IStudentsCounter;
import Main.StudentsCounter.IStudentsCounterHash;
import Main.StudentsCounter.IStudentsCounterList;
import Main.StudentsCounter.IStudentsCounterSet;
import Main.Tools.DataType;
import Main.Tools.IValidator;
import Main.Tools.IYamlReader;
import Main.Tools.InvalidDataStructureException;
import Main.Tools.Printers.IExceptionPrinter;
import MyClasses.Abstract.IInstitute;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;

@CommandLine.Command(name = "count-students", description = "Counts number of students in the provided institute.")
public class StudentsCounterCommand extends BaseCommand implements IStudentsCounterCommand
{

    private final HashMap<DataType, IStudentsCounter> counters;
    private final IValidator validator;
    private final IExceptionPrinter exceptionPrinter;

    @Inject
    public StudentsCounterCommand(
            IYamlReader yamlReader,
            IValidator validator,
            IExceptionPrinter exceptionPrinter,
            IStudentsCounterList studentsCounterList,
            IStudentsCounterSet studentsCounterSet,
            IStudentsCounterHash studentsCounterHash
    )
    {
        super(yamlReader);
        this.validator = validator;
        this.exceptionPrinter = exceptionPrinter;
        this.counters = new HashMap<>();

        this.counters.put(DataType.LIST, studentsCounterList);
        this.counters.put(DataType.TREESET, studentsCounterSet);
        this.counters.put(DataType.HASHSET, studentsCounterHash);
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

        IStudentsCounter studentsCounter = counters.get(dataType);

        int studentsNumber = studentsCounter.count(institute);

        System.out.println(studentsNumber);

        return 0;
    }
}
