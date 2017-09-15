package com.epam.poliakov.task6.shop.entity.product;

import java.io.Serializable;

public class Cabriolet extends Car implements Serializable{

    private String color;

    public Cabriolet() {
    }

    public Cabriolet(String name, int price, String fuel, String color) {
        super(name, price, fuel);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cabriolet{" +
                "name='" + this.getName() + '\'' +
                "price='" + this.getPrice() + '\'' +
                "fuel='" + this.getFuel() + '\'' +
                "color='" + color + '\'' +
                '}';
    }
}
