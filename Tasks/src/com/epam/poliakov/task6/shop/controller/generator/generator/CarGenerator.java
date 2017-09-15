package com.epam.poliakov.task6.shop.controller.generator.generator;

import com.epam.poliakov.task6.shop.controller.generator.inputer.Inputer;
import com.epam.poliakov.task6.shop.entity.product.Car;
import com.epam.poliakov.task6.shop.entity.product.Vehicle;

public class CarGenerator extends VehicleGenerator {

    private Inputer inputer;

    public CarGenerator(Inputer inputer) {
        super(inputer);
        this.inputer = inputer;
        vehicle = new Car();
    }

    @Override
    public Vehicle generate() {
        vehicle = super.generate();
        ((Car) vehicle).setFuel(inputer.setString("fuel"));
        return vehicle;
    }
}
