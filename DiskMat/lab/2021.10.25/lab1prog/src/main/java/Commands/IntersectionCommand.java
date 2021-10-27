package Commands;

import picocli.CommandLine;

@CommandLine.Command(name = "intersection", description = "Calculates the intersection of provided sets")
public class IntersectionCommand
{
    @CommandLine.ParentCommand
    AppCommand parent;



}
