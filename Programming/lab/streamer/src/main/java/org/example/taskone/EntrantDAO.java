package org.example.taskone;

import java.util.LinkedList;
import java.util.List;

public class EntrantDAO
{
    private final List<Entrant> entrants;
    private static EntrantDAO instance;
    public static EntrantDAO getInstance()
    {
        if (instance == null)
        {
            instance = new EntrantDAO();
        }

        return instance;
    }


    private EntrantDAO()
    {
        Entrant one = new Entrant("Avramenko", 80);
        Entrant two = new Entrant("Stalin", 45);
        Entrant three = new Entrant("Molchanov", 94);
        Entrant four = new Entrant("Zaporogchenko", 97);
        Entrant five = new Entrant("Syzov", 59);
        Entrant six = new Entrant("Einstein", 100);
        Entrant seven = new Entrant("Human", 61);

        List<Entrant> entrants = new LinkedList<>();
        entrants.add(one);
        entrants.add(two);
        entrants.add(three);
        entrants.add(four);
        entrants.add(five);
        entrants.add(six);
        entrants.add(seven);

        this.entrants = entrants;
    }

    public List<Entrant> readAll()
    {
        return entrants;
    }
}
