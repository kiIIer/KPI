package io.promova.forkjoincube.validators.params;

import io.promova.forkjoincube.models.logic.Parameter;
import io.promova.forkjoincube.util.APISubError;
import io.promova.forkjoincube.util.Tuple;
import io.promova.forkjoincube.validators.util.INotNullValidator;

import java.util.ArrayList;
import java.util.List;

public class ParamValidator implements IParamValidator
{
    private final INotNullValidator INotNullValidator;
    private final IBoundsValidator IBoundsValidator;
    private final INameValidator INameValidator;
    private final IStepValidator IStepValidator;

    public ParamValidator(INotNullValidator INotNullValidator, IBoundsValidator IBoundsValidator, INameValidator INameValidator, IStepValidator IStepValidator)
    {
        this.INotNullValidator = INotNullValidator;
        this.IBoundsValidator = IBoundsValidator;
        this.INameValidator = INameValidator;
        this.IStepValidator = IStepValidator;
    }

    @Override
    public List<APISubError> validate(Parameter object)
    {
        List<APISubError> errors = new ArrayList<>(INotNullValidator.validate(object));
        if (errors.size() == 0)
        {
            errors.addAll(IBoundsValidator.validate(new Tuple<Double, Double>(object.lowBound(), object.highBound())));
            errors.addAll(INameValidator.validate(object.name()));
            errors.addAll(IStepValidator.validate(object.step()));
        }

        return errors.size() != 0 ? List.of(new APISubError(String.format("Parameter '%s' is invalid", object.name()), errors)) : List.of();
    }
}
