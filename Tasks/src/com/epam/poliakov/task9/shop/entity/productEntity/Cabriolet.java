package com.epam.poliakov.task9.shop.entity.productEntity;

import com.epam.poliakov.task7_1.annotation.Product;

import java.io.Serializable;

public class Cabriolet extends Car implements Serializable{

    public static final String COLOR = "color";
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

    @Product(key = COLOR)
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
