package io.promova.tablemath.endpoints.tools;

import io.promova.tablemath.models.Parameter;

import java.util.List;

public interface IMatrixFormer
{
    List<List<Long>> form(Parameter paramA, Parameter paramB);
}
