package io.promova.tablemath.endpoints.tools;

import io.promova.tablemath.models.Matrix;
import io.promova.tablemath.models.Parameter;

public interface IMatrixFormer
{
    void form(Matrix matrix, Parameter paramA, Parameter paramB);
}
