package MyClasses.Hash;

import MyClasses.Abstract.IStudent;
import com.google.common.base.Objects;

public class Student implements IStudent
{
    private String name;
    private String surname;
    private String gradeBookId;
    private int grade;

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public void setGradeBookId(String gradeBookId)
    {
        this.gradeBookId = gradeBookId;
    }

    public void setGrade(int grade)
    {
        this.grade = grade;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public String getSurname()
    {
        return this.surname;
    }

    @Override
    public String getGradeBookId()
    {
        return this.gradeBookId;
    }

    @Override
    public int getGrade()
    {
        return this.grade;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (this.grade != student.grade) return false;
        if (this.name != null ? !name.equals(student.name) : student.name != null) return false;
        if (this.surname != null ? !surname.equals(student.surname) : student.surname != null) return false;
        return this.gradeBookId != null ? gradeBookId.equals(student.gradeBookId) : student.gradeBookId == null;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(this.name, this.surname, this.gradeBookId, this.grade);
    }
}
