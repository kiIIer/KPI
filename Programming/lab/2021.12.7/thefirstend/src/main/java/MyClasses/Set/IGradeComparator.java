package MyClasses.Set;

import MyClasses.Abstract.IStudent;

import java.util.Comparator;

/**
 * Comparator which compares students by their grade.
 */
public interface IGradeComparator extends Comparator<IStudent>
{
    /**
     * Compares its two arguments for order.
     *
     * @param o1 The first student to be compared.
     * @param o2 The second student to be compared.
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     */
    @Override
    int compare(IStudent o1, IStudent o2);
}
