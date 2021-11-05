package Commands;

import Tools.*;
import com.google.inject.Inject;
import com.opencsv.exceptions.CsvException;
import picocli.CommandLine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "composition", description = "Calculates composition of provided relation")
public class CompositionCommand implements ICompositionCommand
{
    private final IMatrixReader matrixReader;
    private final IMatrixWriter matrixWriter;
    private final IValidator validator;
    private final IRelationComposer relationComposer;
    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @CommandLine.Option(names = {"-n", "--power"}, description = "Power of composition to be calculated", required = true)
    public void setPower(int power)
    {
        if (power <= 0)
        {
            throw new CommandLine.ParameterException(spec.commandLine(), "Power below 1 cannot be calculated!");
        }
        this.power = power;
    }

    @CommandLine.Option(names = {"-w", "--write"}, description = "File to be written to. Default is /dev/stdout", defaultValue = "/dev/stdout")
    String fileWriteName;

    @CommandLine.Option(names = {"-f", "--file"}, description = "File with a matrix to be read", required = true)
    String filename;

    private int power;

    @Inject
    public CompositionCommand(
            IMatrixReader matrixReader,
            IMatrixWriter matrixWriter,
            IValidator validator,
            IRelationComposer relationComposer
    )
    {
        this.matrixReader = matrixReader;
        this.matrixWriter = matrixWriter;
        this.validator = validator;
        this.relationComposer = relationComposer;
    }

    @Override
    public Integer call() throws Exception
    {
        int[][] matrix;
        try
        {
            matrix = this.matrixReader.read(this.filename);
            this.validator.validate(matrix);
        } catch (NumberFormatException | IOException | CsvException | InvalidRelationException e)
        {
            throw new CommandLine.ParameterException(spec.commandLine(), e.getMessage());
        }

        int[][] composition = matrix.clone();

        for (int i = 1; i < this.power; i++)
        {
            composition = relationComposer.compose(composition, matrix);
        }


        this.matrixWriter.write(composition, fileWriteName);

        return CommandLine.ExitCode.OK;
    }
}
