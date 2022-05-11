package io.promova.forkjoincube.porcessors.calculator;

import io.promova.forkjoincube.models.logic.Formula;

import java.util.Map;

public interface IFormulaCrawler
{
    double compute(Formula formula, Map<String, Double> params);
}
