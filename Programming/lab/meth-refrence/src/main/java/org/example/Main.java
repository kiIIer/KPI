package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main
{
    public static void main(String[] args)
    {
//        Static meth reference
        IntBinaryOperator someBinaryOperator = Integer::sum;
        int reduce = IntStream.range(0, 10).reduce(0, someBinaryOperator);
        System.out.println(reduce);

        MyMath lilMath = new MyMath();
        Map<Integer, Long> collect = IntStream.range(0, 10)
//                Object meth ref
                .map(lilMath::apply)
//                Obj meth ref
                .peek(System.out::println)
                .boxed()
//                Class but like obj meth ref
                .map(Integer::bitCount)
                .peek(integer -> System.out.printf("After bit %s\n", integer))
//                Constructor ref
                .map(SomeVeryImportantClass::new)
//                Class meth ref
                .collect(Collectors.groupingBy(SomeVeryImportantClass::a, Collectors.counting()));
//                Class meth ref
        collect.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getKey)).forEach(System.out::println);
    }
}