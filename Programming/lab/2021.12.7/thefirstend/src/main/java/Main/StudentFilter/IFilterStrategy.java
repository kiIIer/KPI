package Main.StudentFilter;

import Main.Tools.DataType;
import Main.Tools.FilterSettings;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;

import java.util.Collection;

public interface IFilterStrategy
{
    Collection<IStudent> get(IInstitute institute, FilterSettings settings, DataType dataType);
}
