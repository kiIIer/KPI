package org.example.tasktwo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UniversityDAO
{
    private final List<University> universities;
    private static UniversityDAO instance;
    public static UniversityDAO getInstance()
    {
        if (instance == null)
        {
            instance = new UniversityDAO();
        }

        return instance;
    }


    private UniversityDAO()
    {
        Student oneS = new Student("Mike", "Molchanov", 1);
        Student twoS = new Student("Ivan", "Hluhov", 2);
        Student threeS = new Student("Anastasiya", "Zp", 3);

        Department oneD = new Department("FIOT", List.of(oneS, twoS, threeS));

        Student fourS = new Student("And", "Einstein", 4);
        Student fiveS = new Student("And", "Amper", 5);
        Student sixS = new Student("Alessandro", "Volta", 6);

        Department twoD = new Department("FMM", List.of(fourS, fiveS, sixS));

        University kpi = new University("KPI", List.of(oneD, twoD));

        Student sevenS = new Student("Lerik", "Sv", 1);
        Student eightS = new Student("Katya", "Zhkve", 2);

        Department threeD = new Department("CSD", List.of(sevenS, eightS));

        Student nineS = new Student("Some", "Body", 3);
        Student tenS = new Student("Once", "Told me the world is gonna...", 4);

        Department fourD = new Department("Shrek", List.of(nineS, tenS));

        University eu = new University("EU", List.of(threeD, fourD));

        List<University> temp = new ArrayList<>();
        temp.add(kpi);
        temp.add(eu);
        this.universities = temp;
    }

    public List<University> readAll()
    {
        return universities;
    }
}
