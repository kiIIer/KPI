package Commands;

import Main.Tools.CollectionType;
import Main.Tools.MyClasses.IValidator;
import Main.Tools.MyClasses.InvalidDataStructureException;
import Main.Tools.Printers.IExceptionPrinter;
import Main.Tools.Yaml.IYamlReader;
import Main.Tools.Yaml.IYamlWriter;
import MyClasses.Abstract.IInstitute;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.concurrent.Callable;

public abstract class BaseCommand implements Callable<Integer>
{
    private final IYamlReader yamlReader;
    private final IValidator validator;
    protected final IYamlWriter yamlWriter;

    @CommandLine.ArgGroup(exclusive = true, multiplicity = "1")
    CheckType checkType;

    protected static CollectionType collectionType;

    @CommandLine.Option(names = {"-f", "--filename"}, required = true, description = "Filename of file with YAML institute")
    protected String filename;

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    static class CheckType
    {
        @CommandLine.Option(names = {"-l", "--list"}, description = "List data type to be used when checked.")
        public void listChecked(boolean b)
        {
            collectionType = (b) ? CollectionType.LIST : collectionType;
        }

        @CommandLine.Option(names = {"-t", "--tree"}, description = "TreeSet data type to be used when checked.")
        public void treeChecked(boolean b)
        {
            collectionType = (b) ? CollectionType.TREESET : collectionType;
        }

        @CommandLine.Option(names = {"-h", "--hash"}, description = "HashSet data type to be used when checked.")
        public void hashChecked(boolean b)
        {
            collectionType = (b) ? CollectionType.HASHSET : collectionType;
        }
    }

    public BaseCommand(
            IYamlReader yamlReader,
            IValidator validator,
            IYamlWriter yamlWriter
    )
    {
        this.yamlReader = yamlReader;
        this.validator = validator;
        this.yamlWriter = yamlWriter;
    }

    protected IInstitute readInstitute()
    {
        IInstitute institute;
        try
        {
            File file = new File(filename);
            institute = yamlReader.read(file, collectionType);

            try
            {
                validator.validate(institute);
            } catch (InvalidDataStructureException e)
            {
                StringWriter stringWriter = new StringWriter();
                yamlWriter.write(System.out, e.getErrors());
                throw new CommandLine.ParameterException(spec.commandLine(), stringWriter.toString());
            }
        } catch (IOException e)
        {
            throw new CommandLine.ParameterException(spec.commandLine(), e.getMessage());
        }
        return institute;
    }
}

