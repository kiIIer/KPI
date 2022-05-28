package io.promova.newsservice.endpoints.titles.tools.util;

public class TitlesAllGetRequest
{
    private String page;
    private String pageSize;
    private String acceptHeader;

    public String getPage()
    {
        return page;
    }

    public void setPage(String page)
    {
        this.page = page;
    }

    public String getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(String pageSize)
    {
        this.pageSize = pageSize;
    }

    public String getAcceptHeader()
    {
        return acceptHeader;
    }

    public void setAcceptHeader(String acceptHeader)
    {
        this.acceptHeader = acceptHeader;
    }

    public TitlesAllGetRequest(String page, String pageSize, String acceptHeader)
    {
        this.page = page;
        this.pageSize = pageSize;
        this.acceptHeader = acceptHeader;
    }

    public TitlesAllGetRequest()
    {
    }
}
