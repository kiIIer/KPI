package Main;

import Root.ToolsModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main
{
    public static void main(String[] args)
    {
        Injector injector = Guice.createInjector(new ProgramModule(), new ToolsModule());
        IProgram program = injector.getInstance(IProgram.class);
        program.run(args);
    }
}
