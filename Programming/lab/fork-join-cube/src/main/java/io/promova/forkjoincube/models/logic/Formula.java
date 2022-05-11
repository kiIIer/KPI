package io.promova.forkjoincube.models.logic;

import io.promova.forkjoincube.porcessors.calculator.operations.IOperation;

public record Formula(
        IOperation operation,
        Formula[] formulas,
        Double constant,
        String paramName
)
{

}
