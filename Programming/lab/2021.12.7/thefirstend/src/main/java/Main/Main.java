package Main;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * The root of the project.
 */
public class Main
{
    /**
     * Called when project is started.
     * Creates injector from module, gets instance of program and executes it.
     * @param args command line arguments given to app
     * @throws Exception this exception will be thrown in case something goes wrong and app didn't expect it. If app works properly it will not be thrown.
     */
    public static void main(String[] args) throws Exception
    {
        Injector injector = Guice.createInjector(new ProgramModule());
        IProgram program = injector.getInstance(IProgram.class);
        program.execute(args);
    }
}
