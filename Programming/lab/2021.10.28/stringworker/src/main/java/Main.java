import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main
{
    public static void main(String[] args)
    {
        Injector injector = Guice.createInjector(new ProgramModule());
        IProgram program = injector.getInstance(IProgram.class);
        program.execute(args);

        var a = new Human();
        var b = new Human();
        a.equals(b)
    }
}
