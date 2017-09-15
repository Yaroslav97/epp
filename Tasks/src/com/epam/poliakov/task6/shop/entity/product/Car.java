package com.epam.poliakov.task6.shop.entity.product;

import java.io.Serializable;

public class Car extends Vehicle implements Serializable{

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
