package io.promova.forkjoincube.models.logic;

import java.util.Map;
import java.util.function.DoubleConsumer;

public record CalculateJob(Map<String, Double> parameters, DoubleConsumer resultLink, Formula formula)
{
}
