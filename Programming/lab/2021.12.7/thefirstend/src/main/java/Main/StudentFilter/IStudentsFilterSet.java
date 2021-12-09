package Main.StudentFilter;

import MyClasses.Abstract.IStudent;

import java.util.Collection;
import java.util.Iterator;

/**
 * Filters students.
 */
public interface IStudentsFilterSet
{
    /**
     * Filters students, using gradeComparator and binary representation of filter type.
     * It runs disjunction on binary representation of comparisonType provided,
     * and according to disjunction runs defined comparator searched. Filters students who passed the check.
     *
     * @param iterator    Iterator on students desired to be filtered.
     * @param compareTo   Grade, students will be compared to.
     * @param compareType Binary representation of comparison checks. Uses ComparisonType to translate binaries to actions.
     * @return Collection of students who passed of check. TreeSet inside.
     */
    Collection<IStudent> get(Iterator<IStudent> iterator, int compareTo, int compareType);
}
