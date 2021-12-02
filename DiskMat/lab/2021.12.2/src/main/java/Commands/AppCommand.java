package Commands;

import picocli.CommandLine;

@CommandLine.Command(name = "bool", description = "Performs different operations and checks on boolean functions(with 3 vars) provided via tuple.")
public class AppCommand implements IAppCommand
{
    @Override
    public Integer call() throws Exception
    {
        System.out.println("Hello, I am Mike, I made this app at night with quite huge coffee consumption, because I have a lot of work to do and deadlines are deadly(quite obvious oneXD). It is 3AM and I am only starting to write code for command classes. I am tired, I have headache and slightly increased temperature(38C). Anyway, code for this program is just huge trash can, so please don't ruin your day by looking at it. If you are Mr. Tsymbal, have a nice day and I hope you find yourself in a lot of happy moments in this pleasant day. May the virus protection be on your side <3");
        return 0;
    }
}
