package com.epam.poliakov.task9.shop.reflection.reflectionGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReflectionInputerContainer {

    private Scanner scanner;
    private ReflectionGeneratorContainer reflectionGeneratorContainer;

    public ReflectionInputerContainer() {
        scanner = new Scanner(System.in);
    }

    public void setTemplate(String inputType) {
        reflectionGeneratorContainer = new ReflectionGeneratorContainer(inputType);
    }

    public String getEntityName(){
        Map<Integer, String> commandMap = new HashMap<>();
        commandMap.put(0, "Vehicle");
        commandMap.put(1, "Car");
        commandMap.put(2, "Cabriolet");
        commandMap.put(3, "Bicycle");

        return commandMap.get(Integer.parseInt(scanner.nextLine()));
    }

    public ReflectionVehicleGenerator generatorProduct() {
        return  reflectionGeneratorContainer.getGenerator();
    }
}
