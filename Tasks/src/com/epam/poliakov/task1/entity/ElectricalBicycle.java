package com.epam.poliakov.task1.entity;

public class ElectricalBicycle extends Bicycle {

    boolean isElectrical;

    public ElectricalBicycle() {
    }

    public ElectricalBicycle(String name, String color, double price, String origin, int countGears, boolean isElectrical) {
        super(name, color, price, origin, countGears);
        this.isElectrical = isElectrical;
    }

    public boolean isElectrical() {
        return isElectrical;
    }

    public void setElectrical(boolean electrical) {
        isElectrical = electrical;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        if (!(o instanceof Vehicle)) return false;

        ElectricalBicycle that = (ElectricalBicycle) o;

        return isElectrical == that.isElectrical;
    }

    @Override
    public String toString() {
        return "ElectricalBicycle{" +
                "name='" + this.getName() + '\'' +
                ", color='" + this.getColor() + '\'' +
                ", price=" + this.getPrice() +
                ", origin='" + this.getOrigin() + '\'' +
                "countGears=" + this.getCountGears() +
                "isElectrical=" + isElectrical +
                '}';
    }
}
