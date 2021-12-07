package Main.Tools.Printers;

import MyClasses.Abstract.IStudent;

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;

public class StudentPrinter implements IStudentPrinter
{
    @Override
    public void print(IStudent student, Writer writer) throws IOException
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Student{" + "name='")
                .append(student.getName())
                .append('\'')
                .append(", surname='")
                .append(student.getSurname())
                .append('\'')
                .append(", gradeBookId='")
                .append(student.getGradeBookId())
                .append('\'')
                .append(", grade=")
                .append(student.getGrade())
                .append('}');

        writer.write(builder.toString());
    }

    @Override
    public void print(Collection<IStudent> students, Writer writer) throws IOException
    {
        for (IStudent student :
                students)
        {
            this.print(student, writer);
            writer.write("\n");
        }
    }
}
