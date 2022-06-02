package org.example.tasktwo;

import java.util.Comparator;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        UniversityDAO dao = UniversityDAO.getInstance();
        List<University> universities = dao.readAll();
        universities.stream()
                .flatMap(
                        university -> university
                                .departments()
                                .stream()
                )
                .flatMap(
                        department -> department
                                .students()
                                .stream()
                )
                .sorted(
                        Comparator
                                .comparing(Student::name)
                                .thenComparing(Student::surname)
                                .thenComparing(Student::id)
                )
                .forEach(System.out::println);
    }
}
