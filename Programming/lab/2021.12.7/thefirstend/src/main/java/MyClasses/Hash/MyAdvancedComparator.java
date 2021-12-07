package MyClasses.Hash;

import MyClasses.Abstract.IStudent;
import com.google.inject.Inject;

public class MyAdvancedComparator implements IMyAdvancedComparator
{

    private final IGradeComparator gradeComparator;

    @Inject
    public MyAdvancedComparator(
            IGradeComparator gradeComparator
    )
    {
        this.gradeComparator = gradeComparator;
    }

    @Override
    public boolean compare(IStudent student, int grade, ComparatorConfiguration configuration)
    {
        Student fakeStudent = new Student();
        fakeStudent.setGrade(grade);

        return Integer.compare(gradeComparator.compare(student, fakeStudent), configuration.a) == configuration.b;
    }
}
