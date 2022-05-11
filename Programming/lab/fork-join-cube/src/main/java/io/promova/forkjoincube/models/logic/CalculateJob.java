package io.promova.forkjoincube.models.logic;

import io.promova.forkjoincube.util.MutableDouble;

import java.util.Map;

public record CalculateJob(Map<String, Double> parameters, MutableDouble resultLink, Formula formula)
{
}
