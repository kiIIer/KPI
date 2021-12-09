package Main;

import Commands.*;
import Main.FileWorker.CheckSummer;
import Main.FileWorker.FirstLongestStringFinder;
import Main.FileWorker.ICheckSummer;
import Main.FileWorker.IFirstLongestStringFinder;
import Main.Finder.*;
import Main.StudentFilter.*;
import Main.StudentsCounter.*;
import Main.Tools.MyClasses.*;
import Main.Tools.Printers.*;
import Main.Tools.Yaml.IYamlReader;
import Main.Tools.Yaml.IYamlWriter;
import Main.Tools.Yaml.YamlReader;
import Main.Tools.Yaml.YamlWriter;
import MyClasses.Hash.IMyAdvancedComparator;
import MyClasses.Hash.MyAdvancedComparator;
import MyClasses.Set.*;
import com.google.inject.AbstractModule;

public class ProgramModule extends AbstractModule
{
    @Override
    public void configure()
    {
        bind(IProgram.class).to(Program.class);

        bind(ICLIBuilder.class).to(CLIBuilder.class);

        bind(IAppCommand.class).to(AppCommand.class);
        bind(IShowCommand.class).to(ShowCommand.class);
        bind(IShowStudentCommand.class).to(ShowStudentCommand.class);
        bind(IShowDepartmentCommand.class).to(ShowDepartmentCommand.class);
        bind(IShowInstituteCommand.class).to(ShowInstituteCommand.class);
        bind(IAddCommand.class).to(AddCommand.class);
        bind(IAddStudentCommand.class).to(AddStudentCommand.class);
        bind(IAddDepartmentCommand.class).to(AddDepartmentCommand.class);
        bind(IRemoveCommand.class).to(RemoveCommand.class);
        bind(IRemoveStudentCommand.class).to(RemoveStudentCommand.class);
        bind(IRemoveDepartmentCommand.class).to(RemoveDepartmentCommand.class);
        bind(IFindCommand.class).to(FindCommand.class);
        bind(IStudentsCounterCommand.class).to(StudentsCounterCommand.class);
        bind(IStudentsFilterCommand.class).to(StudentsFilterCommand.class);
        bind(ICheckSummerCommand.class).to(CheckSummerCommand.class);
        bind(IFirstLongestCommand.class).to(FirstLongestCommand.class);

        bind(IYamlReader.class).to(YamlReader.class);
        bind(IDepartmentFinder.class).to(DepartmentFinder.class);
        bind(IStudentFinder.class).to(StudentFinder.class);
        bind(IStudentPrinter.class).to(StudentPrinter.class);
        bind(IDepartmentPrinter.class).to(DepartmentPrinter.class);
        bind(IStudentCreator.class).to(StudentCreator.class);
        bind(IYamlWriter.class).to(YamlWriter.class);
        bind(IInstitutePrinter.class).to(InstitutePrinter.class);
        bind(IDepartmentCreator.class).to(DepartmentCreator.class);
        bind(IFinderList.class).to(FinderList.class);
        bind(IFinderSet.class).to(FinderSet.class);
        bind(IFinderHash.class).to(FinderHash.class);
        bind(IStudentsNumberComparator.class).to(StudentsNumberComparator.class);
        bind(IStudentsCounterList.class).to(StudentsCounterList.class);
        bind(IStudentsCounterSet.class).to(StudentsCounterSet.class);
        bind(IStudentsCounterHash.class).to(StudentsCounterHash.class);
        bind(IFilterStrategy.class).to(FilterStrategy.class);
        bind(IFilterListLauncher.class).to(FilterListLauncher.class);
        bind(IFilterTreeLauncher.class).to(FilterTreeLauncher.class);
        bind(IFilterHashLauncher.class).to(FilterHashLauncher.class);
        bind(IStudentsFilterList.class).to(StudentsFilterList.class);
        bind(IStudentsFilterSet.class).to(StudentsFilterSet.class);
        bind(IStudentsFilterHash.class).to(StudentsFilterHash.class);
        bind(IMyAdvancedComparator.class).to(MyAdvancedComparator.class);
        bind(IGradeComparator.class).to(GradeComparator.class);
        bind(MyClasses.Hash.IGradeComparator.class).to(MyClasses.Hash.GradeComparator.class);
        bind(ICheckSummer.class).to(CheckSummer.class);
        bind(IFirstLongestStringFinder.class).to(FirstLongestStringFinder.class);
        bind(IValidator.class).to(Validator.class);
        bind(IExceptionPrinter.class).to(ExceptionPrinter.class);
    }
}
