package com.epam.poliakov.task1.entity;

public class Car extends Vehicle {

    private String driveUnit;
    private String fuelType;

    public Car() {
    }

    public Car(String name, String color, double price, String origin, String driveUnit, String fuelType) {
        super(name, color, price, origin);
        this.driveUnit = driveUnit;
        this.fuelType = fuelType;
    }

    public String getDriveUnit() {
        return driveUnit;
    }

    public void setDriveUnit(String driveUnit) {
        this.driveUnit = driveUnit;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        if (!(o instanceof Vehicle)) return false;

        Car car = (Car) o;

        if (!driveUnit.equals(car.driveUnit)) return false;
        return fuelType.equals(car.fuelType);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + this.getName() + '\'' +
                ", color='" + this.getColor() + '\'' +
                ", price=" + this.getPrice() +
                ", origin='" + this.getOrigin() + '\'' +
                "driveUnit='" + driveUnit + '\'' +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
