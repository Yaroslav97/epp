package com.epam.poliakov.task9.shop.entity.productEntity;

import com.epam.poliakov.task7_1.annotation.Product;

import java.io.Serializable;

public class Vehicle implements Serializable {

    public static final String NAME = "name";
    public static final String PRICE = "price";

    private String name;
    private int price;

    public Vehicle() {
    }

    public Vehicle(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Product(key = NAME)
    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    @Product(key = PRICE)
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
