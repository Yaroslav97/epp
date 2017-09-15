package com.epam.poliakov.task9.shop.controller.generator.generator;

import com.epam.poliakov.task7_1.reflection.ReflectionResourceBundle;
import com.epam.poliakov.task9.shop.controller.generator.inputer.Inputer;
import com.epam.poliakov.task9.shop.entity.productEntity.Cabriolet;
import com.epam.poliakov.task9.shop.entity.productEntity.Vehicle;

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

        reflectionResourceBundle = new ReflectionResourceBundle(Cabriolet.class);
        ((Cabriolet) vehicle).setColor(inputer.generateString(reflectionResourceBundle.getI18nWord(Cabriolet.COLOR)));
        return vehicle;
    }
}
