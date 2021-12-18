package Commands;

import CSV.IMatrixReader;
import Definer.IGraphDefiner;
import Validators.IGraphValidator;
import com.opencsv.exceptions.CsvException;
import picocli.CommandLine;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "check-graph", description = "Checks whether graph is oriented or not. Needs matrix provided as csv file")
public class GraphCheckCommand implements IGraphCheckCommand
{
    @CommandLine.Option(names = {"-f", "--filename"}, description = "Filename of a file with matrix", required = true)
    String filename;
    private IMatrixReader matrixReader;
    private IGraphValidator validator;
    private IGraphDefiner definer;

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @Inject
    public GraphCheckCommand(
            IMatrixReader matrixReader,
            IGraphValidator validator,
            IGraphDefiner definer
    )
    {
        this.matrixReader = matrixReader;
        this.validator = validator;
        this.definer = definer;
    }

    @Override
    public Integer call() throws CommandLine.ParameterException
    {
        int[][] matrix;
        try
        {
            matrix = matrixReader.read(filename);
        } catch (IOException | CsvException e)
        {
            throw new CommandLine.ParameterException(spec.commandLine(), e.getMessage());
        }

        if (!validator.isValid(matrix))
        {
            throw new CommandLine.ParameterException(spec.commandLine(), "Not valid matrix!");
        }

        if (definer.defineOriented(matrix))
        {
            System.out.println("Graph is oriented!");
        } else
        {
            System.out.println("Graph may be either oriented or not oriented!");
        }

        return CommandLine.ExitCode.OK;
    }
}
