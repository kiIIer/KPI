package MyClasses.Abstract;

/**
 * Abstract representation of all students. Unique factor: GradeBookID.
 */
public interface IStudent
{
    /**
     * Getter
     *
     * @return The name of this student.
     */
    public String getName();

    /**
     * Getter
     *
     * @return The surname of this student.
     */
    public String getSurname();

    /**
     * Getter
     *
     * @return The grade book id of this student.
     */
    public String getGradeBookId();

    /**
     * Getter
     *
     * @return The grade of this student.
     */
    public int getGrade();
}
