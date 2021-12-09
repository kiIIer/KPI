package Main.Tools.MyClasses;

import MyClasses.Abstract.IStudent;

import java.util.Collection;

/**
 * Used to find students.
 */
public interface IStudentFinder
{
    /**
     * Searches student in collection by gradeBookId and returns found student. Has O(n).
     *
     * @param gradeBookId GradeBookId of student desired to be found.
     * @param students    Collection of students to look in.
     * @return Found student.
     */
    IStudent find(String gradeBookId, Collection<IStudent> students);
}
