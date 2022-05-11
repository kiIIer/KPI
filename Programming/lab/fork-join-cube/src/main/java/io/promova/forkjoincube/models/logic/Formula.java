package io.promova.forkjoincube.models.logic;

import io.promova.forkjoincube.porcessors.calculator.operations.IOperation;

public record Formula(
        IOperation operation,
        io.promova.forkjoincube.models.logic.Formula[] formulas,
        Double constant,
        String paramName
)
{

}
