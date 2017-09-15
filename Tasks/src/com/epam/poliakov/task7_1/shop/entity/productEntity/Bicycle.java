package com.epam.poliakov.task7_1.shop.entity.productEntity;

import com.epam.poliakov.task7_1.annotation.Product;

import java.io.Serializable;

public class Bicycle extends Vehicle implements Serializable {

    public static final String COUNT_OF_GEARS = "countofgears";
    private int countGears;

    public Bicycle() {
    }

    public Bicycle(String name, int price, int countGears) {
        super(name, price);
        this.countGears = countGears;
    }

    public int getCountGears() {
        return countGears;
    }

    @Product(key = COUNT_OF_GEARS)
    public void setCountOfGears(int countGears) {
        this.countGears = countGears;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "name='" + this.getName() + '\'' +
                "price='" + this.getPrice() + '\'' +
                "countGears=" + countGears +
                '}';
    }
}
