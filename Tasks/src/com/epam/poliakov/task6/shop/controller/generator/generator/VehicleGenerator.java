package com.epam.poliakov.task6.shop.controller.generator.generator;

import com.epam.poliakov.task6.shop.controller.generator.inputer.Inputer;
import com.epam.poliakov.task6.shop.entity.product.Vehicle;

public class VehicleGenerator implements Generator {

    private Inputer inputer;
    protected Vehicle vehicle;

    public VehicleGenerator(Inputer inputer) {
        this.inputer = inputer;
        vehicle = new Vehicle();
    }

    @Override
    public Vehicle generate() {
        vehicle.setName(inputer.setString("name"));
        vehicle.setPrice(inputer.setInt("price"));

        return vehicle;
    }
}
