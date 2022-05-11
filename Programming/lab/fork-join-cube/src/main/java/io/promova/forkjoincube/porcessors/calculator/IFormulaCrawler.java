package io.promova.forkjoincube.porcessors.calculator;

import java.util.Map;

public interface IFormulaCrawler
{
    double compute(IFormula formula, Map<String, Double> params);
}
