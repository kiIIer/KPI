package Main;

import Commands.*;
import com.google.inject.Inject;
import picocli.CommandLine;

public class CLIBuilder implements ICLIBuilder
{
    private final IAppCommand appCommand;
    private final IDualityCommand dualityCommand;
    private final ITruthTableCommand truthTableCommand;
    private final IZhegalkinPolynomialCommand zhegalkinPolynomialCommand;
    private final ICCNFCommand ccnfCommand;
    private final ICDNFCommand cdnfCommand;
    private final ICheckCommand checkCommand;

    @Inject
    public CLIBuilder(
            IAppCommand appCommand,
            IDualityCommand dualityCommand,
            ITruthTableCommand truthTableCommand,
            IZhegalkinPolynomialCommand zhegalkinPolynomialCommand,
            ICCNFCommand ccnfCommand,
            ICDNFCommand cdnfCommand,
            ICheckCommand checkCommand
    )
    {
        this.appCommand = appCommand;
        this.dualityCommand = dualityCommand;
        this.truthTableCommand = truthTableCommand;
        this.zhegalkinPolynomialCommand = zhegalkinPolynomialCommand;
        this.ccnfCommand = ccnfCommand;
        this.cdnfCommand = cdnfCommand;
        this.checkCommand = checkCommand;
    }

    @Override
    public CommandLine build()
    {
        var commandLine = new CommandLine(appCommand);

        commandLine.addSubcommand(CommandLine.HelpCommand.class);
        commandLine.addSubcommand(dualityCommand);
        commandLine.addSubcommand(truthTableCommand);
        commandLine.addSubcommand(zhegalkinPolynomialCommand);
        commandLine.addSubcommand(ccnfCommand);
        commandLine.addSubcommand(cdnfCommand);
        commandLine.addSubcommand(checkCommand);

        return commandLine;
    }
}
