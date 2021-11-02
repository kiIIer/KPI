import Commands.*;
import com.google.inject.Inject;
import picocli.CommandLine;

public class CLIInitializer implements ICLIInitializer
{
    private final IAppCommand appCommand;
    private final UnionCommand unionCommand;
    private final ShowCommand showCommand;
    private final IntersectionCommand intersectionCommand;
    private final DifferenceCommand differenceCommand;
    private final ComplementCommand complementCommand;
    private final SymetricDifferenceCommand symetricDifferenceCommand;
    private final EqualCommand equalCommand;
    private final SubsetCommand subsetCommand;
    private final CartesianProductCommand cartesianProductCommand;

    @Inject
    public CLIInitializer(
            IAppCommand appCommand,
            UnionCommand unionCommand,
            ShowCommand showCommand,
            IntersectionCommand intersectionCommand,
            DifferenceCommand differenceCommand,
            ComplementCommand complementCommand,
            SymetricDifferenceCommand symetricDifferenceCommand,
            EqualCommand equalCommand,
            SubsetCommand subsetCommand,
            CartesianProductCommand cartesianProductCommand
    )
    {
        this.appCommand = appCommand;
        this.unionCommand = unionCommand;
        this.showCommand = showCommand;
        this.intersectionCommand = intersectionCommand;
        this.differenceCommand = differenceCommand;
        this.complementCommand = complementCommand;
        this.symetricDifferenceCommand = symetricDifferenceCommand;
        this.equalCommand = equalCommand;
        this.subsetCommand = subsetCommand;
        this.cartesianProductCommand = cartesianProductCommand;
    }

    public CommandLine initialize()
    {
        CommandLine commandLine = new CommandLine(appCommand);

        commandLine.addSubcommand(CommandLine.HelpCommand.class);
        commandLine.addSubcommand("union", this.unionCommand);
        commandLine.addSubcommand("intersection", this.intersectionCommand);
        commandLine.addSubcommand("difference", this.differenceCommand);
        commandLine.addSubcommand("complement", this.complementCommand);
        commandLine.addSubcommand("symmetric-difference", this.symetricDifferenceCommand);
        commandLine.addSubcommand("show", this.showCommand);
        commandLine.addSubcommand("equal", this.equalCommand);
        commandLine.addSubcommand("subset", this.subsetCommand);
        commandLine.addSubcommand("cartesian-product", this.cartesianProductCommand);

        return commandLine;
    }
}
