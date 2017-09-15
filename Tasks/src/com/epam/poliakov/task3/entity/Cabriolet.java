package com.epam.poliakov.task3.entity;

public class Cabriolet extends Car {
    private boolean isAutoRoof;

    public Cabriolet() {
    }

    public Cabriolet(String name, String color, double price, String origin, String driveUnit, String fuelType, boolean isAutoRoof) {
        super(name, color, price, origin, driveUnit, fuelType);
        this.isAutoRoof = isAutoRoof;
    }

    public boolean isAutoRoof() {
        return isAutoRoof;
    }

    public void setAutoRoof(boolean autoRoof) {
        isAutoRoof = autoRoof;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        if (!(o instanceof Vehicle)) return false;

        Cabriolet cabriolet = (Cabriolet) o;

        return isAutoRoof == cabriolet.isAutoRoof;
    }

    @Override
    public String toString() {
        return "Cabriolet{" +
                "name='" + this.getName() + '\'' +
                ", color='" + this.getColor() + '\'' +
                ", price=" + this.getPrice() +
                ", origin='" + this.getOrigin() + '\'' +
                "driveUnit='" + this.getDriveUnit() + '\'' +
                ", fuelType='" + this.getFuelType() + '\'' +
                "isAutoRoof=" + isAutoRoof +
                '}';
    }
}
