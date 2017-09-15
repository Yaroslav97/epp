package com.epam.poliakov.util.query_builder;

public class Query {

    private String origin;
    private String subject;
    private Double priceFrom;
    private Double priceTo;
    private String search;
    private String sortBy;
    private Integer limit;
    private Integer position;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(Double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public Double getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(Double priceTo) {
        this.priceTo = priceTo;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Query{" +
                "origin='" + origin + '\'' +
                ", subject='" + subject + '\'' +
                ", priceFrom=" + priceFrom +
                ", priceTo=" + priceTo +
                ", search='" + search + '\'' +
                ", sortBy='" + sortBy + '\'' +
                ", limit=" + limit +
                ", position=" + position +
                '}';
    }
}
