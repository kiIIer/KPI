package io.promova.forkjoincube.validators.params;

import io.promova.forkjoincube.models.logic.Parameter;
import io.promova.forkjoincube.util.APISubError;
import io.promova.forkjoincube.validators.IValidator;
import io.promova.forkjoincube.validators.util.INotNullValidator;

import java.util.ArrayList;
import java.util.List;

public class ParamsValidator implements IParamsValidator
{
    private final INotNullValidator INotNullValidator;
    private final IParamValidator IParamValidator;

    public ParamsValidator(INotNullValidator INotNullValidator, IParamValidator IParamValidator)
    {
        this.INotNullValidator = INotNullValidator;
        this.IParamValidator = IParamValidator;
    }

    @Override
    public List<APISubError> validate(List<Parameter> object)
    {
        List<APISubError> errors = new ArrayList<>(INotNullValidator.validate(object));
        if (errors.size() == 0)
        {
            object.forEach(object1 -> errors.addAll(IParamValidator.validate(object1)));
        }

        return errors.size() != 0 ? List.of(new APISubError("Parameter array is invalid", errors)) : List.of();
    }
}
