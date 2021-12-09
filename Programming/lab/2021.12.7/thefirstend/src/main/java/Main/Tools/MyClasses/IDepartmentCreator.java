package Main.Tools.MyClasses;

import Main.Tools.CollectionType;
import MyClasses.Abstract.IDepartment;

/**
 * Used to create departments.
 */
public interface IDepartmentCreator
{
    /**
     * Creates department with provided name and colleciton type. Sets student collection as collectoin type as a base, contatining 0 students.
     * @param name Name of department to be created.
     * @param collectionType Type of collection to be used while creating.
     * @return Created Department.
     */
    IDepartment create(String name, CollectionType collectionType);
}
