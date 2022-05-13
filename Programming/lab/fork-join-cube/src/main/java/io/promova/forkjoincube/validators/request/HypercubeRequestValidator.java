package io.promova.forkjoincube.validators.request;

import io.promova.forkjoincube.models.request.HypercubeRequest;
import io.promova.forkjoincube.util.APISubError;
import io.promova.forkjoincube.util.Tuple;
import io.promova.forkjoincube.validators.params.IParamsValidator;
import io.promova.forkjoincube.validators.polish.IPolishValidator;
import io.promova.forkjoincube.validators.util.INotNullValidator;
import io.promova.forkjoincube.validators.util.IPolishParamsValidator;

import java.util.ArrayList;
import java.util.List;

public class HypercubeRequestValidator implements IHypercubeRequestValidator
{
    private final INotNullValidator INotNullValidator;
    private final IPolishValidator IPolishValidator;
    private final IParamsValidator IParamsValidator;
    private final IPolishParamsValidator IPolishParamsValidator;

    public HypercubeRequestValidator(INotNullValidator INotNullValidator,
                                     IPolishValidator IPolishValidator,
                                     IParamsValidator IParamsValidator,
                                     IPolishParamsValidator IPolishParamsValidator)
    {
        this.INotNullValidator = INotNullValidator;
        this.IPolishValidator = IPolishValidator;
        this.IParamsValidator = IParamsValidator;
        this.IPolishParamsValidator = IPolishParamsValidator;
    }

    @Override
    public List<APISubError> validate(HypercubeRequest object)
    {
        List<APISubError> errors = new ArrayList<>(INotNullValidator.validate(object));
        if (errors.size() == 0)
        {
            errors.addAll(IPolishValidator.validate(object.polish()));
            errors.addAll(IParamsValidator.validate(object.parameters()));
            if (errors.size() == 0)
            {
                errors.addAll(IPolishParamsValidator.validate(new Tuple<>(object.polish(), object.parameters())));
            }
        }

        return errors.size() != 0 ? List.of(new APISubError("Request is invalid", errors)) : List.of();
    }
}
