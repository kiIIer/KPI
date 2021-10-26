import Commands.AppCommand;
import Commands.IAppCommand;
import Tools.BitTranslator;
import Tools.IBitTranslator;
import com.google.inject.AbstractModule;

public class ProgramModule extends AbstractModule
{
    @Override
    public void configure(){
        bind(IProgram.class).to(Program.class);
        bind(ICLIInitializer.class).to(CLIInitializer.class);
        bind(IAppCommand.class).to(AppCommand.class);
        bind(IBitTranslator.class).to(BitTranslator.class);
    }
}
