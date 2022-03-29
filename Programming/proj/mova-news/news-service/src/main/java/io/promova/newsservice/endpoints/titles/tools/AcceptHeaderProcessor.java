package io.promova.newsservice.endpoints.titles.tools;

import java.util.Objects;

public class AcceptHeaderProcessor implements IAcceptHeaderProcessor
{
    @Override
    public boolean areLinksEnables(String header)
    {
        return !Objects.equals(header, "application/json");
    }
}
