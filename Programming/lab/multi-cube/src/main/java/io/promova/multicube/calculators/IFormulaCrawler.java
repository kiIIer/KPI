package io.promova.multicube.calculators;

import java.util.Map;

public interface IFormulaCrawler
{
    double compute(Formula formula, Map<String, Double> params);
}
