package MyClasses.Hash;

import MyClasses.Abstract.IDepartment;

import java.util.Comparator;

/**
 * Comparator which compared 2 departments by number of their students.
 */
public interface IStudentsNumberComparator extends Comparator<IDepartment>
{
    /**
     * Compares its two arguments for order.
     *
     * @param o1 The first department to be compared.
     * @param o2 The second department to be compared.
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     */
    int compare(IDepartment o1, IDepartment o2);
}
