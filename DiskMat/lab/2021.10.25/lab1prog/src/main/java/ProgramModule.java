import Commands.AppCommand;
import Commands.IAppCommand;
import Tools.*;
import com.google.inject.AbstractModule;

public class ProgramModule extends AbstractModule
{
    @Override
    public void configure(){
        bind(IProgram.class).to(Program.class);
        bind(ICLIInitializer.class).to(CLIInitializer.class);
        bind(IAppCommand.class).to(AppCommand.class);
        bind(IBitTranslator.class).to(BitTranslator.class);
        bind(IUnioner.class).to(Unioner.class);
        bind(IIntersectioner.class).to(Intersectioner.class);
    }
}
