package Main.Tools;

import MyClasses.Abstract.IStudent;

import java.util.Collection;
import java.util.Objects;

public class StudentFinder implements IStudentFinder
{
    @Override
    public IStudent find(String gradeBookId, Collection<IStudent> students)
    {
        for (IStudent student :
                students)
        {
            if (Objects.equals(gradeBookId, student.getGradeBookId()))
            {
                return student;
            }
        }
        return null;
    }
}
