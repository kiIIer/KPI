package Main.Tools;

import MyClasses.Abstract.IStudent;
import MyClasses.List.Student;

public class StudentCreator implements IStudentCreator
{
    @Override
    public IStudent create(String name, String surname, String gradeBookId, int grade, DataType dataType)
    {
        switch (dataType)
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
