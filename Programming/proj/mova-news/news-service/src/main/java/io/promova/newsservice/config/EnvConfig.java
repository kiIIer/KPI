package io.promova.newsservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "cont")
public class EnvConfig
{
    private int maxPageSize = 10;

    public int getMaxPageSize()
    {
        return maxPageSize;
    }

    public void setMaxPageSize(int maxPageSize)
    {
        this.maxPageSize = maxPageSize;
    }
}
