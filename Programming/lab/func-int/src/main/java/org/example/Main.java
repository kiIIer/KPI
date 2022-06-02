package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Main
{
    public static void main(String[] args)
    {
        Subject vm = new Subject("Vishcha matematika", 100);
        Subject op = new Subject("OP", -1);
        Subject physics = new Subject("Physics", 10);
        Subject Ukr = new Subject("Ukr", 900000);

        List<Subject> subjects = new ArrayList<>();
        subjects.add(vm);
        subjects.add(op);
        subjects.add(physics);
        subjects.add(Ukr);

        subjects.forEach((subject -> System.out.println(subject.toString())));

        MyMath myMath = (a, b, c, d) -> Math.abs(a) + Math.pow(b, c) * (d % 2);

        System.out.println(myMath.accept(-5, 2, 5, 1));
    }

}