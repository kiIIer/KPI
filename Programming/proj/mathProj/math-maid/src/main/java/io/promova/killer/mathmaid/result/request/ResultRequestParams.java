package io.promova.killer.mathmaid.result.request;

import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

import java.util.HashMap;
import java.util.Map;

public class ResultRequestParams
{
    private @Valid SimpleParam[] params;

    public void setParams(SimpleParam[] params)
    {
        this.params = params;
    }

    public Map<String, Double> getMap()
    {
        Map<String, Double> map = new HashMap<>();
        for (SimpleParam param : params)
        {
            map.put(param.getName(), param.getValue());
        }
        return map;
    }

}
