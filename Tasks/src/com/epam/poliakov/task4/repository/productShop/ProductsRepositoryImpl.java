package com.epam.poliakov.task4.repository.productShop;

import com.epam.poliakov.task4.entity.Product;

import java.util.*;

public class ProductsRepositoryImpl implements ProductsRepository {

    private Map<String, Product> productMap = new HashMap<>();

    {
        Product candy = new Product("candy", 1);
        Product coffee = new Product("coffee", 3);
        Product tea = new Product("tea", 2);
        Product milk = new Product("milk", 3);
        Product water = new Product("water", 1);
        Product cookie = new Product("cookie", 2);

        productMap.put("candy", candy);
        productMap.put("coffee", coffee);
        productMap.put("tea", tea);
        productMap.put("milk", milk);
        productMap.put("water", water);
        productMap.put("cookie", cookie);
    }

    @Override
    public Map<String, Product> getProductMap() {
        return Collections.unmodifiableMap(productMap);
    }

    @Override
    public Product getProductByName(String productName) {
        return productMap.get(productName);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
