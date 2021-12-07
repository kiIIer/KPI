package Main;

import Commands.*;
import com.google.inject.Inject;
import picocli.CommandLine;

public class CLIBuilder implements ICLIBuilder
{
    private final IAppCommand appCommand;
    private final IShowCommand showCommand;
    private final IShowStudentCommand showStudentCommand;
    private final IShowDepartmentCommand showDepartmentCommand;
    private final IShowInstituteCommand showInstituteCommand;
    private final IAddCommand addCommand;
    private final IAddStudentCommand addStudentCommand;
    private final IAddDepartmentCommand addDepartmentCommand;
    private final IRemoveCommand removeCommand;
    private final IRemoveStudentCommand removeStudentCommand;
    private final IRemoveDepartmentCommand removeDepartmentCommand;
    private final IFindCommand findCommand;
    private final IStudentsCounterCommand studentsCounterCommand;
    private final IStudentsFilterCommand studentsFilterCommand;

    @Inject
    public CLIBuilder(
            IAppCommand appCommand,
            IShowCommand showCommand,
            IShowStudentCommand showStudentCommand,
            IShowDepartmentCommand showDepartmentCommand,
            IShowInstituteCommand showInstituteCommand,
            IAddCommand addCommand,
            IAddStudentCommand addStudentCommand,
            IAddDepartmentCommand addDepartmentCommand,
            IRemoveCommand removeCommand,
            IRemoveStudentCommand removeStudentCommand,
            IRemoveDepartmentCommand removeDepartmentCommand,
            IFindCommand findCommand,
            IStudentsCounterCommand studentsCounterCommand,
            IStudentsFilterCommand studentsFilterCommand
    )
    {
        this.appCommand = appCommand;
        this.showCommand = showCommand;
        this.showStudentCommand = showStudentCommand;
        this.showDepartmentCommand = showDepartmentCommand;
        this.showInstituteCommand = showInstituteCommand;
        this.addCommand = addCommand;
        this.addStudentCommand = addStudentCommand;
        this.addDepartmentCommand = addDepartmentCommand;
        this.removeCommand = removeCommand;
        this.removeStudentCommand = removeStudentCommand;
        this.removeDepartmentCommand = removeDepartmentCommand;
        this.findCommand = findCommand;
        this.studentsCounterCommand = studentsCounterCommand;
        this.studentsFilterCommand = studentsFilterCommand;
    }

    @Override
    public CommandLine build()
    {
        CommandLine commandLine = new CommandLine(appCommand);

        CommandLine show = new CommandLine(showCommand);
        show.addSubcommand(showStudentCommand);
        show.addSubcommand(showDepartmentCommand);
        show.addSubcommand(showInstituteCommand);

        CommandLine add = new CommandLine(addCommand);
        add.addSubcommand(addStudentCommand);
        add.addSubcommand(addDepartmentCommand);

        CommandLine remove = new CommandLine(removeCommand);
        remove.addSubcommand(removeStudentCommand);
        remove.addSubcommand(removeDepartmentCommand);

        commandLine.addSubcommand(CommandLine.HelpCommand.class);
        commandLine.addSubcommand(show);
        commandLine.addSubcommand(add);
        commandLine.addSubcommand(remove);
        commandLine.addSubcommand(findCommand);
        commandLine.addSubcommand(studentsCounterCommand);
        commandLine.addSubcommand(studentsFilterCommand);

        return commandLine;
    }
}
