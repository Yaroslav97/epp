package com.epam.poliakov.task7_1.shop.repository.productShop;

import com.epam.poliakov.task7_1.shop.entity.productEntity.Vehicle;

import java.util.Map;

/**
 * Interface consist basic methods for ProductsRepository map.
 */
public interface ProductsRepository {

    Map<String, Vehicle> getProductMap();

    void addProduct(Vehicle vehicle);

    void initSerialization();

    void initDeserialization();

    Vehicle getProductByName(String productName);
}
