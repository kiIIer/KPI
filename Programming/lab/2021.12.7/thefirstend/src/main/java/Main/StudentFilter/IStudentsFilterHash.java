package Main.StudentFilter;

import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;
import MyClasses.Hash.ComparatorConfiguration;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public interface IStudentsFilterHash
{
    Collection<IStudent> get(Iterator<IStudent> iterator, int grade, ComparatorConfiguration configuration);
}
