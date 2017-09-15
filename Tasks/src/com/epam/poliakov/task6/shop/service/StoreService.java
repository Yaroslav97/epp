package com.epam.poliakov.task6.shop.service;

import com.epam.poliakov.task6.shop.entity.Store;
import com.epam.poliakov.task6.shop.entity.product.Vehicle;
import com.epam.poliakov.task6.shop.repository.productShop.ProductsRepository;
import com.epam.poliakov.task6.shop.repository.productShop.ProductsRepositoryImpl;

/**
 * Class contain methods to display some info in Store.
 */
public class StoreService {

    private ProductsRepository productsRepository = new ProductsRepositoryImpl();

    /**
     * Method add Product to vehicle container
     *
     * @param vehicle
     */
    public void addProduct(Vehicle vehicle) {
        productsRepository.addProduct(vehicle);
    }

    /**
     * Method gets Product from collection by productName.
     *
     * @param productName
     * @return Product
     */
    public Vehicle getProduct(String productName) {
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

    public void initSerialization(){
        productsRepository.initSerialization();
    }

    public void initDeserialization(){
        productsRepository.initDeserialization();
    }

    public Store getProductMap() {
        return new Store(productsRepository.getProductMap());
    }
}
