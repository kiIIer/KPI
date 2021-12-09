package Main.StudentsCounter;

import MyClasses.Abstract.IInstitute;

/**
 * Counts students in provided institute.
 */
public interface IStudentsCounter
{
    /**
     * Counts student in all departments in provided institute.
     *
     * @param institute Institute with students to be counted.
     * @return Number of students in institute.
     */
    int count(IInstitute institute);
}
