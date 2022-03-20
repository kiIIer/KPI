package io.promova.newsservice.endpoints.tools;

import java.util.Objects;

public class AcceptHeaderParser implements IAcceptHeaderParser
{
    @Override
    public boolean addLinks(String acceptHeader)
    {
        return !Objects.equals(acceptHeader, "application/json");
    }
}
