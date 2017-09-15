package com.epam.poliakov.task7_1.shop.controller.generator.inputer;

import com.epam.poliakov.task7_1.shop.controller.constant.InputTypeCons;
import com.epam.poliakov.task7_1.shop.controller.generator.generator.Generator;
import com.epam.poliakov.task7_1.shop.controller.generator.generator.GeneratorContainer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputerContainer {

    private String inputType;
    private Scanner scanner;
    private GeneratorContainer generatorContainer;

    public InputerContainer() {
        scanner = new Scanner(System.in);
    }

    public void setTemplate() {
        System.out.println("choice input type\n" +
                "0 - manual\n" +
                "1 - random");
        String type = scanner.nextLine();

        Map<String, String> map = new HashMap<>();
        map.put("0", InputTypeCons.MANUAL);
        map.put("1", InputTypeCons.RANDOM);

        inputType = map.get(type);

        generatorContainer = new GeneratorContainer(inputType);
    }

    public String getInputType() {
        return inputType;
    }

    public Generator generatorProduct() {
       return  generatorContainer.getGenerator(Integer.parseInt(scanner.nextLine()));
    }
}
