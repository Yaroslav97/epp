package com.epam.poliakov.task7_1.shop.controller.CommandImpl;

import com.epam.poliakov.task7_1.shop.controller.Command;
import com.epam.poliakov.task7_1.shop.service.StoreService;

public class ExitCommand implements Command {

    private StoreService storeService;

    public ExitCommand(StoreService storeService) {
        this.storeService = storeService;
    }

    @Override
    public void execute() {
        storeService.initSerialization();
        System.out.println("exit from store");
        System.exit(0);
    }
}
