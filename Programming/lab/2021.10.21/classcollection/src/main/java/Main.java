public class Main
{
    public static void main(String[] args)
    {
        var a = new Human(15, 150, 50);
        System.out.println(a.toString());

        var b = new Human();
        System.out.println(b.toString());

        var c = new Human(27, 170, 70);

        System.out.println(c.equals(b));

        var d = new Student(17, 140, 31, "KNEU", 3);
        System.out.println(d.toString());

        var e = new Student();
        System.out.println(e.toString());

        var f = new Student("KNNN", 3);
        System.out.println(f.toString());

        System.out.println(b.equals(f));

        var g = new Human();
        System.out.println(g.toString());
        g.liveOneYear();
        System.out.println(g.toString());

        var h = new Student();
        System.out.println(h.toString());
        h.liveOneYear();
        System.out.println(h.toString());

    }
}
