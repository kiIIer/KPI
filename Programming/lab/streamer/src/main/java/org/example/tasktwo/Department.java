package org.example.tasktwo;

import java.util.List;

public record Department(String name, List<Student> students)
{
}
