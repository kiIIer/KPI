package Main.Tools.MyClasses;

import Main.Tools.CollectionType;
import MyClasses.Abstract.IStudent;
import MyClasses.List.Student;

public class StudentCreator implements IStudentCreator
{
    @Override
    public IStudent create(String name, String surname, String gradeBookId, int grade, CollectionType collectionType)
    {
        switch (collectionType)
        {
            case LIST -> {
                Student student = new Student();
                student.setName(name);
                student.setSurname(surname);
                student.setGradeBookId(gradeBookId);
                student.setGrade(grade);
                return student;
            }
            case TREESET -> {
                MyClasses.Set.Student student = new MyClasses.Set.Student();
                student.setName(name);
                student.setSurname(surname);
                student.setGradeBookId(gradeBookId);
                student.setGrade(grade);
                return student;
            }
            case HASHSET -> {
                MyClasses.Hash.Student student = new MyClasses.Hash.Student();
                student.setName(name);
                student.setSurname(surname);
                student.setGradeBookId(gradeBookId);
                student.setGrade(grade);
                return student;
            }
            default -> {
                return null;
            }
        }

    }
}
