package Main.Tools.MyClasses;

import Main.Tools.CollectionType;
import MyClasses.Abstract.IStudent;

/**
 * Creates Students.
 */
public interface IStudentCreator
{
    /**
     * Creates student using provided parameters. The type of student is defined by collection type.
     * @param name Name of student to be created.
     * @param surname Surname  of student to be created.
     * @param gradeBookId GradeBookId  of student to be created.
     * @param grade Grade of student to be created.
     * @param collectionType Type of student desired to be created.
     * @return Created student.
     */
    IStudent create(String name, String surname, String gradeBookId, int grade, CollectionType collectionType);
}
