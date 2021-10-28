package Commands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "strings", description = "Program capable of performing different operations on strings")
public class AppCommand implements Callable<Integer>
{
    @Override
    public Integer call() throws Exception
    {
        System.out.println("Hello, I am a program. Run 'help' command to see help. Mr. Evgeniy please don't judge me too hard °^°");
        return 0;
    }
}
