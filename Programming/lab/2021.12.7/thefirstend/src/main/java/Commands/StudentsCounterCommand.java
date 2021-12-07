package Commands;

import Main.StudentsCounter.IStudentsCounter;
import Main.StudentsCounter.IStudentsCounterHash;
import Main.StudentsCounter.IStudentsCounterList;
import Main.StudentsCounter.IStudentsCounterSet;
import Main.Tools.DataType;
import Main.Tools.IYamlReader;
import MyClasses.Abstract.IInstitute;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@CommandLine.Command(name = "count-students", description = "Counts number of students in the provided institute.")
public class StudentsCounterCommand extends BaseCommand implements IStudentsCounterCommand
{

    private final IYamlReader yamlReader;
    private final HashMap<DataType, IStudentsCounter> counters;

    @Inject
    public StudentsCounterCommand(
            IYamlReader yamlReader,
            IStudentsCounterList studentsCounterList,
            IStudentsCounterSet studentsCounterSet,
            IStudentsCounterHash studentsCounterHash
    )
    {
        this.yamlReader = yamlReader;
        this.counters = new HashMap<>();

        this.counters.put(DataType.LIST, studentsCounterList);
        this.counters.put(DataType.TREESET, studentsCounterSet);
        this.counters.put(DataType.HASHSET, studentsCounterHash);
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

        IStudentsCounter studentsCounter = counters.get(dataType);

        int studentsNumber = studentsCounter.count(institute);

        System.out.println(studentsNumber);

        return 0;
    }
}
