package com.epam.poliakov.task7_1.shop.controller.generator.generator;

import com.epam.poliakov.task7_1.reflection.ReflectionResourceBundle;
import com.epam.poliakov.task7_1.shop.controller.generator.inputer.Inputer;
import com.epam.poliakov.task7_1.shop.entity.productEntity.Car;
import com.epam.poliakov.task7_1.shop.entity.productEntity.Vehicle;

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

        reflectionResourceBundle = new ReflectionResourceBundle(Car.class);
        ((Car) vehicle).setFuel(inputer.generateString(reflectionResourceBundle.getI18nWord(Car.FUEL)));
        return vehicle;
    }
}
