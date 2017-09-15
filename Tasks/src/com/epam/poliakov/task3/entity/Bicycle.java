package com.epam.poliakov.task3.entity;

public class Bicycle extends Vehicle {

    private int countGears;

    public Bicycle() {
    }

    public Bicycle(String name, String color, double price, String origin, int countGears) {
        super(name, color, price, origin);
        this.countGears = countGears;
    }

    public int getCountGears() {
        return countGears;
    }

    public void setCountGears(int countGears) {
        this.countGears = countGears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        if (!(o instanceof Vehicle)) return false;

        Bicycle bicycle = (Bicycle) o;

        return countGears == bicycle.countGears;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "name='" + this.getName() + '\'' +
                ", color='" + this.getColor() + '\'' +
                ", price=" + this.getPrice() +
                ", origin='" + this.getOrigin() + '\'' +
                "countGears=" + countGears +
                '}';
    }
}
