package MyClasses.Hash;

import MyClasses.Abstract.IStudent;

/**
 * Advanced comparator, capable of telling whether student's grade meets requirements.
 */
public interface IMyAdvancedComparator
{
    /**
     * Compares provided student with provided grade using provided configuration.
     *
     * @param student       Studnet to be compared.
     * @param grade         Grade to be compared to.
     * @param configuration Configuration of comparison(equal, grater of equal...).
     * @return Whether student meets requirements.
     */
    boolean compare(IStudent student, int grade, ComparatorConfiguration configuration);
}
