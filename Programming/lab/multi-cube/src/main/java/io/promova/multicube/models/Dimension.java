package io.promova.multicube.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dimension
{
    private Double value;
    private Map<Double, Dimension> dimensions;
    private String parameterName;

    public Double getValue()
    {
        return value;
    }

    public void setValue(Double value)
    {
        this.value = value;
    }

    public Map<Double, Dimension> getDimensions()
    {
        return dimensions;
    }

    public void setDimensions(Map<Double, Dimension> dimensions)
    {
        this.dimensions = dimensions;
    }

    public String getParameterName()
    {
        return parameterName;
    }

    public void setParameterName(String parameterName)
    {
        this.parameterName = parameterName;
    }

    public Dimension(double value, Map<Double, Dimension> dimensions, String parameterName)
    {
        this.value = value;
        this.dimensions = dimensions;
        this.parameterName = parameterName;
    }

    public Dimension()
    {
        value = null;
        dimensions = null;
        parameterName = null;
    }
}
