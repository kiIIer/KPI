public class Student extends Human
{
    private String university;
    private int course;


    public void setUniversity(String university)
    {
        if (university == null)
        {
            throw new IllegalArgumentException("University cannot be null");
        }
        this.university = university;
    }

    public String getUniversity()
    {
        return university;
    }

    public void setCourse(int course)
    {
        if (course < 0)
        {
            throw new IllegalArgumentException("Course cannot be negative");
        }
        this.course = course;
    }

    public int getCourse()
    {
        return course;
    }

    public Student()
    {
        this("KPI", 1);
    }

    public Student(String university, int course)
    {
        super();
        setUniversity(university);
        setCourse(course);
    }

    public Student(int age, double height, double weight, String university, int course)
    {
        super(age, height, weight);
        setUniversity(university);
        setCourse(course);
    }

    @Override
    public void liveOneYear()
    {
        super.liveOneYear();
        setCourse(getCourse() + 1);
    }

    @Override
    public String toString()
    {
        return (super.toString() + String.format(", University: %s, Course: %s", this.university, this.course));
    }

    @Override
    public boolean equals(Object anObject)
    {
        if (this == anObject)
        {
            return true;
        }

        if (!super.equals(anObject))
        {
            return false;
        }

        if (!(anObject instanceof Student))
        {
            return false;
        }

        Student aStudent = (Student) anObject;

        if (!this.university.equals(aStudent.university))
        {
            return false;
        }

        if (this.course != aStudent.course)
        {
            return false;
        }

        return true;
    }
}
