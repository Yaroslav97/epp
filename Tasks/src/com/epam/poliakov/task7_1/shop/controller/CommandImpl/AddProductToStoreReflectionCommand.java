package com.epam.poliakov.task7_1.shop.controller.CommandImpl;

import com.epam.poliakov.task7_1.shop.controller.Command;
import com.epam.poliakov.task7_1.reflection.reflectionGenerator.ReflectionInputerContainer;
import com.epam.poliakov.task7_1.shop.entity.productEntity.Vehicle;
import com.epam.poliakov.task7_1.shop.service.StoreService;

public class AddProductToStoreReflectionCommand implements Command {

    private ReflectionInputerContainer inputerContainer;
    private StoreService storeService;

    public AddProductToStoreReflectionCommand(ReflectionInputerContainer inputerContainer, StoreService storeService) {
        this.inputerContainer = inputerContainer;
        this.storeService = storeService;
    }

    @Override
    public void execute() {
        System.out.println("Choice productEntity to adding");
        System.out.println("vehicle - 0");
        System.out.println("car - 1");
        System.out.println("cabriolet - 2");
        System.out.println("bicycle - 3");

        Vehicle vehicle = inputerContainer.generatorProduct().generate(inputerContainer.getEntityName());
        storeService.addProduct(vehicle);
        System.out.println(storeService.getProduct(vehicle.getName()));
    }
}
