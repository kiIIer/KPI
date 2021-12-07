package Main.StudentFilter;

import MyClasses.Abstract.IStudent;
import MyClasses.Hash.ComparatorConfiguration;

import java.util.Collection;
import java.util.Iterator;

public interface IStudentsFilterHash
{
    Collection<IStudent> get(Iterator<IStudent> iterator, int grade, ComparatorConfiguration configuration);
}
