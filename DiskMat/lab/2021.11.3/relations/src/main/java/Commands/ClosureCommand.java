package Commands;

import Tools.*;
import com.google.inject.Inject;
import com.opencsv.exceptions.CsvException;
import picocli.CommandLine;

import java.io.IOException;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "closure", description = "Calculates specified closure on provided matrix")
public class ClosureCommand implements IClosureCommand
{
    private final IMatrixReader matrixReader;
    private final IMatrixWriter matrixWriter;
    private final IValidator validator;
    private final IReflexiveClosurer reflexiveClosurer;
    private final ISymmetricClosurer symmetricClosurer;
    private final ITransitiveClosurer transitiveClosurer;
    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @CommandLine.Option(names = {"-w", "--write"}, description = "File to be written to. Default is /dev/stdout", defaultValue = "/dev/stdout")
    String fileWriteName;

    @CommandLine.Option(names = {"-f", "--file"}, description = "File with a matrix to be read", required = true)
    String filename;

    @CommandLine.Option(names = {"-r", "--reflexive"}, description = "Calculates reflexive closure on provided matrix", defaultValue = "false")
    boolean isReflexive;

    @CommandLine.Option(names = {"-s", "--symmetric"}, description = "Calculates symmetric closure on provided matrix", defaultValue = "false")
    boolean isSymmetric;

    @CommandLine.Option(names = {"-t", "--transitive"}, description = "Calculates transitive closure on provided matrix", defaultValue = "false")
    boolean isTransitive;

    @CommandLine.Option(names = "--all", description = "Calculates all closures on provided matrix", defaultValue = "false")
    boolean isAll;

    @Inject
    public ClosureCommand(
            IMatrixReader matrixReader,
            IMatrixWriter matrixWriter,
            IValidator validator,
            IReflexiveClosurer reflexiveClosurer,
            ISymmetricClosurer symmetricClosurer,
            ITransitiveClosurer transitiveClosurer
    )
    {
        this.matrixReader = matrixReader;
        this.matrixWriter = matrixWriter;
        this.validator = validator;
        this.reflexiveClosurer = reflexiveClosurer;
        this.symmetricClosurer = symmetricClosurer;
        this.transitiveClosurer = transitiveClosurer;
    }

    @Override
    public Integer call() throws Exception
    {
        if (isAll)
        {
            isReflexive = true;
            isSymmetric = true;
            isTransitive = true;
        }

        int[][] matrix;
        try
        {
            matrix = this.matrixReader.read(this.filename);
            this.validator.validate(matrix);
        } catch (NumberFormatException | IOException | CsvException | InvalidRelationException e)
        {
            throw new CommandLine.ParameterException(spec.commandLine(), e.getMessage());
        }

        if (this.isReflexive)
        {
            System.out.println("Reflexive closure:");
            int[][] reflexiveMatrix = reflexiveClosurer.calculate(matrix);
            matrixWriter.write(reflexiveMatrix, fileWriteName);
            System.out.println();
        }
        if (this.isSymmetric)
        {
            System.out.println("Symmetric closure:");
            int[][] symmetricMatrix = symmetricClosurer.calculate(matrix);
            matrixWriter.write(symmetricMatrix, fileWriteName);
            System.out.println();
        }
        if (this.isTransitive)
        {
            System.out.println("Transitive closure:");
            int[][] transitiveMatrix = transitiveClosurer.calculate(matrix);
            matrixWriter.write(transitiveMatrix, fileWriteName);
            System.out.println();
        }

        return 0;
    }
}
