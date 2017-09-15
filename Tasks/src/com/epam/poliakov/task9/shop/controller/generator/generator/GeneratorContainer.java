package com.epam.poliakov.task9.shop.controller.generator.generator;

import com.epam.poliakov.task9.shop.controller.constant.InputTypeCons;
import com.epam.poliakov.task9.shop.controller.generator.inputer.Inputer;
import com.epam.poliakov.task9.shop.controller.generator.inputer.ManualInputer;
import com.epam.poliakov.task9.shop.controller.generator.inputer.RandomInputer;

import java.util.HashMap;
import java.util.Map;

public class GeneratorContainer {

    private String type;

    private Map<Integer, Generator> commandMap = new HashMap<>();

    public GeneratorContainer(String type) {
        this.type = type;

        //commandMap.put(0, "Vehicle");
        commandMap.put(0, new VehicleGenerator(setInputerMethod()));
        commandMap.put(1, new CarGenerator(setInputerMethod()));
        commandMap.put(2, new CabrioletGenerator(setInputerMethod()));
        commandMap.put(3, new BicycleGenerator(setInputerMethod()));
    }

    public Generator getGenerator(int key) {
        return commandMap.get(key);
    }

    private Inputer setInputerMethod() {

        Map<String, Inputer> inputerMap = new HashMap<>();

        inputerMap.put(InputTypeCons.MANUAL,new ManualInputer());
        inputerMap.put(InputTypeCons.MANUAL,new ManualInputer());
        inputerMap.put(InputTypeCons.RANDOM,new RandomInputer());

        return inputerMap.get(type);
    }
}
