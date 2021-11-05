package Commands;

import Tools.*;
import Tools.Checks.*;
import com.google.inject.Inject;
import com.opencsv.exceptions.CsvException;
import picocli.CommandLine;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@CommandLine.Command(name = "check", description = "Check properties of provided relation")
public class CheckCommand implements ICheckCommand
{
    private final Map<Integer, IPropertyChecker> propertyCheckers;
    private final Map<Integer, String> propertyName;
    private final IMatrixReader matrixReader;
    private final IValidator validator;

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @CommandLine.Option(names = {"-r", "--reflexive"}, description = "Checks whether provided relation is reflexive", defaultValue = "false")
    public void addReflexiveCheck(boolean flag)
    {
        this.checks |= flag ? Checks.reflexive : Checks.none;
    }

    @CommandLine.Option(names = {"-R", "--irreflexive"}, description = "Checks whether provided relation is irreflexive", defaultValue = "false")
    public void addIrreflexiveCheck(boolean flag)
    {
        this.checks |= flag ? Checks.irreflexive : Checks.none;
    }

    @CommandLine.Option(names = {"-s", "--symmetric"}, description = "Checks whether provided relation is symmetric", defaultValue = "false")
    public void addSymmetric(boolean flag)
    {
        this.checks |= flag ? Checks.symmetric : Checks.none;
    }

    @CommandLine.Option(names = {"-S", "--antisymmetric"}, description = "Checks whether provided relation is antisymmetric", defaultValue = "false")
    public void addAntiSymmetric(boolean flag)
    {
        this.checks |= flag ? Checks.antiSymmetric : Checks.none;
    }

    @CommandLine.Option(names = {"-a", "--asymmetric"}, description = "Checks whether provided relation is asymmetric", defaultValue = "false")
    public void addAsymmetric(boolean flag)
    {
        this.checks |= flag ? Checks.asymmetric : Checks.none;
    }

    @CommandLine.Option(names = {"-t", "--transitive"}, description = "Checks whether provided relation is transitive", defaultValue = "false")
    public void addTransitive(boolean flag)
    {
        this.checks |= flag ? Checks.transitive : Checks.none;
    }

    @CommandLine.Option(names = {"-T", "--antitransitive"}, description = "Checks whether provided relation is antitransitive", defaultValue = "false")
    public void addAntiTransitive(boolean flag)
    {
        this.checks |= flag ? Checks.antiTransitive : Checks.none;
    }

    @CommandLine.Option(names = {"--all"}, description = "Runs all checks on provided relation", defaultValue = "false")
    public void addAll(boolean flag)
    {
        this.checks |= flag ? Checks.all : Checks.none;
    }

    @CommandLine.Option(names = {"-e", "--equivalence"}, description = "Checks whether provided relation is equivalence", defaultValue = "false")
    public void addEquivalence(boolean flag)
    {
        this.checks |= flag ? Checks.equivalence : Checks.none;
    }

    @CommandLine.Option(names = {"-p", "--partial"}, description = "Checks whether provided relation is partial order", defaultValue = "false")
    public void addPartial(boolean flag)
    {
        this.checks |= flag ? Checks.partialOrder : Checks.none;
    }

    @CommandLine.Option(names = {"-o", "--strict"}, description = "Checks whether provided relation is strict order", defaultValue = "false")
    public void addStrict(boolean flag)
    {
        this.checks |= flag ? Checks.strictOrder : Checks.none;
    }

    @CommandLine.Option(names = {"-f", "--file"}, description = "File with a matrix to be read", required = true)
    String filename;


    @Inject
    public CheckCommand(
            IMatrixReader matrixReader,
            IValidator validator,
            IReflexivePropertyChecker reflexivePropertyChecker,
            IIrreflexivePropertyChecker irreflexivePropertyChecker,
            ISymmetricPropertyChecker symmetricPropertyChecker,
            IAntiSymmetricPropertyChecker antiSymmetricPropertyChecker,
            IAsymmetricPropertyChecker asymmetricPropertyChecker,
            ITransitivePropertyChecker transitivePropertyChecker,
            IAntiTransitivePropertyChecker antiTransitivePropertyChecker,
            IEquivalencePropertyChecker equivalencePropertyChecker,
            IPartialOrderPropertyChecker partialOrderPropertyChecker,
            IStrictOrderPropertyChecker strictOrderPropertyChecker
    )
    {
        this.matrixReader = matrixReader;
        this.validator = validator;

        Map<Integer, IPropertyChecker> propertyCheckers = new HashMap<>();
        Map<Integer, String> propertyName = new HashMap<>();

        propertyCheckers.put(Checks.reflexive, reflexivePropertyChecker);
        propertyName.put(Checks.reflexive, "Reflexive");
        propertyCheckers.put(Checks.irreflexive, irreflexivePropertyChecker);
        propertyName.put(Checks.irreflexive, "Irreflexive");
        propertyCheckers.put(Checks.symmetric, symmetricPropertyChecker);
        propertyName.put(Checks.symmetric, "Symmetric");
        propertyCheckers.put(Checks.antiSymmetric, antiSymmetricPropertyChecker);
        propertyName.put(Checks.antiSymmetric, "AntiSymmetric");
        propertyCheckers.put(Checks.asymmetric, asymmetricPropertyChecker);
        propertyName.put(Checks.asymmetric, "Asymmetric");
        propertyCheckers.put(Checks.transitive, transitivePropertyChecker);
        propertyName.put(Checks.transitive, "Transitive");
        propertyCheckers.put(Checks.antiTransitive, antiTransitivePropertyChecker);
        propertyName.put(Checks.antiTransitive, "AntiTransitive");
        propertyCheckers.put(Checks.equivalence, equivalencePropertyChecker);
        propertyName.put(Checks.equivalence, "Equivalence");
        propertyCheckers.put(Checks.partialOrder, partialOrderPropertyChecker);
        propertyName.put(Checks.partialOrder, "PartialOrder");
        propertyCheckers.put(Checks.strictOrder, strictOrderPropertyChecker);
        propertyName.put(Checks.strictOrder, "StrictOrder");

        this.propertyCheckers = propertyCheckers;
        this.propertyName = propertyName;
    }

    int checks = Checks.none;

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

        for (Integer binary :
                this.propertyCheckers.keySet())
        {
            if ((this.checks & binary) == binary)
            {
                System.out.printf("%s: %s%n", this.propertyName.get(binary), propertyCheckers.get(binary).check(matrix));
            }
        }

        return CommandLine.ExitCode.OK;
    }
}
