package Main;

import Commands.*;
import com.google.inject.AbstractModule;

public class ProgramModule extends AbstractModule
{
    @Override
    public void configure()
    {
        bind(IProgram.class).to(Program.class);
        bind(ICLIBuilder.class).to(CLIBuilder.class);

        bind(IAppCommand.class).to(AppCommand.class);
        bind(IGraphCheckCommand.class).to(GraphCheckCommand.class);
        bind(ICalculateTreeCommand.class).to(CalculateTreeCommand.class);
        bind(IShowTreeCommand.class).to(ShowTreeCommand.class);
        bind(IPostfixTableCommand.class).to(PostfixTableCommand.class);
        bind(IPrefixTableCommand.class).to(PrefixTableCommand.class);
    }
}
