package io.promova.newsservice.endpoints.util.tools;

import org.springframework.http.MediaType;

import java.util.Objects;

public class AcceptHeaderProcessor implements IAcceptHeaderProcessor
{
    @Override
    public boolean areLinksEnables(String header)
    {
        return !Objects.equals(header, MediaType.APPLICATION_JSON_VALUE);
    }
}
