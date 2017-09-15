package com.epam.poliakov.task6.shop.controller.generator.generator;

import com.epam.poliakov.task6.shop.controller.generator.inputer.Inputer;
import com.epam.poliakov.task6.shop.entity.product.Cabriolet;
import com.epam.poliakov.task6.shop.entity.product.Vehicle;

public class CabrioletGenerator extends CarGenerator {

    private Inputer inputer;

    public CabrioletGenerator(Inputer inputer) {
        super(inputer);
        this.inputer = inputer;
        vehicle = new Cabriolet();
    }

    @Override
    public Vehicle generate() {
        vehicle = super.generate();
        ((Cabriolet) vehicle).setColor(inputer.setString("color"));
        return vehicle;
    }
}
