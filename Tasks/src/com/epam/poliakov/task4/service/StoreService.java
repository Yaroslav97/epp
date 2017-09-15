package com.epam.poliakov.task4.service;

import com.epam.poliakov.task4.entity.Product;
import com.epam.poliakov.task4.entity.Store;
import com.epam.poliakov.task4.repository.productShop.ProductsRepository;
import com.epam.poliakov.task4.repository.productShop.ProductsRepositoryImpl;

/**
 * Class contain methods to display some info in Store.
 */
public class StoreService {

    private ProductsRepository productsRepository = new ProductsRepositoryImpl();

    /**
     * Method gets Product from collection by productName.
     *
     * @param productName
     * @return Product
     */
    public Product getProduct(String productName) {
        return productsRepository.getProductByName(productName);
    }

    /**
     * Method check, is exist the Product in collection by productName.
     *
     * @param productName
     * @return true if collection contains productName.
     */
    public boolean isExist(String productName) {
        return productsRepository.getProductMap().containsKey(productName);
    }

    public Store getProductMap() {
        return new Store(productsRepository.getProductMap());
    }
}
