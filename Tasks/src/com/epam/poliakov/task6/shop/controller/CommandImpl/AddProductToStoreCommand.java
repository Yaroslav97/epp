package com.epam.poliakov.task6.shop.controller.CommandImpl;

import com.epam.poliakov.task6.shop.controller.generator.GeneratorContainer;
import com.epam.poliakov.task6.shop.controller.Command;
import com.epam.poliakov.task6.shop.entity.product.Vehicle;
import com.epam.poliakov.task6.shop.service.StoreService;

import java.util.Scanner;

public class AddProductToStoreCommand implements Command {

    private GeneratorContainer generatorContainer;
    private StoreService storeService;
    private Scanner scanner;

    public AddProductToStoreCommand(GeneratorContainer generatorContainer, StoreService storeService, Scanner scanner) {
        this.generatorContainer = generatorContainer;
        this.storeService = storeService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Choice product to adding");
        System.out.println("vehicle - 0");
        System.out.println("car - 1");
        System.out.println("cabriolet - 2");
        System.out.println("bicycle - 3");

        String key = scanner.nextLine();

        Vehicle vehicle = generatorContainer.getGenerator(Integer.parseInt(key)).generate();
        storeService.addProduct(vehicle);
        System.out.println(storeService.getProduct(vehicle.getName()));
    }
}
