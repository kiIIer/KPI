package Main.Tools.MyClasses;

import MyClasses.Abstract.IInstitute;

/**
 * Validates institute.
 */
public interface IValidator
{
    /**
     * Validates provided institute according to rules:
     *
     * Institute's name must be present.
     * Institute must have department collection.
     * Each department must have a unique name.
     * Each department must have a student collection.
     * Each student must have a unique gradeBookId.
     * Each studnet must have a name.
     * Each student must have a surname.
     * Each student must have a grade in range [0; 100]
     *
     * If these requirements are not net. Invalid objects are places into Errors DTO and then an Exception is thrown with created Erorrs.
     * @param institute Institute to be validated.
     * @throws InvalidDataStructureException Will be thrown if institute contains invalid elements.
     */
    void validate(IInstitute institute) throws InvalidDataStructureException;
}
