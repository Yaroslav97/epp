package com.epam.poliakov.task6.shop.entity.product;

import java.io.Serializable;

public class Bicycle extends Vehicle implements Serializable {

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

    public void setCountGears(int countGears) {
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
