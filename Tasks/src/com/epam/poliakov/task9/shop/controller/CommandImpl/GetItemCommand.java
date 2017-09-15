package com.epam.poliakov.task9.shop.controller.CommandImpl;

import com.epam.poliakov.task9.shop.controller.Command;
import com.epam.poliakov.task9.shop.service.StoreService;

import java.util.Scanner;

public class GetItemCommand implements Command {
    private StoreService storeService;
    private Scanner scanner;

    public GetItemCommand(StoreService storeService, Scanner scanner) {
        this.storeService = storeService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {

        System.out.println("Enter item name $");
        String product = scanner.nextLine();

        if (storeService.isExist(product)) {
            System.out.printf("%s | %d", storeService.getProduct(product).getName(), storeService.getProduct(product).getPrice());
        } else {
            System.err.printf("the item %s is not exist", product);
        }
    }
}
