package io.promova.multicube.models;

import java.util.List;

public class HypercubeRequest
{
    private String polish;

    private List<Parameter> parameters;

    public String getPolish()
    {
        return polish;
    }

    public void setPolish(String polish)
    {
        this.polish = polish;
    }

    public List<Parameter> getParameters()
    {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters)
    {
        this.parameters = parameters;
    }

    public HypercubeRequest(String polish, List<Parameter> parameters)
    {
        this.polish = polish;
        this.parameters = parameters;
    }

    public HypercubeRequest()
    {
    }
}
