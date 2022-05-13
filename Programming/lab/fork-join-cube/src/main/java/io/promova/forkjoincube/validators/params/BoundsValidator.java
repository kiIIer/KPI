package io.promova.forkjoincube.validators.params;

import io.promova.forkjoincube.util.APISubError;
import io.promova.forkjoincube.util.Tuple;
import io.promova.forkjoincube.validators.IValidator;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class BoundsValidator implements IBoundsValidator
{
    private final IHighBoundValidator IHighBoundValidator;
    private final ILowBoundValidator ILowBoundValidator;

    public BoundsValidator(IHighBoundValidator IHighBoundValidator, ILowBoundValidator ILowBoundValidator)
    {
        this.IHighBoundValidator = IHighBoundValidator;
        this.ILowBoundValidator = ILowBoundValidator;
    }

    @Override
    public List<APISubError> validate(Tuple<Double, Double> object)
    {
        List<APISubError> errors = new ArrayList<>();
        errors.addAll(ILowBoundValidator.validate(object.left()));
        errors.addAll(IHighBoundValidator.validate(object.right()));

        if (object.left() != null && object.right() != null && object.left() > object.right())
        {
            errors.add(new APISubError("Lower bound is greater than Higher bound", null));
        }


        return errors.size() != 0 ? List.of(new APISubError("Bounds are invalid", errors)) : List.of();
    }
}
