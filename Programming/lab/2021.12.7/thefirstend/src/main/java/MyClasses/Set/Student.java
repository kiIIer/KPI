package MyClasses.Set;

import MyClasses.Abstract.IStudent;

public class Student implements IStudent, Comparable<IStudent>
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
    public int compareTo(IStudent student)
    {
        return Double.compare(this.grade, student.getGrade());
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        return gradeBookId != null ? gradeBookId.equals(student.gradeBookId) : student.gradeBookId == null;
    }

    @Override
    public int hashCode()
    {
        return gradeBookId != null ? gradeBookId.hashCode() : 0;
    }
}
