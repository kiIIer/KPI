package Main.Tools;

import MyClasses.Abstract.IStudent;

import java.util.Collection;

public interface IStudentFinder
{
    IStudent find(String gradeBookId, Collection<IStudent> students);
}
