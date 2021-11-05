package Commands;

import Tools.IMatrixReader;
import Tools.IMatrixWriter;
import com.google.inject.Inject;
import picocli.CommandLine;

@CommandLine.Command(name = "relations", description = "Does basic calculations with relations provided as matrices")
public class AppCommand implements IAppCommand
{
    private final IMatrixWriter matrixWriter;
    private final IMatrixReader matrixReader;

    @Inject
    public AppCommand(IMatrixWriter matrixWriter, IMatrixReader matrixReader)
    {
        this.matrixWriter = matrixWriter;
        this.matrixReader = matrixReader;
    }

    @Override
    public Integer call() throws Exception
    {
        System.out.println("Hi Mr. Tsymbal)");

        return CommandLine.ExitCode.OK;
    }
}
