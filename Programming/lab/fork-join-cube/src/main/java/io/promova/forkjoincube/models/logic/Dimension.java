package io.promova.forkjoincube.models.logic;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
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

    public Map<Double, Dimension> getDimensions()
    {
        return dimensions;
    }

    public String getParameterName()
    {
        return parameterName;
    }

    public void setValue(Double value)
    {
        System.out.println(value);
        this.value = value;
    }

    public void setDimensions(Map<Double, Dimension> dimensions)
    {
        this.dimensions = dimensions;
    }

    public void setParameterName(String parameterName)
    {
        this.parameterName = parameterName;
    }

    public Dimension()
    {
    }
}
