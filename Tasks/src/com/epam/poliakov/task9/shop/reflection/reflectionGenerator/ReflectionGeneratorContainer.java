package com.epam.poliakov.task9.shop.reflection.reflectionGenerator;

import com.epam.poliakov.task9.shop.controller.constant.InputTypeCons;
import com.epam.poliakov.task9.shop.controller.generator.inputer.Inputer;
import com.epam.poliakov.task9.shop.controller.generator.inputer.ManualInputer;
import com.epam.poliakov.task9.shop.controller.generator.inputer.RandomInputer;

import java.util.HashMap;
import java.util.Map;

public class ReflectionGeneratorContainer {

    private String type;

    public ReflectionGeneratorContainer(String type) {
        this.type = type;
    }

    public ReflectionVehicleGenerator getGenerator() {
        return new ReflectionVehicleGenerator(setInputerMethod());
    }

    private Inputer setInputerMethod() {

        Map<String, Inputer> inputerMap = new HashMap<>();
        inputerMap.put(InputTypeCons.MANUAL, new ManualInputer());
        inputerMap.put(InputTypeCons.RANDOM, new RandomInputer());

        return inputerMap.get(type);
    }
}
