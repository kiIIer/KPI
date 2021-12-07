package Commands;

import Main.Tools.DataType;
import picocli.CommandLine;

import java.util.concurrent.Callable;

public abstract class BaseCommand implements Callable<Integer>
{
    @CommandLine.ArgGroup(exclusive = true, multiplicity = "1")
    CheckType checkType;

    protected static DataType dataType;

    @CommandLine.Option(names = {"-f", "--filename"}, required = true, description = "Filename of file with YAML institute")
    protected String filename;

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    static class CheckType
    {
        @CommandLine.Option(names = {"-l", "--list"}, description = "List data type to be used when checked.")
        public void listChecked(boolean b)
        {
            dataType = (b) ? DataType.LIST : dataType;
        }

        @CommandLine.Option(names = {"-t", "--tree"}, description = "TreeSet data type to be used when checked.")
        public void treeChecked(boolean b)
        {
            dataType = (b) ? DataType.TREESET : dataType;
        }

        @CommandLine.Option(names = {"-h", "--hash"}, description = "HashSet data type to be used when checked.")
        public void hashChecked(boolean b)
        {
            dataType = (b) ? DataType.HASHSET : dataType;
        }
    }
}

