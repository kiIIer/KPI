package Main.Tools;

import MyClasses.Abstract.IInstitute;

public interface IValidator
{
    void validate(IInstitute institute) throws InvalidDataStructureException;
}
