package com.epam.poliakov.task6.shop.controller.generator.generator;

import com.epam.poliakov.task6.shop.controller.generator.inputer.Inputer;
import com.epam.poliakov.task6.shop.entity.product.Bicycle;
import com.epam.poliakov.task6.shop.entity.product.Vehicle;

public class BicycleGenerator extends VehicleGenerator {

    private Inputer inputer;

    public BicycleGenerator(Inputer inputer) {
        super(inputer);
        this.inputer = inputer;
        vehicle = new Bicycle();
    }

    @Override
    public Vehicle generate() {
        vehicle = super.generate();
        ((Bicycle) vehicle).setCountGears(inputer.setInt("count of gears"));
        return vehicle;
    }
}
