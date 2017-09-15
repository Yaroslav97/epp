package com.epam.poliakov.util.query_builder;

import javax.servlet.http.HttpServletRequest;

public class QueryDTO {

    private int itemSize;
    private String search;
    private double priceFrom;
    private double priceTo;
    private String subject;
    private String origin;
    private String sortBy;
    private int current_page;
    private int nextPage;

    private HttpServletRequest req;

    public QueryDTO(HttpServletRequest req) {
        this.req = req;
    }

    public int getItemSize() {
        return Integer.parseInt(req.getParameter("item_size"));
    }

    public String getSearch() {
        return req.getParameter("search");
    }

    public Double getPriceFrom() {
        if (req.getParameter("price_from").equals("")) {
            return null;
        }
        return Double.valueOf(req.getParameter("price_from"));
    }

    public Double getPriceTo() {
        if (req.getParameter("price_to").equals("")) {
            return null;
        }
        return Double.valueOf(req.getParameter("price_to"));
    }

    public String getSubject() {
        return req.getParameter("subject");
    }

    public String getOrigin() {
        return req.getParameter("origin");
    }

    public String getSortBy() {
        return req.getParameter("sort_by");
    }

    public int getCurrent_page() {
        return current_page;
    }

    public Integer getNextPage() {
        if (req.getParameter("next_page") == null) {
            return current_page;
        }
        return Integer.parseInt(req.getParameter("next_page"));
    }
}
