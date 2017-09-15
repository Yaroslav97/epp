package com.epam.poliakov.task3.entity;

public class Vehicle {

    private String name;
    private String color;
    private double price;
    private String origin;

    public Vehicle() {
    }

    public Vehicle(String name, String color, double price, String origin) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!(o instanceof Vehicle)) return false;

        Vehicle vehicle = (Vehicle) o;

        if (Double.compare(vehicle.price, price) != 0) return false;
        if (!name.equals(vehicle.name)) return false;
        if (!color.equals(vehicle.color)) return false;
        return origin.equals(vehicle.origin);
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", origin='" + origin + '\'' +
                '}';
    }
}
