package io.promova.forkjoincube.models.logic;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Iterator;

public record Parameter(
        @JsonProperty("name") String name,
        @JsonProperty("lowBound") double lowBound,
        @JsonProperty("highBound") double highBound,
        @JsonProperty("step") double step
)
{
    public Iterable<Double> values()
    {
        return () -> new Iterator<Double>()
        {
            private int current = 0;
            private final int max = (int) ((Parameter.this.highBound - Parameter.this.lowBound) / Parameter.this.step);

            @Override
            public boolean hasNext()
            {
                return current < max;
            }

            @Override
            public Double next()
            {
                Double value = Parameter.this.lowBound + Parameter.this.step * current;
                current++;
                return value;
            }
        };
    }
}
