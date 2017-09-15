package com.epam.poliakov.task4.repository.productShop;

import com.epam.poliakov.task4.entity.Product;

import java.util.Map;

/**
 * Interface consist basic methods for ProductsRepository map.
 */
public interface ProductsRepository {

    Map<String, Product> getProductMap();

    Product getProductByName(String productName);
}
