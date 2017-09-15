package com.epam.poliakov.util.query_builder.builder;

import com.epam.poliakov.util.query_builder.Query;

public class QueryBuilderImpl implements QueryBuilder {

    private static final String ALL = "all";
    private Query query;
    private StringBuilder select = new StringBuilder("SELECT * FROM products JOIN subjects ON products.subject = subjects.id JOIN origins ON products.origin = origins.id");
    private final int initialLength = select.length();

    public QueryBuilderImpl() {
        query = new Query();
    }

    @Override
    public QueryBuilder setOrigin(String origin) {
        buildQuery(origin.equals(ALL) ? null : origin, "products.origin = (SELECT origins.id FROM origins WHERE origin = ?)");
        query.setOrigin(origin.equals(ALL) ? null : origin);
        return this;
    }

    @Override
    public QueryBuilder setSubject(String subject) {
        buildQuery(subject.equals(ALL) ? null : subject, "products.subject = (SELECT subjects.id FROM subjects WHERE subject = ?)");
        query.setSubject(subject.equals(ALL) ? null : subject);
        return this;
    }

    @Override
    public QueryBuilder setPrice(Double priceFrom, Double priceTo) {
        if (priceFrom != null && priceTo != null) {
            buildQuery(priceFrom, "price BETWEEN ? AND ?");
        } else if (priceFrom != null) {
            buildQuery(priceFrom, "price > ?");
        } else if (priceTo != null) {
            buildQuery(priceTo, "price < ?");
        }
        query.setPriceFrom(priceFrom);
        query.setPriceTo(priceTo);
        return this;
    }

    @Override
    public QueryBuilder setSearch(String search) {
        buildQuery(search, "name LIKE ?");
        query.setSearch("%" + search + "%");
        return this;
    }

    @Override
    public QueryBuilder setSortBy(String sortBy) {
        buildQuery(sortBy, "ORDER BY " + sortBy);
        query.setSortBy(sortBy);
        return this;
    }

    @Override
    public QueryBuilder setLimitProducts(Integer limit, Integer position) {
        buildQuery(limit, "LIMIT ? OFFSET ?");
        query.setLimit(limit);
        query.setPosition(position);
        return this;
    }

    @Override
    public String getGenerateQuery() {
        return select.toString();
    }

    @Override
    public Query getQueryObject() {
        return query;
    }

    private void buildQuery(Object parameter, String query) {
        if (parameter != null && !query.contains("null") && !query.contains(ALL)) {
            if (select.length() == initialLength) {
                select.append(" WHERE ");
                select.append(query);
            } else if (query.contains("ORDER BY") || query.contains("LIMIT")) {
                select.append(" ").append(query);
            } else {
                select.append(" and ").append(query);
            }
        }
    }

    @Override
    public String toString() {
        return select.toString();
    }
}
