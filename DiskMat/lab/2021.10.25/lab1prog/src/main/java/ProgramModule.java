import Commands.AppCommand;
import Commands.IAppCommand;
import Tools.*;
import com.google.inject.AbstractModule;

public class ProgramModule extends AbstractModule
{
    @Override
    public void configure()
    {
        bind(IProgram.class).to(Program.class);
        bind(ICLIInitializer.class).to(CLIInitializer.class);
        bind(IAppCommand.class).to(AppCommand.class);
        bind(IUnioner.class).to(Unioner.class);
        bind(IIntersectioner.class).to(Intersectioner.class);
        bind(IDifferencer.class).to(Differencer.class);
        bind(IComplementer.class).to(Complementer.class);
        bind(ISymetricDifferencer.class).to(SymetricDifferencer.class);
        bind(IEqualer.class).to(Equaler.class);
        bind(ISubseter.class).to(Subseter.class);
        bind(ICartesianProducter.class).to(CartesianProducter.class);
    }
}
