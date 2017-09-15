package com.epam.poliakov.task7_1.shop.controller.generator.generator;

import com.epam.poliakov.task7_1.reflection.ReflectionResourceBundle;
import com.epam.poliakov.task7_1.shop.controller.generator.inputer.Inputer;
import com.epam.poliakov.task7_1.shop.entity.productEntity.Vehicle;

public class VehicleGenerator implements Generator {

    private Inputer inputer;
    protected Vehicle vehicle;
    protected ReflectionResourceBundle reflectionResourceBundle;

    public VehicleGenerator(Inputer inputer) {
        this.inputer = inputer;
        vehicle = new Vehicle();
    }

    @Override
    public Vehicle generate() {
        reflectionResourceBundle = new ReflectionResourceBundle(Vehicle.class);

        vehicle.setName(inputer.generateString(reflectionResourceBundle.getI18nWord(Vehicle.NAME)));
        vehicle.setPrice(inputer.generateInt(reflectionResourceBundle.getI18nWord(Vehicle.PRICE)));

        return vehicle;
    }
}
