import Tools.IIntToHexer;
import Tools.INumberOfWordser;
import Tools.IntToHexer;
import Tools.NumberOfWordser;
import com.google.inject.AbstractModule;

public class ProgramModule extends AbstractModule
{
    @Override
    public void configure()
    {
        bind(IProgram.class).to(Program.class);
        bind(ICLIInitializer.class).to(CLIInitializer.class);
        bind(IIntToHexer.class).to(IntToHexer.class);
        bind(INumberOfWordser.class).to(NumberOfWordser.class);
    }
}
