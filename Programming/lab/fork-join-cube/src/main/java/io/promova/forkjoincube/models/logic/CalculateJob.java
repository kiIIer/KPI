package io.promova.forkjoincube.models.logic;

import java.util.Map;

public record CalculateJob(Map<String, Double> parameters, Double resultLink)
{
}
