package org.example.taskone;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Main
{
    public static void main(String[] args)
    {
        EntrantDAO entrantDAO = EntrantDAO.getInstance();

        List<Entrant> entrants = entrantDAO.readAll();

        int budgetPlaces = 4;

        entrants.stream()
                .filter(entrant -> entrant.points() >= 60)
                .limit(budgetPlaces)
                .sorted((o1, o2) -> Objects.compare(o1.surname(), o2.surname(), String.CASE_INSENSITIVE_ORDER)).forEach(System.out::println);
    }
}
