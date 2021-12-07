package Main.Tools;

import MyClasses.Abstract.IStudent;

public interface IStudentCreator
{
    IStudent create(String name, String surname, String gradeBookId, int grade, DataType dataType);
}
