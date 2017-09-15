package com.epam.poliakov.task7_1.shop.controller.generator.generator;

import com.epam.poliakov.task7_1.reflection.ReflectionResourceBundle;
import com.epam.poliakov.task7_1.shop.controller.generator.inputer.Inputer;
import com.epam.poliakov.task7_1.shop.entity.productEntity.Bicycle;
import com.epam.poliakov.task7_1.shop.entity.productEntity.Vehicle;

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

        reflectionResourceBundle = new ReflectionResourceBundle(Bicycle.class);
        ((Bicycle) vehicle).setCountOfGears(inputer.generateInt(reflectionResourceBundle.getI18nWord(Bicycle.COUNT_OF_GEARS)));
        return vehicle;
    }
}
