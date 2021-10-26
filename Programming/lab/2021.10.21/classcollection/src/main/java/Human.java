import javax.swing.event.HyperlinkEvent;

public class Human
{
    private int age;
    private double height;
    private double weight;

    public void setAge(int age)
    {
        ensurePositive(age);
        this.age = age;
    }

    public int getAge()
    {
        return this.age;
    }

    public void setHeight(double height)
    {
        ensurePositive(height);
        this.height = height;
    }

    public double getHeight()
    {
        return height;
    }

    public void setWeight(double weight)
    {
        ensurePositive(weight);
        this.weight = weight;
    }

    public double getWeight()
    {
        return weight;
    }

    private void ensurePositive(double a)
    {
        if (a < 0)
        {
            throw new IllegalArgumentException("Values cannot be negative");
        }
    }

    public Human()
    {
        this(27, 170, 70);
    }

    public Human(int age, double height, double weight)
    {
        setAge(age);
        setHeight(height);
        setWeight(weight);
    }

    public void liveOneYear()
    {
        setAge(getAge() + 1);
        setHeight(getHeight() + 3);
        setWeight(getWeight() + ((int) (Math.random() * 10)));
    }

    @Override
    public String toString()
    {
        return String.format("Age = %s, Height = %s, Weight = %s", age, height, weight);
    }

    @Override
    public boolean equals(Object anObject)
    {
        if (this == anObject)
        {
            return true;
        }
        if (!(anObject instanceof Human))
        {
            return false;
        }
        Human aHuman = (Human) anObject;
        if (this.age != aHuman.age)
        {
            return false;
        }
        if (this.height != aHuman.height)
        {
            return false;
        }
        if (this.weight != aHuman.weight)
        {
            return false;
        }
        return true;
    }
}
