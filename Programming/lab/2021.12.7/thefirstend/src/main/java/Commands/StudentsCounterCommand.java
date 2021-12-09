package Commands;

import Main.StudentsCounter.IStudentsCounter;
import Main.StudentsCounter.IStudentsCounterHash;
import Main.StudentsCounter.IStudentsCounterList;
import Main.StudentsCounter.IStudentsCounterSet;
import Main.Tools.CollectionType;
import Main.Tools.MyClasses.IValidator;
import Main.Tools.Yaml.IYamlReader;
import Main.Tools.MyClasses.InvalidDataStructureException;
import Main.Tools.Printers.IExceptionPrinter;
import Main.Tools.Yaml.IYamlWriter;
import MyClasses.Abstract.IInstitute;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.StringWriter;
import java.util.HashMap;

@CommandLine.Command(name = "count-students", description = "Counts number of students in the provided institute.")
public class StudentsCounterCommand extends BaseCommand implements IStudentsCounterCommand
{

    private final HashMap<CollectionType, IStudentsCounter> counters;

    @Inject
    public StudentsCounterCommand(
            IYamlReader yamlReader,
            IValidator validator,
            IYamlWriter yamlWriter,
            IStudentsCounterList studentsCounterList,
            IStudentsCounterSet studentsCounterSet,
            IStudentsCounterHash studentsCounterHash
    )
    {
        super(yamlReader, validator, yamlWriter);
        this.counters = new HashMap<>();

        this.counters.put(CollectionType.LIST, studentsCounterList);
        this.counters.put(CollectionType.TREESET, studentsCounterSet);
        this.counters.put(CollectionType.HASHSET, studentsCounterHash);
    }

    @Override
    public Integer call() throws CommandLine.ParameterException
    {
        IInstitute institute = super.readInstitute();

        IStudentsCounter studentsCounter = counters.get(collectionType);

        int studentsNumber = studentsCounter.count(institute);

        System.out.println(studentsNumber);

        return CommandLine.ExitCode.OK;
    }
}
