package org.example;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args)
    {
        Human h1 = new Human("Mike", "Molchanov", 17);
        Human h2 = new Human("Alina", "Purtova", 16);
        Human h3 = new Human("Ivan", "Ivanov", 17);
        Human h4 = new Human("Ivan", "Hluhov", 17);
        Human h5 = null;

        List<Human> humans = new ArrayList<Human>();
        humans.add(h1);
        humans.add(h2);
        humans.add(h3);
        humans.add(h4);
        Comparator<Human> name = (o1, o2) -> Objects.compare(o1.name(), o2.name(), String.CASE_INSENSITIVE_ORDER);
        Comparator<Human> surname = (o1, o2) -> Objects.compare(o1.name(), o2.name(), String.CASE_INSENSITIVE_ORDER);
        Comparator<Human> age = (o1, o2) -> Integer.compare(o1.age(), o2.age());
        Consumer<List<Human>> printer = (list) -> list.forEach(System.out::println);

        System.out.println("Name");
        humans.sort(name);
        printer.accept(humans);

        System.out.println("Surname");
        humans.sort(surname);
        printer.accept(humans);

        System.out.println("Age");
        humans.sort(age);
        printer.accept(humans);
        humans.add(h5);

        System.out.println("Age then name then surname null last");
        humans.sort(Comparator.nullsLast(age.thenComparing(name).thenComparing(surname)));
        printer.accept(humans);


        System.out.println("NullFirst and reverse");
        humans.sort(Comparator.nullsFirst(age.thenComparing(name).thenComparing(surname)).reversed());
        printer.accept(humans);
    }
}