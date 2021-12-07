package Main.StudentFilter;

import MyClasses.Abstract.IStudent;

import java.util.Collection;
import java.util.Iterator;

public interface IStudentsFilterSet
{
    Collection<IStudent> get(Iterator<IStudent> iterator, int compareTo, int compareType);
}
