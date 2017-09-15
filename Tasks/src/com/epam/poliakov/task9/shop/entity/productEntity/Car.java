package com.epam.poliakov.task9.shop.entity.productEntity;

import com.epam.poliakov.task7_1.annotation.Product;

import java.io.Serializable;

public class Car extends Vehicle implements Serializable{

    public static final String FUEL = "fuel";
    private String fuel;

    public Car() {
    }

    public Car(String name, int price, String fuel) {
        super(name, price);
        this.fuel = fuel;
    }

    public String getFuel() {
        return fuel;
    }

    @Product(key = FUEL)
    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + this.getName() + '\'' +
                "price='" + this.getPrice() + '\'' +
                "fuel='" + fuel + '\'' +
                '}';
    }
}
