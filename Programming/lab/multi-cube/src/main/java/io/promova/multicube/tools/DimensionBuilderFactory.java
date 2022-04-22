package io.promova.multicube.tools;

import io.promova.multicube.calculators.IFormulaCrawler;
import io.promova.multicube.tools.util.DimensionBuilderConfig;


public class DimensionBuilderFactory implements IDimensionBuilderFactory
{
    private final IFormulaCrawler formulaCrawler;

    public DimensionBuilderFactory(IFormulaCrawler formulaCrawler)
    {
        this.formulaCrawler = formulaCrawler;
    }

    @Override
    public DimensionBuilder create(DimensionBuilderConfig config)
    {
        return new DimensionBuilder(config, formulaCrawler, this);
    }
}
