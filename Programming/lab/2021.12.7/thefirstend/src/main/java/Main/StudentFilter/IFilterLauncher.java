package Main.StudentFilter;

import Main.Tools.FilterSettings;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;

import java.util.Collection;

public interface IFilterLauncher
{
    public Collection<IStudent> launch(IInstitute institute, FilterSettings settings);
}
