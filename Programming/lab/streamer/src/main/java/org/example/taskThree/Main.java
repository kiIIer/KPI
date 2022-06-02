package org.example.taskThree;

import org.example.taskone.Entrant;
import org.example.taskone.EntrantDAO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
        EntrantDAO dao = EntrantDAO.getInstance();

        List<Entrant> entrants = dao.readAll();

        List<Entrant> failed = entrants.stream()
                .filter(entrant -> entrant.points() < 60)
//                .toList();
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        failed.forEach(System.out::println);
    }
}
