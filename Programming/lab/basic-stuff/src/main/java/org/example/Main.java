package org.example;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        ProgrammingLanguage CSharp = new ProgrammingLanguage("C#", 2000, "This is the default choice for any big company which wants structured code!");
        ProgrammingLanguage Cpp = new ProgrammingLanguage("C++", 1985, "This bad boi is fast and scary. A lot of weird things but man this is fast...");
        ProgrammingLanguage Cpp2 = new ProgrammingLanguage("Imposter", 1985, "This is imposter");
        ProgrammingLanguage Golang = new ProgrammingLanguage("Golang", 2009, "He is easy like Python, he is almost as fast as that beast C++, and it's made by Google, no it's not God, it's Golang. Love ma boi");
        ProgrammingLanguage Rust = new ProgrammingLanguage("Rust", 2010, "Fast. Very. Save. Very. Learning him now. This is cool");

        ProgrammingLanguage[] languages = new ProgrammingLanguage[]{CSharp, Cpp2, Golang, Rust, Cpp};

        System.out.println("With Anonymous \uD83D\uDD25");
        Arrays.sort(languages, ProgrammingLanguage.getComparator());
        Arrays.stream(languages).forEach(System.out::println);
        System.out.println();

        System.out.println("With Static");
        Arrays.sort(languages, new ProgrammingLanguage.LilComparator());
        Arrays.stream(languages).forEach(System.out::println);
        System.out.println();

        System.out.println("With both");
        Arrays.sort(languages, ProgrammingLanguage.getComparator().thenComparing(new ProgrammingLanguage.LilComparator()));
        Arrays.stream(languages).forEach(System.out::println);
    }
}