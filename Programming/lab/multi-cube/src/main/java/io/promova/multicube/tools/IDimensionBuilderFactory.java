package io.promova.multicube.tools;

import io.promova.multicube.tools.util.DimensionBuilderConfig;

public interface IDimensionBuilderFactory
{
    DimensionBuilder create(DimensionBuilderConfig config);
}
