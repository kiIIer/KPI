package Main.StudentFilter;

import MyClasses.Abstract.IStudent;
import MyClasses.Hash.ComparatorConfiguration;

import java.util.Collection;
import java.util.Iterator;

/**
 * Filters students.
 */
public interface IStudentsFilterHash
{
    /**
     * Filters students using advancedComparator and configuration provided to it.
     *
     * @param iterator      Iterator on institutes to be filtered.
     * @param grade         Grade to which students will be compared to.
     * @param configuration Configuration of filter. It is Integer pair which is used in advancedComparator to filter students.
     * @return Collection with HashSet as a base, containing filtered students.
     */
    Collection<IStudent> get(Iterator<IStudent> iterator, int grade, ComparatorConfiguration configuration);
}
