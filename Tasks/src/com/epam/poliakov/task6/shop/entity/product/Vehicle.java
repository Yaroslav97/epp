package com.epam.poliakov.task6.shop.entity.product;

import java.io.Serializable;

public class Vehicle implements Serializable{

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

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

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
