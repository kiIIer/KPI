package org.example;

import java.util.Comparator;
import java.util.Objects;

public record ProgrammingLanguage(String name, int dateOfBirth, String description)
{
    public static class LilComparator implements Comparator<ProgrammingLanguage>
    {
        @Override
        public int compare(ProgrammingLanguage o1, ProgrammingLanguage o2)
        {
            return Objects.compare(o1.name, o2.name, String.CASE_INSENSITIVE_ORDER);
        }
    }

    public static Comparator<ProgrammingLanguage> getComparator()
    {
        return new Comparator<ProgrammingLanguage>()
        {
            @Override
            public int compare(ProgrammingLanguage o1, ProgrammingLanguage o2)
            {
                return Integer.compare(o1.dateOfBirth, o2.dateOfBirth);
            }
        };
    }
}
