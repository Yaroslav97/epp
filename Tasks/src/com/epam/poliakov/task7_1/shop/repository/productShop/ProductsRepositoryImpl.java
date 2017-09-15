package com.epam.poliakov.task7_1.shop.repository.productShop;

import com.epam.poliakov.task7_1.shop.entity.productEntity.Vehicle;
import com.epam.poliakov.task7_1.shop.serialization.Serialization;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.epam.poliakov.task7_1.shop.serialization.FileCons.FILE_SERIALIZATION;

public class ProductsRepositoryImpl implements ProductsRepository {

    private Map<String, Vehicle> productMap;

    @Override
    public Map<String, Vehicle> getProductMap() {
        return Collections.unmodifiableMap(productMap);
    }

    @Override
    public void addProduct(Vehicle vehicle) {
        productMap.put(vehicle.getName(), vehicle);
    }

    public void initSerialization() {
        try {
            Serialization.serialize(getProductMap(), FILE_SERIALIZATION);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initDeserialization() {

        Map<String, Vehicle> store = null;

        try {
            store = (Map) Serialization.deserialize(FILE_SERIALIZATION);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        productMap = new HashMap(store);
    }

    @Override
    public Vehicle getProductByName(String productName) {
        return productMap.get(productName);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
