package Main.Tools;

import MyClasses.Abstract.IDepartment;

public interface IDepartmentCreator
{
    IDepartment create(String name, DataType dataType);
}
