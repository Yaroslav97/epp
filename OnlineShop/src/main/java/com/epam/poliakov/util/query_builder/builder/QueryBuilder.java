package com.epam.poliakov.util.query_builder.builder;

import com.epam.poliakov.util.query_builder.Query;

public interface QueryBuilder {

    QueryBuilder setOrigin(String origin);

    QueryBuilder setSubject(String subject);

    QueryBuilder setPrice(Double priceFrom, Double priceTo);

    QueryBuilder setSearch(String search);

    QueryBuilder setSortBy(String sortBy);

    QueryBuilder setLimitProducts(Integer limit, Integer position);

    String getGenerateQuery();

    Query getQueryObject();
}
