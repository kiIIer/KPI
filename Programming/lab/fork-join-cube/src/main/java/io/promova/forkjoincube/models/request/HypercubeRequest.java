package io.promova.forkjoincube.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.promova.forkjoincube.models.logic.Parameter;

import java.util.List;

public record HypercubeRequest(
        @JsonProperty("polish") String polish,
        @JsonProperty("parameters") List<Parameter> parameters
)
{

}

